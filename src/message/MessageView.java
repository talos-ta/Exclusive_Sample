package message;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entity.Message;

@Named
@RequestScoped
public class MessageView {

	public void info(Message message) {
		FacesContext.getCurrentInstance().addMessage(message.getMessageId(),
				new FacesMessage(FacesMessage.SEVERITY_INFO, message.getSummary(), message.getDetail()));
	}

	public void warn(Message message) {
		FacesContext.getCurrentInstance().addMessage(message.getMessageId(),
				new FacesMessage(FacesMessage.SEVERITY_WARN, message.getSummary(), message.getDetail()));
	}

	public void error(Message message) {
		FacesContext.getCurrentInstance().addMessage(message.getMessageId(),
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message.getSummary(), message.getDetail()));
	}

	public void fatal(Message message) {
		FacesContext.getCurrentInstance().addMessage(message.getMessageId(),
				new FacesMessage(FacesMessage.SEVERITY_FATAL, message.getSummary(), message.getDetail()));
	}
}
