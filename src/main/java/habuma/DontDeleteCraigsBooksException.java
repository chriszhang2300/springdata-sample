package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED)
public class DontDeleteCraigsBooksException extends RuntimeException {
	private static final long serialVersionUID = -8115555971721052984L;

	public DontDeleteCraigsBooksException(String title) {
		super("Don't delete book: " + title);
	}
	
}
