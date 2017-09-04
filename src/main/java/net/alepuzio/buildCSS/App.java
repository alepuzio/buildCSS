package net.alepuzio.buildCSS;

import net.alepuzio.buildCSS.DevelopmentUtil;
import net.alepuzio.buildCSS.FlowMoreCSS;

public class App {
	
	/**
	 * @effects: it launche program
	 * @param args: parameters from terminal
	 * */
    public static void main( String[] args ) throws Exception {
    	DevelopmentUtil.printMsgDebug("Begin");
    	FlowMoreCSS.factory(args).createsCSSThemesFromDirectory();
    	DevelopmentUtil.printMsgDebug("Successfull creation of themes");
    }

}
