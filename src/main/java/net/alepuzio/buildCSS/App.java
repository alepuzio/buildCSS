package net.alepuzio.buildCSS;

import org.kohsuke.args4j.CmdLineParser;

import net.alepuzio.buildCSS.parsing.ArgumentsByConsole;

public class App {

	/**
	 * @effects: it runs program
	 * @param args:
	 *            parameters from terminal
	 */
	public static void main(String[] args) throws Exception {
		ArgumentsByConsole bean = new ArgumentsByConsole();
		CmdLineParser parser = new CmdLineParser(bean);
		try {
			System.out.println("Started elaboration");//TODO timestmap?
			parser.parseArgument(args);
			bean.run();
			bean.themes();
			System.out.println("Finished elaboration");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			parser.printUsage(System.err);
		} finally {
			System.out.println("Released resources");
		}
	}

}
