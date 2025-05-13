import java.util.Scanner;
public class Bai_6_3_Triangle {
	public static void main(String[] args)
	{
		java.util.Scanner keyboard=new Scanner(System.in);
		System.out.println("Nhap chieu cao tam giac:");
		int h=keyboard.nextInt();
		for(int i=0; i<h; i++)
		{
			for(int j=0; j<h-i-1; j++) System.out.print(" ");
			for(int j=0; j<2*i+1; j++) System.out.print("*");
			for(int j=0; j<h-i-1; j++) System.out.print(" ");
			System.out.println("");
		}
		System.exit(0);
	}
}
