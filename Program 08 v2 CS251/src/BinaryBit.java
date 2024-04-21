
public class BinaryBit extends AbstractBit 
{
	//makes a static final varable of type binary bit named 0 and 1 
	//the 0 bit is set to true and the 1 bit is set to false 
	public static final BinaryBit zero = new BinaryBit(false);
	public static final BinaryBit one = new BinaryBit(true);
	
	//default consructor 
	//we are going to use the same paramaters from the abstract bit constructor
	//which means that we have a object that is set to false
	public BinaryBit()
	{
		super();
	}
	
	//this is our specifying constructor
	
	public BinaryBit(Boolean bit)
	{
		setBit(bit);
	}
	
	//I dont know what this does 
	//
	public BinaryBit(int bit) {
	    if (bit == 0) 
	    {
	        setBit(false); // Set the bit to false if 0 is passed
	    } 
	    else if (bit == 1) 
	    
	    {
	        setBit(true); // Set the bit to true if 1 is passed
	    } 
	    
	}

	//this is our copy constructor 
	public BinaryBit(BinaryBit guest)
	{
		super(guest);
	}
	
	//we want to make a copy of our binary bit and here is how we are doing it 
	//first we overwrote the abstract method in abstract bit 
	public BinaryBit clone()
	{
		//we called this.get bit to get an identical copy of the bit that we want to clone 
		return new BinaryBit(this.getBit());
	}
    public boolean equals(AbstractBit guest) {
        // Check if the guest bit is a BinaryBit
        if (!(guest instanceof BinaryBit)) 
        {
            return false;
        }

        // Cast the guest bit to BinaryBit
        BinaryBit guestBit = (BinaryBit) guest;

        // Compare the bits for equality
        //returns true or false 
        return this.getBit() == guestBit.getBit();
    }

    //this will be what happens when we print out any indivadual bits
    //the goal is to only print a 0 or a 1 
	public String toString()
	{
		//so our bit can only have 2 positions which are true and false
		if(this.getBit() == true)
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
	// returns the low order bit of adding the host bit to the guest bit
	//this is how we add bits together 
	public AbstractBit addBits(AbstractBit guest) {
	    BinaryBit guestBit = (BinaryBit) guest;
	    
	    if(this.getBit() ^ guestBit.getBit()) 
	    {
	    	return one;
	    } 
	    else 
	    
	    {
	    	return zero;
	    }
	}

	
	// returns the low order bit of adding the host bit, the guest1 bit, and the guest2 bit
	public AbstractBit addBits(AbstractBit guest1, AbstractBit carry) {
	    
		//make both members of type binary bit 
		BinaryBit bit1 = (BinaryBit) guest1;
	    BinaryBit bit2 = (BinaryBit) carry;
	    
	    
	    if(this.getBit() && bit1.getBit()  && bit2.getBit())
	    {
	    	
	    	return zero;
	    }
	    
	    else if(this.getBit()  && bit1.getBit()  && !bit2.getBit() 
	    ||bit1.getBit()  && this.getBit() && bit2.getBit() 
	    ||bit2.getBit() && this.getBit() && bit1.getBit()
	    || (this.getBit() && bit1.getBit() && bit2.getBit()))
	    {
	    	//1+1+1
	    	//1+0+0 and other variations of this as long as there is 2 0's and 1 1's
	    	return one;
	    }
	    
	    
	    return zero;
	}

	
	//3/2  quiootent: 1 Remander: 1
	//1/2  Quotent 0 Ramander: 1
	
	//if sum of bits = 0 then return 0 
	//if the sum of bits = 1 then we return 1 
	//if the sum of bits = 2 then we retuen 0
	//if the sum of bits is 3 then we return 1
	
	
	// returns the high order bit of adding the host bit to the guest bit
	//this method is how we are able to keep our binary numbers accurate
	public AbstractBit carryBit(AbstractBit guest)
	{
		BinaryBit bit = (BinaryBit) guest;
		
		//we will only carry our bits if we add a 1 and a 1 
		//we are returning a one because we want to carry a 1 
		if((this.getBit()==true && bit.getBit() == true))
		{
			return one;
		}
		else
		{
			return zero;
		}
	        
	}
	// returns the high order bit of adding the host bit to the guest bit
	//this method is for adding 3 binary bits together 
	public AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2)
	{
		
		BinaryBit bit1 = (BinaryBit) guest1;
	    BinaryBit bit2 = (BinaryBit) guest2;
	    
	    if(bit1.getBit() && this.getBit() || this.getBit() && bit2.getBit() || bit1.getBit() && bit2.getBit()
	    		|| bit1.getBit() && bit2.getBit() && this.getBit())
	    {
	    	return zero;
	    }
	    else
	    {
	    	return one;
	    }
    }
	
}
