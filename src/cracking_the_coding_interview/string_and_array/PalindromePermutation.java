package cracking_the_coding_interview.string_and_array;
/*
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true


 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int [] characterCount = new int[128];

        for(int i=0;i<s.length();i++){

            characterCount[s.charAt(i)] +=1;

        }

        int oddCount = 0;

        for(int count: characterCount){
            if(count%2 !=0){
                oddCount++;
            }


        }


        if(oddCount==1 && s.length()%2!=0){
            return true;
        }else if(oddCount > 1){
            return false;
        }

        return true;


    }
}
