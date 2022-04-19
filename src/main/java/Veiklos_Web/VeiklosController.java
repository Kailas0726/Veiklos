package Veiklos_Web;

import java.util.Optional;

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
public class VeiklosController {
	
	@Autowired
	private VeiklosRepository veiklos_repository;
	
	@RequestMapping(path="/veiklos", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id
			, @RequestParam(name="veikla", required=false, defaultValue="") String veikla
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String aprasymas
			, Model model) {
			
			
			model.addAttribute("veiklos", veiklos_repository.findAll() );
			model.addAttribute("lst_menu", Menu.values() );
			
			return "veiklos";
			
			}
	
	//@RequestMapping("/veikla1")
	//public /*String*/@ResponseBody Veiklos veikla1(@RequestParam(name="i", required=true, defaultValue="0") String id, Model model)
	/*{
		//model.addAttribute("name", id);
		Optional<Veiklos> veikla11 = veiklos_repository.findById(Integer.parseInt(id));
		Veiklos veikla111 = null;
		if(!veikla11.isEmpty()) {
			
			veikla111 = veikla11.get();
			
		}
		return veikla111;
	}*/
	
	@RequestMapping("/veikla1")
	public String veikla1(@RequestParam(name="i", required=true, defaultValue="0") String id, Model model)
	{
		//model.addAttribute("name", id);
		Optional<Veiklos> veikla11 = veiklos_repository.findById(Integer.parseInt(id));
		Veiklos veikla111 = null;
		if(!veikla11.isEmpty()) {
			
			veikla111 = veikla11.get();
			
		}
		
		model.addAttribute("veikla1", veikla111);
		model.addAttribute("lst_menu", Menu.values() );
		
		return "veikla1";
		
	}
	
}
