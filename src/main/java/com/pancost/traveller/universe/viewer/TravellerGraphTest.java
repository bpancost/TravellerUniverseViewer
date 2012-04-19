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
    
    ArrayList<Planet> planetList = new ArrayList<>();
    TransactionalGraph graphDB;
    Graph<Vertex,Edge> visGraph;
    DefaultVisualizationModel<Vertex,Edge> visModel;
    VisualizationViewer<Vertex,Edge> visServer;
    Layout<Vertex,Edge> layout;
    FramesManager framesManager;

    public TravellerGraphTest() {
        graphDB = new Neo4jGraph("C:/traveller/graphdb");
        framesManager = new FramesManager(graphDB);
        visGraph = new SparseMultigraph<>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Iterable<PlanetList> planetListIterable = framesManager.frameVertices(Index.VERTICES, "indexed", "YES", PlanetList.class);
        planetList = new ArrayList<>(planetListIterable.iterator().next().getPlanetList());
        
        Planet planet = planetList.get(0);
        Vertex planetVertex = planet.asVertex();
        visGraph.addVertex(planetVertex);
        
        Collection<Shift> shifts = planet.getShifts();
        for(Shift shift : shifts){
            Planet otherPlanet = shift.getToPlanet();
            visGraph.addVertex(otherPlanet.asVertex());
            visGraph.addEdge(shift.asEdge(), planetVertex, otherPlanet.asVertex());
        }
        
        layout = new FRLayout(visGraph);
        layout.setSize(new Dimension(800,800));
        
        visModel = new DefaultVisualizationModel<>(layout);
        
        visServer = new VisualizationViewer<>(visModel);
        visServer.setPreferredSize(new Dimension(800,800));
        
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
                visGraph = new SparseMultigraph<>();
                visGraph.addVertex(v);
                Planet planet = framesManager.frame(v, Planet.class);
                Collection<Shift> shifts = planet.getShifts();
                for(Shift shift : shifts){
                    Planet otherPlanet = shift.getToPlanet();
                    visGraph.addVertex(otherPlanet.asVertex());
                    visGraph.addEdge(shift.asEdge(), v, otherPlanet.asVertex());
                }
                
                setLayout(new FRLayout(visGraph));
                visModel.setGraphLayout(layout);
                /*Layout<Node,Relationship> newLayout = new FRLayout(visGraph);
                //StaticLayout<Node,Relationship> staticLayout = new StaticLayout<Node,Relationship>(visGraph, newLayout);
                LayoutTransition<Node,Relationship> transition = new LayoutTransition<Node,Relationship>(visServer, visServer.getGraphLayout(), newLayout);
                Animator animator = new Animator(transition);
                animator.start();
                visServer.repaint();*/
            }

            @Override
            public void graphPressed(Vertex v, MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void graphReleased(Vertex v, MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        
        });
        
        this.setSize(new Dimension(800,800));
        add(visServer);
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
