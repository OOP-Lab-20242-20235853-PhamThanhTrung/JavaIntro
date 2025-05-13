//Bai_2_2_6_Equation
import javax.swing.JOptionPane;
public class Bai_2_2_6_Equation{
	public static void main(String[] args){
		String menuInput;
		menuInput = JOptionPane.showInputDialog(null, "Please select the menu:\n1. The first-degree equation (linear equation) with one variable\n2. The system of first-degree equations (linear system) with two variables\n3. The second-degree equation with one variable\n", "MENU", JOptionPane.INFORMATION_MESSAGE);
		double menu = Double.parseDouble(menuInput);
		if(menu == 1)
		{
			String aInput = JOptionPane.showInputDialog(null, "In the format ax + b = 0\nPlease input a:", "First-degree equation with one variable", JOptionPane.INFORMATION_MESSAGE);
			String bInput = JOptionPane.showInputDialog(null, "In the format ax + b = 0\nPlease input b:", "First-degree equation with one variable", JOptionPane.INFORMATION_MESSAGE);
			double a = Double.parseDouble(aInput);
			double b = Double.parseDouble(bInput);
			System.out.println("Your equation is: " + a + "x + " + b + " = 0\n");
			if(a == 0)
				if(b == 0) System.out.println("This equation has infinitely many solutions\n");
				else System.out.println("This equation has no solution\n");
			else System.out.println("This equation has a unique solution of " + (0 - b) / a);
		}
		else
			if(menu == 2)
			{
				String a_11, a_12, a_21, a_22, b_1, b_2;
				a_11 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put a11:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				a_12 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put a12:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				b_1 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put b1:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				a_21 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put a21:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				a_22 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put a22:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				b_2 = JOptionPane.showInputDialog(null, "In the format:\n\ta11x + a12y = b1\n\ta21x + a22y = b2\nPlease in put b2:", "System of First_degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
				double a11 = Double.parseDouble(a_11);
				double a12 = Double.parseDouble(a_12);
				double b1 = Double.parseDouble(b_1);
				double a21 = Double.parseDouble(a_21);
				double a22 = Double.parseDouble(a_22);
				double b2 = Double.parseDouble(b_2);
				System.out.println("Your equation is:\n" + a11 + "x + " + a12 + "y = " + b1 + "\n" + a21 + "x + " + a22 + "y = " + b2);
				double d = a11*a22 - a12*a21;
				double d1 = b1*a22 - a12*b2;
				double d2 = a11*b2 - b1*a21;
				if(d != 0)
					System.out.println("This equation has a unique solution of x = " + d1/d + " and y = " + d2/d);
				else
					if(d1 == 0 && d2 == 0) System.out.println("This equation has infinitely many solutions\n");
					else System.out.println("This equation has no solution\n");
			}
			else
				if(menu == 3)
				{
					String aInput, bInput, cInput;
					aInput = JOptionPane.showInputDialog(null, "In the format: ax2 + bx + c = 0\nPlease in put a:", "Second_degree equations with one variable", JOptionPane.INFORMATION_MESSAGE);
					bInput = JOptionPane.showInputDialog(null, "In the format: ax2 + bx + c = 0\nPlease in put b:", "Second_degree equations with one variable", JOptionPane.INFORMATION_MESSAGE);
					cInput = JOptionPane.showInputDialog(null, "In the format: ax2 + bx + c = 0\nPlease in put c:", "Second_degree equations with one variable", JOptionPane.INFORMATION_MESSAGE);
					double a = Double.parseDouble(aInput);
					double b = Double.parseDouble(bInput);
					double c = Double.parseDouble(cInput);
					System.out.println("Your equation is: " + a + "x2 + " + b + "x + " + c + " = 0\n");
					if(a == 0)
					{
						if(b == 0)
							if(c == 0) System.out.println("This equation has infinitely many solutions\n");
							else System.out.println("This equation has no solution\n");
						else System.out.println("This equation has a unique solution of " + (0 - b) / a);
						System.exit(0);
					}
					double delta = b*b - 4*a*c;
					if(delta == 0)
						System.out.println("This equation has a double root for " + (0 - b)/(2*a));
					else
						if(delta > 0)
							System.out.println("This equation has two distinct roots for " + (0 - b + Math.sqrt(delta))/(2*a) + " and " + (0 - b - Math.sqrt(delta))/(2*a));
						else
							System.out.println("This equation has no integer root");
				}
		System.exit(0);
	}
}
