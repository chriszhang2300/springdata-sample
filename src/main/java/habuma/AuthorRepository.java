package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="/author", rel="writer")
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
