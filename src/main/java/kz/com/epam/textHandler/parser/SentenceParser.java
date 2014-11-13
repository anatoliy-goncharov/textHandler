package kz.com.epam.textHandler.parser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import kz.com.epam.textHandler.text.Sentence;

public class SentenceParser extends Parser {
	
	public SentenceParser(Parser p, String r) {
		super(p, r);
	}
	
	@Override
	public Sentence defineComponent(String text) {
		Sentence sent = new Sentence();
		
		Sentence.SentenceType type = Sentence.SentenceType.DECLERATIVE;
		
		
		if (Pattern.matches("\\?$", text)) {
			type = Sentence.SentenceType.INTERROGATIVE;
		} else
		if (Pattern.matches("!$", text)) {
			type = Sentence.SentenceType.EXCLAMATORY;
		}
		
		sent.setSentenceType(type);
		
		return sent;
	}
}
