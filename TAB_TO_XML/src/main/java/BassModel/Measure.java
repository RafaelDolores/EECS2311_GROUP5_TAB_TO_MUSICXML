package BassModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Measure {

	@JacksonXmlProperty(isAttribute=true)
	int number;

	Attributes attributes;
	
    @JacksonXmlElementWrapper(useWrapping = false)
	ArrayList<Note> note;
	Barline barline;

	public Measure() {}
	public Measure(int number, ArrayList<Note> note, Attributes attributes, Barline barline) {
		super();
		this.number = number;
		this.note = note;
		this.attributes = attributes;
		this.barline = barline;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ArrayList<Note> getNote() {
		return note;
	}
	public void setNote(ArrayList<Note> note) {
		this.note = note;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Barline getBarline() {
		return barline;
	}
	public void setBarline(Barline barline) {
		this.barline = barline;
	}

}
