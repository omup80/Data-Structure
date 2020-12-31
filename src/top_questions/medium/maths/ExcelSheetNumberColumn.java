package top_questions.medium.maths;
//https://leetcode.com/problems/excel-sheet-column-number/
class ExcelSheetNumberColumn {
    public int titleToNumber(String s) {
        int i=s.length()-1;
        int result=0;
        int mul=1;
        while(i>=0){
            result += mul*(s.charAt(i)-'A'+1);
            mul = mul * 26;  
            i--;
        }
        
        return result;
    }
}