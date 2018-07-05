/**
 * Classical Change making problem with an unlimited amount of coins of each type. <br> 
 * Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
 * Depending on the type of coins, it can lead to an optimal solution.<br>
 * The class encapsulates all the functions of the Greedy schema<br>
 */

//A02_H3

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}

	//-------------------------------------------------------------------
	// 0. displayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this function displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void displayElements(MyList<Integer> m){
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
			System.out.print("MyList has " + size + " items: [");

			//2. We traverse the items
			for (int i = 0; i < size - 1; i++)
				System.out.print(m.getElement(i) + ", ");
			System.out.println(m.getElement(size - 1) + "]");

			break;
		}

	}

	// -------------------------------------------------------------------
	// 1. selectionFunctionDummy --> It selects the next candidate to be
	// considered.
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionDummy(MyList<Integer> candidates) {

		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		int res = -1;

		// -----------------------------
		// SET OF OPS
		// ----------------------------

		if(candidates.length() > 0)
		{
			res = 0;
		}


		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the biggest non-discarded type of coin.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBiggestCoin(MyList<Integer> candidates){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int index = candidates.length() -1;
		int maxValue = 0;
		
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		while(index >= 0)
		{
			int e0 = candidates.getElement(index);

			if(e0 > maxValue)
			{
				res = index;
				maxValue = e0;
			}

			index --;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = false;

		if(candidateValue + changeGenerated <= amount)
		{
			res = true;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	// -------------------------------------------------------------------
	// 3. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {

		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		boolean res = false;

		if(candidates.length() == 0)
		{
			res = true;
		}

		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its value according to:<br>
	 * How many coins are used in the solution.<br>
	 * How accurate it is the change.<br> 
	 * @param sol: The MyList containing the solution to the problem.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param amount: The amount of change we want to generate. 
	 * @return 
	 * @return: The value of such solution.
	 */	
	public MyList<Integer> objectiveFunction(MyList<Integer> sol, int changeGenerated, int amount){

		//-----------------------------
		//Output Variable --> InitialValue
		//-------------------------------

		//We initialize the solutionSet
		MyList<Integer> solutionSet = null;
		solutionSet = new MyDynamicList<Integer>();
		
		//The amountLeft is equal to the amount
		int amountLeft = amount;

		//-----------------------------
		//SET OF OPS
		//-----------------------------	

		//Initialize the index
		int index = 0;

		if(sol.length() > 0)
		{
			while(changeGenerated < amount)
			{
				amountLeft = amount - changeGenerated;

				if(sol.getElement(0) <= amountLeft)
				{
					//We increase the changeGenerated by the current element used
					changeGenerated = changeGenerated + sol.getElement(0);
					
					//We add the current element to our solutionSet
					solutionSet.addElement(index, sol.getElement(0));
					
					//We increase the index
					index ++;
				}

				else if(sol.getElement(1) <= amountLeft)
				{
					changeGenerated = changeGenerated + sol.getElement(1);
					solutionSet.addElement(index, sol.getElement(1));
					index++;
				}

				else if(sol.getElement(2) <= amountLeft)
				{
					changeGenerated = changeGenerated + sol.getElement(2);
					solutionSet.addElement(index, sol.getElement(2));
					index++;
				}

				else if(sol.getElement(3) <= amountLeft)
				{
					changeGenerated = changeGenerated + sol.getElement(3);
					solutionSet.addElement(index, sol.getElement(3));
					index++;
				}
			}
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//------------------------------

		return solutionSet;
	}

	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------

		MyList<Integer> sol;
		MyList<Integer> solutionSet;
		
		// We use 'candidates' as a MyList with the items that can be considered
		MyList<Integer> candidates = null;
		// We use 'changeGenerated' to state the amount of change we have generated so far
		int changeGenerated = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//'sol' is initialized to be a list of the items we will use
		sol = new MyDynamicList<Integer>();
		candidates = new MyDynamicList<Integer>();

		// we copy all the items in the candidates list
		for (int i = 0; i < coinValues.length(); i++)
		{
			candidates.addElement(i, coinValues.getElement(i));
		}

		//We construct the final solution:
		while (solutionTest(candidates) == false) {

			// We use 'candidateSelected' to state the index of the candidate being selected.
			int candidateSelected = -1;

			//We pick the most promising candidate
			switch (typeSelectFunc) {
			case 1:
				candidateSelected = selectionFunctionDummy(candidates);
				break;

			case 2:
				candidateSelected = selectionFunctionBiggestCoin(candidates);
				break;
			}

			int candidateValue = candidates.getElement(candidateSelected);

			//If the candidate is feasible
			if (feasibilityTest(candidateValue, amount, changeGenerated) == true) {

				//We add it to the solution
				sol.addElement(sol.length(), candidateValue);

			}

			//We discard the candidate for future iterations
			candidates.removeElement(candidateSelected);
		}

		//We print the solution
		solutionSet = objectiveFunction(sol,changeGenerated, amount);
		System.out.println("available Coins: " + sol.length());
		displayElements(solutionSet);

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return sol;		
	}
}