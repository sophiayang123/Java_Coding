//package Employee_info;
import java.util.Calendar;
public class OurDate {
	private static Calendar calendar = Calendar.getInstance(); 
	private int day;
	private int month;
	private int year;
	
	public OurDate() {
		this(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH+1), calendar.get(Calendar.YEAR));
	}
//	public OurDate(int day) {
//		this(day,calendar.get(Calendar.MONTH));
//	} 
//	public OurDate(int day, int month) {
//		this(day,month,calendar.get(Calendar.YEAR));
//	}
	public OurDate(int day, int month, int year) {		
		this.setYear(year); 
		this.setMonth(month);
		this.setDay(day);
	}
	
	public int getDay() {	
		return day;
	}
	private void setDay(int day) { 
		if (day < 1 || day> calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			throw new IllegalArgumentException("Invalid day ");
		}else
			this.day=day;
	}
	public int getMonth() {
		 return month;
	}
	private void setMonth(int month) {
		if (month < 0 || month>12) {
			throw new IllegalArgumentException("Invalid month ");
		}else
			this.month=month;
	}
	public int getYear() {
		return year;
	}
	private void setYear(int year) {
		if (year < 0 || year> calendar.get(Calendar.YEAR)) {
			throw new IllegalArgumentException("Invalid year");
		}else
			this.year=year;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d/%d", day,month,year);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)  {
			return true;
		}
//		dead code????
//		if(this==null) {
//			return false;
//		}
		if(obj == null) {
			return false;
		}	
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		OurDate other = (OurDate) obj;
		
		return this.getDay()== other.getDay() && this.getMonth() == other.getMonth() && this.getYear() == other.getYear();
			
	}
		
		
	
}
	

	
	
	

