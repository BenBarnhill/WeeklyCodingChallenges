package buildorder;

public class NoValidOrderException extends Exception{

	@Override
	public String getMessage() {
		return "There is no valid build order for the given dependencies.";
	}
}
