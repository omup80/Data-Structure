package cracking_the_coding_interview.string_and_array;


import java.util.HashMap;

//Given a string, Determine if the string has all unique characters.?
public class isUnique {
    public static boolean isUniqueCharacter(String str){

        HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();

        for(int i=0;i< str.length(); i++){
           Character c =  str.charAt(i);
           Integer count= characterCount.get(c);
           if(count == null){
               characterCount.put(c, 1);
           }else{
               return false;
           }
        }



        return true;
    }

    public static void main(String []args){
        String str = "omjiti";
        System.out.println(isUniqueCharacter(str));
    }

}
