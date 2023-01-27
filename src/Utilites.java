import java.util.Scanner;

//Ngoc Doan CIS340 Tue Thur 1:30-2:45
public class Utilites {
// pressEnter method
	Scanner inputDevice = new Scanner(System.in);
	public void pressEnter()
	{
		System.out.println("Please Enter to continue...");
	}
	
//readInput method
	public void readInput()
	{
		inputDevice.nextLine();
	}
//invalidNumber method
	public void invalidNumber()
	{
		System.out.println("Invalid Number");
	}
}
