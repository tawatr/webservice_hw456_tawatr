package web;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.web.bind.annotation.*;

// When run on 
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

//@RestController
@Controller
public class Hibernate {

	SessionFactory factory = new Configuration()
		// .addPackage("entity")
		.addAnnotatedClass(User.class)
		.addAnnotatedClass(Zipcode.class)
		.addAnnotatedClass(Station.class)
		.buildSessionFactory();
        
      @RequestMapping("/suburb-result")
	String get_suburb(List list1, Model model) {
                model.addAttribute( "items", list1 );
		return "suburb-result";
       }
        
/*
        	@RequestMapping("/hello")
	String index() {
		return "Hello World!";
	}
        
        @RequestMapping("/vat/{price}")
        double tax( @PathVariable double price){
            return price *7/100;
        }        
        @RequestMapping("/area")
        double area( double width, double height){
            return width*height;
        }	@RequestMapping("/hello")
	String index() {
		return "Hello World!";
	}
        
        @RequestMapping("/vat/{price}")
        double tax( @PathVariable double price){
            return price *7/100;
        }        
        @RequestMapping("/area")
        double area( double width, double height){
            return width*height;
        }
        */        

        // ==== ==== ==== zipcode
	@RequestMapping("/zipcode")
        String zipcode(){
            return "zipcode";
        }        
/*	@RequestMapping("/zipcode-result") @ResponseBody
	List get_zipcode(String ampher1) {
		Session session = factory.openSession();
		// list = session.createQuery("from Zip").list();
                Query query = session.createQuery("from Zipcode");
                List zipResults = query.list();
		session.close();
		return zipResults;
        }
 */
        
        @RequestMapping("/zipcode-result")
	String get_zipcode(String ampher1, Model model) {
		Session session = factory.openSession();
                Query query = session.createQuery("from Zipcode where city like :city");
                query.setParameter( "city", "%" + ampher1 + "%");
                List zipResults = query.list();
		session.close();
                model.addAttribute( "items", zipResults );
		return "zipcode-result";
        }
        
/*	@RequestMapping("/zipcode-result")
	String get_zipcode(String ampher1, Model model) {
		String zipcode1="99999";     // zip code

                if ( ampher1.equals( "เมืองนนทบุรี" )){ zipcode1="11000"; }
                if ( ampher1.equals( "บางบัวทอง" )){ zipcode1="11110"; }
                if ( ampher1.equals( "ปากเกร็ด" )){ zipcode1="11120"; }
                if ( ampher1.equals( "บางกรวย" )){ zipcode1="11130"; }
                if ( ampher1.equals( "บางใหญ่" )){ zipcode1="11140"; }
                if ( ampher1.equals( "ไทรน้อย" )){ zipcode1="11150"; }

		model.addAttribute("input1", ampher1);
		model.addAttribute("result1", zipcode1);
		return "/zipcode-result";
	}
       */

	@RequestMapping("/get-user-list") @ResponseBody
	List getUserList() {
		List list = new ArrayList();
		Session session = factory.openSession();
		list = session.createQuery("from User").list();
		session.close();
		return list;
	}
        
}