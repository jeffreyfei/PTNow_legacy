import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
/*This class is built to extract information from the current system time in order
 * to construct programs like a digital clock
 * 													By: Jeffrey Fei from Pinetree C.S.C.*/
import java.util.Scanner;

public class Time {

	private int hour;
	private int min;
	private int sec;
	private int dayOfWeek;
	private int dayOfMonth;
	private int month;
	private int year;
	private int dayOfYear;
	ArrayList<Integer> al;
	
	Time() throws IOException {
		Calendar cal = Calendar.getInstance();
		hour = getAdjHour();
		min = getAdjMin();
		//hour = cal.get(Calendar.HOUR_OF_DAY);
		//min = cal.get(Calendar.MINUTE);
		sec = cal.get(Calendar.SECOND);
		dayOfMonth =  cal.get(Calendar.DAY_OF_MONTH);
		dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
	}
	
	//this method will return the time in HH:MM:SS format when no parameter is entered
	public String getTime() {
		String hourStr = "";
		String minStr = "";
		String secStr = "";




		hourStr = hour + "";
		if(min < 10) {
			minStr = "0" + min;
		}
		else {
			minStr = min + "";
		}
		if (sec < 10) {
			secStr = "0" + sec;
		}
		else {
			secStr = sec + "";
		}
		String currentTime = hourStr + ":" + minStr + ":" + secStr;
		return currentTime;
	}
	//this method could return different formats of time given type and format
	public String getTime(int type, String format) {
		
		
		String hourStr = "";
		String minStr = "";
		String secStr = "";



		hourStr = hour + "";
		if(min < 10) {
			minStr = "0" + min;
		}
		else {
			minStr = min + "";
		}
		if (sec < 10) {
			secStr = "0" + sec;
		}
		else {
			secStr = sec + "";
		}
		if(type == 12 && format.equals("HM")) {
			if(hour < 13) {
				String currentTime = hourStr + ":" + minStr + " AM";
				if(hour == 0)	{
					currentTime = "12" + ":" + minStr + " AM";
				}
				if(hour == 12) {
					currentTime = "12" + ":" + minStr + " PM";
				}
				return currentTime;
			}
			else {
				String currentTime = hour - 12 + ":" + minStr + " PM";
				return currentTime;
			}
			
		}
		if(type == 24 && format.equals("HM")) {
				String currentTime = hourStr + ":" + minStr;
				return currentTime;
		}
		String currentTime = hourStr + ":" + minStr + ":" + secStr;
		return currentTime;
		
	}
	//this method returns the date within a year in numbers, and month & weeks in names
	public String getDate() {
		String dayOfMonthStr = "";
		String dayOfWeekStr = "";
		String monthStr = "";
		String yearStr = year + "";
		
		dayOfMonthStr = dayOfMonth + "";
		
		String[] weekDayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturaday"};
		dayOfWeekStr = weekDayName[dayOfWeek - 1];

		String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		monthStr = monthName[month];
		
		
		String currentDate = dayOfWeekStr + "  " + monthStr + ". " + dayOfMonthStr + "  " + yearStr;
		
		return currentDate;
		
		
	}
	
	//These getter methods enables user to get different components of the current time individually
	//get hour in 24 hr format
	public int getHour() {
		return hour;
	}
	//get current minute
	public int getMin() {
		return min;
	}
	//get current second
	public int getSec() {
		return sec;
	}
	//get current month in numerical value
	public int getMonth() {
		return month + 1;
	}
	//get day of week in numerical value
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	//get current date with respective with month
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	//get current year
	public int getYear() {
		return year;
	}
	//get date with respective of the year
	public int getDayOfYear() {
		return dayOfYear;
	}
	//get minute with respective of the day
	public int getMinOfDay() {
		Calendar cal = Calendar.getInstance();
		int hourR = cal.get(Calendar.HOUR_OF_DAY);
		int minR = cal.get(Calendar.MINUTE);
		return (hourR * 60) + minR;
	}
	
	//convert date relative to a certain month to date relative within a certain year
	public int convertDateOfYear(int date, int month, int year) {
		int dateOfYear = 0;
		month -= 1;
		int[] daysWithinMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean isLeapYear = false;
		if(year % 4 == 0) {
			if(year % 100 != 0) {
				isLeapYear = true;
			}
			if(year % 100 == 0 && year % 400 == 0) {
				isLeapYear = true;
			}
		}
		if(isLeapYear) {
			daysWithinMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		}
		for(int i = 0; i < month; ++i) {
			dateOfYear += daysWithinMonth[i];
		}
		dateOfYear += date;
		return dateOfYear;
	}
	
	public int convertMinOfDay(int hours, int min) {
		return (hours * 60) + min;
	}
	
	
	public static int[] backConvert(int totMin) {
	        int hours = 0;
	        int mins = 0;
	        hours = (totMin - (totMin % 60)) / 60;
	        mins = totMin - (hours * 60);
	        int[] time = {hours, mins};
	        return time;
	    }
	    
	public int adjustTime() throws IOException {
	        int minTot = getMinOfDay();
			
			int ajTime = readSettings();
			int result = ajTime + minTot;
			
			if(result > 1440) {
			    result -= 1440;
			}
			if(result < 0) {
			    result += 1440;
			}
			return result;
	 }
	
	private int getAdjMin() throws IOException {
		int totMin = adjustTime();
		int hours = (totMin - (totMin % 60)) / 60;
		int min = totMin - (hours * 60);
		return min;
	}
	
	private int getAdjHour() throws IOException {
		int totMin = adjustTime();
		int hours = (totMin - (totMin % 60)) / 60;
		return hours;
	}
	
	private int readSettings() throws IOException  {
		String fileName = "settings.dat";
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner inFile = new Scanner(new FileReader(fileName));
		while(inFile.hasNextLine()) {
			data.add(Integer.parseInt(inFile.nextLine()));
		}
		inFile.close();
		
		int factor = data.get(20);
			
		
		return factor;
	}

}



