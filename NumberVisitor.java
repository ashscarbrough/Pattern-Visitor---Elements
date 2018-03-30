import java.util.ArrayList;

public interface NumberVisitor
{
	public int visit(TwoElement twoElement);
	public int visit(ThreeElement threeElement);
	public int visit(ArrayList<NumberElement> elementList);
}