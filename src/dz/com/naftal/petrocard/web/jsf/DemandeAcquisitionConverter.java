package dz.com.naftal.petrocard.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.naftal.petrocard.model.DemandeAcquisition;

import dz.com.naftal.petrocard.service.IDemandeAcquisitionService;
@ManagedBean(name = "demandeAcquisitionConverter")
@SessionScoped
public class DemandeAcquisitionConverter implements Converter {

	
	@ManagedProperty(name = "iDemandeAcquisitionService", value = "#{iDemandeAcquisitionService}")
	private IDemandeAcquisitionService iDemandeAcquisitionService;

	public IDemandeAcquisitionService getiDemandeAcquisitionService() {
		return iDemandeAcquisitionService;
	}

	public void setiDemandeAcquisitionService(
			IDemandeAcquisitionService iDemandeAcquisitionService) {
		this.iDemandeAcquisitionService = iDemandeAcquisitionService;
	}

	@Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iDemandeAcquisitionService.getDemandeAcquisitionbyId(Integer.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid demande"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
            return ((DemandeAcquisition) value).getDemandeacquisitionid().toString();
        }
        
    }

}
