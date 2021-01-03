package dz.com.naftal.petrocard.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import dz.com.naftal.petrocard.model.Ident;
import dz.com.naftal.petrocard.service.IdentService;

@ManagedBean(name = "porteurConverter")
@SessionScoped
public class PorteurConverter implements Converter {

	@ManagedProperty(name = "identService", value = "#{identService}")
	private IdentService identService;
	
	
	
	public IdentService getIdentService() {
		return identService;
	}

	public void setIdentService(IdentService identService) {
		this.identService = identService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return identService.getIdentbyID(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid porteur"));
            }
        }

       
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return ((Ident) value).getPorteurid().toString();
        }
	}     

}
