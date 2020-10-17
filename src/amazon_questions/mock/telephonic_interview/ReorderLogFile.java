package amazon_questions.mock.telephonic_interview;

import java.util.Arrays;
import java.util.Comparator;

class ReorderFileLog {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new LogComparator());
        
        return logs;
    }
    
    
}

class LogComparator implements Comparator<String> {
    
    public int compare(String a, String b){
        String[] s1 = a.split("\\s+");
        String[] s2 = b.split("\\s+");
        if(Character.isDigit(s1[1].charAt(0))  && !Character.isDigit(s2[1].charAt(0)))
            return 1;
        if(!Character.isDigit(s1[1].charAt(0))  && Character.isDigit(s2[1].charAt(0)))
            return -1;
        if(Character.isDigit(s1[1].charAt(0))  && Character.isDigit(s2[1].charAt(0)))
            return 0;
       String newA = a.substring(a.indexOf(" ")+1);
       String newB=b.substring(b.indexOf(" ")+1);
        int result= a.compareTo(b);;
        return newA.compareTo(newB)==0? a.compareTo(b):newA.compareTo(newB);
    }
}