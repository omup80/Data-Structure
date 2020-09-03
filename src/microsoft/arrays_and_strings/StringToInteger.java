package microsoft.arrays_and_strings;
//8. String to Integer (atoi)
//https://leetcode.com/problems/string-to-integer-atoi/
class StringToInteger {
public int myAtoi(String str) {
 
    
 int sign=1;
 int i=0;
 int result=0;
 
 while(i<str.length() && str.charAt(i)==' '){
      i++;    
 }
 
    
if(i==str.length())
      return 0;

 if(str.charAt(i)=='-'){
     sign=-1;
     i++;
 }else if(str.charAt(i)=='+'){
     i++;
 }   
    
    
  while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
      int digit = str.charAt(i)-'0';
      if(result==Integer.MAX_VALUE/10 ){
          if(sign==-1 && digit > Integer.MAX_VALUE%10){
              return Integer.MIN_VALUE;
          }else if(digit > Integer.MAX_VALUE%10){
              return Integer.MAX_VALUE;
          }
       }else if(result>Integer.MAX_VALUE/10){
          if(sign==-1)
              return Integer.MIN_VALUE;
           else
               return Integer.MAX_VALUE;
      }
      result = result * 10 + digit;
      i++;
            
  }   
         
    
  return sign * result;  
}
    
    

}