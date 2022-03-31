package testing;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WordOccurrenceTest {

	@Test
	void test1() throws Exception {
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		
		WordOccurrence test = new WordOccurrence();
		Map output = test.wordO("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm", words);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("the", 57);
		map.put("and", 38);
		map.put("i", 32);
		
	
		assertEquals(map.values(), output.values());
		
		
	}

	@Test
	void test2() throws Exception {
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		
		WordOccurrence test = new WordOccurrence();
		Map output = test.wordO("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm", words);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("the", 57);
		map.put("and", 38);
		map.put("i", 32);
		
	
		assertEquals(map.keySet(), output.keySet());		
		
	}

}
