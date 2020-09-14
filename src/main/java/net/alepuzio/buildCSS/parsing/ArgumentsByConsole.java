package net.alepuzio.buildCSS.parsing;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.ParserProperties;

import net.alepuzio.buildCSS.enumeration.EnumMessages;
import net.alepuzio.buildCSS.logic.element.FactoryFlowMoreCSS;
import net.alepuzio.buildCSS.logic.element.FlowMoreCSSFiles;

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
	private void validate() throws CmdLineException {
		File configurationFile = this.getConfigurationFile();
		EnumMessages showException = null;
		if (null != configurationFile) {
			if (configurationFile.exists()) {
				if (!configurationFile.canRead()) {
					showException = EnumMessages.FORBITTEN_FILE;
				}
			} else {
				showException = EnumMessages.WRONG_ARGUMENTS;
				File f = new File(".");
				List<String> lista = Arrays.asList(f.list());
				for(String tmp: lista) {
					System.out.println(tmp	);
				}
			}
		} else {
			showException = EnumMessages.NULL_INSTANCE; //TODO use a class, not an enum
		}
		if (null != showException) {
			throw new CmdLineException(buildMsg(showException, configurationFile));
		}
	}

	private String buildMsg(EnumMessages message, File configurationFile) {
		String msg = message.getValue();
		if(!EnumMessages.NULL_INSTANCE.equals(message)) {
			msg = msg + ": " + configurationFile.getName();
		}
		return msg;
	}

	/**
	 * 
	 * */
	public void createsCSSThemesFromDirectory() {
		try {
			FlowMoreCSSFiles css = new FactoryFlowMoreCSS(this.getConfigurationFile()).factory();
			css.createsCSSThemesFromDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getConfigurationFile() {
		return this.configurationFile;
	}

}
