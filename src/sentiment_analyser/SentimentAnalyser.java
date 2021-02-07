package sentiment_analyser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SentimentAnalyser {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);

			boolean isValid = true;
			String language = null;
			String[] sentences;

			//take the specific language
			do {
				System.out.print("Select language (pt, en, es, any): ");
				language = new String(sc.next());
				System.out.println("type of language: " + language.getClass().getName());
				isValid = language.equalsIgnoreCase("pt") || language.equalsIgnoreCase("es") || language.equalsIgnoreCase("en") || language.equalsIgnoreCase("any");
				if (!isValid) System.out.print("Invalid language, please try again.\n");
			} while (!isValid);

			if (language.equalsIgnoreCase("pt")) {
				System.out.print("Por favor, insira o número de frases que você deseja analisar: ");
				sentences = new String[sc.nextInt()];
			} else if (language.equalsIgnoreCase("es")) {
				System.out.print("Por favor, introduzca el número de frases que desea analizar: ");
				sentences = new String[sc.nextInt()];
			} else {
				System.out.print("Please enter the number of sentences you want to analyse: ");
				sentences = new String[sc.nextInt()];
			}

			SentimentAnalyserAlgorithm algorithm = new SentimentAnalyserAlgorithm(language);

			//takes all the sentences
			sc.nextLine();
			for (int i = 0; i < sentences.length; i++) {
				System.out.print(i + " -> ");
				sentences[i] = sc.nextLine();
			}

			algorithm.algorithm(sentences);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
