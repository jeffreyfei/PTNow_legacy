import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*This class incorporates the Pinetree Secondary block rotation and bell schedule of 2013-2014
 *and is specially designed to work as a schedule on an updating clock
 *
 *NOTE: since the school schedule varies each year, update must be made each and every school
 * year to keep the schedule in sync with the school's schedule 
 * 													By: Jeffrey Fei From Pinetree C.S.C.*/

public class BlockRotation {
	private int currentWeekday;
	private int currentDayOfYear;
	private int currentTimeMin;
	private String currentBlk;
	private String nextBlk;
	private boolean hasSchool;
	private int rotationPeriod;
	final private String fileName = "settings.dat";
	private boolean hasClass;
	/////////////////////////////variables for schedule excluding Wednesday////////////////////////
	int timeStart;
	int time1End;
	int time2Start;
	int time2End;
	int time3Start;
	int time3End;
	int time4Start;
	int time4End;
	int time5Start;
	int time5End;
	int time6Start;
	int timeEnd;
	/////////////////////////////variables for schedule of Wednesday////////////////////////////
	int timeStartWed;
	int time1EndWed;
	int time2StartWed;
	int time2EndWed;
	int time3StartWed;
	int time3EndWed;
	int time4StartWed;
	int time4EndWed;
	int time5StartWed;
	int time5EndWed;
	int time6StartWed;
	int time6EndWed;
	int time7StartWed;
	int timeEndWed;
	
	BlockRotation() throws IOException {
		Time time = new Time();
		currentWeekday = time.getDayOfWeek();
		currentDayOfYear = time.getDayOfYear();
		currentTimeMin = time.adjustTime();
		hasSchool = false;
		rotationPeriod = 0;
		currentBlk = "";
		hasClass = false;
		nextBlk = "";
		initializeSchedule();
		updateInstance();
	}
	
	private void initializeSchedule() throws IOException {
		ArrayList<Integer> settings = readSettings();
		boolean hasNull = false;
		for(int i = 0; i < settings.size(); ++i) {
			if(settings.get(i) == null) {
				hasNull = true;
			} else {
				hasNull = false;
			}
		}
		if(!hasNull) {
			timeStart = settings.get(21);
			time1End = settings.get(22);
			time2Start = settings.get(23);
			time2End = settings.get(24);
			time3Start = settings.get(25);
			time3End = settings.get(26);
			time4Start = settings.get(27);
			time4End = settings.get(28);
			time5Start = settings.get(29);
			time5End = settings.get(30);
			time6Start = settings.get(31);
			timeEnd = settings.get(32);
			timeStartWed = settings.get(33);
			time1EndWed = settings.get(34);
			time2StartWed = settings.get(35);
			time2EndWed = settings.get(36);
			time3StartWed = settings.get(37);
			time3EndWed = settings.get(38);
			time4StartWed = settings.get(39);
			time4EndWed = settings.get(40);
			time5StartWed = settings.get(41);
			time5EndWed = settings.get(42);
			time6StartWed = settings.get(43);
			time6EndWed = settings.get(44);
			time7StartWed = settings.get(45);
			timeEndWed = settings.get(46);

		}
		
	}
	/* Method to read the data from the settings file 
	 * Index Number		Data
	 * 		0			School Opening Date
	 * 		1			First Block Rotation
	 * 		2			Second Block Rotation
	 * 		3			Third Block Rotation
	 * 		4			School Closing Date
	 * */
	public ArrayList<Integer> readSettings() throws IOException  {
		ArrayList<Integer> data = new ArrayList<Integer>();
		try {
			Scanner inFile = new Scanner(new FileReader(fileName));
			while(inFile.hasNextLine()) {
				data.add(Integer.parseInt(inFile.nextLine()));
			}
			inFile.close();
			
		} catch(FileNotFoundException fnfe) {
			data.add(0, 244);
			data.add(1, 324);
			data.add(2, 36);
			data.add(3, 99);
			data.add(4, 169);
			data.add(20, 0);
			PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
			for(int i = 0; i < 20; ++i) {
				outFile.println(0);
			}
			outFile.close();
			
		}
		return data;
	}

