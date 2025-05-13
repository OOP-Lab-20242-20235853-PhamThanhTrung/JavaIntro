import java.util.Scanner;
public class Bai_6_4_NgayThangNam {
	public static void main(String[] args)
	{
		java.util.Scanner keyboard=new Scanner(System.in);
		System.out.println("Nhap nam:");
		int year=keyboard.nextInt();
		boolean leapyear=false;
		if(year%4==0)
		{
			leapyear=true;
			if(year%100==0)
				if(year%400==0) leapyear=false;
		}
		keyboard.nextLine();
		System.out.println("Nhap thang:");
		String imonth=keyboard.nextLine();
		int day=0, month=0;
		switch (imonth)
		{
			case "January": case "Jan.": case "Jan": case "1": day=31; month=1; break;
			case "February": case "Feb.": case "Feb": case "2": day= leapyear==true ? 30 : 29; month=2; break;
			case "March": case "Mar.": case "Mar": case "3": day=31; month=3; break;
			case "April": case "Apr.": case "Apr": case "4": day=30; month=4; break;
			case "May": case "5": day=31; month=5; break;
			case "June": case "Jun": case "6": day=30; month=6; break;
			case "July": case "Jul": case "7": day=31; month=7; break;
			case "August": case "Aug.": case "Aug": case "8": day=31; month=8; break;
			case "September": case "Sept.": case "Sep": case "9": day=30; month=9; break;
			case "October": case "Oct.": case "Oct": case "10": day=31; month=10; break;
			case "November": case "Nov.": case "Nov": case "11": day=30; month=11; break;
			case "December": case "Dec.": case "Dec": case "12": day=31; month=12; break;
		}
		System.out.println("Thang " + month + " nam " + year + " co " + day + " ngay.");
		System.exit(0);
	}
}
