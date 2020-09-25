package net.alepuzio.buildCSS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.alepuzio.buildCSS.logging.TestDevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.row.TestRowCodeCSS;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class,TestDevelopmentUtilActive.class
	, TestRowCodeCSS.class })
public class AllTests {
	/**
	 * empty
	 * */

}
