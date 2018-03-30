import java.util.ArrayList;

public class VisitorDemo
{
	public static void main(String[] args)
	{
		TwoElement two1 = new TwoElement(3, 3);
		TwoElement two2 = new TwoElement(7, 2);
		ThreeElement three1 = new ThreeElement(3, 5, 4);

		ArrayList<NumberElement> list = new ArrayList<NumberElement>();
		list.add(two1);
		list.add(two2);
		list.add(three1);
		
		NumberVisitor sumVisitor = new SumVisitor();
		
		System.out.println("Test 1: Visiting twoElement (7, 2) with SumVisitor");
		System.out.println("Sum is " + two2.accept(sumVisitor));
		
		System.out.println("\nTest 2: Visiting threeElement (3, 5, 4) with SumVisitor");
		System.out.println("Sum is " + three1.accept(sumVisitor));

		System.out.println("\nTest 3: Visiting element list ((3, 3), (7, 2), (3, 5, 4)) with SumVisitor");
		System.out.println("Sum is " + sumVisitor.visit(list));

		NumberVisitor largestVisitor = new LargestVisitor();
		
		System.out.println("\nTest 4: Visiting twoElement (3, 3) with LargestVisitor");
		System.out.println("Largest is " + two1.accept(largestVisitor));
		
		System.out.println("\nTest 5: Visiting threeElement (3, 5, 4) with LargestVisitor");
		System.out.println("Largest is " + three1.accept(largestVisitor));

		System.out.println("\nTest 6: Visiting element list ((3, 3), (7, 2), (3, 5, 4)) with LargestVisitor");
		System.out.println("Largest is " + largestVisitor.visit(list));
	}
}