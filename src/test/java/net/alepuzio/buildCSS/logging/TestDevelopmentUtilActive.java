/**
 * 
 */
package net.alepuzio.buildCSS.logging;

import org.junit.Test;

import junit.framework.Assert;
import net.alepuzio.buildCSS.logging.DevelopmentUtilActive;
import net.alepuzio.buildCSS.logic.element.FactoryRowCSS;

/**
 * @author Alessandro
 *
 */
public class TestDevelopmentUtilActive  {
	
	private DevelopmentUtilActive instance = null;
	
	
	@Test
	public void testGetValue() {
		String valoreAtteso = "valoreatteso";
		this.instance = new DevelopmentUtilActive(valoreAtteso);
		String valoreOttenuto = this.instance.getMessage();
		Assert.assertNotNull(valoreOttenuto);
		Assert.assertEquals(valoreOttenuto, valoreAtteso);
	}
	
}
