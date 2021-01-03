package dz.com.naftal.petrocard.web.jsf;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.AuthenticationException;



@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2868742783741899100L;

	public LoginBean() {

	}

	// ActionEvent actionEvent
	public String login() throws IOException, ServletException {
		try {
			
			
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();

			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
					.getRequestDispatcher("/j_spring_security_check");

			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());

			FacesContext.getCurrentInstance().responseComplete();

			
			// It's OK to return null here because Faces is just going to exit.
			return "/views/home.xhtml";
		} catch (AuthenticationException ex) {
			System.out.println("Login Failed");
			FacesContext.getCurrentInstance()
					.addMessage(
							"formLogin",
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Login Failed",
									"User Name and Password Not Match!"));

			return null;
		}
	}

}
