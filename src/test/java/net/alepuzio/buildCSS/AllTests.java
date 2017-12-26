package net.alepuzio.buildCSS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import net.alepuzio.buildCSS.element.TestRowCodeCSS;
import net.alepuzio.buildCSS.logging.TestDevelopmentUtilActive;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class,TestDevelopmentUtilActive.class, TestRowCodeCSS.class })
public class AllTests {
	/**
	 * empty
	 * */

}
