package exception;
/**
 * 用户访问异常
 * @author 靳雅楠
 *
 */
public class DataAccessException extends RuntimeException {

	public DataAccessException() {
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
