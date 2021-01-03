package dz.com.naftal.petrocard.web.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "dialogBean")
@SessionScoped
public class DialogBean {
	
	public void clientDialog() {
		
	        RequestContext.getCurrentInstance().openDialog("FormSaisieClient");  
	    }
	
	public void porteurDialog(){
		
        RequestContext.getCurrentInstance().openDialog("FormSaisiePorteur");  
    }
	
      public void emailDialog(){
		
        RequestContext.getCurrentInstance().openDialog("email");  
    }
}
