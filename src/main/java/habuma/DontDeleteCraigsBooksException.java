package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED,reason="Don't delete Craig's books")
public class DontDeleteCraigsBooksException 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DontDeleteCraigsBooksException(String isbn) {
		super("Can't delete book with ISBN: " + isbn);
	}
	
}
