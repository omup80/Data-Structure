package cracking_the_coding_interview.string_and_array;

public class URLify {

    public static void main(String[] args){
        char []str = {'o','m','j',' ', 't', ' ', 's',' ',' ',' ',' ',' ',' ',' '};
        int length = 7;
        System.out.println(replaceString(str, length));
    }

    public static char[] replaceString(char[] str, int length){

        int spaceCount = 0;

        for(int i=0;i< length; i++){
            if(str[i]==' ')
                spaceCount +=1;
        }

        if(spaceCount > 0){
           int trueLength=length + 2*spaceCount;

           //Char array cannot be trimmed in java for extra spaces
           //if(str.length > trueLength){

             //  str[trueLength] = '\0';



           //}

            int k = length-1;
            int j= trueLength-1;

            while(k>0){
                if(str[k]==' '){
                    str[j--]='0';
                    str[j--]='2';
                    str[j--]='%';

                }else{
                    str[j] = str[k];
                    j--;

                }
                k--;

            }



        }

        return str;
    }

}
