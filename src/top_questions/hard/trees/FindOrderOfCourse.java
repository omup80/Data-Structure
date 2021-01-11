package top_questions.hard.trees;

import java.util.*;
//
class FindOrderOfCourse {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        
        for(int[] relation: prerequisites){
            
            
            indegree[relation[0]] +=1;
            List<Integer> children = map.getOrDefault(relation[1], new ArrayList<Integer>());
            children.add(relation[0]);
            map.put(relation[1], children);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        
        int index=0;
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
    
        while(!q.isEmpty()){
            Integer node = q.remove();
            result[index++] = node;
            for(Integer child: map.getOrDefault(node, new ArrayList<Integer>())){
                indegree[child]--;
                if(indegree[child]==0)
                    q.add(child);
                
            }
            
            
        }
        System.out.println(index);
        if(index==numCourses)
            return result;
        return new int[0];
    }
}