package amazon_questions.array_and_strings;
import java.util.Collections;
import java.util.HashMap;

class IntegerToRoman {
    HashMap<Integer, String> ir;
    IntegerToRoman(){
             ir = new HashMap<Integer, String>();
            ir.put(1, "I");
            ir.put(5, "V");
            ir.put(10, "X");
            ir.put(50, "L");
            ir.put(100, "C");
            ir.put(500, "D");
            ir.put(1000, "M");
    
    }
    public String intToRoman(int num) {
        //>3 && <5
        //>5 & 
        
        
        String number = "";
        
        
        int df = 10;
        while(num> 0){
           int r = num%df;
           //find  the roman of remainer
           num = num - r;
           df = df*10;
           String roman = findRoman(r);
           number = roman+number; 
        }
        
        return number;
        
        
    }
    private String findRoman(int number){
        
        if(number/10 ==0){
            return one(number);
        }else if(number/100==0){
            return ten(number);
        }else if(number/1000==0){
            return hundred(number);
        }else{
            return thousand(number);
        }
        
    }
    
    private String one(int number){
        String roman="";
        
        if(number<=3){
           String s =  ir.get(1);
           roman= String.join("", Collections.nCopies(number, s));
        }else if(number > 3 && number<=5){
            if(number==4)
                return ir.get(1)+ir.get(5);
            else
                return ir.get(5);
            
        }else if(number > 5 && number <= 8){
            
            return ir.get(5) + String.join("", Collections.nCopies(number-5, ir.get(1)));
            
        }else{
            return ir.get(1)+ir.get(10);
        }
        
        return roman;
    
    }
    private String ten(int number){
        String roman="";
        
        if(number<=30){
           String s =  ir.get(10);
           roman= String.join("", Collections.nCopies(number/10, s));
        }else if(number > 30 && number<=50){
            if(number==40)
                return ir.get(10)+ir.get(50);
            else
                return ir.get(50);
            
        }else if(number > 50 && number <= 80){
            
            return ir.get(50) + String.join("", Collections.nCopies(number/10-5, ir.get(10)));
            
        }else{
            return ir.get(10)+ir.get(100);
        }
        
        return roman;
    }
    
    private String hundred(int number){
        String roman="";
        
        if(number<=300){
           String s =  ir.get(100);
           roman= String.join("", Collections.nCopies(number/100, s));
        }else if(number > 300 && number<=500){
            if(number==400)
                return ir.get(100)+ir.get(500);
            else
                return ir.get(500);
            
        }else if(number > 500 && number <= 800){
            
            return ir.get(500) + String.join("", Collections.nCopies(number/100-5, ir.get(100)));
            
        }else{
            return ir.get(100)+ir.get(1000);
        }
        
        return roman;
    }
    
    private String thousand(int number){
        return String.join("", Collections.nCopies(number/1000, ir.get(1000)));
    }



    public String intToRomanBestSolution(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}