package Veiklos_Web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
																						
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringRunner.class)
@SpringBootTest																				
public class VeiklosRepositoryTest {
	
    @Autowired
    private VeiklosRepository veiklosRepository;
   
    @Test
    public void testSaveGetVeiklos() {

        																			      	
        Veiklos veiklos = new Veiklos("Šokiai", "Įvairūs šokių uzsiėmimai");
        Veiklos veikl = veiklosRepository.save(veiklos);
        Veiklos veik = veiklosRepository.findByVeikla("Šokiai");
        																			            
        assertNotNull(veiklos);
        																			          
        assertNotNull(veik);        
        																			           
        assertEquals(veik.getVeikla(), veiklos.getVeikla());
        																				  
        																				
        assertEquals(veik.getAprasymas(), veiklos.getAprasymas());
        																				       
        
        veiklosRepository.deleteById(veikl.getId());				  
        																		        
    }
    
    @Test   
    public void testFindAllVeiklos() {
        assertNotNull(veiklosRepository.findAll());
    }
    
    @Test    
    public void deleteFoundedByName() {
        																			      
        Veiklos veiklos = new Veiklos( "Dainavimas", "Karaokė, dainavimo pamokos, choras" ); 
        Veiklos veik = veiklosRepository.save( veiklos );        
		veiklosRepository.delete( veik );                  					     
        Veiklos veikl = veiklosRepository.findByVeikla("Dainavimas");
        assertEquals( veikl, null );		
    }    

    @Test
    public void deletByVeiklosIdTest() {
    	
		Veiklos veikl = null;
        Veiklos veiklos = new Veiklos("Skaitymo burelis", "Knygų skaitymas, aptarimas, diskutavimas");    	
        Veiklos veik = veiklosRepository.save(veiklos);
        Integer id_veik = veik.getId();
        veiklosRepository.deleteById(id_veik);
        Optional <Veiklos> found = veiklosRepository.findById ( id_veik );
        
		if ( found.isPresent() ) {
			
			   veikl = found.get();
		}
        assertEquals( veikl, null );     
    }  
}