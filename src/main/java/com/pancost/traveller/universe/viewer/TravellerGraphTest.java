package com.pancost.traveller.universe.viewer;

import com.pancost.traveller.universe.builder.TravellerConstants.ShiftTypes;
import com.pancost.traveller.universe.builder.TravellerConstants.UtilityTypes;
import com.pancost.traveller.universe.graph.PlanetLabeller;
import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;
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
import javax.swing.JFrame;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerGraphTest extends JFrame {
    
    ArrayList<Vertex> planetList = new ArrayList<>();
    TransactionalGraph graphDB;
    Graph<Vertex,Edge> visGraph;
    DefaultVisualizationModel<Vertex,Edge> visModel;
    VisualizationViewer<Vertex,Edge> visServer;
    Layout<Vertex,Edge> layout;

    public TravellerGraphTest() {
        graphDB = new Neo4jGraph("C:/traveller/graphdb");
        visGraph = new SparseMultigraph<>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Vertex planets = graphDB.getVertex(UtilityTypes.Planet.getProperty());
        for(Edge planetEdge : planets.getOutEdges(UtilityTypes.Planet.getProperty())){
            Vertex planet = planetEdge.getInVertex();
            planetList.add(planet);
            /*visGraph.addVertex(planet);
            for(Relationship shiftRelationship : planet.getRelationships(ShiftTypes.Shift)){
                Node otherPlanet = shiftRelationship.getOtherNode(planet);
                if(!planetList.contains(otherPlanet)){
                    visGraph.addEdge(shiftRelationship, planet, otherPlanet);
                }
            }*/
        }
        Vertex planet1 = planetList.get(0);
        visGraph.addVertex(planet1);
        for(Edge shiftEdge : planet1.getOutEdges(ShiftTypes.Shift.getProperty())){
            Vertex planet2 = shiftEdge.getInVertex();
            visGraph.addEdge(shiftEdge, planet1, planet2);
            visGraph.addVertex(planet2);
        }
        
        layout = new FRLayout(visGraph);
        layout.setSize(new Dimension(800,800));
        
        visModel = new DefaultVisualizationModel<>(layout);
        
        visServer = new VisualizationViewer<>(visModel);
        visServer.setPreferredSize(new Dimension(800,800));
        
        visServer.getRenderContext().setVertexLabelTransformer(new PlanetLabeller());
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
                visGraph.addVertex(v);
                for(Edge shiftEdge : v.getOutEdges(ShiftTypes.Shift.getProperty())){
                    Vertex otherPlanet = shiftEdge.getInVertex();
                    visGraph.addEdge(shiftEdge, v, otherPlanet);
                    visGraph.addVertex(otherPlanet);
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
            public void run() {
                new TravellerGraphTest().setVisible(true);
            }
        });
    }
    
}
