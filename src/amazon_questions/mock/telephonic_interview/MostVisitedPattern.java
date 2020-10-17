package amazon_questions.mock.telephonic_interview;

import java.util.*;

class Pair{
    int time;
    String web;
    public Pair(int time, String web){
        this.time=time;
        this.web=web;
    }
}
class MostVisitedPatern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap();
        
        for(int i=0;i<username.length;i++){
           List<Pair> seq = map.getOrDefault(username[i], new LinkedList<Pair>());
           seq.add(new Pair(timestamp[i], website[i]));
           map.put(username[i],seq);
        }
        
        String result="";
        Map<String, Integer> count = new HashMap();
        for(List<Pair> data: map.values()){
            Set<String> set = new HashSet();
            Collections.sort(data, (a,b)-> a.time-b.time);
            
            for(int i=0;i<data.size();i++){
                for(int j=i+1;j<data.size();j++){
                    for(int k=j+1;k<data.size();k++){
                       StringBuffer sb = new StringBuffer();
                       sb.append(data.get(i).web).append(" ").append(data.get(j).web).append(" ").append(data.get(k).web);
                       String s = sb.toString();
                       if(!set.contains(s)){
                         int c = count.getOrDefault(s, 0);
                         count.put(s, c+1);
                         set.add(s);  
                       } 
                       
                       if("".equals(result) || count.get(s) > count.get(result) || (count.get(s)== count.get(result) && result.compareTo(s)>0)) 
                           result=s;   
                    }
                }
            }
            
        }
        
    
       return Arrays.asList(result.split(" "));
    
    
    
    } 
    
}