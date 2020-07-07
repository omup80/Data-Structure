package amazon_questions.array_and_strings;

import javafx.util.Pair;

class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] sVersion1 = version1.split("\\.");
        String[] sVersion2 = version2.split("\\.");
        
        
        int v1Len = sVersion1.length;
        int v2Len = sVersion2.length;
        
        int loop  = v1Len > v2Len ? v2Len: v1Len;
        
        int i = 0;
        for(;i< loop;i++){
            
            if(Integer.parseInt(sVersion1[i]) > Integer.parseInt(sVersion2[i])){
                return 1;
            }else if(Integer.parseInt(sVersion1[i]) < Integer.parseInt(sVersion2[i]) ){
                return -1;
            }
            
        }
        
        if(v1Len==v2Len)
               return 0;
               
         if(v1Len>v2Len){
             for(;i<v1Len;i++){
                 
                 if(Integer.parseInt(sVersion1[i]) >0)
                    return 1;
             }
         }else{
             for(;i<v2Len;i++){
                 if(Integer.parseInt(sVersion2[i]) >0)
                    return -1;
             }
         }      
        
         return 0;      
    }
    public int compareVersionBetterSolution(String version1, String version2){ {
            int p1 = 0, p2 = 0;
            int n1 = version1.length(), n2 = version2.length();

            // compare versions
            int i1, i2;
            Pair<Integer, Integer> pair;
            while (p1 < n1 || p2 < n2) {
                pair = getNextChunk(version1, n1, p1);
                i1 = pair.getKey();
                p1 = pair.getValue();

                pair = getNextChunk(version2, n2, p2);
                i2 = pair.getKey();
                p2 = pair.getValue();
                if (i1 != i2) {
                    return i1 > i2 ? 1 : -1;
                }
            }
            // the versions are equal
            return 0;
        }
    }
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        // if pointer is set to the end of string
        // return 0
        if (p > n - 1) {
            return new Pair(0, p);
        }
        // find the end of chunk
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }
        // retrieve the chunk
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }
        // find the beginning of next chunk
        p = pEnd + 1;

        return new Pair(i, p);
    }
}