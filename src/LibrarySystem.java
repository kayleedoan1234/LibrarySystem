
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

// Ngoc Doan CIS340 Tue Thur 1:30 - 2:45
public class LibrarySystem extends Utilites {
	static Scanner inputDevice = new Scanner(System.in);
	static int input = 0;
	static ArrayList <Device> deviceList = new ArrayList<>(10);
	static int numberOrder = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibrarySystem myLibrarySystem = new LibrarySystem(); 	
		Device device1 = new Device("6757A", "Apple 9.7 - inch iPad Pro", "Available");
		Device device2 = new Device("93P51B","Amazon Kindle Fire Kids Edition","Available");
		Device device3 = new Device("10N8C","LeapFrog Epic Learning Tablet","Available");
		Device device4 = new Device("85U20","Amazon Kindle Fire HD 8", "Checked Out");
		Device device5 = new Device("91H2D","HP Envy 8 Note","Available");

		deviceList.add(device1);
		deviceList.add(device2);
		deviceList.add(device3);
		deviceList.add(device4);
		deviceList.add(device5);

		
		while (true) {
			myLibrarySystem.printTitle();
			System.out.println();
			myLibrarySystem.loadList();
			myLibrarySystem.askMenu();
			
			switch (input)
			{
			case 1:
				myLibrarySystem.printTitle();
				System.out.println("- List");
				myLibrarySystem.listDevice();
				break;

			case 2:
				myLibrarySystem.printTitle();
				System.out.println("- Add New Device");
				myLibrarySystem.addDevice();
				break;

			case 3:
				myLibrarySystem.printTitle();
				System.out.println("- List");
				myLibrarySystem.editDevice();
				break;

			case 4:
				myLibrarySystem.printTitle();
				System.out.println("- Search");
				myLibrarySystem.searchDevice();
				break;

			case 5:
				myLibrarySystem.printTitle();
				System.out.println("- Check Out Device");
				myLibrarySystem.checkOut();
				break;

			case 6:
				myLibrarySystem.printTitle();
				System.out.println("- Check In Device");
				myLibrarySystem.checkIn();
				break;

			case 7:
				myLibrarySystem.exit();
				break;
			}
		}
	}


	//addDevice method
		public void addDevice()
		{
			String SKU = "";
			String Name = "";
			System.out.print("Sku: ");
			SKU = inputDevice.nextLine().toUpperCase();
			while (SKU.length() > 6)
			{
				System.out.print("Sku: ");
				SKU = inputDevice.nextLine().toUpperCase();
			}
			
			System.out.print("Name: ");
			Name = inputDevice.nextLine();
			Device newDevice= new Device(SKU.toUpperCase(),Name,"Available");
			deviceList.add(newDevice);
			newDevice.setSKU(SKU);
			newDevice.setName(Name);
			newDevice.setAvailable("Available");
			System.out.printf("Added %s to Catalog",newDevice.getName());
			System.out.println();
			super.pressEnter();
			super.readInput();

		}


	// askMenu method
	public void askMenu()
	{
		System.out.print("Select menu options 1-7: ");
		
		try {
			input = Integer.parseInt(inputDevice.nextLine());
		} 
		catch (NumberFormatException e) {
			input = 0;
		}
	}
	
	// checkIn method
	public void checkIn()
	{
		int deviceIn = 0;
		boolean checkinStatus = false;

		for(int i = 0; i<deviceList.size(); i++)
		{
			if(deviceList.get(i).getAvailable().equalsIgnoreCase("Checked Out"))
			{
				System.out.printf("%-2s%-10s%-40s\n",i + 1,deviceList.get(i).getSKU(),deviceList.get(i).getName());
			}
		}
		System.out.print("Enter device number: ");
		deviceIn = Integer.parseInt(inputDevice.nextLine());
		
		if(deviceIn > deviceList.size())
		{
			super.invalidNumber();
			return;
		}
		
		if (deviceList.get(deviceIn - 1).getAvailable()== "Checked Out")
		{
			deviceList.get(deviceIn - 1).setAvailable("Available");
			checkinStatus = true;
		}
		else {
			checkinStatus = false;
		}
		
		
		if (checkinStatus)
		{
			System.out.println("Device Checked In");
		}
		else {
			System.out.println("This device is not checked out");
		}
		
		super.pressEnter();
		super.readInput();
	}



	// checkOut method
	public void checkOut()
	{
		boolean checkoutStatus = false;
		int deviceOut = 0;
		for(int i = 0; i < deviceList.size(); i++)
		{
			if(deviceList.get(i).getAvailable().equalsIgnoreCase("Available"))
			{
				System.out.printf("%-2s%-10s%-40s\n",i+1,deviceList.get(i).getSKU(),deviceList.get(i).getName());
			}
		}
		System.out.print("Enter device number: ");
		deviceOut = Integer.parseInt(inputDevice.nextLine());
	
		
		if (deviceOut > deviceList.size()) 
		{
			super.invalidNumber();
			return;
		}
		
		if (deviceList.get(deviceOut - 1).getAvailable().equalsIgnoreCase("Available")) 
		{
			deviceList.get(deviceOut - 1).setAvailable("Checked Out");
			checkoutStatus = true;
		}
		else {
			checkoutStatus = false;
		}
	
		if(checkoutStatus)
		{
			System.out.println("Device Checked Out");
			
		}
		else
		{
			System.out.println("This device is already checked out. ");
		}
		
		super.pressEnter();
		super.readInput();
	
	}
	
	
	// editDevice method
	public void editDevice()
	{
		int numberEditInput = 0;
		String SKU = "";
		String Name = "";
		System.out.printf("\t#%-10s%-30s","SKU","Name");
		System.out.println();
		for(int i = 0; i < deviceList.size(); i++)
		{
			System.out.printf("%-2s%-10s%-40s%-30s\n",i+1, deviceList.get(i).getSKU(),deviceList.get(i).getName(),deviceList.get(i).getAvailable());
		}
		System.out.printf("Enter Device number to edit(1-%d): ",deviceList.size());
		numberEditInput = Integer.parseInt(inputDevice.nextLine());
		System.out.println();
	
		
		if (numberEditInput <= deviceList.size()) {
			System.out.print("Sku: ");
			SKU = inputDevice.nextLine().toUpperCase();
			while (SKU.length() > 6)
			{
				System.out.print("Sku: ");
				SKU = inputDevice.nextLine().toUpperCase();
			}
			System.out.print("Name: ");
			Name = inputDevice.nextLine();
			deviceList.get(numberEditInput-1).setSKU(SKU);
			deviceList.get(numberEditInput-1).setName(Name);
			System.out.println("Device information updated");
		}
		
		else 
		{
			super.invalidNumber();
		} 
		super.pressEnter();
		super.readInput();
	}
	
	// exit method
		public void exit()
		{
			System.out.println("Good bye!");
			inputDevice.close();
			System.exit(0);
		}
	

	//loadList method
	public void loadList()
	{
		System.out.println("1. List Devices by Title");
		System.out.println("2. Add New Devices");
		System.out.println("3. Edit Device Information");
		System.out.println("4. Search by Device Name");
		System.out.println("5. Check Out Device");
		System.out.println("6. Check In Devices");
		System.out.println("7. Exit");
	}

	// listDevice method
	public void listDevice()
	{
		System.out.printf("%-2s%-10s%-40s\n","#","SKU","Name");

		for(int i = 0; i < deviceList.size(); i++)
		{
			System.out.printf("%-2s%-10s%-40s%-30s\n",i+1,deviceList.get(i).getSKU(),deviceList.get(i).getName(),deviceList.get(i).getAvailable());
		}

		super.pressEnter();
		super.readInput();

	}


	// printTitle method
	public void printTitle()
	{
		System.out.print("\t\tLibrary Device Checkout System");
	}

	// searchDevice method
	public void searchDevice()
	{
		String keySearch = "";
		System.out.print("Enter Device to search for: ");
		keySearch = inputDevice.nextLine();
		System.out.printf("Listings for '%s'",keySearch);
		System.out.println();
		System.out.printf("%-2s%-10s","#","SKU");
		System.out.println();
		String variable = "";
		for(int i = 0; i < deviceList.size();i++) 
		{
			//ignore case needed
			variable = deviceList.get(i).getName().toLowerCase();
			if(variable.contains(keySearch.toLowerCase())== true)
			{
				System.out.printf("%-2s%-10s%-40s\n",i+1,deviceList.get(i).getSKU(),deviceList.get(i).getName());
			}
		}
		super.pressEnter();
		super.readInput();

	}
	

	
	
}
