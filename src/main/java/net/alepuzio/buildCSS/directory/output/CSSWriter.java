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
					System.out.println(String.format("The directory %s is available", this.directory));
				}else{
					System.err.println(String.format("You are not allowed to write the directory %s", this.directory));
				}
			}else{
				dir.mkdirs();
				System.out.println(String.format("The directory %s is built", this.directory));
			}
		} else{
			//error not directory
			System.err.println(String.format("The file %s is not a directory", this.directory));
		}
		return this;
	}	
	
}
