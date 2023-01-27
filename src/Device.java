// Ngoc Doan CIS340 Tue Thur 1:30-2:45
public class Device {

	//declare attributes
	private String Name;
	private String SKU;
	private String Available;
	
	
	// constructor
	public Device (String SKU, String Name, String Available)
	{
		this.SKU = SKU;
		this.Available = Available;
		this.Name = Name;
	}
	
	
	
	public void setSKU(String SKU)
	{
		this.SKU = SKU;
	}
	public String getSKU()
	{
		return SKU;
	}
	
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public String getName()
	{
		return Name;
	}
	
	public void setAvailable(String Available)
	{
		this.Available = Available;
	}
	public String getAvailable()
	{
		return Available;
	}
}
