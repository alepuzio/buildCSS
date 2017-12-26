package net.alepuzio.buildCSS.logging;

public class DevelopmentUtilActive extends DevelopmentUtil {
	
	private String message;
	
	public DevelopmentUtilActive( String newMessage) {
		this.message = newMessage;
	}
	
	@Override
	public void printMsgDebug(){
		System.out.println( this.getMessage());
	}

	public String getMessage() {
		return this.message;
	}
	
	

}
