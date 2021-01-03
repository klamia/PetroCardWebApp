package dz.com.naftal.petrocard.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.naftal.petrocard.model.TypeEtat;
import dz.com.naftal.petrocard.service.ITypeEtatService;

@ManagedBean(name = "typeEtatConverter")
@SessionScoped
public class TypeEtatConverter implements Converter {

	@ManagedProperty(name = "iTypeEtatService", value = "#{iTypeEtatService}")
	private ITypeEtatService iTypeEtatService;
	
	public ITypeEtatService getiTypeEtatService() {
		return iTypeEtatService;
	}

	public void setiTypeEtatService(ITypeEtatService iTypeEtatService) {
		this.iTypeEtatService = iTypeEtatService;
	}

	@Override
	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iTypeEtatService.getTypeEtatbyId(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid type etat"));
            }
        }

       
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return ((TypeEtat) value).getTypeetatid().toString();
        }
        
	}

}
