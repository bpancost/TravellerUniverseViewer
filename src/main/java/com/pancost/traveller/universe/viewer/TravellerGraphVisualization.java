package com.pancost.traveller.universe.viewer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerGraphVisualization extends JPanel {
    
    Graph<Node,Relationship> visGraph;
    BasicVisualizationServer<Node,Relationship> visServer;
    
    public TravellerGraphVisualization(){
        super();
    }
    
    public TravellerGraphVisualization(Graph<Node,Relationship> visGraph){
        super();
        this.visGraph = visGraph;
        Layout<Node,Relationship> layout = new CircleLayout(visGraph);
        layout.setSize(new Dimension(200,200));
        visServer = new BasicVisualizationServer<Node,Relationship>(layout);
        visServer.setPreferredSize(new Dimension(200,200));
        add(visServer);
        setVisible(true);
    }
}
