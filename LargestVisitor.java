/*
 * Name: Ash Scarbrough
 * Class: CSCI-C490
 * Semester: Summer II, 2017
 * Assignment: Homework 7
 */

import java.util.ArrayList;
import java.util.Iterator;	// Needed to cycle through ArrayList

public class LargestVisitor implements NumberVisitor
{
	public int visit(TwoElement twoElement)
	{
		if(twoElement.a >= twoElement.b) 	// Determines which number is largest of 2 data members
			return twoElement.a;
		else
			return twoElement.b;
	}
	
	public int visit(ThreeElement threeElement)
	{
		// Determines which number is largest of 3 data members
		if ((threeElement.a >= threeElement.b) && (threeElement.a >= threeElement.c)) 
			return threeElement.a;
		else if ((threeElement.b >= threeElement.a) && (threeElement.b >= threeElement.c))
			return threeElement.b;
		else 
			return threeElement.c;
	}

	public int visit(ArrayList<NumberElement> elementList)
	{
		int largest, tempLarge;
		NumberElement numEl;
		Iterator<NumberElement> iter = elementList.iterator(); 	// Instantiates iterator to cycle through ArrayList
		
		numEl = iter.next();	// Iterate to first NumberElement in ArrayList "elementList"
		
		if (numEl instanceof ThreeElement)	// Determine specific instance of NumberElement and utilize visit method accordingly
			largest = this.visit((ThreeElement) numEl);
		else
			largest = this.visit((TwoElement) numEl);
		
		while (iter.hasNext())	// while values exist in ArrayList
		{
			numEl = iter.next();
			
			if (numEl instanceof ThreeElement)	// Obtain largest number based on instance type
			{
				tempLarge = this.visit((ThreeElement)numEl);
				if (tempLarge > largest)
					largest = tempLarge;
			}
			else 
			{
				tempLarge = this.visit((TwoElement)numEl);
				if (tempLarge > largest)
					largest = tempLarge;
			}
		}
		return largest;
	}
}