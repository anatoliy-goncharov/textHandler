package kz.com.epam.textHandler.Runner;

import kz.com.epam.textHandler.parser.*;
import kz.com.epam.textHandler.text.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TextHandler {
	
	private static final Logger log = LogManager.getLogger(TextHandler.class);
	
	public static List<Sentence> getSentencesFromText(Text text) {
		
		List<Sentence> list = new LinkedList<Sentence>();
		
		for (Component p : text.getParts()) {
			if (p.getClass() == Paragraph.class) {
				
				for (Component sent : ((Paragraph)p).getParts()) {
					if (sent.getClass() == Sentence.class) {
						list.add((Sentence)sent);
						
					}
				}
			}
		}
		return list;
	}
	
	public static List<Word> getWordsFromSentence(Sentence sentence) {
		
		List<Word> list = new LinkedList<Word>();
		
		for (Component word : sentence.getParts()) {
			if (word.getClass() == Word.class) {
				list.add((Word)word);
			}
		}
		return list;
	}
	
	public static List<Word> getWordsFromText(Text text) {
		
		List<Word> list = new LinkedList<Word>();
		
		for (Sentence sent : getSentencesFromText(text)) {
			list.addAll(getWordsFromSentence(sent));
		}
		return list;
	}
	
	public static String writeFileIntoString(String filename) {
		
		File file = new File(filename);
		String str = null;
		
		try {
			if (file.length() != 0) {
				char[] charBuf = new char[(int) file.length()];
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
				final int read = isr.read(charBuf);
				str = new String(charBuf, 0, read);
				isr.close();
			}
		} catch (FileNotFoundException e) {
			log.error("can not find file", e);
		} catch (IOException e) {
			log.error("can not read file", e);
		}
		
		return str;
	}
	
	public static Text getTextFromString(String str) {
		
		String par = "(\\n[A-Z][^\\n]+)|[\\d][.][^\\n]+";
		String sent = "[A-Z][^.!?\\n]+[.!?\\n]";
		String word = "(\\b[^\\W\\s]+[']*\\b)+";
		String letter = "[^\\W\\s]";
		
		Parser parser = new TextParser(new ParagraphParser(new SentenceParser(new WordParser(null, letter), word), sent), par);
		Text text = parser.parse(str);
		log.info("start parsing");
		return text;
	}
}
