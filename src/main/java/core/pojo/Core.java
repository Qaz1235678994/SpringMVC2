package core.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Core implements Serializable {
	private static final long serialVersionUID = 1457755989409740329L;
	private boolean successful;
	private String message;
	
	// 因為引用了lombok的外掛所以建構子跟GET SET都不用了會自動產生
//	public Core() {
//	}
//
//	public Core(boolean successful, String message) {
//		this.successful = successful;
//		this.message = message;
//	}
//
//	public boolean isSuccessful() {
//		return successful;
//	}
//
//	public void setSuccessful(boolean successful) {
//		this.successful = successful;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
}
