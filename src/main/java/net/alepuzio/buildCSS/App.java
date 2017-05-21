package net.alepuzio.buildCSS;

public class App {
	
    public static void main( String[] args ) throws Exception {
    	System.out.println("Begin");
    	FlowMoreCSS.factory(args).createsCSSThemesFromDirectory();
    	System.out.println("Successfull creation of themes");
    }

}
