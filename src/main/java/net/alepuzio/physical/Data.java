package net.alepuzio.physical;

import java.io.File;
import java.util.Properties;

public class Data {
	 
	 public final HardDisk source ;
	 
	 Data(HardDisk newHardDisk){
		 this.source = newHardDisk;
	 }

	public File directoryInput (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.DIRECTORY_INPUT.name()));
	}
	
	public File directoryOutput (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.DIRECTORY_OUTPUT.name()));
	}
	public File pathDesktopModelCSS  (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_DESKTOP_MODEL_CSS.name()));
	}

	public File pathMobileModelCSS  (){
		return new File(this.source.propertiesEnvironment().getProperty(EnumFileSystem.PATH_MOBILE_MODEL_CSS.name()));
	}

	public Properties templateCSSProperties  (){
		return null;
	}
	
}