	//this method updates the status of the block rotation schedule
	private void updateInstance() throws IOException {
		int op = 244;
		int firstBR = 324;
		int secondBR = 36;
		int thirdBR = 99;
		int cl = 169;
		
		ArrayList<Integer> settings = readSettings();
		String[] blk = {"Dismissal", "Block 1", "Block 2", "Block 3", "Block 4", "Block 5", "Break", "Lunch", "Pack"};
		if(settings.get(0) != null && settings.get(1) != null && settings.get(2) != null && settings.get(3) != null && settings.get(4) != null) {
			op = settings.get(0) - 1;
			firstBR = settings.get(1) - 3;
			secondBR = settings.get(2) - 3;
			thirdBR = settings.get(3) - 3;
			cl = settings.get(4) + 1;
		}
		if(currentWeekday > 1 && currentWeekday < 7) {
			switch(currentWeekday) {
			case 2:
				if(currentTimeMin >= timeStart && currentTimeMin < time1End) {
					currentBlk = blk[1];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time1End && currentTimeMin < time2Start) {
					currentBlk = blk[1];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time2Start && currentTimeMin < time2End) {
					currentBlk = blk[2];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time2End && currentTimeMin < time3Start) {
					currentBlk = blk[2];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time3Start && currentTimeMin < time3End) {
					currentBlk = blk[3];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time3End && currentTimeMin < time4Start) {
					currentBlk = blk[3];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time4Start && currentTimeMin < time4End) {
					currentBlk = blk[7];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time4End && currentTimeMin < time5Start) {
					currentBlk = blk[7];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time5Start && currentTimeMin < time5End) {
					currentBlk = blk[4];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time5End && currentTimeMin < time6Start) {
					currentBlk = blk[4];
					nextBlk = blk[5];
				}

				if(currentTimeMin >= time6Start && currentTimeMin < timeEnd) {
					currentBlk = blk[5];
					nextBlk = blk[0];
				}
				break;
			case 3:
				if(currentTimeMin >= timeStart && currentTimeMin < time1End) {
					currentBlk = blk[1];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time1End && currentTimeMin < time2Start) {
					currentBlk = blk[1];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time2Start && currentTimeMin < time2End) {
					currentBlk = blk[3];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time2End && currentTimeMin < time3Start) {
					currentBlk = blk[3];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time3Start && currentTimeMin < time3End) {
					currentBlk = blk[4];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time3End && currentTimeMin < time4Start) {
					currentBlk = blk[4];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time4Start && currentTimeMin < time4End) {
					currentBlk = blk[7];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time4End && currentTimeMin < time5Start) {
					currentBlk = blk[7];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time5Start && currentTimeMin < time5End) {
					currentBlk = blk[5];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time5End && currentTimeMin < time6Start) {
					currentBlk = blk[5];
					nextBlk = blk[2];
				}

				if(currentTimeMin >= time6Start && currentTimeMin < timeEnd) {
					currentBlk = blk[2];
					nextBlk = blk[0];
				}
				break;
			case 4:
				if(currentDayOfYear > op && currentDayOfYear < firstBR) {
					rotationPeriod = 1;
					if(currentTimeMin >= timeStart && currentTimeMin < time1EndWed) {
						currentBlk = blk[2];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time1EndWed && currentTimeMin < time2StartWed) {
						currentBlk = blk[2];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time2StartWed && currentTimeMin < time2EndWed) {
						currentBlk = blk[3];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time2EndWed && currentTimeMin < time3StartWed) {
						currentBlk = blk[3];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time3StartWed && currentTimeMin < time3EndWed) {
						currentBlk = blk[4];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time3EndWed && currentTimeMin < time4StartWed) {
						currentBlk = blk[4];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time4StartWed && currentTimeMin < time4EndWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time4EndWed && currentTimeMin < time5StartWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time5StartWed && currentTimeMin < time5EndWed) {
						currentBlk = blk[7];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time5EndWed && currentTimeMin < time6StartWed) {
						currentBlk = blk[7];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time6StartWed && currentTimeMin < time6EndWed) {
						currentBlk = blk[5];
						nextBlk = blk[1];
					}
					if(currentTimeMin >= time6EndWed && currentTimeMin < time7StartWed) {
						currentBlk = blk[5];
						nextBlk = blk[1];
					}
					if(currentTimeMin >= time7StartWed && currentTimeMin < timeEnd) {
						currentBlk = blk[1];
						nextBlk = blk[0];
					}
				}
				if(currentDayOfYear >= firstBR || currentDayOfYear < secondBR) {
					rotationPeriod = 2;
					if(currentTimeMin >= timeStart && currentTimeMin < time1EndWed) {
						currentBlk = blk[3];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time1EndWed && currentTimeMin < time2StartWed) {
						currentBlk = blk[3];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time2StartWed && currentTimeMin < time2EndWed) {
						currentBlk = blk[4];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time2EndWed && currentTimeMin < time3StartWed) {
						currentBlk = blk[4];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time3StartWed && currentTimeMin < time3EndWed) {
						currentBlk = blk[5];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time3EndWed && currentTimeMin < time4StartWed) {
						currentBlk = blk[5];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time4StartWed && currentTimeMin < time4EndWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time4EndWed && currentTimeMin < time5StartWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time5StartWed && currentTimeMin < time5EndWed) {
						currentBlk = blk[7];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time5EndWed && currentTimeMin < time6StartWed) {
						currentBlk = blk[7];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time6StartWed && currentTimeMin < time6EndWed) {
						currentBlk = blk[2];
						nextBlk = blk[1];
					}
					if(currentTimeMin >= time6EndWed && currentTimeMin < time7StartWed) {
						currentBlk = blk[2];
						nextBlk = blk[1];
					}

					if(currentTimeMin >= time7StartWed && currentTimeMin < timeEnd) {
						currentBlk = blk[1];
						nextBlk = blk[0];
					}
				}
				if(currentDayOfYear >= secondBR && currentDayOfYear < thirdBR) {
					rotationPeriod = 3;
					if(currentTimeMin >= timeStart && currentTimeMin < time1EndWed) {
						currentBlk = blk[4];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time1EndWed && currentTimeMin < time2StartWed) {
						currentBlk = blk[4];
						nextBlk = blk[5];
					}
					if(currentTimeMin >= time2StartWed && currentTimeMin < time2EndWed) {
						currentBlk = blk[5];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time2EndWed && currentTimeMin < time3StartWed) {
						currentBlk = blk[5];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time3StartWed && currentTimeMin < time3EndWed) {
						currentBlk = blk[2];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time3EndWed && currentTimeMin < time4StartWed) {
						currentBlk = blk[2];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time4StartWed && currentTimeMin < time4EndWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time4EndWed && currentTimeMin < time5StartWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time5StartWed && currentTimeMin < time5EndWed) {
						currentBlk = blk[7];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time5EndWed && currentTimeMin < time6StartWed) {
						currentBlk = blk[7];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time6StartWed && currentTimeMin < time6EndWed) {
						currentBlk = blk[3];
						nextBlk = blk[1];
					}
					if(currentTimeMin >= time6EndWed && currentTimeMin < time7StartWed) {
						currentBlk = blk[3];
						nextBlk = blk[1];
					}

					if(currentTimeMin >= time7StartWed && currentTimeMin < timeEnd) {
						currentBlk = blk[1];
						nextBlk = blk[0];
					}
				}
				if(currentDayOfYear >= thirdBR && currentDayOfYear < cl) {
					rotationPeriod = 4;
					if(currentTimeMin >= timeStart && currentTimeMin < time1EndWed) {
						currentBlk = blk[5];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time1EndWed && currentTimeMin < time2StartWed) {
						currentBlk = blk[5];
						nextBlk = blk[2];
					}
					if(currentTimeMin >= time2StartWed && currentTimeMin < time2EndWed) {
						currentBlk = blk[2];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time2EndWed && currentTimeMin < time3StartWed) {
						currentBlk = blk[2];
						nextBlk = blk[3];
					}
					if(currentTimeMin >= time3StartWed && currentTimeMin < time3EndWed) {
						currentBlk = blk[3];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time3EndWed && currentTimeMin < time4StartWed) {
						currentBlk = blk[3];
						nextBlk = blk[8];
					}
					if(currentTimeMin >= time4StartWed && currentTimeMin < time4EndWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time4EndWed && currentTimeMin < time5StartWed) {
						currentBlk = blk[8];
						nextBlk = blk[7];
					}
					if(currentTimeMin >= time5StartWed && currentTimeMin < time5EndWed) {
						currentBlk = blk[7];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time5EndWed && currentTimeMin < time6StartWed) {
						currentBlk = blk[7];
						nextBlk = blk[4];
					}
					if(currentTimeMin >= time6StartWed && currentTimeMin < time6EndWed) {
						currentBlk = blk[4];
						nextBlk = blk[1];
					}
					if(currentTimeMin >= time6EndWed && currentTimeMin < time7StartWed) {
						currentBlk = blk[4];
						nextBlk = blk[1];
					}

					if(currentTimeMin >= time7StartWed && currentTimeMin < timeEnd) {
						currentBlk = blk[1];
						nextBlk = blk[0];
					}
				}
					
				break;
			case 5:
				if(currentTimeMin >= timeStart && currentTimeMin < time1End) {
					currentBlk = blk[1];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time1End && currentTimeMin < time2Start) {
					currentBlk = blk[1];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time2Start && currentTimeMin < time2End) {
					currentBlk = blk[4];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time2End && currentTimeMin < time3Start) {
					currentBlk = blk[4];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time3Start && currentTimeMin < time3End) {
					currentBlk = blk[5];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time3End && currentTimeMin < time4Start) {
					currentBlk = blk[5];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time4Start && currentTimeMin < time4End) {
					currentBlk = blk[7];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time4End && currentTimeMin < time5Start) {
					currentBlk = blk[7];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time5Start && currentTimeMin < time5End) {
					currentBlk = blk[2];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time5End && currentTimeMin < time6Start) {
					currentBlk = blk[2];
					nextBlk = blk[3];
				}

				if(currentTimeMin >= time6Start && currentTimeMin < timeEnd) {
					currentBlk = blk[3];
					nextBlk = blk[0];
				}
				break;
			case 6:
				if(currentTimeMin >= timeStart && currentTimeMin < time1End) {
					currentBlk = blk[1];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time1End && currentTimeMin < time2Start) {
					currentBlk = blk[1];
					nextBlk = blk[5];
				}
				if(currentTimeMin >= time2Start && currentTimeMin < time2End) {
					currentBlk = blk[5];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time2End && currentTimeMin < time3Start) {
					currentBlk = blk[5];
					nextBlk = blk[2];
				}
				if(currentTimeMin >= time3Start && currentTimeMin < time3End) {
					currentBlk = blk[2];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time3End && currentTimeMin < time4Start) {
					currentBlk = blk[2];
					nextBlk = blk[7];
				}
				if(currentTimeMin >= time4Start && currentTimeMin < time4End) {
					currentBlk = blk[7];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time4End && currentTimeMin < time5Start) {
					currentBlk = blk[7];
					nextBlk = blk[3];
				}
				if(currentTimeMin >= time5Start && currentTimeMin < time5End) {
					currentBlk = blk[3];
					nextBlk = blk[4];
				}
				if(currentTimeMin >= time5End && currentTimeMin < time6Start) {
					currentBlk = blk[3];
					nextBlk = blk[4];
				}

				if(currentTimeMin >= time6Start && currentTimeMin < timeEnd) {
					currentBlk = blk[4];
					nextBlk = blk[0];
				}
				break;
					
				
			}
			hasSchool = true;	
		} else {
			hasSchool = false;
		}
		
		if(currentTimeMin >= timeStart && currentTimeMin <= timeEnd) {
			hasClass = true;
		} else {
			hasClass = false;
		}
	}
		

