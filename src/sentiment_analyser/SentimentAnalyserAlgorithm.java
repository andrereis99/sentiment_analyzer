package sentiment_analyser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class SentimentAnalyserAlgorithm {

    private String contents;
    private String language;
    private JSONObject languagesFile;
    private Path path = Paths.get("words.json");
    private Increments incrementChecker;

	public SentimentAnalyserAlgorithm(String language) throws IOException {
		this.contents = new String(Files.readAllBytes(path));
		this.languagesFile = new JSONObject(this.contents);
		this.language = language;
		this.incrementChecker = new Increments(language);
    }

	public void algorithm(String[] sentences) {
		Value generalValue = new Value("General Value", 0, 0);
		
		for(String sentence: sentences) {
			Value v = this.analyseSentence(sentence);
			generalValue.incrementSentiments(v);
			System.out.println(v.toString());
		}
		
		System.out.println("Sentiment: " + generalValue.getSentiment());
	}

	/**
	 * Analisa o sentimento de uma frase
	 * @param str
	 */
	public Value analyseSentence(String str) {
		String aux = str.replaceAll("\\p{Punct}", "");
		String[] splited = aux.split("\\s+"); //split string by spaces
		Value response = new Value();
		response.setValue(str);
		long totalTime = 0;

		for(int i = 0; i < splited.length; i++) {
			int multiplier = 1;
			
			long initialTime = System.currentTimeMillis();

			// Find from object file
			initialTime = System.currentTimeMillis();
			Value obj2 = this.findWord(splited[i]);
			if (obj2 != null) {
				if (i-1 >= 0 && incrementChecker.isAPrecedentFortifier(splited[i-1])) multiplier++;
				if (i+1 < splited.length && incrementChecker.isAAccessingFortifier(splited[i+1])) multiplier++;
				response.setPositive(response.getPositive() + (obj2.getPositive() * multiplier));
				response.setNegative(response.getNegative() + (obj2.getNegative() * multiplier));
			}
			totalTime += System.currentTimeMillis() - initialTime;
		}

		System.out.println("totalTime: " + totalTime);

		return response;
	}

	public Value findWord(String word) {
		JSONObject wordsFile = languagesFile.getJSONObject("pt");
		Value word1 = null;
		try {
			JSONObject object = wordsFile.getJSONObject(word);
			word1 = new Value(object, word);
		} catch(Exception e) {
			return null;
		}
		return word1;
	}
}
