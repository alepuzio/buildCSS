package net.alepuzio.buildCSS.parsing;

import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.ParserProperties;

import net.alepuzio.buildCSS.enumeration.EnumMessages;
import net.alepuzio.buildCSS.logic.element.FactoryFlowMoreCSS;
import net.alepuzio.buildCSS.logic.element.FlowMoreCSSFiles;

public class ArgumentsByConsole {

	final int WITDH_OF_CONSOLE= 80;
	@Option(name = "-conf", usage = "name of configuration file", metaVar = "PROPERTIES")
	private File configurationFile = null;

	@Option(name = "-message", usage = "true if it's showing the messages, false otherside", metaVar = "SHOWMESSAGE")
	private boolean showMessage = false;



	public void setShowMessage(boolean activeMessage) {
		this.showMessage = activeMessage;
	}


	@SuppressWarnings("deprecation")
	public void run() throws CmdLineException {

        
        ParserProperties parserProperties = ParserProperties.defaults();
        parserProperties.withUsageWidth(this.WITDH_OF_CONSOLE);
		File configurationFile = this.getConfigurationFile();
		if (null != configurationFile) {
			
			if (configurationFile.exists()) {
				if (!configurationFile.canRead()) {
					throw new CmdLineException( EnumMessages.FORBITTEN_FILE.getValue());
				}
			} else {
				throw new CmdLineException(EnumMessages.WRONG_ARGUMENTS.getValue());
			}
		}else {
			throw new CmdLineException(EnumMessages.NULL_INSTANCE.getValue());
		}
		
		
	}

	/**
	 * 
	 * */
	public void createsCSSThemesFromDirectory() {
		try {
			FlowMoreCSSFiles css = 	new FactoryFlowMoreCSS(this.getConfigurationFile()).factory();
			css.createsCSSThemesFromDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public File getConfigurationFile() {
		return this.configurationFile;
	}


}
