package net.alepuzio.physical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;

class FileProperties implements HardDisk{
	
	public final Properties propertiesEnvironment;
	 
	public FileProperties(){
		this.propertiesEnvironment = new Properties();
	}
	
	public Properties propertiesEnvironment(){
		return this.propertiesEnvironment;
	}
	
	/**
	 * @return initialized object
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * */	
	public HardDisk init(File abc) {
		Properties propertiesEnvironment = new Properties();
		try {
			propertiesEnvironment.load(new BufferedReader(new FileReader(abc.getAbsolutePath())));
			//Data disk = new Data(new HardDisk()); TODO fix
			new DevelopmentUtilActive("toString: " + this.toString()).printMsgDebug();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}

 }
