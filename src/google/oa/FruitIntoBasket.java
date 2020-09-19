package google.oa;
//904. Fruit Into Baskets
//https://leetcode.com/problems/fruit-into-baskets/
class FruitIntoBasket {
    public int totalFruit(int[] tree) {
        int maxFruit = 0;
        int type1=-1;
        int type2=-1;
        int type2EndIndex=-1;
        int type1EndIndex=-1;
        
        int max=0;
        for(int i=0;i<tree.length;i++){
            if(type1==-1 || type1==tree[i]){
                type1= tree[i];
                type1EndIndex = i;
                max++;
                maxFruit = Math.max(max,maxFruit);
            }else if(type2==-1 || type2==tree[i]){
                type2= tree[i];
                type2EndIndex = i;
                max++;
                maxFruit = Math.max(max,maxFruit);
            }else if(tree[i]!=type1 && tree[i]!=type2){
                max = Math.abs(type1EndIndex-type2EndIndex)+1;
                type1 = type1EndIndex>type2EndIndex?type1:type2;
                type1EndIndex = type1EndIndex>type2EndIndex?type1EndIndex:type2EndIndex;
                type2=tree[i];
                type2EndIndex = i;
                maxFruit = Math.max(max,maxFruit);
            }
            
        }
        return maxFruit;
    }
}