import java.util.Scanner;
import java.util.Arrays;
public class Bai_6_5_Mang {
	public static void main(String[] args)
	{
		java.util.Scanner keyboard=new Scanner(System.in);
		System.out.println("Nhap so phan tu cua mang:");
		int n=keyboard.nextInt();
		int[] arr;
		arr=new int[n];
		int sum=0;
		System.out.println("Nhap cac phan tu cua mang:");
		for(int i=0; i<n; i++)
		{
			arr[i]=keyboard.nextInt();
			sum=sum+arr[i];
		}
		Arrays.sort(arr);
		System.out.println("Mang sau khi sap xep: " + Arrays.toString(arr));
		System.out.println("Tong cac phan tu cua mang: " + sum);
		System.out.println("Gia tri trung binh cua cac phan tu: " + sum*1.0/n);
		System.exit(0);
	}
}
