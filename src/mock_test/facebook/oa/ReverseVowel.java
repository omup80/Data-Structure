package mock_test.facebook.oa;
//https://leetcode.com/problems/reverse-vowels-of-a-string/
class ReverseVowel {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int i=0, j=s.length()-1;
        while(i<j){
            if(vowel(a[i]) && vowel(a[j])){
                swap(a, i, j);
                i++;
                j--;
            }else if(vowel(a[i])){
                j--;
            }else if(vowel(a[j])){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return new String(a);
        
    }
    private void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private boolean vowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return true;
        
        if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return true;
        
        return false;
    }
}