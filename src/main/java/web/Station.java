package web;
import javax.persistence.*;

@Entity @Table(name="stations")
public class Station {
	public @Id Long id;
	public String state;
	public String suburb;
	public String address;
	public String postcode;
	public float latitude;
	public float longitude;
        
        public String getState() {
            return state;
        }
        public String getSuburb() {
            return suburb;
        }
        public String getAddress() {
            return address;
        }
        public String getPostcode() {
            return postcode;
        }
        public float getLatitude() {
            return latitude;
        }
        public float getLongitude() {
            return longitude;
        }
        
     
}