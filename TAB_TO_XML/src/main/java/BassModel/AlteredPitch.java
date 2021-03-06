package BassModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonPropertyOrder({"step", "alter", "octave"})
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
