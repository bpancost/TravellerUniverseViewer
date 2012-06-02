package com.pancost.traveller.universe.viewer;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.neo4j.Neo4jGraph;
import com.tinkerpop.blueprints.oupls.jung.GraphJung;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Brandon Pancost
 */
public class TravellerBlueprintsGraphTest extends JFrame {
    
    TransactionalGraph graphDB;
    
    public TravellerBlueprintsGraphTest(){
        graphDB = new Neo4jGraph("C:/traveller/graphdb");
        GraphJung graph = new GraphJung(graphDB);
        Layout<Vertex, Edge> layout = new CircleLayout<>(graph);
        layout.setSize(new Dimension(800, 800));
        BasicVisualizationServer<Vertex, Edge> viz = new BasicVisualizationServer<>(layout);
        viz.setPreferredSize(new Dimension(800, 800));

        Transformer<Vertex, String> vertexLabelTransformer = new Transformer<Vertex,String>() {
            @Override
            public String transform(Vertex vertex) {
                return (String) vertex.getProperty("designation");
            }
        };

        Transformer<Edge, String> edgeLabelTransformer = new Transformer<Edge,String>() {
            @Override
            public String transform(Edge edge) {
                return edge.getLabel();
            }
        };

        viz.getRenderContext().setEdgeLabelTransformer(edgeLabelTransformer);
        viz.getRenderContext().setVertexLabelTransformer(vertexLabelTransformer);

        this.setTitle("Traveller Universe Viewer");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(viz);
        pack();
    }
    
    @Override
    public void dispose(){
        this.setVisible(false);
        graphDB.shutdown();
        System.exit(0);
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TravellerBlueprintsGraphTest().setVisible(true);
            }
        });
    }
}
