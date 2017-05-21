package net.alepuzio.buildCSS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Flow {
	
	private String nameTemplate;
	private Properties properties = null;
	
	
	public Flow(String[] args) {
		if(null == args || args.length != 1){
    		System.err.println("Wrong arguments: it need only the name of CSS template.");
    		System.exit(1);
    	}else{
    		this.nameTemplate = args[0];
    		this.properties = new  Properties();
    	}
	}

	public Properties getProperties() {
		return properties;
	}

	public String getNameTemplate() {
		return nameTemplate;
	}

	
	public void loadProperties()
			throws FileNotFoundException {
		try {
			String pathInput = ".\\src\\main\\resources\\" + this.getNameTemplate() + ".properties";
			getProperties().load(new BufferedReader(new FileReader(pathInput)));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined [" + this.getNameTemplate() + "]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<RowCodeCSS> manipulateTemplate() throws IOException {
		List<RowCodeCSS> row = new ArrayList<RowCodeCSS>();
    	BufferedReader br = null;
    	String model = ".\\src\\main\\resources\\model.css";
    	
    	try {
			br = new BufferedReader(new FileReader(model));
			//sostituendo i parametri
			String currentLine = null;
			
			while(null != ( currentLine = br.readLine())){
				RowCodeCSS codeCSS = RowCodeCSS.instance(currentLine).substitutes(getProperties());
				row.add(codeCSS);
				row.add(RowCodeCSS.instanceEmpty());
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Undefined model:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return row;
	}
	
	public void writeNewCSSTheme(List<RowCodeCSS> row) throws IOException {
		BufferedWriter bw = null;
    	try {
			bw = new BufferedWriter(new FileWriter(getNameTemplate() + ".css"));
			Iterator<RowCodeCSS> toWrite = row.iterator();
			while(toWrite.hasNext()){
				bw.write(toWrite.next().getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
