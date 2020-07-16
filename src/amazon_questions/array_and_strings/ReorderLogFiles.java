package amazon_questions.array_and_strings;

import java.util.Arrays;
/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.
It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.
 The letter-logs are ordered lexicographically ignoring identifier, with the identifier used
 in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.


Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (log1, log2) ->{
            String [] split1 = log1.split(" ",2);
            String [] split2 = log2.split(" ",2);   
            
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2  = Character.isDigit(split2[1].charAt(0));
            
            if(!digit1 && !digit2){
                int cmp = split1[1].compareTo(split2[1]);
                if(cmp!=0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            
            return digit1?(digit2?0:1):-1;
        
        }
                   
        );
            
        return logs;
        
    }
}