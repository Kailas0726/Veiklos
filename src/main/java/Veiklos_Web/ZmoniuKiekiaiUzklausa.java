package Veiklos_Web;

import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;

public class ZmoniuKiekiaiUzklausa {
	
	  protected Session em;	
	
	  public ZmoniuKiekiaiUzklausa(  Session em  ) {
		  
		    this.em = em;
	  }
	  
	  public List<ZmoniuKiekiai> zmoniuKiekiai( String nuo, String iki) {
		  
		  String zmoniu_kiekiai =
				  
				"SELECT " 
				  +		"`veiklos`.`id` AS `id`"
				  + 	", `veiklos`.`veikla` AS `veikla`"
				  + 	", `veiklos`.`aprasymas` AS `aprasymas`"
				  + 	", COUNT(`zmones`.`id`) AS `zmoniu_skaicius`"
				  +" FROM "
				  +		"`veiklos`"
				  +" LEFT JOIN "
				  +	"	`zmones_veiklos` ON("
				  +      	"`veiklos`.`id` = `zmones_veiklos`.`veiklos_id`"
				  +      ") "
				  + " LEFT JOIN "
				  + "	 `zmones` ON("
				  +			"`zmones_veiklos`.`zmones_id` = `zmones`.`id`" 
				  +  	  ")"
				  + " WHERE "
				  +	 	  " 1 "
				  + " GROUP BY "
				  +			"`veiklos`.`id`"
				  +	" HAVING "
				  + 	  "`zmoniu_skaicius` BETWEEN " + nuo + " AND " + iki
				  
				  ;
				  
				  
		
		  
		  Query query = em.createNativeQuery ( zmoniu_kiekiai );
				  
		  return (List<ZmoniuKiekiai>) query.getResultList();
	  }
	  

}
