package net.alepuzio.buildCSS.logic.element;

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

import net.alepuzio.buildCSS.enumeration.EnumMessages;

/**
 * @overview: old version
 * */
public class Flow {
	
	private String nameTemplate = null;
	private Properties properties = null;
	
	
	protected Flow(String[] args) {
		if(null == args || args.length != 1){
    		System.err.println(net.alepuzio.buildCSS.enumeration.EnumMessages.WRONG_ARGUMENTS.getValue());
    		System.exit(1);
    	}else{
    		this.nameTemplate = args[0];
    		this.properties = new  Properties();
    	}
	}

	protected Properties getProperties() {
		return this.properties;
	}

	protected String getNameTemplate() {
		return this.nameTemplate;
	}

	/**
	 * 
	 * */
	public void loadProperties() {
		try {
			String pathInput = ".\\src\\main\\resources\\" + this.getNameTemplate() + ".properties";
			getProperties().load(new BufferedReader(new FileReader(pathInput)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return 
	 * */
	public List<RowCodeCSS> manipulateTemplate() throws IOException {
		List<RowCodeCSS> row = new ArrayList<RowCodeCSS>();
    	BufferedReader br = null;
    	String model = ".\\src\\main\\resources\\model.css";
    	
    	try {
			br = new BufferedReader(new FileReader(model));
			String currentLine = null;
			while(null != ( currentLine = br.readLine())){
				FactoryRowCSS factoryRow = new FactoryRowCSS(currentLine);
				RowCodeCSS codeCSS = factoryRow.instance().substitutes(getProperties());
				row.add(codeCSS);
				row.add(factoryRow.instanceEmpty());
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(EnumMessages.UNDEFINED_MODEL.getValue() + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return row;
	}
	
	/**
	 * @param row: list of CSS instructions
	 * */
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
