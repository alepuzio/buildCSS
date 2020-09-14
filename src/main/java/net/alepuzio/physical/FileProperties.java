package net.alepuzio.physical;

import java.util.Properties;

class FileProperties implements HardDisk{
	
	public final Properties propertiesEnvironment;
	 
	public FileProperties(){
		this.propertiesEnvironment = new Properties();
	}
	
	public Properties propertiesEnvironment(){
		return this.propertiesEnvironment;
	}
	
 }
