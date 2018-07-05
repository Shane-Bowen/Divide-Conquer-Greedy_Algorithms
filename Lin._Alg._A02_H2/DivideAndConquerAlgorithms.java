
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */

//A02_H2

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
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 * @return 
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		if(m.length() == 0)//If myList is empty
		{
			scenario = 1;
			System.out.println("");
		}

		else if(m.length() >= 0)//If myList is not empty
		{
			scenario = 2;
		}


		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){

		case 1:
			break;

		case 2://We print everything in the list
			int e0 = m.getElement(0);//We get the first element
			System.out.print(e0 + ",");//We print the first element
			m.removeElement(0);//We remove the first element
			recursiveDisplayElements(m);//We recursively display the elements

			m.addElement(0, e0);//We add back the element
			break;
			
		}
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return 
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if(m.length() == 0)//If myList is empty
		{
			scenario = 1;
		}

		if(m.length() > 0)//If myList is not empty
		{
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){

		case 1:
			res = new MyDynamicList<Integer>();//We create a empty list
			break;

		case 2:
			res = new MyDynamicList<Integer>();//We create a new list.
			int e0 = m.getElement(0);
			m.removeElement(0);
			res = smallerMyList(m, e);

			if(e0 < e)
			{
				res.addElement(0, e0);
			}

			m.addElement(0, e0);

		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		

		return res;

	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		if(m.length() == 0)
		{
			scenario = 1;
		}

		else if(m.length() > 0)
		{
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){

		case 1:
			res = new MyDynamicList<Integer>();//We create a empty list as a result
			break;

		case 2:
			res = new MyDynamicList<Integer>();//We create a new list
			int e0 = m.getElement(0);
			m.removeElement(0);
			res = biggerEqualMyList(m, e);

			if(e0 >= e)//If the first element is greater than or equal to e then we add this to the list
			{
				res.addElement(0, e0);
			}

			m.addElement(0, e0);

		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------	

		return res;
	}

	//-------------------------------------------------------------------
	// 4. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		if (m1.length() == 0) 
		{
			scenario = 1;
		}

		else if(m2.length() == 0)
		{
			scenario = 2;
		}

		else if (m1.length() > 0 && m2.length() > 0)
		{
			scenario = 3;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------

		int size = 0;//Create a new variable called size.
		int e0 = 0;//Create a new variable for the first element
		int auxE = 0;//Create a new auxiliary element

		switch(scenario){	

		case 1: 
			res = new MyDynamicList<Integer>();//1. We create the new list as a result

			size = m2.length() - 1;
			while (size >= 0){//We traverse all elements of m2, adding them to the list

				auxE = m2.getElement(size);//We access to the element in m2

				res.addElement(0, auxE);//We append the element to res 

				size--;//We decrease the index of size
			}

			break;

		case 2: 
			res = new MyDynamicList<Integer>();//We create the new list as a result

			size = m1.length() - 1;
			while (size >= 0){//We traverse all elements of m1, adding them to the list

				auxE = m1.getElement(size);//We access to the element in m1

				res.addElement(0, auxE);//We append the element to res 

				size--;//We decrease the index of size
			}

			break;

		case 3: 
			e0 = m1.getElement(0);//We get the first element of m1

			m1.removeElement(0);//We remove the first element from m1

			res = concatenate(m1, m2);//We recursively solve the problem

			res.addElement(0, e0);//We add e0 to the resulting list

			m1.addElement(0, e0);//We add the element back to m1

			break;									
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;			
	}	
}	