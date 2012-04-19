package com.pancost.traveller.universe.graph;

import com.tinkerpop.frames.FramesManager;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Brandon Pancost
 */
public class PlanetLabeller<Planet> implements Transformer<com.tinkerpop.blueprints.pgm.Vertex, String>{
    
    FramesManager framesManager;
    
    public PlanetLabeller(FramesManager framesManager){
        super();
        this.framesManager = framesManager;
    }
    
    @Override
    public String transform(com.tinkerpop.blueprints.pgm.Vertex planetVertex) {
        com.pancost.traveller.universe.frames.Planet planet = framesManager.frame(planetVertex, com.pancost.traveller.universe.frames.Planet.class);
        return planet.getDesignation();
    }
    
}
