import javax.swing.JOptionPane;
public class Bai_2_2_5_Calculation {
	public static void main(String[] args){
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and";
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		System.out.println("two numbers is " + num1 + " and " + num2);
		double sum = num1 + num2;
		System.out.println("Sum: " + sum);
      		double difference = num1 - num2;
		System.out.println("Difference: " + difference);
		double product = num1 * num2;
		System.out.println("product: " + product);
		if (num2 != 0)
        	{
			double quotient = num1 / num2;
			System.out.println("quotient: " + quotient);
		}
        	else
        		System.out.println("Can not divide by 0.");
		System.exit(0);
	}
}