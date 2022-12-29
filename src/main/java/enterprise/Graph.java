
package enterprise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Graph {

    private HashMap<String, Node> nodesMap;

    public Graph() {
        this.nodesMap = new HashMap<>();
    }

    public void addNode(String nodeName) {
        Node node = new Node(nodeName);
        nodesMap.put(nodeName, node);
    }

    public void createEdge(String nodeName1, String nodeName2) {

        Node node1 = nodesMap.get(nodeName1);
        Node node2 = nodesMap.get(nodeName2);

        node1.addNode(node2);
        node2.addNode(node1);
    }

    public void passQueueByWidth(String startNodeName, String endNodeName) {

        Node startNode = nodesMap.get(startNodeName);
        Node endNode = nodesMap.get(endNodeName);

        LinkedList<Node> nodeQueue = new LinkedList<>();

        HashSet<Node> visited = new HashSet<>();
        visited.add(startNode);

        Node currentNode = startNode;

        while (currentNode != endNode) {

            LinkedList<Node> nodeList = currentNode.getNodeList();

            for (Node node : nodeList) {

                if (!visited.contains(node)) {

                    visited.add(node);

                    nodeQueue.add(node);
                }
            }

            currentNode = nodeQueue.remove();
        }

        System.out.println("All visited nodes:");

        for (Node node : visited) {
            System.out.print(node.getName() + " ");
        }

        System.out.println();
    }

    public LinkedList<Node> shortestPathSearch(String startNodeName, String endNodeName) {

        Node startNode = nodesMap.get(startNodeName);
        Node endNode = nodesMap.get(endNodeName);

        LinkedList<Node> nodeQueue = new LinkedList<>();
        HashMap<Node, Node> visited = new HashMap<>();

        visited.put(startNode, null);

        Node currentNode = startNode;

        while (currentNode != endNode) {

            LinkedList<Node> nodeList = currentNode.getNodeList();

            for (Node node : nodeList) {

                if (!visited.containsKey(node)) {

                    visited.put(node, currentNode);

                    nodeQueue.add(node);
                }
            }

            currentNode = nodeQueue.remove();
        }

        LinkedList<Node> path = new LinkedList<>();
        path.addFirst(currentNode);

        while (currentNode != startNode) {

            currentNode = visited.get(currentNode);

            path.addFirst(currentNode);
        }

        System.out.println("Shortest path is:");

        for (Node node : path) {
            System.out.print(node.getName() + " ");
        }

        System.out.println();

        return path;
    }
}
