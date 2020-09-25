package net.alepuzio.buildCSS.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class Factory {

	public InputFile file(String param){
		InputFile result = null;
		result = new Fake();
		return result;
	}
}

class Fake implements InputFile {

	public List<RowCodeCSS> code() throws IOException {
		return null;
	}

	public Properties data() {
	// TODO Auto-generated method stub
		return null;
	}

	public String title() {
		return null;
	}

}
