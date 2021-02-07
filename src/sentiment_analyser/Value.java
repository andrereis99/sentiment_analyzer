package sentiment_analyser;

import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONObject;

public class Value {
	private String value;
	private int positive;
	private int negative;
	
	public Value(String value, int positive, int negative) {
		this.value = value;
		this.positive = positive;
		this.negative = negative;
    }

	public Value() {
		this.value = "";
		this.positive = 0;
		this.negative = 0;
	}
	
	public Value(JSONObject object, String word) {
		this.value = word != null ? word : object.getString("value");
		this.positive = object.getInt("positive");
		this.negative = object.getInt("negative");
	}
	
	public void incrementSentiments(Value value) {
		this.positive = this.positive + value.getPositive();
		this.negative = this.negative + value.getNegative();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPositive() {
		return positive;
	}

	public void setPositive(int positive) {
		this.positive = positive;
	}

	public int getNegative() {
		return negative;
	}

	public void setNegative(int negative) {
		this.negative = negative;
	}
	
	public String getSentiment() {
		if (this.positive > this.negative) return "Positive";
		else if (this.negative > this.positive) return "Negative";
		else return "Neutral";
	}
	
	@Override
    public String toString() { 
        return String.format('"' + this.value + '"' + ": { positive: " + this.positive + ", negative: " + this.negative + " }");
    } 
}
