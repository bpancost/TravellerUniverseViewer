package com.pancost.traveller.universe.viewer;

import com.pancost.traveller.universe.frames.Planet;
import com.pancost.traveller.universe.frames.PlanetList;
import com.pancost.traveller.universe.frames.Shift;
import com.pancost.traveller.universe.graph.PlanetLabeller;
import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
import com.tinkerpop.frames.FramesManager;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.DefaultVisualizationModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.picking.ShapePickSupport;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFrame;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerGraphTest extends JFrame {
    
    private static final int MAX_SHIFT_DEPTH = 5;
    private static final int DISPLAY_WIDTH = 1680;
    private static final int DISPLAY_HEIGHT = 1000;
    
    private ArrayList<Planet> planetList = new ArrayList<>();
    private TransactionalGraph graphDB;
    private Graph<Vertex,Edge> visGraph;
    private DefaultVisualizationModel<Vertex,Edge> visModel;
    private VisualizationViewer<Vertex,Edge> visServer;
    private Layout<Vertex,Edge> layout;
    private FramesManager framesManager;

    public TravellerGraphTest() {
        graphDB = new Neo4jGraph("C:/traveller/graphdb");
        framesManager = new FramesManager(graphDB);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Iterable<PlanetList> planetListIterable = framesManager.frameVertices(Index.VERTICES, "indexed", "YES", PlanetList.class);
        planetList = new ArrayList<>(planetListIterable.iterator().next().getPlanetList());
        
        Planet planet = planetList.get(0);
        
        visGraph = new SparseMultigraph<>();
        visGraph.addVertex(planet.asVertex());
        
        layout = new FRLayout(visGraph);
        
        visModel = new DefaultVisualizationModel<>(layout);
        
        visServer = new VisualizationViewer<>(visModel);
        visServer.setPreferredSize(new Dimension(DISPLAY_WIDTH,DISPLAY_HEIGHT));
        
        addPlanetShiftsToVisServer(planet);
        
        visServer.getRenderContext().setVertexLabelTransformer(new PlanetLabeller(framesManager));
        visServer.getRenderer().getVertexLabelRenderer().setPosition(Position.N);
        
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        //gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        gm.setMode(ModalGraphMouse.Mode.PICKING);
        visServer.setGraphMouse(gm);
        
        visServer.setPickSupport(new ShapePickSupport(visServer));
        
        visServer.addGraphMouseListener(new GraphMouseListener<Vertex>(){

            @Override
            public void graphClicked(Vertex v, MouseEvent me) {
                Planet planet = framesManager.frame(v, Planet.class);
                addPlanetShiftsToVisServer(planet);
                /*Layout<Node,Relationship> newLayout = new FRLayout(visGraph);
                //StaticLayout<Node,Relationship> staticLayout = new StaticLayout<Node,Relationship>(visGraph, newLayout);
                LayoutTransition<Node,Relationship> transition = new LayoutTransition<Node,Relationship>(visServer, visServer.getGraphLayout(), newLayout);
                Animator animator = new Animator(transition);
                animator.start();
                visServer.repaint();*/
            }

            @Override
            public void graphPressed(Vertex v, MouseEvent me) {
            }

            @Override
            public void graphReleased(Vertex v, MouseEvent me) {
            }
        
        });
        
        this.setTitle("Traveller Graph Tester");
        this.setSize(new Dimension(DISPLAY_WIDTH,DISPLAY_HEIGHT));
        add(visServer);
    }
    
    private void addPlanetShiftsToVisServer(Planet planet){
        visGraph = new SparseMultigraph<>();
        
        addPlanetShiftsToVisRecursive(planet, MAX_SHIFT_DEPTH);
        
        setLayout(new FRLayout(visGraph));
        layout.setSize(new Dimension(DISPLAY_WIDTH-40,DISPLAY_HEIGHT-40));
        visModel.setGraphLayout(layout);
    }
    
    private void addPlanetShiftsToVisRecursive(Planet planet, int remainingDepth){
        if(!visGraph.containsVertex(planet.asVertex())){
            visGraph.addVertex(planet.asVertex());
        }
        Collection<Shift> shifts = planet.getShifts();
        for(Shift shift : shifts){
            Planet otherPlanet = shift.getToPlanet();
            if(!visGraph.containsVertex(otherPlanet.asVertex())){
                visGraph.addVertex(otherPlanet.asVertex());
                visGraph.addEdge(shift.asEdge(), planet.asVertex(), otherPlanet.asVertex());
                if(remainingDepth > 1){
                    addPlanetShiftsToVisRecursive(otherPlanet, remainingDepth-1);
                }
            }
        }
    }
    
    public void setLayout(Layout<Vertex,Edge> layout){
        this.layout = layout;
    }
    
    @Override
    public void dispose(){
        this.setVisible(false);
        graphDB.shutdown();
        System.exit(0);
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TravellerGraphTest().setVisible(true);
            }
        });
    }
    
}
