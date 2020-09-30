package net.alepuzio.buildCSS.file.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class FinalCSS implements Code {
	
	public final Code initialCSS;
	public final Code templateProperties;
	
	
	public FinalCSS(Code newInitialCSS, Code newTemplateProperties){
		this.initialCSS = newInitialCSS;
		this.templateProperties = newTemplateProperties;
			
	}
	
	public List<RowCodeCSS> css()  throws IOException {
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
		Iterator<RowCodeCSS> iteraRows = this.initialCSS.css().iterator();
		while(iteraRows.hasNext()){
			finalCSS.add(iteraRows.next().finalCSS(this.templateProperties.properties()));
		}
		return finalCSS;
	}

	/**
	 * @TODO refactoring
	 * */
	public DecodedCSSInstruction properties() {
		throw new UnsupportedOperationException(
				String.format(
						"The {0} doesn't support this method",
						this.getClass().getName() 
						)
				); 
	}
	
	public String title(){
		return this.templateProperties.title().concat("-").concat(this.initialCSS.title());
	}

}