	//this blocks takes in the day of week and the row number in order to determine the current block number
	public String getTableLine(int dayOfWeek, int rowNum) {
		int[] blkPattern = {1, 2, 3, 4, 5};
		switch(dayOfWeek) {
			case 2:
				blkPattern = new int[]{1, 2, 3, 4, 5};
				break;
			case 3:
				blkPattern = new int[]{1, 3, 4, 5, 2};
				break;
			case 4:
				switch(rotationPeriod) {
					case 1:
						blkPattern = new int[]{2, 3, 4, 5, 1};
						break;
					case 2:
						blkPattern = new int[]{3, 4, 5, 2, 1};
						break;
					case 3:
						blkPattern = new int[]{4, 5, 2, 3, 1};
						break;
					case 4:
						blkPattern = new int[]{5, 2, 3, 4, 1};
						break;
				}
				break;
		
			case 5:
				blkPattern = new int[]{1, 4, 5, 2, 3};
				break;
			case 6:
				blkPattern = new int[]{1, 5, 2, 3, 4};
				break;
		}
		return "Block " + blkPattern[rowNum - 1];
	}
	
	//This method returns the number of row that is going to be highlighted
	public int getCurrentRow() {
		int currentRow = 0;
		if(currentWeekday != 4 && currentWeekday != 1 && currentWeekday != 7) {
			if(currentTimeMin >= timeStart && currentTimeMin < time1End) {
				currentRow = 1;
			}
			if(currentTimeMin >= time1End && currentTimeMin < time2End) {
				currentRow = 2;
			}
			if(currentTimeMin >= time2End && currentTimeMin < time3End) {
				currentRow = 3;
			}
			if(currentTimeMin >= time3End && currentTimeMin < time4End) {
				currentRow = 4;
			}
			if(currentTimeMin >= time4End && currentTimeMin < time5End) {
				currentRow = 5;
			}
			if(currentTimeMin >= time5End && currentTimeMin < timeEnd) {
				currentRow = 6;
			}
		}
		if(currentWeekday == 4) {
			if(currentTimeMin >= timeStart && currentTimeMin < time1EndWed) {
				currentRow = 1;
			}
			if(currentTimeMin >= time1EndWed && currentTimeMin < time2EndWed) {
				currentRow = 2;
			}
			if(currentTimeMin >= time2EndWed && currentTimeMin < time3EndWed) {
				currentRow = 3;
			}
			if(currentTimeMin >= time3EndWed && currentTimeMin < time4EndWed) {
				currentRow = 4;
			}
			if(currentTimeMin >= time4EndWed && currentTimeMin < time5EndWed) {
				currentRow = 5;
			}
			if(currentTimeMin >= time5EndWed && currentTimeMin < time6EndWed) {
				currentRow = 6;
			}

			if(currentTimeMin >= time6EndWed && currentTimeMin < timeEnd) {
				currentRow = 7;
			}
			
		}
		return currentRow;
	}
	
