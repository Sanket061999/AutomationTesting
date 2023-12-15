package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterDemo {

	@Test
	public void countStringStartWithA() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Sanket");
		list.add("Anjuman");
		list.add("Shiwam");
		list.add("Aniket");
		list.add("Vishwas");

		Long value = list.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(value);
		System.out.println("------------Starts with S-------------");
		long d = Stream.of("Sanket", "Aniket", "Shiwam", "Anjuman").filter(s -> {
			s.startsWith("S");
			return true;

		}).count();
		System.out.println("Its an wrong ans as method is returning true every time " + d);
		System.out.println("---------------------------");

		list.stream().filter(l -> l.length() > 6).forEach(s -> System.out.println(s));
		System.out.println("--------------limiting the result to 1--------------");
		list.stream().filter(s -> s.length() > 6).limit(1).forEach(s -> System.out.println(s)); // limiting the result
																								// to 1
		System.out.println("--------------------------");

	}

	@Test
	public void streamMap() {
		System.out.println("------------All Upper Case----------------");

		Stream.of("Sanket", "Aniket", "Shiwam", "Anjuman").map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		System.out.println("--------------Ends with T Upper case-------------");

		Stream.of("Sanket", "Aniket", "Shiwam", "Anjuman").filter(s -> s.endsWith("t")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		
		System.out.println("-------------Ends with T and Sorted----------------");

		// sort above
		Stream.of("Sanket", "Aniket", "Shiwam", "Anjuman").filter(s -> s.endsWith("t")).sorted()
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	}

	@Test
	public void concatTwoStream() {
		List<String> listA = Arrays.asList("Sanket", "Aniket", "Shiwam", "Anjuman");
		List<String> listB = Arrays.asList("Rajesh", "Rupesh", "Suraj", "Nitesh");
		Stream<String> newStream=Stream.concat(listA.stream(), listB.stream());
		System.out.println("-----------Merging and Sorting two list----------------");
		newStream.sorted().forEach(s->System.out.println(s));
		System.out.println("----------------------------");
		
		System.out.println("----------is Sanket Present------------------");
		Stream<String> newStream1=Stream.concat(listA.stream(), listB.stream());
		boolean flag=newStream1.anyMatch(s->s.equalsIgnoreCase("Sanket"));
		Assert.assertTrue(flag);
		System.out.println(flag);
		
		

	}
	
	@Test
	public void streamCollect() {
		System.out.println("---------------Printing List after modification-------------");
		List<String> ls=Stream.of("Sanket", "Aniket", "Shiwam", "Anjuman").filter(s->s.endsWith("t")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls);
		
		
		System.out.println("-------------Find Distinct Number-------------");
		List<Integer> list = Arrays.asList(2,3,4,5,4,3,2,3,45,6,7,8,98,44);
		list.stream().distinct().forEach(s->System.out.println(s));
		System.out.println("------------Distinct Sorted-------------");
		list.stream().sorted().distinct().collect(Collectors.toList()).forEach(a->System.out.println(a));;
		System.out.println("------------Second Number of Distinct Sorted-------------");
		System.out.println(list.get(2));
	}
	
	
	
	
}
