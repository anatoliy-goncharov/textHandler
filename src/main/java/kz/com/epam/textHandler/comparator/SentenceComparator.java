package kz.com.epam.textHandler.comparator;

import kz.com.epam.textHandler.Runner.TextHandler;
import kz.com.epam.textHandler.text.Sentence;
import kz.com.epam.textHandler.text.Word;

import java.util.Comparator;
import java.util.List;

public class SentenceComparator implements Comparator<Sentence> {
		
	public int compare(Sentence s1, Sentence s2) {
		List<Word> words1 = TextHandler.getWordsFromSentence(s1);
		List<Word> words2 = TextHandler.getWordsFromSentence(s2);
		return Integer.compare(words1.size(), words2.size());
	}
}
