package amazon_questions.trees_and_graph;



import java.util.*;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<prerequisites.length;i++){
            //int course = prerequisites[i][0];
            //int dependency = prerequisites[i][1];
            
            List<Integer> dependencies = graph.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            dependencies.add(prerequisites[i][1]);
            graph.put(prerequisites[i][0], dependencies);
        }
        
        boolean[] visited = new boolean[numCourses];
        
        Set<Integer> currentlyVisited = new HashSet<Integer>();
        
        for(int course=0;course< numCourses;course++){
            if(visited[course]==true)
                continue;
            
            if(checkCycleByDfs(course,graph, visited, currentlyVisited)==false)
                return false;
            
        }
        return true;
    }
    
    private boolean checkCycleByDfs(int course, Map<Integer, List<Integer>> graph, boolean[] visited, Set<Integer> currentlyVisited){
            
           if(currentlyVisited.contains(course))
                    return false;
        
           visited[course] = true;
        
           currentlyVisited.add(course);
        
           List<Integer> dependencies = graph.getOrDefault(course, new ArrayList<Integer>());
            
            for(int dependency: dependencies){
                
               if(checkCycleByDfs(dependency, graph, visited, currentlyVisited)==false)
                   return false;
                               
            }
        
        currentlyVisited.remove(course);
        return true;
    }
}