package net.alepuzio.buildCSS.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class Factory {

	public Code file(String param){
		Code result = null;
		result = new Fake();
		return result;
	}
}

class Fake implements Code {

	public List<RowCodeCSS> css() throws IOException {
		return null;
	}

	public DecodedCSSInstruction properties() {
		return null;
	}

	public String title() {
		return null;
	}

}
