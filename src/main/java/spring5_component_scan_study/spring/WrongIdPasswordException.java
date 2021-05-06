package spring5_component_scan_study.spring;

@SuppressWarnings("serial")
public class WrongIdPasswordException extends RuntimeException {

	public WrongIdPasswordException() {
	}

	public WrongIdPasswordException(String message) {
		super(message);
	}

}
