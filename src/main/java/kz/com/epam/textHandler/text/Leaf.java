package kz.com.epam.textHandler.text;

abstract public class Leaf extends Component {
	
	String text;
	
	public Leaf(String text) {
		if (text == null) {
			text = "";
			throw new IllegalArgumentException();
		}
		this.text = text;
	}
	
	public String constructTextOfTheParts() {
		return text;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		if (! super.equals(obj)) {
			return false;
		}
		
		Leaf leaf = (Leaf) obj;
		
		if (!text.equals(leaf.constructTextOfTheParts())) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = super.hashCode();
        result = prime * result + text.hashCode();
        return result;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append(getClass().getName())
			.append(", text: ").append(text);
		
		return str.toString();
	}
}
