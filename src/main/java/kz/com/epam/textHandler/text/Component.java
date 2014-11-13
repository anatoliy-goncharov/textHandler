package kz.com.epam.textHandler.text;

abstract public class Component implements Comparable<Component> {
	
	abstract public String constructTextOfTheParts();
	
	@Override
	public int compareTo(Component obj) {
		return constructTextOfTheParts().compareTo(obj.constructTextOfTheParts());
	}
}
