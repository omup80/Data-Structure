package practise.arrays;

public class ShortestWordDistance {
        public int shortestDistance(String[] words, String word1, String word2) {
            boolean word1Found = false;
            boolean word2Found = false;
            int word1Index = 0;
            int word2Index = words.length;
            int leastLength = Integer.MAX_VALUE;

            for(int i=0; i< words.length; i++){
                if(words[i].equals(word1)){
                    word1Index = i;
                    word1Found = true;
                    if(word2Found)
                        leastLength = Math.min(leastLength, Math.abs(word1Index-word2Index) );

                }else if(words[i].equals(word2)){
                    word2Index = i;
                    word2Found = true;
                    if(word1Found)
                        leastLength =Math.min(leastLength, Math.abs(word1Index-word2Index) );

                }

            }
            return leastLength;
        }

}
