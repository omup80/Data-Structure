package cracking_the_coding_interview.string_and_array;


/*
Check if two strings are permutation of each other
Write a function to check whether two given strings are
Permutation of each other or not. A Permutation of a string is another string
that contains same characters, only the order of characters can be different.
For example, “abcd” and “dabc” are Permutation of each other.
 */

//Complexity is n for this method
public class CheckPermutation {

    public static boolean checkPermutation(String str1, String str2){
        if(str1.length() !=str2.length())
            return false;

        int [] charCount = new int[256];

        for(int i=0 ; i<str1.length();i++){
           charCount[str1.charAt(i)] +=1;

        }

        for(int i=0 ; i<str2.length();i++){
            charCount[str2.charAt(i)] -=1;

        }

        for(int i=0 ; i<charCount.length;i++){

            if(charCount[i]!=0)
                return false;

        }

        return true;


    }

    public static void main(String [] args){
        System.out.println(checkPermutation("abcd","dbac"));
    }
}
