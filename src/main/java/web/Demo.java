package web;
import java.util.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class Demo {
	
        @RequestMapping("*") @ResponseBody
                // * represent any routine
                // Add @ResponseBody will not return file
        String error(){
            return "Not found";
        }
        
	@RequestMapping("/")
	String index() {
		return "index";
	}
        
	@RequestMapping("/test1") @ResponseBody
	Book test1() {
		Book  b = new Book();
		b.title = "Hello World";
		b.price = 199;
		return b;
	}
	
	@RequestMapping("/test2") @ResponseBody
	ArrayList test2() {
		ArrayList list = new ArrayList();
	// To send array list
		Book  b1 = new Book();
		b1.title = "Hello World";
		b1.price = 199;
		
		Book  b2 = new Book();
		b2.title = "Happy Birthday";
		b2.price = 99;
		
		list.add(b1);
		list.add(b2);
                
                
		return list;
	}
}