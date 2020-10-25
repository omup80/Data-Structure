package amazon_questions.mock.onsite;

import java.util.*;

class KSimilarString {
    public int kSimilarity(String A, String B) {
        Set<String> visited = new HashSet();
        int result = 0;
        Queue<String> q = new LinkedList();
        q.add(A);
        visited.add(A);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String a = q.remove();
                if(a.equals(B))
                    return result;
                for(String child: getChildren(a, B)){
                    if(!visited.contains(child)){
                        q.add(child);
                        visited.add(child);
                    }
                        
                }
                
            }
            result++;
        }
        return result;
    }
    private List<String> getChildren(String A, String B){
        int i =0;
        char[] a = A.toCharArray();
        List<String> children = new ArrayList();
        
        while(i<A.length() && a[i]==B.charAt(i))
            i++;
        
        int j=i+1;
        while(j<A.length()){
            if(a[j]==B.charAt(i)){
                swap(a,i,j);
                children.add(new String(a));
                swap(a, i, j);
            }
            j++;
        }
        return children;
    }
    
    private void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}