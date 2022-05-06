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
	
	/**
	 * gaunamas sujungtinės lentelės sąrašas 
	 * 
	 * @param id
	 * @param zmones_id
	 * @param veiklos_id
	 * @param kontaktai
	 * @param veiklos_vieta
	 * @param veiklos_sritis
	 * @return zmonesveiklos - grąžinamami sujungtinės lentelės duomenis
	 */
	@RequestMapping(path="/zmonesveiklos", method={ RequestMethod.GET, RequestMethod.POST })
    public String zmones(@RequestParam(name="id", required=false, defaultValue="0") Integer id
			, @RequestParam(name="veikla", required=false, defaultValue="") String zmones_id
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String veiklos_id
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String kontaktai
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String veiklos_vieta
			, @RequestParam(name="aprasymas", required=false, defaultValue="") String veiklos_sritis
			, Model model) {
			
			
			model.addAttribute("zmonesveiklos", zmones_veiklos_repository.findAll() );
			
			return "zmonesveiklos";
			
			}
}