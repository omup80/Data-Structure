package mock_test.facebook.oa;
//https://leetcode.com/problems/number-of-days-between-two-dates/
class DaysBetweenDates {
    int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(days(date1)-days(date2));
    }
    private int days(String date){
        String[] dt = date.split("-");
        int y=Integer.parseInt(dt[0]), m=Integer.parseInt(dt[1]), d= Integer.parseInt(dt[2]);
        for(int iy=1971;iy<y;iy++)
            d += isLeap(iy) ? 366 : 365;
        
        for (int i = 1; i < m ; i++) d += days[i];
       
        
        d += isLeap(y)&&m>2?1:0;
        return d;
        
    }

    private boolean isLeap(int year){
        if(year%100==0)
            return  year%400==0?true:false;
        return year%4==0?true:false;
    }
}