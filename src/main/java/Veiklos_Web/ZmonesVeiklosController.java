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
public class ZmonesVeiklosController {
	
	@Autowired
	private ZmonesRepository zmones_veiklos_repository;
	
	@RequestMapping(path="/zmonesveiklos", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id
			, @RequestParam(name="veikla", required=false, defaultValue="") String veikla
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String aprasymas
			, Model model) {
			
			
			model.addAttribute("zmonesveiklos", zmones_veiklos_repository.findAll() );
			
			return "zmonesveiklos";
			
			}
}