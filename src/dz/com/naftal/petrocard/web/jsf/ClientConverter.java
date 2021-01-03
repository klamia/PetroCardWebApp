package dz.com.naftal.petrocard.web.jsf;


import javax.faces.application.FacesMessage;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;



import dz.com.naftal.petrocard.model.Client;
import dz.com.naftal.petrocard.service.IClientService;

@ManagedBean(name = "clientConverter")
@SessionScoped

public class ClientConverter implements Converter {

	
	@ManagedProperty(name = "iClientService", value = "#{iClientService}")
	private IClientService iClientService;
	
	

	
	public IClientService getiClientService() {
		return iClientService;
	}

	public void setiClientService(IClientService iClientService) {
		this.iClientService = iClientService;
	}
	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iClientService.findBayId(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid client"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return ((Client) value).getClientid().toString();
        }
        
    }
}


