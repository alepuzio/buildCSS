package net.alepuzio.buildCSS.directory.input;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.directory.Directory;
import net.alepuzio.buildCSS.directory.Physical_to_move;
import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.file.type.TemplateCSS;

/**
 * @overview : it manage the operations on the directory with CSS files
 * */
public class CSS implements Directory {

	public final Physical_to_move origin;
	
	public CSS(Physical_to_move newOrigin){
		this.origin = newOrigin;
	}
	
	public List<Code> files() {
		File[] templates = this.origin.files("css");
		List<Code> result = new ArrayList<Code>();
		for (File tmp : templates){
			Code css = new TemplateCSS(tmp);
			result.add(css);
		}
		return result ;
	}
}

