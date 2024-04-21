
public abstract class AbstractBit 
{
	//private varable of type boolean named bit
	private boolean bit;
	
	//this is a clone method that returns a value of type abstract bit 
	public abstract AbstractBit clone();
	//method that takes in an abstract bit object named guest 
	public abstract AbstractBit addBits(AbstractBit guest);
	//takes in 2 abstract bit objects
	public abstract AbstractBit addBits(AbstractBit guest1, AbstractBit guest2);
	//method that takes in one abstract bit object
	public abstract AbstractBit carryBit(AbstractBit guest);
	//this one takes in 2
	public abstract AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2);
		
	//this is our setter for the bit data
	protected void setBit(boolean value)
	{
		this.bit = value;
	}
	
	//this is our getter for the bit data
	public boolean getBit()
	{
		return this.bit;
	}
	
	
	//this creates a new abstract bit the default value will be false meaning its 0
	public AbstractBit()
	{
		this.bit = false; 
	}
	
	//this is our specifiying constructor this is how we will set our binary values to either 0 (false) and 1 (true)
	public AbstractBit(boolean value)
	{
		this.bit = value;
	}
	
	//this is our copy constructor this will help us 
	//make coppy's of abstact bits
	public AbstractBit(AbstractBit guest)
	{
		this.bit = guest.getBit();
	}
	
	//this is how we will check if two bits are both true or both false
	public boolean equals(AbstractBit guest)
	{
		 return this.bit == guest.getBit();
	}
	
	//this is how we will print off abstract bits 
	//if a bit is true we will print off 1 and if its false we will print off 0
	public String toString()
	{
		if(this.getBit()== true)
		{
			//we will return 1 for true
			return "1";
		}
		else
		{
			//and we will return 0 for false 
			return "0";
		}
	}
}
