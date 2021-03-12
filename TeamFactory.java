public class TeamFactory {
	
	public Team getTeam(String teamType) {
		if(teamType == null) {
			return null;
		}
		if(teamType.equals("football")){
			return new FootballTeam();
		}
		else if(teamType.equals("basketball")){
			return new BasketballTeam();
		}
		else if(teamType.equals("handball")){
			return new HandballTeam();
		}
		return null;
	}
}
