package orko.dev.springWebToken.exception;

public class ExceptionToken extends RuntimeException {

	public ExceptionToken() {
		super();
	}

	public ExceptionToken(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionToken(String message) {
		super(message);
	}

	public ExceptionToken(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3850899868622652346L;
}
