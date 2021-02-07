package sentiment_analyser;

import java.util.ArrayList;

public class Increments {

	private String language;
	private ArrayList<TranslatedString> precedentFortifiers = new ArrayList<TranslatedString>();
	private ArrayList<TranslatedString> acedentFortifiers = new ArrayList<TranslatedString>();
	
	public Increments(String language) {
        this.language = language;
        
        this.precedentFortifiers.add(new TranslatedString("muito", "very", "muy"));
        this.precedentFortifiers.add(new TranslatedString("bastante", "quite", "bastante"));
        this.precedentFortifiers.add(new TranslatedString("basicamente", "basicly", "bastamente "));
        this.precedentFortifiers.add(new TranslatedString("extremamente", "extremely", "extremadamente"));
        this.precedentFortifiers.add(new TranslatedString("fortemente", "strong", "fuertemente"));
        this.precedentFortifiers.add(new TranslatedString("tão", "so", "tan"));

        this.acedentFortifiers.add(new TranslatedString("bastante", "quite", "bastante"));
    }
	
	public boolean isAPrecedentFortifier(String word) {
		if (word == null) return false;

		for (TranslatedString str : precedentFortifiers) {
			if (language == "pt" && str.getPt().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (language == "en" && str.getEn().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (language == "es" && str.getEs().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (str.getPt().equalsIgnoreCase(word) || str.getEn().equalsIgnoreCase(word) || str.getEs().equalsIgnoreCase(word)) {
	        	return true;
	        }
	    }

		return false;
	}
	
	public boolean isAAccessingFortifier(String word) {
		if (word == null) return false;

		for (TranslatedString str : acedentFortifiers) {
			if (language == "pt" && str.getPt().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (language == "en" && str.getEn().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (language == "es" && str.getEs().equalsIgnoreCase(word)) {
	        	return true;
	        } else if (str.getPt().equalsIgnoreCase(word) || str.getEn().equalsIgnoreCase(word) || str.getEs().equalsIgnoreCase(word)) {
	        	return true;
	        }
	    }

		return false;
	}
}