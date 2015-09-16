package web;
import javax.persistence.*;

@Entity @Table(name="zip")
public class Zipcode {
	public @Id Long id;
	public String city;
	public String code;
        
        public String getCity() {
            return city;
        }
          public String getCode() {
            return code;
        }      
}