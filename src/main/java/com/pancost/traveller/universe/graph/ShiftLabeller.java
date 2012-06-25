package com.pancost.traveller.universe.graph;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.frames.FramedGraph;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Brandon Pancost
 */
public class ShiftLabeller<Shift>  implements Transformer<Edge, String>{
    
    FramedGraph framedGraph;
    
    public ShiftLabeller(FramedGraph framedGraph){
        super();
        this.framedGraph = framedGraph;
    }
    
    @Override
    public String transform(Edge shiftEdge) {
        com.pancost.traveller.universe.frames.Shift shift = (com.pancost.traveller.universe.frames.Shift) framedGraph.frame(shiftEdge, Direction.BOTH ,com.pancost.traveller.universe.frames.Shift.class);
        return shift.getTrafficRaw().toString();
    }
    
}
