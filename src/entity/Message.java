package entity;

import java.io.Serializable;

public class Message implements Serializable {

	private String messageId;
	private String summary;
	private String detail;

	public Message(String messageId, String summary, String detail) {
		this.messageId = messageId;
		this.summary = summary;
		this.detail = detail;
	}

	// getter setter
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
