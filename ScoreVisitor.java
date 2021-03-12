public class ScoreVisitor implements Visitor {
	public double visit(FootballTeam football) {
		int i;
		double sum = 0;;
		if(football.get_gender().equals("masculin")) {
			double max = football.players.get(0).get_score();
			for(i = 0; i < football.get_nb(); i++) {
				if(max < football.players.get(i).get_score()) {
					max = football.players.get(i).get_score();					
				}
				sum += football.players.get(i).get_score();
			}
			sum += max;
			return sum;
		}
		else {
			double min = football.players.get(0).get_score();
			for(i = 0; i < football.get_nb(); i++) {
				if(min > football.players.get(i).get_score()) {
					min = football.players.get(i).get_score();					
				}
				sum += football.players.get(i).get_score();
			}
			sum += min;
			return sum;
		}
	}
			
	public double visit(HandballTeam handball) {
		int i;
		double sum = 0, prod = 1;
		if(handball.get_gender().equals("masculin")) {
			for(i = 0; i < handball.get_nb(); i++) {
				sum += handball.players.get(i).get_score();
			}
			return sum;
		}
		else {
			for(i = 0; i < handball.get_nb(); i++) {
				prod *= handball.players.get(i).get_score();
			}
			return prod;
		}	
	}
		
	public double visit(BasketballTeam basketball) {
		int i;
		double sum = 0;
		for(i = 0; i < basketball.get_nb(); i++) {
			sum += basketball.players.get(i).get_score();
		}
		return (sum / basketball.get_nb());
	}
		
}