	/* Method to save the data from the settings file 
	 *		Name			Data
	 * 		op			School Opening Date
	 * 		fst			First Block Rotation
	 * 		snd			Second Block Rotation
	 * 		trd			Third Block Rotation
	 * 		cl			School Closing Date
	 * */
	public void saveSettings(int[] data) throws IOException {
		PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
		for(int dat : data) {
			outFile.println(dat);
		}
		outFile.close();
	}
	
	public boolean ifHasSchool() {
		return hasSchool;
	}
	
	public boolean ifHasClass() {
		return hasClass;
	}
	
	public String getCurrentBlk() {
		if(hasSchool) {
			if(hasClass) {
				return currentBlk;
			}
			else {
				return "Class Not In Session";
			}
		}
		return "No School Today";
	}
	
	public String getTimeInterval(int row) {
		if(currentWeekday == 4) {
            switch(row) {
                case 1:
                	return "8:00 - 9:14";
                case 2:
                	return "9:19 - 10:33";
                case 3:
                	return "10:38 - 11:52";
                case 4:
                    return "11:57 - 12:22";
                case 5:
                	return "12:22 - 1:02";
                case 6:
                	return "1:02 - 2:16";
                case 7:
                	return "2:21 - 3:35";
                case 8:
                	return "";
                default:
                	return "";
    
            }
        }else{
            switch(row) {
	            case 1:
	            	return "8:00 - 9:19";
	            case 2:
	            	return "9:24 - 10:43";
	            case 3:
	            	return "10:48 - 12:07";
	            case 4:
	                return "12:07 - 12:47";
	            case 5:
	            	return "12:47 - 2:11";
	            case 6:
	            	return "2:11 - 3:30";
	            case 7:
	            	return "";
	            case 8:
	            	return "";
	            default:
	            	return "";
    
            }
        }
	}
	public String getNextBlk() {
		if(hasClass && hasSchool) {
			return nextBlk;
		}
		return "";
	}
	
	private String backToTime(int minTot) throws IOException {
		Time t = new Time();
		int[] temp = Time.backConvert(minTot);
		int hours = temp[0];
		int min = temp[1];
		String minStr = min + "";
		String hoursStr = hours + "";
		if(min < 10) {
			minStr = "0" + min;
		}
		else {
			minStr = min + "";
		}
		if(hours < 13) {
			if(hours == 0)	{
				hoursStr = "12";
			}
			if(hours == 12) {
				hoursStr = "12";
			}
		}
		else {
			hoursStr = hours - 12 + "";
		}
		
		return hoursStr + ":" + minStr;
	}

	
}