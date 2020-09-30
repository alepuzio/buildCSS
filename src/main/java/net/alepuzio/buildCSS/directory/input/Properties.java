package net.alepuzio.buildCSS.directory.input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.directory.Directory;
import net.alepuzio.buildCSS.directory.Physical_to_move;
import net.alepuzio.buildCSS.file.Nameplate;
import net.alepuzio.buildCSS.file.type.InputProperties;

/**
 * @overview : it manage the operations on the directory with properties files
 * */
public class Properties implements Directory {

	public final Physical_to_move origin;
	
	public Properties(Physical_to_move newOrigin){
		this.origin = newOrigin;
	}
	
	public List<Nameplate> files() {
		File[] templates = this.origin.files("properties");
		List<Nameplate> result = new ArrayList<Nameplate>();
		for (File tmp : templates){
			Nameplate properties = new InputProperties(tmp);
			result.add(properties);
		}
		return result ;
	}

}
