package kz.com.epam.textHandler.parser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import kz.com.epam.textHandler.text.Paragraph;

public class ParagraphParser extends Parser {
	
	public ParagraphParser(Parser p, String r) {
		super(p, r);
	}
	
	@Override
	public Paragraph defineComponent(String text) {
		Paragraph par = new Paragraph();
		
		boolean head;
		
		head = Pattern.matches("\\b([\\d][.])+[^\\n]+", text);
		
		par.setHead(head);
		
		return par;
	}
}
