package dz.com.naftal.petrocard.web.jsf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "emailBean")
@SessionScoped
public class EmailBean {

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
    
    private String destination="C:\\liste\\";
    	  
 public void handleFileUpload(FileUploadEvent event) {  
        	 
        	FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded."); 
        	FacesContext.getCurrentInstance().addMessage(null, msg);
        	// Do what you want with the file       
        	try {
        	copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        	} catch (IOException e) {
        e.printStackTrace();
        	}
        	 
        	} 
        	 
        	public void copyFile(String fileName, InputStream in) {
        	try {
        	 
        	 
        	// write the inputStream to a FileOutputStream
        	OutputStream out = new FileOutputStream(new File(destination + fileName));
        	
        	int read = 0;
        	byte[] bytes = new byte[1024];
        	 
        	while ((read = in.read(bytes)) != -1) {
        	out.write(bytes, 0, read);
        	}
        	 
        	in.close();
        	out.flush();
        	out.close();
        	 
        	System.out.println("New file created!");
        	} catch (IOException e) {
        	System.out.println(e.getMessage());
        	}
        	}  
      
   
    
    
    
    public String send() {
        statusMessage = "Message Sent";
        try {
            MailService.sendMessage(recipient, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
        return "email";  // redisplay page with status message
    }
    
    public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	private String recipient;
    private String subject;
    private String message;
    private String statusMessage = "";
    
}

