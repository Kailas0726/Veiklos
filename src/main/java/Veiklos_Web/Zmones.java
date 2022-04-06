package Veiklos_Web;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zmones {

		public Zmones() {
			
			super();
			
		}

		 @Id
		 @GeneratedValue(strategy=GenerationType.IDENTITY)
		 
		 private Integer id;
		 private String vardas;
		 private String pavarde;
		 private String elektroninis_pastas;
		 private String telefono_numeris;
		 
		public Integer getId() {
			
			return id;
			
		}
		public void setId(Integer id) {
			
			this.id = id;
			
		}
		public String getVardas() {
			
			return vardas;
			
		}
		public void setVardas(String vardas) {

			this.vardas = vardas;
			
		}
		public String getPavarde() {
			
			return pavarde;
			
		}
		public void setPavarde(String pavarde) {
			
			this.pavarde = pavarde;
			
		}
		public String getElektroninis_pastas() {
			
			return elektroninis_pastas;
			
		}
		public void setElektroninis_pastas(String elektroninis_pastas) {
			
			this.elektroninis_pastas = elektroninis_pastas;
			
		}
		public String getTelefono_numeris() {
			
			return telefono_numeris;
			
		}
		public void setTelefono_numeris(String telefono_numeris) {
			
			this.telefono_numeris = telefono_numeris;
			
		}
		
		
		
		
}
