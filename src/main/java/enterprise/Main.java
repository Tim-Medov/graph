
package enterprise;

public class Main {

    public static void main(String[] args) {

        // create an object of the Graph class (a map of links and nodes)
        Graph graph = new Graph();

        // add nodes to the map
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addNode("h");
        graph.addNode("i");
        graph.addNode("j");

        /*
        Think over the connections of nodes on the graph map

        a <--> b

        b <--> c
        b <--> d
        b <--> e

        d <--> f
        d <--> g

        f <--> h
        f <--> i

        h <--> j
         */

        // add links between nodes to the graph map
        graph.createEdge("a", "b");
        graph.createEdge("b", "c");
        graph.createEdge("b", "d");
        graph.createEdge("b", "e");
        graph.createEdge("d", "f");
        graph.createEdge("d", "g");
        graph.createEdge("f", "h");
        graph.createEdge("f", "i");
        graph.createEdge("h", "j");

        // walk on the graph map from point 'a' to point 'j'
        graph.passQueueByWidth("a", "j");

        // find the shortest path on the graph map from point 'a' to point 'j'
        graph.shortestPathSearch("a", "j");
    }
}
