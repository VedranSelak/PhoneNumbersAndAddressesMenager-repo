package bonusfinal;

import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
	public void print() {
		System.out.println("available operations");
		System.out.println(" 1 add a number");
		System.out.println(" 2 search for a number");
		System.out.println(" 3 search for a person by phone number");
		System.out.println(" 4 add an address");
		System.out.println(" 5 search for personal information");
		System.out.println(" 6 delete personal information");
		System.out.println(" 7 filtered listing");
		System.out.println(" x quit");
	}
	public void start() {
		Scanner reader = new Scanner(System.in);
		PersonData data = new PersonData();
		Search sr = new Search();
		print();
		while(true) {
			System.out.println();
			System.out.print("command: ");
			String cmd = reader.nextLine();
			if(cmd.equals("1")) {
				System.out.print("whose number: ");
				String person = reader.nextLine();
				System.out.print("number: ");
				String phoneNumber = reader.nextLine();
				data.add(person, phoneNumber);
			}else if(cmd.equals("2")) {
				System.out.print("whose number: ");
				String person = reader.nextLine();
				HashSet<String> numbers = (HashSet<String>) sr.searchByName(data.getNumbers(), person);
				if(numbers == null) {
					System.out.println("not found");
				}else {
					for(String num : numbers) {
						System.out.println(num);
					}
				}
			}else if(cmd.equals("3")) {
				System.out.print("number: ");
				String phoneNumber = reader.nextLine();
				if(sr.searchByNumber(data.getNumbers(), phoneNumber) == null) {
					System.out.println("not found");
				}else {
					System.out.println(sr.searchByNumber(data.getNumbers(), phoneNumber));
				}
			}else if(cmd.equals("4")) {
				System.out.print("whose address: ");
				String person = reader.nextLine();
				System.out.print("street: ");
				String streetName = reader.nextLine();
				System.out.print("city: ");
				String cityName = reader.nextLine();
				data.addAddress(person, streetName + " " + cityName);
			}else if(cmd.equals("5")) {
				System.out.print("whose information: ");
				String person = reader.nextLine();
				sr.getInfo(data.getNumbers(), data.getAdresses(), person);
			}else if(cmd.equals("6")) {
				System.out.print("whose information: ");
				String person = reader.nextLine();
				data.remove(person);
			}else if(cmd.equals("7")) {
				System.out.print("keyword (if empty, all listed): ");
				String keyword = reader.nextLine();
				System.out.println();
				sr.SearchKeyword(data.getNumbers(), data.getAdresses(), keyword);
			}else if(cmd.equals("x")) {
				break;
			}else {
				System.out.println("Command not recognized");
			}
		}
	}
}
