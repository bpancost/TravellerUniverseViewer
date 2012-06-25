package com.pancost.traveller.universe.graph;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.frames.FramedGraph;
import java.awt.Color;
import java.awt.Paint;
import org.apache.commons.collections15.Transformer;

/**
 * @author Brandon Pancost
 */
public class ShiftColoring implements Transformer<Edge, Paint>{

    FramedGraph framedGraph;
    
    public ShiftColoring(FramedGraph framedGraph){
        super();
        this.framedGraph = framedGraph;
    }
    
    @Override
    public Paint transform(Edge shiftEdge) {
        com.pancost.traveller.universe.frames.Shift shift = (com.pancost.traveller.universe.frames.Shift) framedGraph.frame(shiftEdge, Direction.BOTH ,com.pancost.traveller.universe.frames.Shift.class);
        Color c;
        switch(shift.getTraffic()){
            case("Very Low"):
                c = Color.GREEN;
                break;
            case ("Low"):
                c = Color.GREEN.darker().darker();
                break;
            case ("Medium"):
                c = Color.YELLOW;
                break;
            case ("High"):
                c = Color.RED.darker().darker();
                break;
            case ("Very High"):
                c = Color.RED;
                break;
            default:
                c = Color.GRAY;
        }
        return c;
    }
    
}
