package amazon_questions.mock.oa;

class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int point=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum += calories[i];
        }
        
        point += calculatePoint(sum, lower, upper);
        
        for(int i=k;i<calories.length;i++){
            sum = sum-calories[i-k]+calories[i];
            point += calculatePoint(sum, lower, upper);
        }
        
        return point;
    }
    
    private int calculatePoint(int T, int lower, int upper){
       
        if(T< lower)
            return -1;
        if(T>upper)
            return 1;
        return 0;
    }
}