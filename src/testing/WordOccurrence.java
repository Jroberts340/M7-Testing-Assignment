package testing;

import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordOccurrence {
	
	public Map wordO (String x, Map<String, Integer> words) throws Exception {
		URL website = new URL(x);
		Scanner scan = new Scanner(website.openStream());
		StringBuffer sb = new StringBuffer();
		
		while (scan.hasNext()) {
			sb.append(scan.next());
			sb.append(System.lineSeparator());
		}
		
		
		String res = sb.toString().replaceAll("<[^>]*>", " ").replaceAll("mdash", "\n").replaceAll("\\-", "\n");
		res = res.substring(res.indexOf("The", 1550)-1);
		res = res.substring(0,res.indexOf("!", 6500)+1);
		res = res.replaceAll("\\p{Punct}", "");
		res = res.replaceAll("\\W", "\n");
		res = res.replaceAll("\\s+","\n");
		res = res.trim();
		
		Scanner wc = new Scanner(res);
		
		while (wc.hasNext())
		{
			String word = wc.nextLine();
			word = word.toLowerCase(); 
			// Frequency count variable
			Integer count = words.get(word);

			// If the same word is repeating
			if (count != null) 
			{
				count++;
			}
			else
				// If word never occurred after occurring once, set count as unity
				count = 1;
			words.put(word, count);
		}
		Map<String, Integer> nwo = words.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new));
		wc.close();
		scan.close();
		return nwo;
	}
}
