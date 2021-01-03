package dz.com.naftal.petrocard.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;




import dz.com.naftal.petrocard.model.Carte;
import dz.com.naftal.petrocard.service.ICarteService;


@ManagedBean(name = "carteConverter")
@SessionScoped
public class CarteConverter implements Converter {

	@ManagedProperty(name = "iCarteService", value = "#{iCarteService}")
	private ICarteService iCarteService;
	
	
	

	

	public ICarteService getiCarteService() {
		return iCarteService;
	}

	public void setiCarteService(ICarteService iCarteService) {
		this.iCarteService = iCarteService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCarteService.getCartebyId(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid carte"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Carte) value).getCarteid().toString();
        }
        
    }

}
