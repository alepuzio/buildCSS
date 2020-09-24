package net.alepuzio.buildCSS.directory;

import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.file.Template;
import net.alepuzio.buildCSS.file.CSS;


public class Factory {
	public Directory file(String param){
		Directory result = new Fake(param);
		return result;
	}
}

class Fake implements Directory {

	public final String root ; 
	Fake (String newRoot){
		this.root = newRoot;
	}


	public List<Template> files(String extension) {
		List<Template> result = new ArrayList<Template>();
		result.add(new CSS(null));
		return result;
	}
}

