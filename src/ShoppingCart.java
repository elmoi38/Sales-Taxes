
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

	static Map<String, Double> map = new HashMap<String, Double>();
	static String key;
	static String value;
	static List<Double> m = new ArrayList<Double>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner1 = new Scanner(System.in); // Create a Scanner object
		System.out.println("Type 'exit' to quit program");
		System.out.println("Enter product:");
		double temp = 0;

		while (scanner1.hasNext()) {

			key = scanner1.nextLine();// Read user input
			if (key.equals("exit")) {
				break;
			} else if (isDouble(key)) {

				while (isDouble(key)) {
					System.out.println("ERROR enter product name:");
					key = scanner1.nextLine();
				}
			}

			System.out.println("Enter Cost:");

			value = scanner1.nextLine();
			temp = returnDouble(value);
			if (!isDouble(value)) {
				while (!isDouble(value)) {
					System.out.println("ERROR enter product cost:");
					value = scanner1.nextLine();
				}
			}
			System.out.println("Enter product:");
			map.put(key, temp);

			m.add(temp);
		}

		for (String name : map.keySet()) {
			String key = name.toString();
			String value = map.get(name).toString();
			double tax = taxSales(returnDouble(value));

			System.out.println(key + " at $" + tax);
		}

		double sum = 0;
		double roundSum = 0;
		double sumTotal = 0;
		double round = 0;
		double total = 0;

		for (Double d : m) {

			double tax = ((d) * 10.0) / 100;
			sum += tax;
			sumTotal += d;
			roundSum = round(sum);
			round = round(sumTotal);
			total = round(round + roundSum);

		}
		System.out.println("Sales Taxes: $" + roundSum);
		System.out.println("Total: $" + total);

	}

	public static boolean isDouble(String s) {

		try {
			Double.valueOf(s); //check is string has a value of double
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static double returnDouble(String s) {
		double a;
		Double.valueOf(s);
		a = Double.parseDouble(s); // return value of double
		return a;

	}

	public static double taxSales(double total) {

		double tax = (total * 10.0) / 100;
		double totalAmount = tax + total;
		double totalRound = round(totalAmount);
		return totalRound;

	}

	public static double round(double total) {
		double round = (double) Math.round(total * 100.0) / 100.0;
		return round;
	}

}
