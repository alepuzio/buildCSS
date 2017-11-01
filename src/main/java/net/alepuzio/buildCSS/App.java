package net.alepuzio.buildCSS;

import net.alepuzio.buildCSS.enumeration.EnumMessages;
import net.alepuzio.buildCSS.logic.FlowMoreCSS;

public class App {
	
	/**
	 * @effects: it launche program
	 * @param args: parameters from terminal
	 * */
    public static void main( String[] args ) throws Exception {
    	//DevelopmentUtil.printMsgDebug(EnumMessages.BEGIN_PROGRAM.getValue());
    	FlowMoreCSS.factory(args).createsCSSThemesFromDirectory();
    	//DevelopmentUtil.printMsgDebug(EnumMessages.END_PROGRAM.getValue());
    }

}
