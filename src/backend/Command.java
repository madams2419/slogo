package backend;

public abstract class Command {

	private String name;

	public Command(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public abstract void execute();

}
