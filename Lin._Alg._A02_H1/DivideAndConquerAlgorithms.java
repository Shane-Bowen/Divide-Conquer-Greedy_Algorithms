/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */

//A02_H1

public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");

			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){

		int maxItem = 0;

		if(m.length() == 0)
		{
			maxItem = -1;
		}

		else if(m.length() > 0)
		{
			int e0 = m.getElement(0);
			m.removeElement(0);
			maxItem = maxInt(m);

			if(e0 > maxItem)
			{
				maxItem = e0;
			}

			m.addElement(0, e0);
		}

		return maxItem;

	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){

		boolean descending = true;

		if(m.length() <= 1)
		{
			descending = false;
		}

		else if(m.length() > 1)
		{
			int e0 = m.getElement(0);
			int e1 = m.getElement(1);

			if(e0 > e1)
			{
				m.removeElement(0);
				descending = isReverse(m);
				m.addElement(0, e0);
			
				descending = true;
			}

			else if(e0 < e1)
			{
				descending = false;
			}
		}

		return descending;
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){

		int numAppearance = 0;

		if(m.length() > 0)
		{
			int e0 = m.getElement(0);
			m.removeElement(0);
			numAppearance = getNumAppearances(m,n);

			if(n == e0)
			{
				numAppearance = numAppearance + 1;
			}

			m.addElement(0, e0);

		}

		else
		{
			numAppearance = 0;
		}

		return numAppearance;

	}

	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){

		int power = 0;

		if(m == 0)
		{
			power = 1;
		}
		
		else if(n == 0)
		{
			power = 0;
		}

		else
		{
			power = n * power(n, m-1);
		}

		return power;

	}

	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){

		int lucas = 0;

		if(n == 0)
		{
			lucas = 2;
		}

		else if(n == 1)
		{
			lucas = 1;
		}

		else if(n > 1)
		{

			int n1 = lucas(n-1);
			int n2 = lucas(n-2);

			lucas = n1 + n2;

		}

		return lucas;
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
			drawImage(n-1);
			
			for(int i = 0; i < n; i++) 
			{
				System.out.print("*");
			}
			
			System.out.println();
	}
}