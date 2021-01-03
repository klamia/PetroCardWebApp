package dz.com.naftal.petrocard.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;



import dz.com.naftal.petrocard.model.TypeCarte;
import dz.com.naftal.petrocard.service.ITypeCarteService;

@ManagedBean(name = "typeCarteConverter")
@SessionScoped
public class TypeCarteConverter implements Converter {

	@ManagedProperty(name = "iTypeCarteService", value = "#{iTypeCarteService}")
	private ITypeCarteService iTypeCarteService;

	
	
	public ITypeCarteService getiTypeCarteService() {
		return iTypeCarteService;
	}

	public void setiTypeCarteService(ITypeCarteService iTypeCarteService) {
		this.iTypeCarteService = iTypeCarteService;
	}

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iTypeCarteService.findById(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid type carte"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return ((TypeCarte) value).getTypecarteid().toString();
        }
        
    }
}
