public class FootballTeam extends Team implements Visitable{
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
