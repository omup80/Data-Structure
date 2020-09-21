package google.arrays_and_string;
//https://leetcode.com/problems/multiply-strings/
//43. Multiply Strings

class MultiplyString {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] val = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = mul+val[i+j+1];
                val[i+j] = val[i+j]+sum/10;
                val[i+j+1] = sum%10;
            }
        }
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m+n;i++){
            if(s.length()!=0 || val[i]!=0){
                s.append(val[i]);
            }
        }
            
        return s.length()==0?"0":s.toString();
    }
    
   
}