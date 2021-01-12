package bonusfinal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonData {
	private Map<String, Set<String>> numbers;
	private Map<String, Set<String>> addresses;
	public PersonData() {
		this.numbers = new HashMap<String, Set<String>>();
		this.addresses = new HashMap<String, Set<String>>();
	}
	public void add(String name ,String number) {
		if(!this.numbers.containsKey(name)) {
			this.numbers.put(name, new HashSet<String>());
		}
		this.numbers.get(name).add(number);
	}
	public void addAddress(String name, String address) {
		if(!this.addresses.containsKey(name)) {
			this.addresses.put(name, new HashSet<String>());
		}
		this.addresses.get(name).add(address);
	}
	public void remove(String name) {
		if(!this.addresses.containsKey(name) && !this.numbers.containsKey(name)) {
			System.out.println("not found");
			return;
		}
		if(this.addresses.containsKey(name)) {
			this.addresses.remove(name);
		}
		if(this.numbers.containsKey(name)) {
			this.numbers.remove(name);
		}
	}
	
	public Map<String,Set<String>> getNumbers(){
		return this.numbers;
	}
	public Map<String,Set<String>> getAdresses(){
		return this.addresses;
	}
}
