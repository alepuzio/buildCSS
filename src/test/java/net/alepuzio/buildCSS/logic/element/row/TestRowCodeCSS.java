package net.alepuzio.buildCSS.logic.element.row;

import org.junit.Test;

import junit.framework.Assert;
import net.alepuzio.buildCSS.file.Factory;

public class TestRowCodeCSS {
	
	private RowCodeCSS rowCodeCSS = null; 
	
	@Test
	public void testGetValue() {
		final String value = "testGetValue";
		this.rowCodeCSS  = new FactoryRowCSS(value).instance();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		Assert.assertEquals(value, this.rowCodeCSS.value);
	}

	@Test
	public void testInstanceEmpty() {
		this.rowCodeCSS  = new FactoryRowCSS("testInstanceEmpty").instanceEmpty();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		Assert.assertEquals(this.rowCodeCSS.value,"");
	}


	@Test
	public void testSubstitutesCSS() {
		this.rowCodeCSS  = new FactoryRowCSS("background: FIRST;").instance();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		try {
			String res = this.rowCodeCSS.finalCSS(
					new Factory("fake").file().properties()
					).value;
			Assert.assertEquals("background: #1;\n", res);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);		
		}
	}
}
