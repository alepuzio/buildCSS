package net.alepuzio.buildCSS.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class Factory {

	public Template file(String param){
		Template result = null;
		result = new Fake();
		return result;
	}
}

class Fake implements Template {

	public List<RowCodeCSS> code() throws IOException {
		return null;
	}

	public Properties data() {
	// TODO Auto-generated method stub
		return null;
	}

}
