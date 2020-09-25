package net.alepuzio.buildCSS.logic.element.row;

import java.util.Properties;

import org.junit.Test;

import junit.framework.Assert;

public class TestRowCodeCSS {
	
	private RowCodeCSS rowCodeCSS = null; 
	
	@Test
	public void testGetValue() {
		String valore = "testGetValue";
		this.rowCodeCSS  = new FactoryRowCSS(valore).instance();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		Assert.assertEquals(valore, this.rowCodeCSS.value);
	}

	@Test
	public void testInstanceEmpty() {
		String valore = "testInstanceEmpty";
		this.rowCodeCSS  = new FactoryRowCSS(valore).instanceEmpty();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		Assert.assertEquals(this.rowCodeCSS.value,"");
	}


	@Test
	public void testSubstitutesCSS() {
		String valore = "background: FIRST;";
		Properties properties = new Properties();
		
		properties.put("FIRST","1");
		this.rowCodeCSS  = new FactoryRowCSS(valore).instance();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		String res = this.rowCodeCSS.finalCSS(properties).value;
		Assert.assertEquals("background: #1;", res);
	}
}
