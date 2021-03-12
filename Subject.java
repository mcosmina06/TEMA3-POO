public interface Subject {
	public void register(Observer observer);
	public void notify(Observer observer, int points);
}
