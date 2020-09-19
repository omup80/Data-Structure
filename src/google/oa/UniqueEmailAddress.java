package google.oa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/unique-email-addresses/
//929. Unique Email Address
class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
      Map<String, Set<String>> map = new HashMap<String, Set<String>>();
       int count=0;
       for(String email:emails){
           String[] mail = email.split("@");
           String localAdress = mail[0].split("\\+")[0].replace(".","");
           Set<String> localAddreses = map.getOrDefault(mail[1], new HashSet<String>());
           if(!localAddreses.contains(localAdress)){
               count++;
               localAddreses.add(localAdress);
               map.put(mail[1], localAddreses);
           }
           
       } 
        
        return count;
    }
}