package DrumModel;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PartList {

	@JacksonXmlProperty(localName = "score-part")
	ArrayList<ScorePart> scoreParts;

	public ArrayList<ScorePart> getScoreParts() {
		return scoreParts;
	}

	public void setScoreParts(ArrayList<ScorePart> scoreParts) {
		this.scoreParts = scoreParts;
	}

	public PartList() {}
	public PartList(ArrayList<ScorePart> scoreParts) {
		super();
		this.scoreParts = scoreParts;
	}
}
