
public class Stack extends DynArray 
{
	public int size()
	{
		return super.arraySize();
	}
	
	public boolean isEmpty()
	{
		if (super.elements() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void push(double value)
	{
		super.insert(value);
	}
	
	public double pop()
	{
		if (this.isEmpty() == false)
		{
			return super.remove();
		}
		else 
		{
			return Double.NaN;
		}
	}
	
	public void stackDump()
	{
		super.printArrayrev();
	}
	
	
}
