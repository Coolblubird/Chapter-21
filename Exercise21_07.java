import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();
		
		ArrayList<WordOccurrence> array = new ArrayList<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
					array.add(new WordOccurrence(key,1));
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
					
					for (int b = 0; b < array.size(); b++){
						if (array.get(b).word.equals(key)){
							array.get(b).count = value;
						}
					}
				}
			}
		}					
			
		Collections.sort(array);
		
		// Display key and value for each entry
		for (int i=0; i<array.size(); i++){
			System.out.println(array.get(i).toString());
		}
	}
}

class WordOccurrence implements Comparable<WordOccurrence>{
	String word;
	public int count=0;
	
	WordOccurrence(String w, int c){
		word = w;
		count = c;
	}
	
	@Override
	public int compareTo(WordOccurrence b){
		if (b.count < this.count){
			return -1;
		}
		else if (b.count > this.count){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	@Override
	public String toString(){
		return word + "\t" + count;
	}
}