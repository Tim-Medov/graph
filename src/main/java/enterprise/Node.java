
package enterprise;

import java.util.LinkedList;

class Node {

    private String nodeName;

    private LinkedList<Node> nodesList;

    public Node(String nodeName) {
        this.nodeName = nodeName;
        this.nodesList = new LinkedList<>();
    }

    public void addNode(Node node) {
        nodesList.add(node);
    }

    public LinkedList<Node> getNodeList() {
        return nodesList;
    }

    public String getName() {
        return nodeName;
    }
}
