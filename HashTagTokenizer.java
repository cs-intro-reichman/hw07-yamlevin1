

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = "zonewirelovea";
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		
		//String fileName= "dictionary.txt";
		//String word = "zug";
		//System.out.println(existInDictionary(word, readDictionary(fileName)));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i = 0; i < dictionary.length; i++){
			dictionary[i]= in.readLine();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean isTheWordExist = false;
		for(int i = 0; i < dictionary.length; i++){
			if (dictionary[i].equals(word)) {
				isTheWordExist = true;
				break;
			}
		}
		return isTheWordExist;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		String lowerCaseHashTag = hashtag.toLowerCase();

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        for (int i = 1; i <= hashtag.length(); i++) {
			if (existInDictionary(lowerCaseHashTag.substring(0, i), dictionary)){
				System.out.println(lowerCaseHashTag.substring(0, i));
				breakHashTag(lowerCaseHashTag.substring(i), dictionary);
				return;
			}
        }
    }
}
