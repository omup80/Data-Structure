package google.trees_and_graphs;

import java.util.*;

class EvaluateExpression {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        buildGraph(equations, values);
        double[] result = new double[queries.size()];
        
        for(int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            String node = query.get(0);
            String target = query.get(1);
            if(!graph.containsKey(node)|| !graph.containsKey(target)){
                result[i]=-1;
            }else if(node.equals(target)){
                result[i]=1;
            }else{
                result[i] = evaluateEquation(node, target, 1, new HashSet<String>());
            }
        }
        
        return result;
        
    }
    private double evaluateEquation(String node, String target, double currentProduct, Set<String> visited){
        if(visited.contains(node))
            return -1;
        
        
        Map<String, Double> path = graph.get(node);
        visited.add(node);
        
        if(path.containsKey(target))
            return currentProduct * path.get(target);
        
        
        for(Map.Entry<String,Double> next: path.entrySet()){
            String nextNode = next.getKey();
            double result =  evaluateEquation(nextNode,target, currentProduct * next.getValue(), visited);
            if(result!=-1)
                return result;
            
        }
        visited.remove(node);
        return -1;
        
        
    }
    
    
    private void buildGraph(List<List<String>> equations, double[] values){
        for(int i=0;i<values.length;i++){
            List<String> equation = equations.get(i);
            String divident = equation.get(0);
            String divisor = equation.get(1);
            Double result = values[i];
            
            Map<String, Double> path = graph.getOrDefault(divident, new HashMap<String, Double>());
            
            path.put(divisor, result);
            graph.put(divident, path);
            
            path = graph.getOrDefault(divisor, new HashMap<String, Double>());
            path.put(divident, 1/result);
            graph.put(divisor, path);
        }
    }
}


