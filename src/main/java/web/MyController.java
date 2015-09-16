package web;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.web.bind.annotation.*;

// When run on 
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

//@Controller
@RestController
public class MyController {
        
	SessionFactory factory = new Configuration()
		// .addPackage("entity")
		.addAnnotatedClass(User.class)
		.addAnnotatedClass(Zipcode.class)
		.addAnnotatedClass(Station.class)
		.buildSessionFactory();
        
        // ==== ==== ==== suburb
	@RequestMapping("/suburb") @ResponseBody
        List suburb( String name ){ 
		Session session = factory.openSession();
                Query query = session.createQuery("from Station where suburb = :suburb");
                                    // from class 
//                query.setParameter( "suburb", "%" + name + "%");
                query.setParameter( "suburb", name );
                List result1 = query.list();
				session.close();
//                model.addAttribute( "items", result1 );
                return result1;
        }
        
        // ==== ==== ==== postcode
	@RequestMapping("/postcode/{postcode}") @ResponseBody
        List postcode( @PathVariable String postcode ){ 
		Session session = factory.openSession();
                Query query = session.createQuery("from Station where postcode = :postcode");
                                    // from class 
                query.setParameter( "postcode", postcode );
                List result1 = query.list();
				session.close();
//                model.addAttribute( "items", result1 );
                return result1;
        }
        
        // ==== ==== ==== search
	@RequestMapping("/search") @ResponseBody
        List search( String query ){ 
		Session session = factory.openSession();
                Query query1 = session.createQuery("from Station where suburb like :suburb");
                                    // from class 
                query1.setParameter( "suburb", "%" + query + "%");
                Query query2 = session.createQuery("from Station where address like :address");
                query2.setParameter( "address", "%" + query + "%");
                
                List result1 = query1.list();
                List result2 = query2.list();
                
                List list_final = new ArrayList();
                list_final.addAll( result1 );
                list_final.addAll( result2 );
                
		session.close();
//                model.addAttribute( "items", result1 );
                return list_final;
        }        
 
        // ==== ==== ==== station-list
	@RequestMapping("/station-list") @ResponseBody
	List stationList(float top, float bottom, float left, float right) {
		Session database = factory.openSession();
		Query query = database.createQuery(
			"from Station where " +
			"latitude  <= :top  and latitude  >= :bottom and " +
			"longitude >= :left and longitude <= :right");
		query.setParameter("top", top);
		query.setParameter("bottom", bottom);
		query.setParameter("left", left);
		query.setParameter("right", right);
		List list = query.list();
		return list;
	}  
//      @RequestMapping("/suburb-result")
//	String get_suburb(String input1, Model model) {
//		Session session = factory.openSession();
//		// list = session.createQuery("from Suburb where suburb like :input1").list();
//                Query query = session.createQuery("from suburb where suburb like :suburb");
 //               query.setParameter( "suburb", "%" + input1 + "%");
//                List result1 = query.list();
///		session.close();
//        }
       
}

