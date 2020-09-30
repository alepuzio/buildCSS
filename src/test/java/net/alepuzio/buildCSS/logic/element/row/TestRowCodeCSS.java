package net.alepuzio.buildCSS.logic.element.row;

import java.util.Properties;

import org.junit.Test;

import junit.framework.Assert;
import net.alepuzio.buildCSS.logic.element.DecodedCSSInstruction;
import net.alepuzio.buildCSS.logic.element.MappingNameplate;

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
		String value = "background: FIRST;";
		Properties properties = new Properties();
		properties.put("FIRST","1");
		DecodedCSSInstruction decodedCSSInstruction = new MappingNameplate(properties);
		this.rowCodeCSS  = new FactoryRowCSS(value).instance();
		Assert.assertNotNull(this.rowCodeCSS);
		Assert.assertNotNull(this.rowCodeCSS.value);
		String res = this.rowCodeCSS.finalCSS(decodedCSSInstruction).value;
		Assert.assertEquals("background: #1;", res);
	}
}
