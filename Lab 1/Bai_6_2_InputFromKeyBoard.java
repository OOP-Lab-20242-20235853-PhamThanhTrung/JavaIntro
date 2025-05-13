import java.util.Scanner;
import java.util.Locale;
public class Bai_6_2_InputFromKeyBoard {
	public static void main(String args[])
	{
		java.util.Scanner keyboard=new Scanner(System.in);
		keyboard.useLocale(Locale.US);
		System.out.println("What's your name?");
		String strName=keyboard.nextLine();
		System.out.println("How old are you?");
		int iAge=keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight=keyboard.nextDouble();
		System.out.println("Mrs/Ms. " +strName+ ", " +iAge+ " years old. Your height is " +dHeight+ "m.");
	}
}