package net.alepuzio.buildCSS;

public class App {
	
	/**
	 * @effects: it launche program
	 * @param args: parameters from terminal
	 * */
    public static void main( String[] args ) throws Exception {
    	System.out.println("Begin");
    	FlowMoreCSS.factory(args).createsCSSThemesFromDirectory();
    	System.out.println("Successfull creation of themes");
    }

}
