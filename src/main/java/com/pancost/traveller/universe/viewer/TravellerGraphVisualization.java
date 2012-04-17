package com.pancost.traveller.universe.viewer;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerGraphVisualization extends JPanel {
    
    Graph<Vertex,Edge> visGraph;
    BasicVisualizationServer<Vertex,Edge> visServer;
    
    public TravellerGraphVisualization(){
        super();
    }
    
    public TravellerGraphVisualization(Graph<Vertex,Edge> visGraph){
        super();
        this.visGraph = visGraph;
        Layout<Vertex,Edge> layout = new CircleLayout(visGraph);
        layout.setSize(new Dimension(200,200));
        visServer = new BasicVisualizationServer<>(layout);
        visServer.setPreferredSize(new Dimension(200,200));
        add(visServer);
        setVisible(true);
    }
}
