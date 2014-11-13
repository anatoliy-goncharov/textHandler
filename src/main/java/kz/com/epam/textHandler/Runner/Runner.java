package kz.com.epam.textHandler.Runner;

import kz.com.epam.textHandler.comparator.SentenceComparator;
import kz.com.epam.textHandler.comparator.WordComparator;
import kz.com.epam.textHandler.comparator.WordComparatorByLetter;
import kz.com.epam.textHandler.text.Sentence;
import kz.com.epam.textHandler.text.Text;
import kz.com.epam.textHandler.text.Word;

import java.util.Collections;
import java.util.List;

public class Runner {
	public static void main(String[] args) {
		
		String str = TextHandler.writeFileIntoString("task2text.txt");
		
		Text text = TextHandler.getTextFromString(str);
		
		System.out.println("---------------");
		
		// 2. Вывести все предложения заданного текста в порядке возрастания
		// количества слов в каждом из них.
		List<Sentence> sList = TextHandler.getSentencesFromText(text);
		Collections.sort(sList, new SentenceComparator());
		
		for (Sentence s : sList) {
			System.out.println(s.constructTextOfTheParts());
		}
		System.out.println("---------------");
		
		// 6. Напечатать слова текста в алфавитном порядке по первой букве.
		// Слова, начинающиеся с новой буквы, печатать с красной строки.
		List<Word> wList = TextHandler.getWordsFromText(text);
		Collections.sort(wList, new WordComparator());
		
		Character c = 'a';
		for (Word w : wList) {
			if (w.isDigit()) continue;
			Character first = Character.toLowerCase(w.constructTextOfTheParts().charAt(0));
			if (c != first) {
				System.out.println();
				c = first;
			}
			System.out.print(w.constructTextOfTheParts() + " ");
		}
		System.out.println("\n---------------");
		
		// 9. Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
		// Слова с одинаковым количеством букв расположить в алфавитном порядке.
		Collections.sort(wList, new WordComparatorByLetter('s'));
		
		for (Word w : wList) {
			if (w.isDigit()) continue;
			System.out.println(w.constructTextOfTheParts());
		}
		System.out.println("---------------");
		
		System.out.println(text.constructTextOfTheParts());
		System.out.println("---------------");
	}
}
