package top_questions.hard.trees;

import java.util.*;
//https://leetcode.com/problems/course-schedule/
class CourseSchedule {
    Map<Integer, List<Integer>> map = new HashMap();
    Set<Integer> gVisited = new HashSet<Integer>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] relation: prerequisites){
            List<Integer> children = map.getOrDefault(relation[1], new ArrayList<Integer>());
            children.add(relation[0]);
            map.put(relation[1], children);
        }
        for(int i=0;i<numCourses;i++){
            
                if(dfs(i, new HashSet<Integer>()))
                    return false;
            
            
            
        }
        return true;
        
    }
    
    private boolean dfs(int node, Set<Integer> set){

        if(set.contains(node))
            return true;
        set.add(node);
        
        for(int child: map.getOrDefault(node, new ArrayList<Integer>())){
            if(dfs(child, set))
                    return true;
            
        }
        set.remove(node);
        return false;
    }
    
    
}