import java.util.*;

public class Competition implements Subject{
	private String type;
	private String gender;
	public ArrayList<Team> teams;
	public ArrayList<Team> clasament;
	
	Competition(){
		type = "";
		gender = "";
		teams = new ArrayList<Team>();
		clasament = new ArrayList<Team>();
	}

	Competition(String type, String gender){
		this.type = type;
		this.gender = gender;
		teams = new ArrayList<Team>();
		clasament = new ArrayList<Team>();
	}
	
	public void register(Observer observer) {
		clasament.add((Team)observer);
	}
	
	public void notify(Observer observer, int points) {
		observer.updata(points);
	}
	
	int get_position(String x) {
		int i;
		for(i = 0; i < clasament.size(); i++) {
			if(clasament.get(i).get_teamName().equals(x)) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public void start_competition() {
		int i, j;
		ScoreVisitor S = new ScoreVisitor();
		for(i = 0; i < teams.size(); i++) {
			for(j = 0; j < teams.size(); j++) {
				if(i != j) {
					if(type.equals("football")) {
						 if(S.visit((FootballTeam)teams.get(i)) < S.visit((FootballTeam)teams.get(j))) {
							 notify(teams.get(j), 3);
						 }
						 else if(S.visit((FootballTeam)teams.get(i)) > S.visit((FootballTeam)teams.get(j))) {
							 notify(teams.get(i), 3);
						 }
						 else {
							 notify(teams.get(i), 1);
							 notify(teams.get(j), 1);

						 }						
					}
					if(type.equals("basketball")) {
						 if(S.visit((BasketballTeam)teams.get(i)) < S.visit((BasketballTeam)teams.get(j))) {
							 notify(teams.get(j), 3);
						 }
						 else if(S.visit((BasketballTeam)teams.get(i)) > S.visit((BasketballTeam)teams.get(j))) {
							 notify(teams.get(i), 3);
						 }
						 else {
							 notify(teams.get(i), 1);
							 notify(teams.get(j), 1);

						 }						
					}
					if(type.equals("handball")) {
						 if(S.visit((HandballTeam)teams.get(i)) < S.visit((HandballTeam)teams.get(j))) {
							 notify(teams.get(j), 3);
						 }
						 else if(S.visit((HandballTeam)teams.get(i)) > S.visit((HandballTeam)teams.get(j))) {
							 notify(teams.get(i), 3);
						 }
						 else {
							 notify(teams.get(i), 1);
							 notify(teams.get(j), 1);

						 }						
					}
				}
				Collections.sort(clasament);
			}
		}
	}
}
