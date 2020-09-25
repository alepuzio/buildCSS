package net.alepuzio.buildCSS.directory;

import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.file.type.TemplateCSS;

/**
 * @overview: it create the correct template, a tempalte is a List of rows
 * */
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

	public List<Code> files(String extension) {
		List<Code> result = new ArrayList<Code>();
		result.add(new TemplateCSS(null));
		return result;
	}
}

