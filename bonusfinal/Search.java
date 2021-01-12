package bonusfinal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Search {
	public Set<String> searchByName(Map<String, Set<String>> numbers, String name) {
		if(numbers.containsKey(name)) {
			return numbers.get(name);
		}else {
			return null;
		}
	}
	public String searchByNumber(Map<String, Set<String>> numbers, String number){
		for(String name : numbers.keySet()) {
			HashSet<String> nums = (HashSet<String>) numbers.get(name);
			if(nums.contains(number)) {
				return name;
			}
		}
		return null;
	}
	public void getInfo(Map<String, Set<String>> numbers,Map<String, Set<String>> addresses,String name) {
		if(!addresses.containsKey(name) && !numbers.containsKey(name)) {
			System.out.println("not found");
			return;
		}
		if(addresses.containsKey(name)) {
			HashSet<String> addr = (HashSet<String>) addresses.get(name);
			System.out.print("address: ");
			if(addr.size() > 1) {
				for(String address : addr) {
					System.out.print(address + " ");
				}
				System.out.println();
			}else {
				for(String address : addr) {
					System.out.print(address);
				}
				System.out.println();
			}
		}else {
			System.out.println("address unknown");
		}
		if(numbers.containsKey(name)) {
			HashSet<String> nums = (HashSet<String>) numbers.get(name);
			System.out.println("phone numbers:");
			for(String number : nums) {
				System.out.println(number);
			}
		}else {
			System.out.println("phone number not found");
		}
	}
	public void SearchKeyword(Map<String, Set<String>> numbers,Map<String, Set<String>> addresses,String word) {
		boolean notIn = true;
		if(word.isEmpty()) {
			notIn = false;
			for(String person: addresses.keySet()) {
				System.out.println(person);
				getInfo(numbers,addresses,person);
				System.out.println();
			}
			return;
		}
		for(String person : addresses.keySet()) {
			HashSet<String> list = (HashSet<String>) addresses.get(person);
			if(person.contains(word)) {
				notIn = false;
				System.out.println(person);
				getInfo(numbers,addresses,person);
				System.out.println();
				continue;
			}
			for(String temp : list) {
				if(temp.contains(word)) {
					notIn = false;
					System.out.println(person);
					getInfo(numbers,addresses,person);
					System.out.println();
				}
			}
		}
		if(notIn) {
			System.out.println("keyword not found");
		}
	}
}
