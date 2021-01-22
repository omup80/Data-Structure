package mock_test.facebook.oa;
//https://leetcode.com/problems/custom-sort-string/
class CustomSortString {
    public String customSortString(String S, String T) {
       int[] count = new int[26];
       for(char c: T.toCharArray())
           count[c-'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()){
            for(int i=0;i<count[c-'a'];i++)
                sb.append(c);
            count[c-'a']=0;
        }
        
        for(char c='a';c<='z';c++){
            if(count[c-'a']>0){
                for(int i=0;i<count[c-'a'];i++)
                    sb.append(c);
                count[c-'a']=0;
            }
        }
        return sb.toString();
    }
    
}