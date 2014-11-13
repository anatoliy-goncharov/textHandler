package kz.com.epam.textHandler.parser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import kz.com.epam.textHandler.text.Text;

public class TextParser extends Parser {
	
	public TextParser(Parser p, String r) {
		super(p, r);
	}
	
	@Override
	public Text defineComponent(String text) {
		return new Text();
	}
}
