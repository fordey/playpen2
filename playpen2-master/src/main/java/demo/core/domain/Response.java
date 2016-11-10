package demo.core.domain;



public class Response {
	
	private String messageId;
	private boolean success;
	private String queueSize;
	
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getQueueSize() {
		return queueSize;
	}
	public void setQueueSize(String queueSize) {
		this.queueSize = queueSize;
	}	
	
}
