import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Dummy {
    public static void main(String[] args) {
        Date d = new Date();
        //System.out.println(d);
        SimpleDateFormat ft = 
        new SimpleDateFormat ("yyyy/MM/dd");
        String formatedDate = ft.format(d);
        System.out.println("Current Date: " + formatedDate);
        //System.out.println(d);
    }
}