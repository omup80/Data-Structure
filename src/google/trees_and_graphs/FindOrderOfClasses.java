package google.trees_and_graphs;

import java.util.*;

class FindOrderOfClasses {
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    boolean[] visited;
    Stack<Integer> st = new Stack();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        visited = new boolean[numCourses];
        
        creasePrequisiteGraph(prerequisites);
        
        if(detectCycle(numCourses))
            return new int[0];
        
        
        
        for(int course=0;course<numCourses;course++){
            if(!visited[course])
                dfs(course, graph.getOrDefault(course, new ArrayList<Integer>()));
            
        }
        
        int[] result = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            result[i]=st.pop();
            i++;
        }
        return result;
         
    }
    private boolean detectCycle(int numCourses){
        int[] processed = new int[numCourses];
        for(int course=0;course<numCourses;course++){
            if(processed[course]==0)
              if(detectCycleUtil(processed, course, graph.getOrDefault(course, new ArrayList<Integer>())))
                  return true;
            
        }
        return false;
    }
    
    private boolean detectCycleUtil(int[] processed, int node, List<Integer> children){
        if(processed[node]==1)
            return true;
        if(processed[node]==2)
            return false;
        processed[node]=1;
        for(int child: children){
            if(detectCycleUtil(processed, child, graph.getOrDefault(child, new ArrayList<Integer>())))
                return true;
        }
        processed[node]=2;
        return false;
    }
    
    
    private void dfs(int course, List<Integer> children){
        visited[course] = true;
        
        for(int child: children){
            if(!visited[child]){
                dfs(child, graph.getOrDefault(child, new ArrayList<Integer>()));
            }
        }
          
        
        st.push(course);    
        
        
    }
    
    
    private void creasePrequisiteGraph(int[][] prerequisites){
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> children = graph.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            children.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], children);
            
        }
    }
    
    
    
}
       