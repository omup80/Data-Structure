package amazon_questions.mock.onsite;

import java.util.*;

class CanFinishCourse {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = createGraph(prerequisites);
        for(int i=0;i<numCourses;i++){
           boolean result =  checkCycle(i, graph, new HashSet());
           if(result)
               return false;
        }
        
        return true;
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