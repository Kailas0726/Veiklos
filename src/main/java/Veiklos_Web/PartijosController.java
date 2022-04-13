package Veiklos_Web;

//import java.io.IOException;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PartijosController {
	
	@Autowired
	private PartijosRepository partijos_repository;
	
	@RequestMapping(path="/partijos", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id
			, @RequestParam(name="vardas", required=false, defaultValue="") String vardas
			, @RequestParam(name="pavarde", required=false, defaultValue="") String pavarde
			, @RequestParam(name="elektroninis_pastas", required=false, defaultValue="") String elektroninis_pastas
			, Model model) {
			
			
			model.addAttribute("partijos", partijos_repository.findAll() );
			
			return "partijos";
			
			}
}