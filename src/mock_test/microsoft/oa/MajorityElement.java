package mock_test.microsoft.oa;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/majority-element-ii/
class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        Integer num1=null, num2=null, count1=0, count2=0;
        for(int num: nums){
            if(num1!=null && num==num1){
                count1++;
                
            }else if(num2!=null && num==num2){
                count2++;
            }else if(count1==0){
                num1=num;
                count1++;
            }else if(count2==0){
                num2=num;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        for(int num: nums){
            if(num1!=null && num==num1) count1++;
            if(num2!=null && num==num2) count2++;
        }
        List<Integer> result = new ArrayList<Integer>();
        if(count1>nums.length/3)
            result.add(num1);
        if(count2>nums.length/3)
            result.add(num2);
        
        return result;
        
    }
}