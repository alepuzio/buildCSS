package net.alepuzio.buildCSS.directory;

import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.file.InputFile;
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

	public List<InputFile> files(String extension) {
		List<InputFile> result = new ArrayList<InputFile>();
		result.add(new TemplateCSS(null));
		return result;
	}
}

