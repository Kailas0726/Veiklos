package Veiklos_Web;

import java.io.IOException;
//import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Controller
public class ZmonesController {
	

	@Autowired
	private ZmonesRepository zmones_repository;
	
	@Autowired
	private VeiklosRepository veiklos_repository;
	
	@Autowired
	private ZmonesVeiklosRepository zmones_veiklos_repository;
	
	@Autowired 
	EntityManagerFactory factory;
	
	public SessionFactory sessionFactory() {

		
        if (factory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return factory.unwrap(SessionFactory.class);
	}
	
	/**
	 * pridedamas žmogus į žmonės lentelę
	 * @param id
	 * @param vardas - pridėti vartotojo vardui
	 * @param pavarde - pridėti vartotojo pavardei
	 * @param elektroninis_pastas - pridėti vartotojo elektroniniam paštui
	 * @param telefono_numeris - pridėti vartotojo telefono numeriui
	 * @param prideti - pridejimo forma
	 * @return zmones - grąžina pridėtus duomenis
	 */
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
		model.addAttribute("lst_menu", Menu.values() );
		
		return "zmones";
	}
	
	/**
	 * redaguojami duomenys apie žmogų zmonės lentelėje
	 * 
	 * @param id - surasti kurio vartotojo duomenys yra redaguojamas
	 * @return zmones - grąžina paredaguotus duomenis
	 */
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
	
	/**
	 * šalinami duomenys iš žmonės lentelės
	 * 
	 * @param id - surasti kuris vartotojas šalinamas iš lentelės
	 * @param salinti - šalinimo forma
	 * @return redirect:zmones - grąžina duomenis, su jau ištrintu varototoju
	 */
	@RequestMapping(path="/salinti-vartotoja")
	public  String salintiVartotoja (@RequestParam(name="id_iraso", required=true, defaultValue="0") Integer id 
			, @RequestParam(name="salinti", required=false, defaultValue="0") String salinti
			) {
		
		Zmones zmones = new Zmones();
		
		if ( salinti.equals( "salinti" ) ) {
			//System.out.println(id);
			Optional <Zmones> found = zmones_repository.findById( id );
			
				if ( found.isPresent() ) {
					
					   zmones = found.get();
					   zmones_repository.deleteById(id);

				}
			
		}
		return "redirect:zmones";
	}
	
	/*@RequestMapping("/zmones1")
	public String @ResponseBody Zmones zmones1(@RequestParam(name="i", required=true, defaultValue="0") String id, Model model)
	{
		//model.addAttribute("name", id);
		Optional<Zmones> zmones11 = zmones_repository.findById(Integer.parseInt(id));
		Zmones zmones111 = null;
		if(!zmones11.isEmpty()) {
			
			zmones111 = zmones11.get();
			
		}
		return zmones111;
	}*/
	
	/*@RequestMapping("/zmones1")
	public String veikla1(@RequestParam(name="i", required=true, defaultValue="0") String id, Model model)
	{
		//model.addAttribute("name", id);
		Optional<Zmones> zmones11 = zmones_repository.findById(Integer.parseInt(id));
		Zmones zmones111 = null;
		if(!zmones11.isEmpty()) {
			
			zmones111 = zmones11.get();
			
		}
		
		model.addAttribute("zmones1", zmones111);
		model.addAttribute("lst_menu", Menu.values() );
		model.addAttribute("lst_veiklos", veiklos_repository.findAll());
		
		return "zmones1";
	
	}*/
	
	@RequestMapping(path="/zmones1")
    public String zmones1(@RequestParam(name="i", required=true, defaultValue="0") String id 
			, @RequestParam(name="papildyti", required=false, defaultValue="nepapildyti") String papildyti
			, @RequestParam(name="veiklos", required=false, defaultValue="") String veiklos
			, @RequestParam(name="kontaktai", required=false, defaultValue="") String kontaktai
			, @RequestParam(name="veiklos_vieta", required=false, defaultValue="") String veiklos_vieta
			, @RequestParam(name="veiklos_sritis", required=false, defaultValue="") String veiklos_sritis
			, Model model) {
		
		Zmones zmones2 = new Zmones();
		
		Optional <Zmones> zmones2_row = zmones_repository.findById(Integer.parseInt(id));
		
		if(zmones2_row.isPresent()) {
			
			zmones2 = zmones2_row.get();
			
		}
		
		
		if(papildyti.equals("papildyti")) {
			
			ZmonesVeiklos zmones_veiklos = new ZmonesVeiklos(id, veiklos, kontaktai, veiklos_vieta, veiklos_sritis);
			zmones_veiklos_repository.save(zmones_veiklos);
			return "redirect:zmones1?i=" + id;
			
		}
		
		model.addAttribute("zmones1", zmones2);
		model.addAttribute("lst_veiklos", veiklos_repository.findAll());
		model.addAttribute("lst_menu", Menu.values());
			
		return "zmones1";
	}
	
	@RequestMapping(path="/salinti-veikla")
    public String SalintiVeikla(@RequestParam(name="veiklos_zmones_id", required=true, defaultValue="0") String id
    		, @RequestParam(name="zmones_id", required=false, defaultValue="0") String zmones_id
			, @RequestParam(name="salinti", required=false, defaultValue="0") String salinti
			, Model model) {
		try
		{
		
		Integer id1 = Integer.parseInt(id);
		Optional <ZmonesVeiklos> found = zmones_veiklos_repository.findById(id1);
			if(salinti.equals("salinti")) {
				
				if(found.isPresent()) {
					
					ZmonesVeiklos zmones_veiklos = found.get();
					zmones_veiklos_repository.deleteById(id1);
					
				}
				
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return "redirect:zmones1?i=" + zmones_id;
	}
	
	@RequestMapping(path="/zmoniukiekiai")
	public  String	ZmoniuKiekiai(
			@RequestParam(name="nuo", required=false, defaultValue="1") String nuo
			, @RequestParam(name="iki", required=false, defaultValue="100000") String iki
			, Model model) {
		
		
		Session session = this.sessionFactory().openSession();
		
		ZmoniuKiekiaiUzklausa zmoniu_kiekiai_uzklausa =  new ZmoniuKiekiaiUzklausa( session );
		
		model.addAttribute("lst_zmoniu_kiekiai", zmoniu_kiekiai_uzklausa.zmoniuKiekiai(nuo, iki) );
		model.addAttribute("lst_menu", Menu.values());
		
		return "zmoniukiekiai";
		
	}
	
	@RequestMapping(path="/atsijungimas")
	public  String	Atsijungimas(
			 Model model) {
		
		model.addAttribute("lst_menu", Menu.values());
		
		return "atsijungimas";
		
	}
	
}
