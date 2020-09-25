package net.alepuzio.buildCSS.directory.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class CSSWriter {
		
	public final  Code origin;
	
	public CSSWriter(Code newOrigin){
		this.origin = newOrigin;
	}
	
	/**
	 * @effects print the data in physical file
	 * */
	public void singleCSSTheme() throws IOException {
		BufferedWriter newThemeCSSToWrite = null;
		String path = this.path();
		try {
    		newThemeCSSToWrite = new BufferedWriter(
    				new FileWriter(path)
    				);
			Iterator<RowCodeCSS> toWrite = this.origin.css().iterator();
			while(toWrite.hasNext()){
				newThemeCSSToWrite.write(toWrite.next().value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != newThemeCSSToWrite) {
				newThemeCSSToWrite.flush();
				newThemeCSSToWrite.close();
			}
		}
	}
	
	String path(){
		return 	new Output().hardDisk().directory.concat(this.origin.title()).concat(".css");
	}

}

class Output {
	
	public final String directory;
	
	Output(){
		this.directory = ".\\output\\";
	}
	
	Output hardDisk() {
		File dir = new File(this.directory);
		if (dir.isDirectory()) {//TODO use decorator
			if (dir.exists()) {
				if (dir.canWrite()) {
					System.out.println("The directory {0} is available".format("%s", this.directory));
				}else{
					System.err.println("You are not allowed to write the directory {0}".format("%s", this.directory));
				}
			}else{
				dir.mkdirs();
				System.out.println("The directory {0} is built".format("%s", this.directory));
			}
		} else{
			//error not directory
			System.err.println("The file {0} is not a directory".format("%s", this.directory));
		}
		return this;
	}	
	
}
