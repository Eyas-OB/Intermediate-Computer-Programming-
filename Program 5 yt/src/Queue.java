
public class Queue extends DynArray 
{
	public int size()
	{
		return super.arraySize();
	}
	
	public boolean isEmpty()
	{
		if(super.elements() == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	public void que(double value)
	{
		super.insert(value);
	}
	
	public double deQue()
	{
		if (this.isEmpty() == false)
		{
			return super.remove1st();
		}
		else 
		{
			return Double.NaN;
		}
	}
	
	public double deQueue()
	{
		return super.remove1st();	
	}
	
	public void queueDump()
	{
		super.printArray();
	}
}

