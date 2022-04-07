package Veiklos_Web;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZmonesController {
	

	@Autowired
	private ZmonesRepository zmones_repository;
	
	@RequestMapping(path="/zmones", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="pavarde", required=false, defaultValue="") String pavarde
			, @RequestParam(name="elektroninis_pastas", required=false, defaultValue="") String elektroninis_pastas
			, @RequestParam(name="telefono_numeris", required=false, defaultValue="0") String telefono_numeris
			, @RequestParam(name="prideti", required=false, defaultValue="0") String prideti
			, Model model) {
		
		
		Zmones zmones = new Zmones();
		
		if ( prideti.equals( "prideti" ) ) {
			
			if (id > 0) {
				
				Optional <Zmones> found = zmones_repository.findById( id );
				
				if ( found.isPresent() ) {
					
					zmones = found.get();
					zmones.setId(id);
					
				}
				
			}
			
			zmones.setVardas(vardas);
			zmones.setPavarde(pavarde);
			zmones.setElektroninis_pastas(elektroninis_pastas);
			zmones.setTelefono_numeris(telefono_numeris);
			
			 zmones_repository.save ( zmones );
			
		}
		
		model.addAttribute("zmones", zmones_repository.findAll());
		
		return "zmones";
	}
	
	@RequestMapping(path="/zmogus")	
	public @ResponseBody Zmones zmoniuDuom(@RequestParam(name="id", required=true, defaultValue="0") Integer id ) throws IOException {

		Zmones zmones = new Zmones();
		
		if (id > 0) {
			
			Optional <Zmones> found = zmones_repository.findById( id );
		
			if ( found.isPresent() ) {
			
			   zmones = found.get();
			   zmones.setId ( id );
			   
			} 
		}		
		
		return zmones;

	}
	
}
