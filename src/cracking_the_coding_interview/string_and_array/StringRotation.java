package cracking_the_coding_interview.string_and_array;
/*
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A
can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
 */
class StringRotation {
    public boolean rotateString(String A, String B) {

        if(A.length() ==0 && B.length()==0)
            return true;

        if(A.length() != B.length()){
            return false;
        }
        //all patterns are available in A+A
        A = A + A;

        int [] lpsTable = getLpsTable(B);

        int i=0;
        int j=0;

        while(j<A.length()){
            if(A.charAt(j) == B.charAt(i)){
                j++;
                i++;
                if(i==B.length())
                    return true;

            }else if(A.charAt(j) != B.charAt(i) && i!=0){
                i = lpsTable[i-1];
            }else{
                j++;
            }
        }

        return false;
    }


    private int[] getLpsTable(String B){
        int []lpsTable = new int[B.length()];

        int i = 0;
        int j = 1;

        while(j<B.length()){
            if(B.charAt(i)==B.charAt(j)){
                lpsTable[j] = i+1;
                i++;
                j++;
            }else if(B.charAt(i)!=B.charAt(j) && i==0){
                j++;

            }else if(B.charAt(i)!=B.charAt(j) && i>0){
                i = lpsTable[i-1];
            }

        }

        return lpsTable;
    }
}