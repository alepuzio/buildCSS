package net.alepuzio.buildCSS.logic.element.row;

import net.alepuzio.buildCSS.file.Template;
import net.alepuzio.buildCSS.file.type.TemplateProperties;

/**
 * @overview: This class represents a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	public final String value;
	/**
	 * @return a new RowCodeCSS , after substitute the constant FIRST, SECOND, etc
	 * */
	public RowCodeCSS finalCSS(TemplateProperties templateProperties) {	
		return new First(new Basic(templateProperties, value)).finalCSS();
	}
	
	RowCodeCSS(String newValue){
		this.value  = newValue;
	}

}


interface Key {
	 RowCodeCSS finalCSS() ;
	 String value() ;
	 public String change(String nameplate, String newValue);
	 
}

class Basic implements Key {
	
	final String value;
	final TemplateProperties templateProperties;
	
	Basic(TemplateProperties newTemplateProperties, String newValue){
		this.value = newValue;
		this.templateProperties = newTemplateProperties;
	}

	 public RowCodeCSS finalCSS() {
		return new RowCodeCSS(this.value);
	}

	 public String value() {
		return this.value;
	}

	 public String change(String nameplate, String newValue){
		 return this.value().replaceAll(nameplate, this.templateProperties.data().getProperty(nameplate));
	 } 


}

class First implements Key { 

	final Key origin;
	final String nameplate = "FIRST";
	
	First(Key newValue){
		this.origin  = newValue;
	}

	 public RowCodeCSS finalCSS() {
		 RowCodeCSS res = null;
		 if( this.value().contains(nameplate) ) {
			 res = new RowCodeCSS( this.origin.change(nameplate, this.value()));
		 }else{
			 res = this.origin.finalCSS();
		 }
		 return res;
	 }
	 
	 public String change(String nameplate, String newValue){
		 return this.origin.change(nameplate, newValue);
	 } 
	 
	public String value() {
		return this.origin.value();
	}
	 
}

//class Second implements Key {
//
//	Key origin;
//	
//	Second(Key newValue){
//		this.origin  = newValue;
//	}
//
//	 RowCodeCSS finalCSS() {
//		 if(value.contains("SECOND") ) {
//			 return origin.change();
//		 }else{
//			 return origin.change();
//		 }
//		 
//	 }
//}
//
//class Third implements Key {
//
//	Key origin;
//
//	Third(Key newValue){
//		this.value  = newValue;
//	}
//
//	 RowCodeCSS finalCSS() {
//		 if(value.contains("THIRD")){
//			 return origin.change();
//		 }else{
//			 return origin.change();
//		 }
//		 
//	 }
//}
//
//
//class Fourth implements Key {
//
//	Key origin;
//	String value;
//
//	Fourth(Key newValue){
//		this.value  = newValue;
//	}
//
//	 RowCodeCSS finalCSS() {
//		 if(value.contains("FOURTH")) {
//			 return origin.change();
//		 }else{
//			 return origin.change();
//		 }
//		 
//	 }
//}
