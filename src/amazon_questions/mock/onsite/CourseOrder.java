package amazon_questions.mock.onsite;

import java.util.*;

class CourseOrder {
    int[] result;
    int index=0;
    Set<Integer> visited = new HashSet();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        Map<Integer, List<Integer>> graph = createGraph(prerequisites);
        for(int i=0;i<numCourses;i++){
          if(!visited.contains(i)){
            boolean cycle = checkCycle(i, graph, new HashSet());
            if(cycle)
                return new int[0];
            addCourses(i, graph);  
          }
            
           
        }
        
        return result;
    }
    private boolean checkCycle(int course, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        
        visited.add(course);
        for(Integer child: graph.getOrDefault(course, new ArrayList<Integer>())){
            if(visited.contains(child))
                return true;
            boolean result = checkCycle(child, graph, visited);
            if(result)
                return result;
            
        }
        visited.remove(course);
        return false;
    }
    
    private void addCourses(int course, Map<Integer, List<Integer>> graph){
        
        visited.add(course);
        for(Integer child: graph.getOrDefault(course, new ArrayList<Integer>())){
            
            if(!visited.contains(child) )
              addCourses(child, graph);
            
        }
        result[index++]=course;
    }
    
    private Map<Integer, List<Integer>> createGraph(int[][] prerequisites){
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] relation: prerequisites){
          List<Integer> prerequisite = graph.getOrDefault(relation[0], new ArrayList());
          prerequisite.add(relation[1]);
          graph.put(relation[0], prerequisite);
        }
        
        return graph;

    }
}