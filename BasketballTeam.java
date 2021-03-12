public class BasketballTeam extends Team implements Visitable{
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
