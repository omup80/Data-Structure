package microsoft.trees_and_graphs;

import java.util.*;

// Definition for a Node.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    Map<GraphNode, GraphNode> copies = new HashMap<GraphNode, GraphNode>();
    Set<GraphNode> visited = new HashSet<GraphNode>();
    public GraphNode cloneGraph(GraphNode node) {
        if(node==null)
            return null;

        createCopies(node);
        GraphNode graphCopy = copies.get(node);;
        createGraph(node, graphCopy);
        return graphCopy;
    }
    private void createGraph(GraphNode node, GraphNode graphCopy){

        visited.add(node);
        graphCopy.neighbors = new ArrayList<GraphNode>();
        for(GraphNode neighbor: node.neighbors){
            graphCopy.neighbors.add(copies.get(neighbor));
        }

        for(int i=0;i< node.neighbors.size();i++){
            if(!visited.contains(node.neighbors.get(i)))
                createGraph(node.neighbors.get(i), graphCopy.neighbors.get(i));
        }
    }

    private void createCopies(GraphNode node){
        if(node==null)
            return;

        if(!copies.containsKey(node)){
            copies.put(node, copy(node));
            for(GraphNode neighbour: node.neighbors){
                createCopies(neighbour);
            }
        }


    }

    private GraphNode copy(GraphNode node){
        return new GraphNode(node.val);
    }
}