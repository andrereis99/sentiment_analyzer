package sentiment_analyser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

public class SentimentAnalyser {

	public static void main(String[] args) {
		String filename = "words.json";
		Path path = Paths.get(filename);
		System.out.println(path.toAbsolutePath());
		try {
			String contents = new String((Files.readAllBytes(path)));
			JSONObject wordsFile = new JSONObject(contents);
			System.out.println(wordsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
