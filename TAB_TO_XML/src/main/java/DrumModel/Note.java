package DrumModel;


public class Note {
	Unpitched unpitch;
	String duration; 
	Instrument instrument;
	String voice; 
	String type; 
	String stem;
	String notehead;
	Beam beam; 
	
	public void setUnpitch(Unpitched pitch) { 
		unpitch = pitch;
		
	}
	
	public Unpitched getUnpitch() { 
		
		return unpitch;
		
	}
	
	public void setDuration(String duration) { 
		
		this.duration = duration; 
		
	}
	
	public String getDuration() { 
		
		return duration; 
		
	}
	
	public void setVoice(String voice) { 
		
		this.voice = voice;  
		
	}
	
	public String getVoice() { 
		
		return voice; 
		
	}
	
	public void setType(String type) { 
		
		this.type = type; 
		
	
	}
	
	public String getType() { 
		
		return type;
		
	}
	
	public void setStem(String stem) { 
		
		this.stem = stem; 
		
	}
	
	public String getStem() { 
		
		return stem;
		
	}
	
	public void setNoteHead(String note) {
		
		notehead = note;
		
	}
	
	public void setInstrument(Instrument instrument) { 
		this.instrument = instrument;
		
	}
	public Instrument getInstrument() { 
		
		return instrument; 
		
	}
	
	public void setBeam(Beam beam) { 
		this.beam = beam;
		
	}
	
	public Beam getBeam() { 
		
		return beam;
	}
	
	public Note() {}
	public Note(Unpitched pitch, String duration, String voice, String stem, String type, String notehead, Instrument instrument, Beam beam) {
		
		super();
		this.beam = beam;
		this.instrument = instrument;
		this.unpitch = pitch;
		this.duration = duration;
		this.voice = voice;
		this.type = type;
		this.stem = stem;
		this.voice = voice;
		this.notehead = notehead;
		
	}
	
}
