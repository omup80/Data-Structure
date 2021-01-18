package mock_test.generic.oa;

import java.util.*;

class GenerateSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        for(List<String> synonym: synonyms){
            String w1 = synonym.get(0);
            String w2 = synonym.get(1);
            connect(w1, w2, graph);
            connect(w2, w1, graph);
        }
        Set<String> result = new TreeSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(text);
        
        while(!q.isEmpty()){
            String txt = q.remove();
            result.add(txt);
            String[]  splittedText = txt.split(" ");
            
            for(int i=0;i<splittedText.length;i++){
                if(graph.containsKey(splittedText[i])){
                    String temp = splittedText[i];
                    for(String synonym: graph.get(splittedText[i])){
                        splittedText[i] = synonym;
                        String ans = String.join(" ", splittedText);
                        if(!result.contains(ans))
                            q.add(ans);
                    }
                    splittedText[i] = temp;
                    
                    
                }
                
                
            }
        }
        
        return new ArrayList<String>(result);
        
    }
    
    private void connect(String w1, String w2, Map<String, List<String>> graph){
        List<String> relation = graph.getOrDefault(w1, new ArrayList<String>());
        relation.add(w2);
        graph.put(w1, relation);
    }
}