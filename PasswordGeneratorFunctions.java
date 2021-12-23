import java.awt.MouseInfo;
import java.util.*;
import javax.swing.JOptionPane;


public class PasswordGeneratorFunctions {
	public static String generatate() {
		String password = "";
		String[] characters = 	{"`","1","2","3","4","5","6","7","8","9","0","-","=","]"
								,"[","p","o","i","u","y","t","r","e","w","q","a","s","d"
								,"f","g","h","j","k","l",";","/",".",",","m","n","b","v"
								,"c","x","z","~","!","@","#","$","%","^","&","*","(",")"
								,"_","+","}","|","{","P","O","I","U","Y","T","R","E","W"
								,"Q","A","S","D","F","G","H","J","K","L",":","?",">","<"
								,"M","N","B","V","C","X","Z"};
		String element = "";
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		char operation1 = 0;
		char operation2 = 0;
		int num = 0;
		boolean loop = true;
		
		double a = MouseInfo.getPointerInfo().getLocation().getX();
		
		int b = (int) Math.round(a);
		
		b = Math.abs(b);
		
		int first = (b / 100) / 3;
		int second = (b / 100) / 2;
		int third = b / 100;
		
		numbers.add(first);
		numbers.add(second);
		numbers.add(third);
		
		System.out.println("b = "+b);
		System.out.println("first = "+numbers.get(0));
		System.out.println("second = "+numbers.get(1));
		System.out.println("third = "+numbers.get(2));
		
		int length = Integer.parseInt(JOptionPane.showInputDialog("How many elements would you like in your password: "));
		JOptionPane.showMessageDialog(null, "Your password will be "+length+" elements long");
		
		for(int i = 1;i<length+1;i++) {
			
			switch (b % i) {
				case 0:
					operation1 = '+';
					break;
				case 1:
					operation1 = '-';
					break;
				case 2:
					operation1 = '*';
					break;
				case 3:
					operation1 = '/';
					break;
			}		
			
			switch (b % i*2) {
				case 0:
					operation2 = '+';
					break;
				case 1:
					operation2 = '-';
					break;
				case 2:
					operation2 = '*';
					break;
				case 3:
					operation2 = '/';
					break;
			}
			
			System.out.println("operation1 = "+operation1);
			System.out.println("operation2 = "+operation2);
			
			int index = getNumber(operation1, operation2, first, second, i);
			
			element = characters[index];
			
			password = password + element;
			
			System.out.println(element);
			
		}

		
		return password;
	}
	
	public static int getNumber(char operator1,char operator2, int a, int b, int c) {
		int value = 0;
		
		if(operator1 == '+') {
			if(operator2 == '+') {
				value = a + b + c;
			}
			if(operator2 == '-') {
				value = a + b - c;
				value = Math.abs(value);
			}
			if(operator2 == '*') {
				value = a + b * c;
			}
			if(operator2 == '/') {
				value = a + b / c;
			}
		}
		
		if(operator1 == '-') {
			if(operator2 == '+') {
				value = a - b + c;
				value = Math.abs(value);
			}
			if(operator2 == '-') {
				value = a - b - c;
				value = Math.abs(value);
			}
			if(operator2 == '*') {
				value = a - b * c;
				value = Math.abs(value);
			}
			if(operator2 == '/') {
				value = a - b / c;
				value = Math.abs(value);
			}
		}
		
		if(operator1 == '*') {
			if(operator2 == '+') {
				value = a * b + c;
			}
			if(operator2 == '-') {
				value = a * b - c;
				value = Math.abs(value);
			}
			if(operator2 == '*') {
				value = a * b * c;
			}
			if(operator2 == '/') {
				value = a * b / c;
			}
		}
		
		if(operator1 == '/') {
			if(operator2 == '+') {
				value = a / b + c;
			}
			if(operator2 == '-') {
				value = a / b - c;
				value = Math.abs(value);
			}
			if(operator2 == '*') {
				value = a / b * c;
			}
			if(operator2 == '/') {
				value = a / b / c;
			}
		}
		
		if(value > 89) {
			value = value / b;
		}
		
		return value;
	}
}












