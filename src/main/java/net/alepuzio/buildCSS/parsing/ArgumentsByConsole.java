package net.alepuzio.buildCSS.parsing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.ParserProperties;

import net.alepuzio.buildCSS.directory.input.Properties;
import net.alepuzio.buildCSS.directory.Directory;
import net.alepuzio.buildCSS.directory.Physical_to_move;
import net.alepuzio.buildCSS.directory.input.CSS;
import net.alepuzio.buildCSS.file.InputFile;
import net.alepuzio.buildCSS.file.type.FinalCSS;
import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public class ArgumentsByConsole {

	final int WITDH_OF_CONSOLE = 80;

	@Option(name = "-input", usage = "name of input directory", metaVar = "directory path")
	private String inputDirectory;

	public void run() throws CmdLineException {
		ParserProperties parserProperties = ParserProperties.defaults();
		parserProperties.withUsageWidth(this.WITDH_OF_CONSOLE);  
		validate();
	}

	@SuppressWarnings("deprecation")
	private void validate() throws CmdLineException {//TODO decorator
		Message showException = null;
		File directory = new File(this.inputDirectory);
		if (directory.exists()) {
			if (!directory.canRead()) {
				showException = new Forbitten();
			}
		} else {
			showException = new NoFile();
			File f = new File(".");
			List<String> lista = Arrays.asList(f.list());
			for(String tmp: lista) {
				System.out.println(tmp	);
			}
		}
		if (null != showException) {
			throw new CmdLineException(new FactoryMessage(showException, directory).message());
		}
	}


	/**
	 * @throws IOException 
	 * 
	 * */
	public void createsCSSThemesFromDirectory() throws IOException {
		Directory directoryProperties = new Properties(
				new Physical_to_move(this.inputDirectory, "properties"));
		List<InputFile> inputProperties = directoryProperties.files("properties");

		Directory directoryCSS = new CSS(
				new Physical_to_move(this.inputDirectory, "css"));
		List<InputFile> inputCSS = directoryCSS.files("CSS");
		
		Iterator<InputFile> iteraCSS = inputCSS.iterator();
		while ( iteraCSS.hasNext() ) {
			InputFile tmpCSS = iteraCSS.next();
			
			Iterator<InputFile> iteraProperties = inputProperties.iterator();
			while ( iteraProperties.hasNext() ) {
				InputFile tmpProperties = iteraProperties.next();
				List<RowCodeCSS> listFinalCSS= new FinalCSS(tmpCSS, tmpProperties.data()).code();
				System.out.println(listFinalCSS);
			}
		}
	}
	


}

class Forbitten implements Message {

	public String getValue() {
		return "Yout don\'t have the read permission";
	}

	public boolean notNull() {
		return true;
	}
}


class NoFile implements Message {

	public String getValue() {
		return "Null instance of the path";
	}

	public boolean notNull() {
		return false;
	}	
	
}

interface Message {
	public String getValue();
	public boolean notNull();
}

class FactoryMessage {
	
	private Message message;
	private File configurationFile;

	FactoryMessage(Message message, File configurationFile) {
		super();
		this.message = message;
		this.configurationFile = configurationFile;
	}

	String message() {
		String msg = message.getValue();
		if(message.notNull()) {//TODO decorator
			msg = msg + ": " + configurationFile.getName();
		}
		return msg;
	}

}