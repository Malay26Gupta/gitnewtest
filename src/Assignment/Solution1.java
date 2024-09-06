package Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// class representing item details and methods to calculate cost
class Item{
	private String name;
	private double price;
	private int quantity;
	private String type;
	
	//constructor to initialize item details
	public Item(String name, double price, int quantity, String type)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}
	
	//getters fro item properties
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getType()
	{
		return type;
	}
	
	
	//method to calculate total cost after tax
	public double TotalCost()
	{
		double totalCost = price*quantity;
		double tax = calculateTax();	
		return totalCost + tax;
	}
	
	//method to calculate sales tax based on item type
	public double calculateTax()
	{
		double totalCost = price*quantity;
		double tax =0.0;
		
		switch(type.toLowerCase())
		{
			case "raw":
				tax = 0.155 * totalCost;
				break;
			case "manufactured":
				tax = 0.205 * totalCost;
				break;
			default:
				throw new IllegalArgumentException("Invalid item type. Vlaid types are 'Raw' or 'Manufactured'. ");
		}
		
		return tax;
	}
	
	//overriding toString method to provide formatted string of item details
	@Override
	public String toString()
	{
		double totalCost = TotalCost();
		double tax = calculateTax();
		return String.format("Item Name: %s, Item price: %.2f, Quantity: %d, Sales Tax: %.2f, Final Price: %.2f",
				name, price, quantity, tax, totalCost);
	}
}


//main class to handle user input and calculate cost
public class Solution1 {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		List<Item> items = new ArrayList<>();
		
		boolean addMoreItems = true;
		
		//loop to handle input of multiple items
		while(addMoreItems)
		{
			try
			{
				Item item = getItemDetails(sc);
				items.add(item);
				addMoreItems = askToAddMoreItems(sc);
			}
			
			catch(NumberFormatException e)
			{
				System .out.println("Invalid number froamt. Please try again");
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		sc.close();
		printItemsDetails(items);
	}
	
	//method to get item details from user
	private static Item getItemDetails(Scanner sc)
	{
		System.out.println("Enter item details: ");
		
		System.out.print("Item name: ");
		String name = sc.nextLine();
		
		System.out.print("Item price: ");
		double price = Double.parseDouble(sc.nextLine());
		
		System.out.print("Item quantity: ");
		int quantity = Integer.parseInt(sc.nextLine());
		
		System.out.print("Item type (Raw/Manufactured: ");
		String type = sc.nextLine();
		
		return new Item(name, price, quantity, type);
	}
	
	//method to ask user if they want to add more items
	private static boolean askToAddMoreItems(Scanner sc)
	{
		System.out.print("Do you want to enter details of any other item (yes/no): ");
		String response = sc.nextLine().trim();
		return response.equalsIgnoreCase("yes");
	}
	
	//method to print detail of all items
	private static void printItemsDetails(List<Item> items)
	{
		System.out.println("Items details: ");
		for(Item item : items)
		{
			System.out.println(item);
		}
	}
}
