package net.alepuzio.physical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.EnumKey;
import net.alepuzio.buildCSS.logic.element.FactoryRowCSS;
import net.alepuzio.buildCSS.logic.element.RowCodeCSS;

public class PathDesktopModelCSS {
	
	public final File pathModelCSS; 
	
	PathDesktopModelCSS(File newPath){
		this.pathModelCSS = newPath;
	}

	/**
	 * @return list of CSS code modified
	 * */
	public List<RowCodeCSS> useTemplateOverModelCSS() throws IOException {
		new DevelopmentUtilActive("useTemplateOverModelCSS();").printMsgDebug();
		List<RowCodeCSS> row = new ArrayList<RowCodeCSS>();
 	   	BufferedReader templateCSSToRead = null;
    		try {
			templateCSSToRead = new BufferedReader(new FileReader(this.pathModelCSS.getAbsoluteFile()));
			String currentLine = null;
			while (null != ( currentLine = templateCSSToRead.readLine())) {
				RowCodeCSS codeCSS = new FactoryRowCSS(currentLine).instance();
				if (codeCSS.currentLineHasAtLeastOneKeyword()) {
					RowCodeCSS codeCSSSostituito = codeCSS.substitutes(templateCSSProperties());
					row.add(codeCSSSostituito);
				} else {
					row.add(codeCSS);
				}
				//row.add(factoryRowCSS.instanceEmpty());TODO read yegor

			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined CSS model:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != templateCSSToRead) {
				templateCSSToRead.close();
			}
		}
		return row;
	}
	



	
	
}
