package net.alepuzio.buildCSS.logic.element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FactoryFlowMoreCSS {
	
	private File abc = null;

	
	public FactoryFlowMoreCSS( File newAbc){
		this.abc = newAbc;
	}
	/**
	 * singleton
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public  FlowMoreCSSFiles factory() {
		return new FlowMoreCSSFiles().init( this.getAbc());
	}

	public File getAbc() {
		return this.abc;
	}
	@Override
	public String toString() {
		return "FactoryFlowMoreCSS [abc=" + this.abc + "]";
	}


	
}
