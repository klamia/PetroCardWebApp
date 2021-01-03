package dz.com.naftal.petrocard.web.jsf;

import java.util.ArrayList;  
import java.util.List;  
import javax.annotation.PostConstruct;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="galleriaBean")
@SessionScoped

public class GalleriaBean {
 
	    private List<String> images;  
	    @PostConstruct  
	    public void init() {  
	        images = new ArrayList<String>();  
	  
	        for(int i=1;i<=5;i++) {  
	            images.add("galleria" + i + ".png");  
	        }  

	    
	    }
	    public List<String> getImages() {  
	        return images;  
	    }  
	}