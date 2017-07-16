package habuma;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleAuthor {

	@Value("#{target.firstName + ' ' + target.lastName}")
	String getName();
	
}
