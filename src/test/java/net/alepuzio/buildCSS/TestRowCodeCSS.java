package net.alepuzio.buildCSS;

import java.util.Properties;

import junit.framework.Assert;

import org.junit.Test;

public class TestRowCodeCSS {
	
	private RowCodeCSS rowCodeCSS = null; 
	
	@Test
	public void testGetValue() {
		String valore = "testGetValue";
		rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( rowCodeCSS);
		Assert.assertNotNull( rowCodeCSS.getValue());
		Assert.assertEquals(valore, rowCodeCSS.getValue());
	}

	@Test
	public void testInstanceEmpty() {
		rowCodeCSS  = RowCodeCSS.instanceEmpty();
		Assert.assertNotNull( rowCodeCSS);
		Assert.assertNotNull( rowCodeCSS.getValue());
		Assert.assertEquals( rowCodeCSS.getValue(), "\n");
	}

	@Test
	public void testSubstitutes() {
		String valore = "abcd";
		Properties properties = new Properties();
		
		properties.put("a","1");
		properties.put("b","2");
		properties.put("c","3");
		properties.put("d","4");
		rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( rowCodeCSS);
		Assert.assertNotNull( rowCodeCSS.getValue());
		
		System.out.println(rowCodeCSS.substitutes(properties).getValue());
		Assert.assertEquals("#1#2#3#4", rowCodeCSS.substitutes(properties).getValue());
	}

	@Test
	public void testSubstitutesCSS() {
		String valore = "background: FIRST;";
		Properties properties = new Properties();
		
		properties.put("FIRST","1");
		rowCodeCSS  = RowCodeCSS.instance(valore);
		Assert.assertNotNull( rowCodeCSS);
		Assert.assertNotNull( rowCodeCSS.getValue());
		Assert.assertEquals("background: #1;", rowCodeCSS.substitutes(properties).getValue());
	}
}
