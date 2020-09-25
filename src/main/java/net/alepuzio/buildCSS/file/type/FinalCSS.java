package net.alepuzio.buildCSS.file.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.file.InputFile;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class FinalCSS implements InputFile {
	
	public final InputFile initialCSS;
	public final /*Input*/Properties templateProperties;
	
	public FinalCSS(InputFile newInitialCSS, /*Input*/Properties newTemplateProperties){
		this.initialCSS = newInitialCSS;
		this.templateProperties = newTemplateProperties;
			
	}
	
	public List<RowCodeCSS> code()  throws IOException {
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
 	   	List<RowCodeCSS> initialCode = this.initialCSS.code();
		Iterator<RowCodeCSS> iteraRows = initialCode.iterator();
		while(iteraRows.hasNext()){
			RowCodeCSS finalRow = iteraRows.next().finalCSS(this.templateProperties);
			finalCSS.add(finalRow);
		}
		return finalCSS;
	}

	public Properties data() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
