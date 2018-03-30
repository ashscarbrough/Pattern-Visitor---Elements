public class TwoElement implements NumberElement
{
	int a; // a>=0
	int b; // b>=0

	public TwoElement(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public int accept(NumberVisitor visitor)
	{
		return visitor.visit(this);
	}
}