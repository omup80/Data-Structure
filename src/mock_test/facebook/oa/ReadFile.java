package mock_test.facebook.oa;
//https://leetcode.com/problems/read-n-characters-given-read4/
class Reader4{
    public int read4(char[] buf4){

        return 0;
    }
}
class ReadFile extends Reader4 {
    char[] buf4 = new char[4];
    int buffStartPtr=0;
    int buffEndPtr=0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalCharRead=0;
        int ptr=0;
        //remaining character read
        while(buffStartPtr<buffEndPtr){
            buf[ptr] = buf4[buffStartPtr];
            buffStartPtr++;
            ptr++;
            totalCharRead++;
        }
        
        while(totalCharRead<n){
            int count = read4(buf4);
            if(count<4 && totalCharRead+count<=n){
                for(int i=0;i<count;i++)
                    buf[i+ptr] = buf4[i];
                totalCharRead += count;
                buffStartPtr=0;
                buffEndPtr=0;
                break;
            }else if(count==4 && totalCharRead+count<n){
                for(int i=0;i<count;i++)
                    buf[i+ptr] = buf4[i];
                ptr=ptr+count;
                totalCharRead += count;
            }else if(count==4 && totalCharRead+count==n){
                for(int i=0;i<count;i++)
                    buf[i+ptr] = buf4[i];
                buffStartPtr=0;
                buffEndPtr=0;
                totalCharRead += count;
                break;
            }else if(count<4 && totalCharRead+count>n){
                int diff = n-totalCharRead;
                for(int i=0;i<count;i++)
                    buf[i+ptr] = buf4[i];
                buffStartPtr += diff;
                buffEndPtr += count;
                totalCharRead += diff;
            }else if(count==4 && totalCharRead+count>n){
                int diff = n-totalCharRead;
                for(int i=0;i<count;i++)
                    buf[i+ptr] = buf4[i];
                buffStartPtr += diff;
                buffEndPtr += count;
                totalCharRead += diff;
            } 
            
            
        }
        
        return totalCharRead;
        
    }
}