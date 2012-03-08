package com.pancost.traveller.universe.graph;

import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Brandon Pancost
 */
public class PlanetLabeller<Node> implements Transformer<org.neo4j.graphdb.Node, String>{

    public PlanetLabeller(){
        super();
    }
    
    public String transform(org.neo4j.graphdb.Node planet) {
        return (String)planet.getProperty("DESIGNATION");
    }
    
}
