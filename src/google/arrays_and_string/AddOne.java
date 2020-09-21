package google.arrays_and_string;
//https://leetcode.com/problems/plus-one/
//66. Plus One
class AddOne {
    public int[] plusOne(int[] digits) {
        int sum=1;
        for(int i=digits.length-1;i>=0;i--){
             sum = sum+digits[i];
            if(sum<=9){
                digits[i] = sum;
                return digits;
            }else{
                digits[i]=0;
                sum=1;
            }
                 
        }
        int[] result = new int[digits.length+1];
        result[0] = sum;
        for(int i=1;i<result.length;i++){
            result[i]=digits[i-1];
        }
        return result;
    }
}