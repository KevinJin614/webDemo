package exception;

/**
 * 服务失败异常
 * @author 李恒
 *
 */
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
