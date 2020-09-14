package net.alepuzio.physical;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.alepuzio.buildCSS.logic.element.FlowMoreCSSFiles;


public class FactoryFlowMoreCSS {
	/**
	 * @overview: input directory*/
	public final File directoryToRead;

	
	public FactoryFlowMoreCSS( File newDirectoryToRead){
		this.directoryToRead = newDirectoryToRead;
	}
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */
	public  FlowMoreCSSFiles factory() {
		return new FlowMoreCSSFiles().init( this.directoryToRead);
	}

	@Override
	public String toString() {
		return "FactoryFlowMoreCSS [directoryToRead=" + this.directoryToRead + "]";
	}


	
}
