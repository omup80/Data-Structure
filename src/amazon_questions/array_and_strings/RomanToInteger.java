package amazon_questions.array_and_strings;

class RomanToInteger {
    public int romanToInt(String s) {
         String []symbol =     {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
         int    []digit =     {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        int number=0;
        int i=0;
        int j=0;
       // int len = s.length();
        //VI
        while(i<s.length() && j< symbol.length){
            int ls = symbol[j].length();
           // int ls = j%2==0?1:2;
            if(i+ls>s.length()){
                j++;
            } else if(s.substring(i, i+ls).equals(symbol[j])){
                number = number + digit[j];
                i = i+ ls; 
            }else{
                j++;
            }
                
            
        }
        return number;
    }
}