package Model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonPropertyOrder({"step", "octave", "alter"})
public class AlteredPitch extends Pitch {
	
	@JacksonXmlProperty(localName = "alter")
	String alter;

	public void setAlter(String alter) { 
		this.alter = alter; 
		
	}
	
	public String getAlter() { 
		
		return this.alter;
		
	}
}
