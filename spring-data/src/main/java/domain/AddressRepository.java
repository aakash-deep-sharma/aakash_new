package domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

	List<Address> findByState(String state);
	
	@Query("SELECT DISTINCT p.state FROM Address p")
	List<Address> findDistinctState();
}
