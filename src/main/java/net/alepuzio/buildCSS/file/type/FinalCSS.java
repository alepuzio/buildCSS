package net.alepuzio.buildCSS.file.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.file.Nameplate;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class FinalCSS implements Code {
	
	public final Code initialCSS;
	public final Nameplate templateProperties;
	
	
	public FinalCSS(Code newInitialCSS, Nameplate newTemplateProperties){
		this.initialCSS = newInitialCSS;
		this.templateProperties = newTemplateProperties;
			
	}
	
	public List<RowCodeCSS> css()  throws Exception {
		List<RowCodeCSS> finalCSS = new ArrayList<RowCodeCSS>();
		Iterator<RowCodeCSS> iteraRows = this.initialCSS.css().iterator();
		while(iteraRows.hasNext()){
			finalCSS.add(iteraRows.next().finalCSS(this.templateProperties.properties()));
		}
		return finalCSS;
	}

	
	public String title(){
		return this.templateProperties.title().concat("-").concat(this.initialCSS.title());
	}

}
