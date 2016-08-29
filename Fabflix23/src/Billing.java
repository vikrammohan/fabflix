

public class Billing {
	public String nameOnCard;
	public int creditID;
	public String expiration;
	public String emailAddress;
	public String password;
	
	public Billing()
	{
		
	}
	
	public String getNameOnCard()
	{
		return nameOnCard;
	}
	
	public void setCardName(String name)
	{
		nameOnCard = name;
	}
	
	public int getCreditID()
	{
		return creditID;
	}
	
	public void setCreditID(int ID)
	{
		creditID = ID;
	}
	
	public String getExp()
	{
		return expiration;
	}
	
	public void setExpiration(String date)
	{
		expiration = date;
	}
	
	public String getEmail()
	{
		return emailAddress;
	}
	
	public void setEmail(String email)
	{
		emailAddress = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
}
