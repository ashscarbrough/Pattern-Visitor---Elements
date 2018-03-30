public class ThreeElement implements NumberElement
{
	int a; // a>=0
	int b; // b>=0
	int c; // c>=0

	public ThreeElement(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int accept(NumberVisitor visitor)
	{
		return visitor.visit(this);
	}
}