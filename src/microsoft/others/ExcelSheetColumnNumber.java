package microsoft.others;
//171. Excel Sheet Column Number
//https://leetcode.com/problems/excel-sheet-column-number/
class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        int multiplicationFactor=1;
        
        for(int i=s.length()-1;i>=0;i--){
            result += value(s.charAt(i)) * multiplicationFactor;
            multiplicationFactor = multiplicationFactor * 26;
        }
        
        return result;
    }
    
    private int value(char c){
        
        return c - 'A' + 1;
    }
}