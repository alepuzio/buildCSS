package net.alepuzio.buildCSS.logging;

public class DevelopmentUtilActive implements DevelopmentUtil {
	
	public final String message;
	
	public DevelopmentUtilActive( String newMessage) {
		this.message = newMessage;
	}
	
	public void printMsgDebug(){
		System.out.println( this.message);
	}
	

}
