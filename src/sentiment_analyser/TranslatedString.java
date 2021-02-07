package sentiment_analyser;

public class TranslatedString {
	private String pt;
	private String en;
	private String es;
	
	public TranslatedString(String pt, String en, String es) {
		this.pt = pt;
		this.en = en;
		this.es = es;
    }

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getEs() {
		return es;
	}

	public void setEs(String es) {
		this.es = es;
	}
}
