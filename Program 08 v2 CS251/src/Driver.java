
public class Driver 
{
	public static void main(String[] args)
	{
		
		//makes a varable of type binary called n1
	Binary n1 = new Binary();
	// makes a varable named n2 of type binary and passes 10 into it 
	Binary n2 = new Binary(10);
	//makes a varable of type binary called n3 and calls n2.clone to make a clone of it
	Binary n3 = n2.clone();
	//calls the toString method on n1
	System.out.println("n1 = " + n1);
	//finds n1's length
	System.out.println("n1.length() = " + n1.length());
	//finds n2's value 
	System.out.println("n2 = " + n2);
	//finds n2's length 
	System.out.println("n2.length() = " + n2.length());
	//same thing for n3 
	System.out.println("n3 = " + n3);
	System.out.println("n3.length() = " + n3.length());
	//uses the bitAt method and passes 1 into the argument 
	System.out.println("n3.bitAt(1) = " + n3.bitAt(1));
	System.out.println();
	//tests the equals method
	System.out.println("n1 equals n1 ? " + n1.equals(n1));
	System.out.println("n1 equals n2 ? " + n1.equals(n2));
	System.out.println("n2 equals n3 ? " + n2.equals(n3));
	System.out.println();
	//tests the additon method 
	//adding 1010 to 1010 and the expected output should be 10100
	Binary n4 = n2.addition(n2);
	
	System.out.println("n4 = " + n4);
	
	for (int i = 0; i <= 10; ++i)
	{
	n4 = n4.addition(n4);
	n4 = n4.addition(n2);
	System.out.println("n4 = " + n4);
	}
	}
	}

