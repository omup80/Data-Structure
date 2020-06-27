package amazon_questions.array_and_strings;

import java.util.ArrayList;
import java.util.Arrays;

class StringToInteger {
    public int myAtoi(String str) {
        ArrayList<Character> digits = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
        int i = 0;
        int characterType=-1;
        long nums=0;
        //find first character
        while(i<str.length()){
            if(digits.contains(str.charAt(i))){
                if('0'==str.charAt(i)){
                    i++;
                    if(characterType!=0){
                    characterType=2;
                    
                }
                    continue;
                }
                if(characterType!=0){
                    characterType=2;
                    
                }
                    
                break;
            }
            if(characterType ==0 || characterType==1||characterType==2){
             return 0;   
            }else if('+'==str.charAt(i)){
                
                characterType = 1;
                i++;
            }else if('-'==str.charAt(i)){
               
                characterType = 0;
                i++;
            }else if(' '==str.charAt(i)){
                i++;
            }else{
                return 0;
            }
                            
                  
        }
        
        if(characterType == -1)
            return 0;
        
        StringBuffer number = new StringBuffer();
        
        //if(characterType == 0 || characterType == 1)
          //  i++;
        
        //extract the number
        while(i<str.length()){
            if(digits.contains(str.charAt(i))){
                number.append(str.charAt(i));
                i++;
            }else{
                break;
            }
                
        }
        
        //handle more than largest number
        
        
        //handle less than lowest number
        i=number.length()-1;
        long multiplicationFactor = 1;
        
        while(i>=0){
            char digit = number.charAt(i);
            switch(digit){
            case '0': 
                  nums = nums    + 0* multiplicationFactor;
                   break; 
            case '1':
                   nums = nums    + 1* multiplicationFactor;
                   break;
  
            case '2':
                    nums = nums    + 2* multiplicationFactor;
                    break;
            case '3':
                    nums = nums    + 3* multiplicationFactor;
                    break;
            case '4':
                    nums = nums    + 4* multiplicationFactor;
                    break;
            case '5':
                    nums = nums    + 5* multiplicationFactor;
                    break;
            case '6':
                    nums = nums    + 6* multiplicationFactor;
                    break;
            case '7':
                    nums = nums    + 7* multiplicationFactor;
                    break;
            case '8':
                    nums = nums    + 8* multiplicationFactor;
                    break;
            case '9':
                    nums = nums    + 9* multiplicationFactor;
                    
            }
            if(characterType==0){
                if(nums > Math.pow(2, 31) || multiplicationFactor > Math.pow(2, 31))
                    return (int)(-1 * Math.pow(2,31));
            }else{
                if(nums > Math.pow(2, 31)-1 || multiplicationFactor > Math.pow(2, 31)-1 )
                    return (int)(Math.pow(2,31)-1);
            }
           multiplicationFactor = multiplicationFactor*10; 
           i--; 
        }
        
        if(characterType==0)
            return (int)(nums * -1);
        return (int)nums;
        
    }
}