import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Team implements Observer, Comparable <Team>{
	private String teamName = "";
	private String gender = "";
	private int numberOfPlayers = 0;
	private int points;
	public ArrayList<Players> players = new ArrayList<Players>();	
	
	void set_name(String name) {
		this.teamName = name;
	}
	
	void set_gender(String gender) {
		this.gender = gender;
	}
	
	void set_nb(int nb) {
		this.numberOfPlayers = nb;
	}
	
	String get_teamName() {
		return this.teamName;
	}
	
	String get_gender() {
		return this.gender;
	}
	
	int get_nb() {
		return this.numberOfPlayers;
	}
	
	int get_points() {
		return this.points;
	}
	
	public void updata(int points) {
		this.points += points;
	}
	
	public int compareTo(Team t) {
		if(points < t.get_points()) {
			return 1;
		}
		if(points > t.get_points()) {
			return -1;
		}
		return 0;
	}
	
	void add_player(String name, int points) {
		Players P = new Players(name, points);
		players.add(P);
	}
	
	void list(String x) throws IOException {
		File fileWriter = new File(x);
		FileWriter output = new FileWriter(fileWriter, true);
		output.write("{" + "teamName: " + teamName + ", " + "gender: " +  gender + ", " + "numberOfPlayers: " + numberOfPlayers + ", " + "players: [");
		int i;
		for(i = 0; i < players.size(); i++) {
			if(i == players.size() - 1){
				output.write("{name: " + players.get(i).get_name() + ", score: " + (int)players.get(i).get_score() + "}]}");
				output.write("\r\n");
			}
			else{
				output.write("{name: " + players.get(i).get_name() + ", score: " + (int)players.get(i).get_score() + "}, ");
			}
		}
		output.close();
	}
	
}
