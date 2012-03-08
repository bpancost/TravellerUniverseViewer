package com.pancost.traveller.universe.viewer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.RadialTreeLayout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.DefaultVisualizationModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.picking.RadiusPickSupport;
import edu.uci.ics.jung.visualization.picking.ShapePickSupport;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.util.Animator;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import com.pancost.traveller.universe.builder.TravellerConstants.UtilityTypes;
import com.pancost.traveller.universe.builder.TravellerConstants.ShiftTypes;
import com.pancost.traveller.universe.graph.PlanetLabeller;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerGraphTest extends JFrame {
    
    ArrayList<Node> planetList = new ArrayList<Node>();
    GraphDatabaseService graphDB;
    Graph<Node,Relationship> visGraph;
    DefaultVisualizationModel<Node,Relationship> visModel;
    VisualizationViewer<Node,Relationship> visServer;
    Layout<Node,Relationship> layout;

    public TravellerGraphTest() {
        graphDB = new EmbeddedGraphDatabase("C:/traveller/graphdb");
        visGraph = new SparseMultigraph<Node,Relationship>();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Node root = graphDB.getReferenceNode();
        Node planets = root.getSingleRelationship(UtilityTypes.ROOT, Direction.BOTH).getOtherNode(root);
        for(Relationship planetRelationship : planets.getRelationships(UtilityTypes.PLANET)){
            Node planet = planetRelationship.getOtherNode(planets);
            planetList.add(planet);
            /*visGraph.addVertex(planet);
            for(Relationship shiftRelationship : planet.getRelationships(ShiftTypes.Shift)){
                Node otherPlanet = shiftRelationship.getOtherNode(planet);
                if(!planetList.contains(otherPlanet)){
                    visGraph.addEdge(shiftRelationship, planet, otherPlanet);
                }
            }*/
        }
        Node planet1 = planetList.get(0);
        visGraph.addVertex(planet1);
        for(Relationship shiftRelationship : planet1.getRelationships(ShiftTypes.Shift)){
            Node planet2 = shiftRelationship.getOtherNode(planet1);
            visGraph.addEdge(shiftRelationship, planet1, planet2);
            visGraph.addVertex(planet2);
        }
        
        layout = new FRLayout(visGraph);
        layout.setSize(new Dimension(800,800));
        
        visModel = new DefaultVisualizationModel<Node,Relationship>(layout);
        
        visServer = new VisualizationViewer<Node,Relationship>(visModel);
        visServer.setPreferredSize(new Dimension(800,800));
        
        visServer.getRenderContext().setVertexLabelTransformer(new PlanetLabeller());
        visServer.getRenderer().getVertexLabelRenderer().setPosition(Position.N);
        
        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        //gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        gm.setMode(ModalGraphMouse.Mode.PICKING);
        visServer.setGraphMouse(gm);
        
        visServer.setPickSupport(new ShapePickSupport(visServer));
        
        visServer.addGraphMouseListener(new GraphMouseListener<Node>(){

            public void graphClicked(Node v, MouseEvent me) {
                visGraph = new SparseMultigraph<Node, Relationship>();
                visGraph.addVertex(v);
                visGraph.addVertex(v);
                for(Relationship shiftRelationship : v.getRelationships(ShiftTypes.Shift)){
                    Node otherPlanet = shiftRelationship.getOtherNode(v);
                    visGraph.addEdge(shiftRelationship, v, otherPlanet);
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

            public void graphPressed(Node v, MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            public void graphReleased(Node v, MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }
        
        });
        
        this.setSize(new Dimension(800,800));
        add(visServer);
    }
    
    public void setLayout(Layout<Node,Relationship> layout){
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
