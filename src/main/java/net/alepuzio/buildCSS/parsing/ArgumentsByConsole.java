package net.alepuzio.buildCSS.parsing;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.ParserProperties;

import net.alepuzio.physical.FactoryFlowMoreCSS;
import net.alepuzio.physical.IDIrectoryOutput;

public class ArgumentsByConsole {

	final int WITDH_OF_CONSOLE = 80;

	@Option(name = "-config", usage = "name of configuration file", metaVar = "PROPERTIES")
	private File configurationFile = null;

	@Option(name = "-message", usage = "true if it's showing the messages, false otherside", metaVar = "SHOWMESSAGE")
	private boolean showMessage = true;

	public void setShowMessage(boolean activeMessage) {
		this.showMessage = activeMessage;
	}

	public void run() throws CmdLineException {
		ParserProperties parserProperties = ParserProperties.defaults();
		parserProperties.withUsageWidth(this.WITDH_OF_CONSOLE);  
		validate();
	}

	@SuppressWarnings("deprecation")
	private void validate() throws CmdLineException {//TODO decorator
		File configurationFile = this.getConfigurationFile();
		Message showException = null;
		if (null != configurationFile) {
			if (configurationFile.exists()) {
				if (!configurationFile.canRead()) {
					showException = new Forbitten();
				}
			} else {
				showException = new NoConfig();
				File f = new File(".");
				List<String> lista = Arrays.asList(f.list());
				for(String tmp: lista) {
					System.out.println(tmp	);
				}
			}
		} else {
			showException = new NoFile();
		}
		if (null != showException) {
			throw new CmdLineException(new FactoryMessage(showException, configurationFile).message());
		}
	}


	/**
	 * 
	 * */
	public void createsCSSThemesFromDirectory() {
			FlowMoreCSSFiles css = new FlowMoreCSSFiles(this.configurationFile);
			css.createsCSSThemesFromDirectory();
		
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

class NoConfig implements Message{
	public String getValue() {
		return "Absent configuration file.";
	}

	public boolean notNull() {
		return true;
	}

}
class NoFile implements Message{

	public String getValue() {
		return "Null instance of configuration file";
	}

	public boolean notNull() {
		return false;
	}	
	
}

interface Message{
	
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