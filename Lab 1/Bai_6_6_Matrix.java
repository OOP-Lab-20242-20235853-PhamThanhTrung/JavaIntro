import java.util.Arrays;
import java.util.Scanner;
public class Bai_6_6_Matrix {
	public static void main(String[] args)
	{
		java.util.Scanner keyboard=new Scanner(System.in);
		System.out.println("Nhap so hang: ");
		int row=keyboard.nextInt();
		System.out.println("Nhap so cot: ");
		int collumn=keyboard.nextInt();
		int[][] A1, A2, sum;
		A1=new int[row][collumn];
		A2=new int[row][collumn];
		sum=new int[row][collumn];
		System.out.println("Nhap ma tran A1: ");
		for(int i=0; i<row; i++)
			for(int j=0; j<collumn; j++) A1[i][j]=keyboard.nextInt();
		System.out.println("Nhap ma tran A2: ");
		for(int i=0; i<row; i++)
			for(int j=0; j<collumn; j++) A2[i][j]=keyboard.nextInt();
		for(int i=0; i<row; i++)
			for(int j=0; j<collumn; j++) sum[i][j]=A1[i][j]+A2[i][j];
		System.out.println("Tong cua hai ma tran la: " + Arrays.deepToString(sum));
		System.exit(0);
	}
}
