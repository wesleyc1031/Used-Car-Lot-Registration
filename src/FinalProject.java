import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FinalProject {
	public static int NUMBER_OF_CARS = 5;
	public static int NUMBER_OF_PROFITS = 5;
	public static int NUMBER_OF_COSTS = 5;
	
	static Scanner key = new Scanner(System.in);
	
	public static void main(String args[]) throws IOException{

		String car1 = "\nHonda Civic\nPurcase price: $7,000\nSale Price: $12,000\nMonthly Ownership Costs: $225\nProfit Goal: $5,000";
		String car2 = "\n\nFord Fusion\nPurcase price: $8,000\nSale Price: $14,000\nMonthly Ownership Costs: $215\nProfit Goal: $6,000";
		String car3 = "\n\nToyota Corolla\nPurcase price: $7,500\nSale Price: $13,000\nMonthly Ownership Costs: $205\nProfit Goal: $5,500";
		String car4 = "\n\nMercedes C-Class\nPurcase price: $13,000\nSale Price: $22,000\nMonthly Ownership Costs: $230\nProfit Goal: $9,000";
		String car5 = "\n\nBMW 3-Series\nPurcase price: $14,000\nSale Price: $24,000\nMonthly Ownership Costs: $235\nProfit Goal: $10,000\n";
			
		Stack Cars = new Stack();
		
		Cars.push(car1);
		Cars.push(car2);
		Cars.push(car3);
		Cars.push(car4);
		Cars.push(car5);
		
		System.out.println("To see the full inventory of NYIT Motors, type 'I'");
		
		String input = key.nextLine();
		
		if(input.equalsIgnoreCase("I")){
			
			System.out.println(Cars);
		
		}else{
			System.out.println("Invalid Entry");
		}
		
		LinkedList Callbacks = new LinkedList();
		loop:
			System.out.println("If a customer called back, type 'Call'");
			String input2 = key.nextLine();
			
			if(input2.equalsIgnoreCase("call")){
				System.out.println("Please enter their name, number, and car they're interested in\n i.e. 'John Smith, (718)-123-4567, Honda Civic'");
				String input3 = new String();
				input3 = key.nextLine();
				Callbacks.add(input3);
			}
			
		System.out.println(Callbacks);
		
		ArrayList<Car> list = new ArrayList<Car>();
		
		list.add(new Car("Honda","Civic","1HGBH41JXMN109186",2014));
		list.add(new Car("Ford","Fusion","3RCAX20ABCD554321",2014));
		list.add(new Car("Toyota","Corolla","2DEFA83GOTS903844",2014));
		list.add(new Car("Mercedes","C Class","8PPBF92XAVR667192",2014));
		list.add(new Car("BMW","3 Series","5HLKM30JBCD742859",2014));

		
		System.out.println("\nEnter a car name from the list below: ");
		System.out.println("Honda Civic, Ford Fusion, Toyota Corolla, Mercedes C Class, BMW 3 Series:");
		String carName = key.nextLine();
		
		
		for(Car car: list){	
			
			if(carName.equalsIgnoreCase(car.getName()+" "+car.getModel())){
				System.out.println("");
				System.out.println(car.toString());
			}
		}
		
		String input4 = new String();
		System.out.println("\nTo see a list of previous calls from customers, type 'Numbers'");		
		input4 = key.nextLine();
		
		if(input4.equalsIgnoreCase("numbers")){
			
			Queue<CustomerQueue> customerQueues = new LinkedList();
			customerQueues.add(new CustomerQueue("Sandy", "Honda Civic", "631-374-8978"));
			customerQueues.add(new CustomerQueue("Peter", "Ford Fusion", "516-818-4010"));
			customerQueues.add(new CustomerQueue("Daniel", "Toyota Corolla", "631-472-2419"));
			customerQueues.add(new CustomerQueue("Kumar", "BMW 3 Series", "516-788-2478"));
			customerQueues.add(new CustomerQueue("Harold", "Mercedes C Class", "631-776-2777"));

			while (!customerQueues.isEmpty()) {
				System.out.println(" ");
				System.out.println(customerQueues.peek());
				customerQueues.remove();
			}
		}else{
			System.out.println("Invalid Entry");
		}
		
		
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		

		String[] cars = new String [NUMBER_OF_CARS];
		double[] profits = new double [NUMBER_OF_PROFITS];
		double [] costs = new double [NUMBER_OF_COSTS];
		
		System.out.println("To sort the list of profit/cost margins from least to greatest,\nbegin by typing the car's Name, Profit margin, and Cost margin.\n");
		
		for (int i = 0; i < NUMBER_OF_CARS; i++){
			System.out.print("Enter the brand of the car: " + "\n");
			cars[i] = keyboard.readLine();
			System.out.print("Enter the car's profit margin: " + "\n");
			profits[i] = Double.parseDouble(keyboard.readLine());
			System.out.print("Enter the car's cost margin: " + "\n");
			costs[i] = Double.parseDouble(keyboard.readLine());
		}
		
		for (int i = 0; i < NUMBER_OF_PROFITS; i++){
			
			for (int j = 1; j < NUMBER_OF_PROFITS; j++){
				
				if (profits[j] < profits[j - 1]){
					String temp = cars[j];
					cars[j] = cars[j - 1];
					cars[j - 1] = temp;
					double tempDouble = profits[j];
					profits[j] = profits[j - 1];
					profits[j - 1] = tempDouble;
				}
			}
		}
		
		for (int i = 0; i < NUMBER_OF_COSTS; i++){
			
			for (int j = 1; j < NUMBER_OF_COSTS; j++){
				
				if (costs[j] < costs[j - 1]){
					String temp = cars[j];
					cars[j] = cars[j - 1];
					cars[j - 1] = temp;
					double tempDouble = costs[j];
					costs[j] = costs[j - 1];
					costs[j - 1] = tempDouble;
				}
			}
		}
			System.out.println("\nCars sorted based on the profit margins (lowest to highest): ");
				for (int i = 0; i < cars.length; i++){
					System.out.println("Profit: " + cars[i] + " $" + profits[i] + " ");
				}

				System.out.println("\nCars sorted based on the cost margins (lowest to highest): ");
				
				for (int i = 0; i < cars.length; i++){
					System.out.println("Cost: " + cars[i] + " $" + costs[i] + " ");
				}
				
	}
}


class CustomerQueue {
	
	private String name;
	private String carName;
	private String phoneNum;
	
	public CustomerQueue(String n, String c, String p) {
		this.name = n;
		this.carName = c;
		this.phoneNum = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String toString() {
		return name + "\n" + "Car Name: " + carName + "\n" + "Phone Number: " + phoneNum + "\n";
	}
	
}


class Car{
	
	private String name;
	private String model;
	private String vin;
	private int year;
	
	
	public Car(String name, String model, String vin, int year) {
		
		this.name = name;
		this.model = model;
		this.vin = vin;
		this.year = year;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {

		return year+" "+name+" "+model+", Vin#: "+vin;
	
	}
}	



