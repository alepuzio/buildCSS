package net.alepuzio.buildCSS.logic.element.row;

import net.alepuzio.buildCSS.logic.element.Mapping_to_trash;


/**
 * @overview: This class represents a single CSS instruction or a single row into CSS files
 * */
public class RowCodeCSS {
	
	public final String value;
	/**
	 * @return a new RowCodeCSS , after substitute the constant FIRST, SECOND, etc
	 * */
	public RowCodeCSS finalCSS(Mapping_to_trash templateProperties) {	
		return new CRLine(
				new Four(
						new Third(
								new Second(
										new First(
												new Basic(templateProperties, value)
												)
										)
								)
						)
				).finalCSS();
	}
	
	RowCodeCSS(String newValue){
		this.value  = newValue;
	}

	@Override
	public String toString() {
		return new StringBuilder("RowCodeCSS [value=").append(value ).append("]").toString();
	}

}


interface Key {
	 RowCodeCSS finalCSS() ;
	 String value() ;
	 public String change(String nameplate);
}

class Basic implements Key {
	
	final String value;
	final Mapping_to_trash templateProperties;
	
	Basic(Mapping_to_trash newTemplateProperties, String newValue){
		this.value = newValue;
		this.templateProperties = newTemplateProperties;
	}

	 public RowCodeCSS finalCSS() {
		return new RowCodeCSS(this.value);
	}

	 public String value() {
		return this.value;
	}

	 public String change(String nameplate){
		 return this.value().replaceAll(nameplate, "#".concat(this.templateProperties.value(nameplate)));
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Basic [value=");
		builder.append(value);
		builder.append(", templateProperties=");
		builder.append(templateProperties);
		builder.append("]");
		return builder.toString();
	} 


}

class CRLine implements Key {
	
	public final Key line;
	
	public CRLine(Key newline){
		this.line = newline;
	}

	public RowCodeCSS finalCSS() {
		return new RowCodeCSS(this.line.finalCSS().value.concat("\n"));
	}

	public String value() {
		return this.line.value();
	}

	public String change(String nameplate) {
		return this.line.change(nameplate);
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
			 res = new RowCodeCSS( this.change(nameplate));
		 } else {
			 res = this.origin.finalCSS();
		 }
		 return res;
	 }
	 
	 public String change(String nameplate){
		 return this.origin.change(nameplate);
	 } 
	 
	public String value() {
		return this.origin.value();
	}
	 
}


class Second implements Key { 

	final Key origin;
	final String nameplate = "SECOND";
	
	Second(Key newValue){
		this.origin  = newValue;
	}

	 public RowCodeCSS finalCSS() {
		 RowCodeCSS res = null;
		 if( this.value().contains(nameplate) ) {
			 res = new RowCodeCSS( this.change(nameplate));
		 } else {
			 res = this.origin.finalCSS();
		 }
		 return res;
	 }
	 
	 public String change(String nameplate){
		 return this.origin.change(nameplate);
	 } 
	 
	public String value() {
		return this.origin.value();
	}
	 
}

class Third implements Key { 

	final Key origin;
	final String nameplate = "THIRD";
	
	Third(Key newValue){
		this.origin  = newValue;
	}

	 public RowCodeCSS finalCSS() {
		 RowCodeCSS res = null;
		 if( this.value().contains(nameplate) ) {
			 res = new RowCodeCSS( this.change(nameplate));
		 } else {
			 res = this.origin.finalCSS();
		 }
		 return res;
	 }
	 
	 public String change(String nameplate){
		 return this.origin.change(nameplate);
	 } 
	 
	public String value() {
		return this.origin.value();
	}
	 
}


class Four implements Key { 

	final Key origin;
	final String nameplate = "FOUR";
	
	Four(Key newValue){
		this.origin  = newValue;
	}

	 public RowCodeCSS finalCSS() {
		 RowCodeCSS res = null;
		 if( this.value().contains(nameplate) ) {
			 res = new RowCodeCSS( this.change(nameplate));
		 } else {
			 res = this.origin.finalCSS();
		 }
		 return res;
	 }
	 
	 public String change(String nameplate){
		 return this.origin.change(nameplate);
	 } 
	 
	public String value() {
		return this.origin.value();
	}
	 
}

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
