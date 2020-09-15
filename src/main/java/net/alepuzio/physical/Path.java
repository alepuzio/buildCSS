package net.alepuzio.physical;

import java.io.File;
/**
 * @overview this class 
 * */
public class Path {
	 
	 public final HardDisk source ;
	 
	 public Path(HardDisk newHardDisk){
		 this.source = newHardDisk;
	 }

	/**
	* @return the directory of the file CSS before the substituition fo the nameplates
	* */
	public File configurationColours (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_SCHEME_COLORS.name()));
	}
	
	/**
	 * @return the directory of the file CSS after substituition
	 * */
	public File output(){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_OUTPUT.name()));
	}
	
	/**
	 * @return the directory of the template Desktop CSS
	 * */
	public File modelDesktopCSS  (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_DESKTOP_MODEL_CSS.name()));
	}
	
	/**
	 * @return the directory of the template Mobile CSS
	 * */
	public File modelMobileCSS  (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_MOBILE_MODEL_CSS.name()));
	}

	
}
