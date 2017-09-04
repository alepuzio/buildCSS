package net.alepuzio.buildCSS;

import java.util.Properties;

import junit.framework.Assert;

import org.junit.Test;

public class TestRowCodeCSS {
	
	private RowCodeCSS rowCodeCSS = null; 
	
	@Test
	public void testGetValue() {
		String valore = "testGetValue";
		this.rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( this.rowCodeCSS);
		Assert.assertNotNull( this.rowCodeCSS.getValue());
		Assert.assertEquals(valore, this.rowCodeCSS.getValue());
	}

	@Test
	public void testInstanceEmpty() {
		this.rowCodeCSS  = RowCodeCSS.instanceEmpty();
		Assert.assertNotNull( this.rowCodeCSS);
		Assert.assertNotNull( this.rowCodeCSS.getValue());
		Assert.assertEquals( this.rowCodeCSS.getValue(), "\n");
	}

	@Test
	public void testSubstitutes() {
		String valore = "abcd";
		Properties properties = new Properties();
		
		properties.put("a","1");
		properties.put("b","2");
		properties.put("c","3");
		properties.put("d","4");
		this.rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( this.rowCodeCSS);
		Assert.assertNotNull( this.rowCodeCSS.getValue());
		
		System.out.println(this.rowCodeCSS.substitutes(properties).getValue());
		Assert.assertEquals("#1#2#3#4", this.rowCodeCSS.substitutes(properties).getValue());
	}

	@Test
	public void testSubstitutesCSS() {
		String valore = "background: FIRST;";
		Properties properties = new Properties();
		
		properties.put("FIRST","1");
		this.rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( this.rowCodeCSS);
		Assert.assertNotNull( this.rowCodeCSS.getValue());
		Assert.assertEquals("background: #1;", this.rowCodeCSS.substitutes(properties).getValue());
	}
}
