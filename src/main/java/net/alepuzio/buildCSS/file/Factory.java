package net.alepuzio.buildCSS.file;


public class Factory {

	public Template file(String param){
		Template result = null;
		result = new Fake();
		return result;
	}
}

class Fake implements Template {

}
