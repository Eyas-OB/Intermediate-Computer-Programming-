
public class DynArray 
{
	private double[] array;
	private int size;
	private int nextIndex;
	
	public DynArray()
	{
		this.array = new double[1];
		this.size = 1;
		this.nextIndex = 0;
	}
	
	public int arraySize()
	{
		return size;
	}
	
	public int elements()
	{
		return nextIndex;
	}
	
	public double at(int index)
	{
		if(0<= index && index < nextIndex)
		{
			return array[index];
		}
		else
		{
			return Double.NaN;
		}
		
	}
	
	public void grow()
	{
		double big_array[] = new double[this.size*2];
		
		for(int i = 0; i< nextIndex; i++)
		{
			big_array[i] = this.array[i]; 		
		}
		array = big_array;
		size *= 2;
	}
	
	public void shrink()
	{
		if (this.arraySize() != 1)
		{
		double small_array[] = new double[this.size/2];
		
		for(int i = 0; i < nextIndex; i++)
		{
			small_array[i] = this.array[i];
		}
		array = small_array;
		size /=2;
		}
	}
	
	
	public void insertAt(int index, double value)
	{
		//if the array is full 
		//grow it
		if(this.elements() == array.length)
		{
			this.grow();
		}
		//if the index is in the array 
		//make the value of next index +1
		if(0 <= index && index <= nextIndex)
		{
			nextIndex++;
			//move elements in the array over one spot to make room for
			//the next value 
			for( int i = index; i >= nextIndex; i++)
			{ 
				this.array[i]= this.array[i+1];
				//insert the value into the open index 
				
			}
			this.array[index] = value;
		}
		else
		{
			//do nothing
		}
	}
	
	public void insert(double value)
	{
		if(this.elements() == array.length)
		{
			this.grow();
		}
		array[nextIndex] = value;
		nextIndex++;
	}
	public double removeAt(int index)
	{
		if( 0 <= index && index < nextIndex )
		{
			double removedValue = this.array[index];
			
			for(int i = index; i< nextIndex - 1; i++)
			{
				this.array[i] = this.array[i+1];
			}
			
			nextIndex--;
			
			return removedValue;
		}
		else
		{
			return Double.NaN; 
		}
	}
	
	
	public double remove()
	{
		if (this.arraySize()/2 == this.elements())
		{
			this.shrink();
		}
		if (nextIndex == 0)
		{
			return Double.NaN;
		}	
		
		double removedValue = array[nextIndex -1];
		array[nextIndex -1] = Double.NaN;
		nextIndex--;
		return removedValue;
	}
	
	public void printArray()
	{
		for (int i = 0; i <nextIndex; i++)
		{
			System.out.println(this.array[i]);
		}
	}
	
	public void printArrayrev()
	{
		for(int i = nextIndex -1; i>= 0; i--)
		{
			System.out.println(this.array[i]);
		}
	}
	
	public double remove1st()
	{
		if (this.arraySize()/2 == this.elements())
		{
			this.shrink();
		}
		if (nextIndex == 0)
		{
			return Double.NaN;
		}	
		
		double removedValue = array[0];
		
		for(int i = 0 + 1; i < nextIndex; i++)
		{
			array[i-1] = array[i];
		}
		
		array[nextIndex-1] = removedValue;
		array[nextIndex-1] = Double.NaN;
		nextIndex--;
		return removedValue;
	}
	
	
	
	
	
}
