package com.project.donation;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationApplication.class, args);
		
		DonationApplication t = new DonationApplication();

	        Map<String, List<String>> inputMap = new LinkedHashMap<String, List<String>>();
	        inputMap.put("A", Arrays.asList("1.0", "2.0", "3.0"));
	        inputMap.put("B", Arrays.asList("2.0", "3.0", "4.0"));
	        inputMap.put("C", Arrays.asList("3.0", "4.0", "5.0"));
	        
	        System.out.println("Result A: " + t.computeA(inputMap));
	        System.out.println("Result B: " + t.computeB(inputMap));
	}
	
			private <E> Map<E, Double> computeA(Map<E, ? extends Collection<String>> inputMap)
		    {
		        Map<E, Double> finalResult = new HashMap<>();
		        for (Entry<E, ? extends Collection<String>> entry : inputMap.entrySet())
		        {
		            double score = computeScore(entry.getValue());
		            finalResult.put(entry.getKey(), score);
		        }
		        return finalResult;
		    }

		    private <T> Map<T, Double> computeB(Map<T, ? extends Collection<String>> inputMap)
		    {
		        return inputMap.entrySet().stream().collect(
		            Collectors.toMap(Entry::getKey, e -> computeScore(e.getValue()))); 
		    }

		    private double computeScore(Collection<String> strings) 
		    {
		        return strings.stream().mapToDouble(this::computeScore).sum();
		    }

		    private double computeScore(String a)
		    {
		        return Double.parseDouble(a);
		    }

}
