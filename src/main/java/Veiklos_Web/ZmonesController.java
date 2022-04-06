package Veiklos_Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ZmonesController {
	

	@Autowired
	private VeiklosRepository veiklos_repository;
	
	@RequestMapping(path="/zmones", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id 
			, @RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="pavarde", required=false, defaultValue="") String pavarde
			, @RequestParam(name="elektroninis_pastas", required=false, defaultValue="") String elektroninis_pastas
			, @RequestParam(name="telefono_numeris", required=false, defaultValue="0") String telefono_numeris			
			, Model model) {
		
		model.addAttribute("zmones", veiklos_repository.findAll());
		return "zmones";
	}

}
