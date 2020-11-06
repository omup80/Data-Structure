import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HW5 {
    int time = 0;
    List<Pair> ans;
    int flag=1;
    static int N, M;
    static List<int[]> edges;
    static List<List<Integer>> adj;
    public HW5(){
        edges = new ArrayList<int[]>();
        ans = new ArrayList<Pair>();
    }
    public int dfs(List<List<Integer>> adj, int[] order, int[] bridge_detect, boolean[] mark, int v, int l){

        mark[v]=true;
        order[v] = order[l] + 1;
        bridge_detect[v] = order[v];
        for (int i = 0; i < adj.get(v).size(); i++) {
            int u = adj.get(v).get(i);

            // Ignores if same edge is traversed
            if (u == l) {
                continue;
            }

            // Ignores the edge u --> v as
            // v --> u is already processed
            if (order[v] < order[u]) {
                continue;
            }

            // Finds a back Edges, cycle present
            if (mark[u]) {

                // Update the bridge_detect[v]
                bridge_detect[v] = Math.min(order[u], bridge_detect[v]);
            }else {

                // Else DFS traversal for current
                // node in the adjacency list
                dfs(adj, order, bridge_detect,
                        mark, u, v);
            }

            // Update the bridge_detect[v]
            bridge_detect[v] = Math.min(bridge_detect[u], bridge_detect[v]);


            // Store the current directed Edge
            ans.add(new Pair(v, u));
        }

        // Condition for Bridges
        if (bridge_detect[v] == order[v]
                && l != 0) {
            flag = 0;
        }

        // Return flag
        return flag;

    }
    // Function to print the direction
// of edges to make graph SCCs
    void convert(List<List<Integer>> adj, int n)
    {

        // Arrays to store the visited,
        // bridge_detect and order of
        // Nodes
        int[] order = new int[n];
        int[] bridge_detect = new int[n];

        boolean[] mark = new boolean[n];




        // DFS Traversal from vertex 1
        int flag = dfs(adj, order,
                bridge_detect,
                mark, 1, 0);

        // If flag is zero, then Bridge
        // is present in the graph
        if (flag == 0) {
            System.out.println("No graph can not be converted to oriented graph");
            bridge();
        }

        // Else print the direction of
        // Edges assigned
        else {
            Collections.sort(ans, (a,b)-> a.u-b.u);
            for (Pair it : ans) {
                System.out.println((it.u+1) + "->"
                        + (it.v+1));
            }
        }
    }

    // Function to create graph
    void createGraph(
                     List<List<Integer>> adj,
                     int M)
    {

        // Traverse the Edges
        for (int i = 0; i < M; i++) {

            int u = edges.get(i)[0];
            int v = edges.get(i)[1];

            // Push the edges in an
            // adjacency list
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    public static void main(String[] args){



        HW5 hw = new HW5();


       hw.readData();

        adj = new ArrayList<>(N);
        for(int i=0;i<N;i++){

            adj.add(new ArrayList<Integer>());
        }

        hw.createGraph(adj, M);
        hw.convert(adj, N);

    }

    public void readData(){
        try {
            File myObj = new File("src/sample_2.in");
            Scanner myReader = new Scanner(myObj);
            boolean firstInput = true;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length()>0){
                    String[] relation = data.split(" ");
                    int x = Integer.parseInt(relation[0]);
                    int y = Integer.parseInt(relation[1]);
                    if(firstInput){
                        N = x;
                        M = y;
                        firstInput = false;
                    }else{
                        edges.add(new int[]{x-1,y-1});
                    }
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void bridge()
    {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[N];
        int disc[] = new int[N];
        int low[] = new int[N];
        int parent[] = new int[N];


        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < N; i++)
        {
            parent[i] = -1;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < N; i++)
            if (visited[i] == false)
                bridgeUtil(i, visited, disc, low, parent);
    }

    void bridgeUtil(int u, boolean visited[], int disc[],
                    int low[], int parent[])
    {

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        Iterator<Integer> i = adj.get(u).iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u

            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[v])
            {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);

                // Check if the subtree rooted with v has a
                // connection to one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[v] > disc[u])
                    System.out.println((u+1)+" "+(v+1));
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }
}

class Pair{
    int u,v;
    public Pair(int u, int v){
        this.u=u;
        this.v=v;
    }
}

