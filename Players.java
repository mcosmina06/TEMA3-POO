public class Players {
	private String name;
	private double score;
	public static final Players instance;	
	
	Players() {
		name = "";
		score = 0;
	}

	String get_name() {
		return this.name;
	}
	
	double get_score() {
		return this.score;
	}
	
	Players(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	static {
		try {
			instance = new Players();
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public static Players getinstance() {
		return instance;
	}
}
