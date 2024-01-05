package logicTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePunch {
	String job;
	String start;
	String end;
	
	
	//Handle the time punches
	public TimePunch(String job, String start, String end) {
		this.job = job;
		this.start = start;
		this.end = end;
	}
	
	
    public double calculateMinutes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        double difference = 0;
        try {
            Date startDate = format.parse(start);
            
            Date endDate = format.parse(end);
            
            difference = ((endDate.getTime() - startDate.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference / 60000.0;
    }
}



