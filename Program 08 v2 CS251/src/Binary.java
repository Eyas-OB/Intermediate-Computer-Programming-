
public class Binary extends BitString 
{
	
	public Binary()
	{
		super();
	}
	// encode a non-negative (base 10) number val such into
	// the host’s bitstring - used in the Binary(long val) constructor
	private void encode(long val)
	{
		//checks if the value is a positive number
		if (val < 0) 
		{
			// if not positive we get mad
	        throw new IllegalArgumentException("Value must be non-negative.");
	    }
		// we clear our constructor because there is a 0 in it 
		getAbstractBitList().clear();
		//while the value is greater than 0 
		while (val > 0) 
		{
	        // Append the least significant bit (remainder of val / 2) to the beginning of the bitString ArrayList
	        getAbstractBitList().add(0, new BinaryBit((int) (val % 2)));
	        // Update val by dividing it by 2 to shift to the next bit position
	        val /= 2;
	    }

	    // If the bitString is empty, add a single zero bit to represent the value 0
	    if (getAbstractBitList().isEmpty()) {
	        getAbstractBitList().add(new BinaryBit(false));
	    }
	}
	public Binary(long val)
	{
		super();
		encode(val);
	}
	public Binary(BitString guest)
	{
		
	}
	public Binary(Binary guest)
	{
		super(guest);
	}
	
	public Binary clone() {
	    // Create a new Binary object to store the cloned bits
	    Binary clonedBinary = new Binary();
	    
	    clonedBinary.getAbstractBitList().clear();
	    
	    // Iterate through each bit in the current Binary and add a cloned copy to the new Binary
	    for (AbstractBit bit : this.getAbstractBitList()) {
	        // Clone the bit and add it to the cloned Binary
	        clonedBinary.addBit(bit.clone());
	    }

	    // Return the cloned Binary
	    return clonedBinary;
	}

	
	public Binary addition(Binary guest) 
	{
	    
		//make a new binary object to store the result
		Binary result = new Binary();
	    //set carry to false because we are not going to be
	    BinaryBit carry = new BinaryBit(false);
	    
	    //find the longer of the 2 lengths 
	    int maxLength = Math.max(this.length(), guest.length());

	    while (this.length() != guest.length()) 
	    {
	        guest.addBit(new BinaryBit(false));
	    }
	    
	    for (int i = 0; i < maxLength; i++) 
	    {
	        AbstractBit bit1 = this.bitAt(i);
	        AbstractBit bit2 = guest.bitAt(i);
	        
	       
	        carry = (BinaryBit) bit1.carryBit(bit2, carry);
	        AbstractBit sum = bit1.addBits(bit2, carry);
	      
	        result.addBit(sum);
	        
	        
	    }

	    if (carry.getBit()) 
	    {
	        result.addBit(new BinaryBit(true));
	    }

	    result.reverse();
	    return result;
	}
		
	}//class

	
	
	
	
	


