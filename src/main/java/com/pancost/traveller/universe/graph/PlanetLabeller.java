package com.pancost.traveller.universe.graph;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.frames.FramedGraph;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Brandon Pancost
 */
public class PlanetLabeller<Planet> implements Transformer<Vertex, String>{
    
    FramedGraph framedGraph;
    
    public PlanetLabeller(FramedGraph framedGraph){
        super();
        this.framedGraph = framedGraph;
    }
    
    @Override
    public String transform(Vertex planetVertex) {
        com.pancost.traveller.universe.frames.Planet planet = (com.pancost.traveller.universe.frames.Planet) framedGraph.frame(planetVertex, com.pancost.traveller.universe.frames.Planet.class);
        return planet.getDesignation();
    }
    
}
