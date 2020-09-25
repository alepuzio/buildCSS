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
import net.alepuzio.buildCSS.directory.output.CSSWriter;
import net.alepuzio.buildCSS.directory.Physical_to_move;
import net.alepuzio.buildCSS.directory.input.CSS;
import net.alepuzio.buildCSS.file.Code;
import net.alepuzio.buildCSS.file.type.FinalCSS;

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
				System.out.println("Present file:" + tmp);
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
	public void themes() throws IOException {
		List<Code> inputProperties = new Properties(
				new Physical_to_move(this.inputDirectory, "pattern")
				).files();
		Iterator<Code> iteraCSS = new CSS(
				new Physical_to_move(this.inputDirectory, "stylesheet")
				).files().iterator();
		while ( iteraCSS.hasNext() ) {
			Code tmpCSS = iteraCSS.next();
			Iterator<Code> iteraProperties = inputProperties.iterator();
			while ( iteraProperties.hasNext() ) {
				new CSSWriter(
						new FinalCSS(tmpCSS, iteraProperties.next())
						).singleCSSTheme();
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