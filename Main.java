import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		String Password = PasswordGeneratorFunctions.generatate();
		System.out.println("Password: "+Password);
		JOptionPane.showMessageDialog(null, "You're password is:\n "+Password);
	}

}
