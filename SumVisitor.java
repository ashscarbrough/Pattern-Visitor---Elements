/*
 * Name: Ash Scarbrough
 * Class: CSCI-C490
 * Semester: Summer II, 2017
 * Assignment: Homework 7
 */

import java.util.ArrayList;
import java.util.Iterator;	// Needed to cycle through ArrayList

public class SumVisitor implements NumberVisitor
{
	public int visit(TwoElement twoElement)
	{
		int sum = twoElement.a + twoElement.b;	// Adds the two public (by default) int data members
		return sum;
	}

	public int visit(ThreeElement threeElement)
	{
		int sum = threeElement.a + threeElement.b + threeElement.c; // Adds the 3 public int data members
		return sum;
	}

	public int visit(ArrayList<NumberElement> elementList)
	{
		int sum, tempSum;
		NumberElement numEl;
		Iterator<NumberElement> iter = elementList.iterator();	// Instantiates iterator to cycle through ArrayList
		
		numEl = iter.next();	// Iterate to first NumberElement in ArrayList "elementList"
		
		if (numEl instanceof ThreeElement)	// Determine specific instance of NumberElement and utilize visit method accordingly
			sum = this.visit((ThreeElement) numEl);
		else
			sum = this.visit((TwoElement) numEl);
		
		while (iter.hasNext()) // while values exist in ArrayList
		{
			numEl = iter.next();
			
			if (numEl instanceof ThreeElement)
			{
				tempSum = this.visit((ThreeElement)numEl);
				sum += tempSum; //	Add NumberElement to previous sum value
			}
			else 
			{
				tempSum = this.visit((TwoElement)numEl);
				sum += tempSum;
			}
		}
		return sum;	// return sum of elementList
	}
}