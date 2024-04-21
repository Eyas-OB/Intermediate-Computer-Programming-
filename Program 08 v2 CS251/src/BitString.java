import java.util.*;
public class BitString 
{
	// an ordered sequence of bits
	private ArrayList<AbstractBit> bitString;
	
	private void setAbstractBitList(ArrayList<AbstractBit> bitList)
	{
		this.bitString = bitList;
	}
	
	public ArrayList<AbstractBit> getBitString()
	{
		return bitString;
	}
	
	protected ArrayList<AbstractBit> getAbstractBitList()
	{
		return bitString;
	}
	// adds a bit to the end of the arrayList of bits
	public void addBit(AbstractBit bit)
	{
		//this will add a bit into our string
		bitString.add(bit);
	}
	// returns a reference to the bit at location loc in the ArrayList of bits
	public AbstractBit bitAt(int loc) 
	{
	    // Calculate the index from the end of the bitString
	    int indexFromEnd = bitString.size() - loc - 1;

	    // Check if the calculated index is within the bounds of the string
	    if (indexFromEnd >= 0 && indexFromEnd < bitString.size()) 
	    {
	        // Get the bit at the specified location and return it
	        AbstractBit bit = bitString.get(indexFromEnd);
	        return bit;
	    } 
	    else 
	    {
	        // If the location is out of bounds, throw an exception
	        throw new IndexOutOfBoundsException("Index out of bounds: " + loc);
	    }
	}

	public BitString()
	{
		//we are making a container to hold our sequence of bits
		//we toss a 0 into the list
		this.bitString = new ArrayList<AbstractBit>();
		this.bitString.add(new BinaryBit(false));
		
	}
	protected BitString(ArrayList<AbstractBit> bitList) 
	{
		
		// Create a new ArrayList and copy the elements from bitList
	    this.bitString = new ArrayList<>(bitList); 
	}
	
	public BitString(BitString guest)
	{
		this.bitString = new ArrayList<>(guest.getAbstractBitList());
		 
	}
	
	public boolean isEmpty()
	{
		//this is a built in function of array lists so we can just call it in this method 
		return bitString.isEmpty();
	}
	public int length()
	{
		return bitString.size();	
	}
	
	//this is how we are going to code out bitStrings
	public BitString clone()
	{
		//we make a new bitstring called cloned bitstring
		//which means that cloned bitstring it a new array list 
		BitString clonedBitString = new BitString();
		
		//we are finding evrey abstract bit object in our bitstring arraylist 
		//we are looking for abstract bit objects because its the most flexable data to work with 
		for(AbstractBit i : bitString)
		{
			//then we add each bit to the array list at index i so basically we are cloning each element into 
			// the new array 
			clonedBitString.addBit(i.clone());
		}
		return clonedBitString;
	}
	public boolean equals(BitString other) 
	{
        // Check if both BitString instances have the same length
        if (this.length() != other.length()) 
        {	
            return false; // If lengths are different, the BitString instances are not equal
        }

        // Check if each bit in both BitString instances is equal
        for (int i = 0; i < this.length(); i++) 
        {
            if (!this.bitAt(i).equals(other.bitAt(i))) 
            {
                return false; // If any bits are different, the BitString instances are not equal
            }
        }

        // If all bits are equal, the BitString instances are equal
        return true;
    }
// this is how we are going to print out our array list 
	public String toString() {
	    StringBuilder result = new StringBuilder();

	    for (int i = 0; i < bitString.size(); i++) {
	        result.append(bitString.get(i));
	    }

	    return result.toString();
	}
	public void reverse() {
	    Collections.reverse(bitString);
	}

}
