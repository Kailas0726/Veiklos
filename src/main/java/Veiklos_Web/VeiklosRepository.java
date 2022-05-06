package Veiklos_Web;

import org.springframework.data.repository.CrudRepository;

public interface VeiklosRepository extends CrudRepository<Veiklos, Integer> {

	Veiklos findByVeikla(String veikla);
	
}