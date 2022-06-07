import java.util.InputMismatchException;
import java.util.Scanner;

public class FinalProjectSwer141 {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			String name[] = new String[100];
			String city[] = new String[100];
			String ID[] = new String[100];
			String salary[] = new String[100];
			int count = 0;
			boolean running = true;

			while (running) {
				String add = "";
				System.out.println("\n\n1.Add new citizens\n2.Modify a existing citizen\n3.Search for citizen"
						+ "\n4.Compute income tax\n5.Display reports\n6.Exit the program" + "\n\nChoose a number :");
				boolean digit = true;

				do {
					if (!digit) {
						System.out.println("Wrong input, please enter a number: ");
					}
					add = input.next();

					digit = Character.isDigit(add.charAt(0));

				} while (!digit);
				int choice = Integer.parseInt(add);

				if (choice == 1) {
					System.out.println("How many citizens you want to Add?");
					String numOfCitizens = "";
					do {
						if (!digit) {
							System.out.println("Wrong input, please enter a number: ");
						}
						numOfCitizens = input.next();

						digit = Character.isDigit(numOfCitizens.charAt(0));

					} while (!digit);
					int num = Integer.parseInt(numOfCitizens);

					for (int i = 0; i < num; i++) {

						System.out.println("\nName " + (i + 1) + ":");
						name[count] = input.next();
						System.out.println("City " + (i + 1) + ":");
						city[count] = input.next();
						System.out.println("ID " + (i + 1) + ":");
						ID[count] = input.next();
						if (count > 0) {
							for (int j = 0; j < 5; j++) {
								if (ID[count] == ID[count - 1]) {
									System.out.println("This Id is already exists. Enter another ID please:");
									ID[count] = input.next();

								}
							}
						}
						System.out.println("Salary " + (i + 1) + ":");
						salary[count] = input.next();

						count++;
					}
					System.out.println("These are the intered citizens :");
					System.out.printf("\n%-5s%-10s %-10s %-10s %-10s\n\n", "Num", "Name", "City", "ID", "Salary");
					for (int j = 0; j < count; j++) {
						System.out.printf("%-5s%-10s %-10s %-10s %-10s\n", j + 1 + ".", name[j], city[j], ID[j], salary[j]);
					}
				}

				else if (choice == 2) {
					System.out.println("These are the intered citizens you are about to modify :");
					System.out.printf("\n%-5s%-10s %-10s %-10s %-10s\n", "Num", "Name", "City", "ID", "Salary");
					for (int j = 0; j < count; j++) {
						System.out.printf("%-5s%-10s %-10s %-10s %-10s\n", j + 1 + ".", name[j], city[j], ID[j], salary[j]);
					}
					System.out.println("\nHow many citizens do want to modify?");
					int modify = input.nextInt();
					int counter = 0;
					for (int y = 0; y < modify; y++) {
						System.out.println("\nEnter ID " + (y + 1) + ":");
						int id = input.nextInt();

						for (int i = 0; i < count; i++) {

							if (id == Integer.parseInt(ID[i])) {
								System.out.println("ID found! It is:");
								System.out.printf("%-8s %-6s %4s %8s", "Name", "City", "ID", "Salary");
								System.out.printf("\n\n%-8s %-6s %4s %8s", name[i], city[i], ID[i], salary[i]);
								System.out.println("\n\n\nEnter the new city for " + name[i]);
								city[i] = input.next();
								System.out.println("\nEnter the new salary:");
								salary[i] = input.next();
								System.out.println("\nThe New record for this citizen is : ");
								System.out.printf("\n%-5s%-10s %-10s %-10s ", "Name", "City", "ID", "Salary");
								System.out.printf("\n%-5s%-10s %-10s %-10s    ", name[i], city[i], ID[i], salary[i]);
								counter++;
							}

						}
					}
					if (counter == 0) {
						System.out.println("citizen is not found!");
					}

				}

				else if (choice == 3) {
					System.out.println("input the citizin's name please");

					String citizinName = input.next();

					int counter = 0;
					for (int i = 0; i < count; i++) {
						if (citizinName.equalsIgnoreCase(name[i])) {
							System.out.println("\ncitizin found! he/she is  :");
							System.out.printf("\n %-8s %-6s %4s %8s", "name", "city", "ID", "Salary");
							System.out.printf("\n %-8s %-6s %4s %8s", name[i], city[i], ID[i], salary[i]);
							counter++;
						}
					}
					if (counter == 0) {
						System.out.println("citizen is not found!");
					}

				}

				else if (choice == 4) {

					System.out.println("Please enter the tax percentage:");

					try {

						double taxPercentage = input.nextDouble();
						String[] newSalaries = new String[100];

						for (int i = 0; i < count; ++i) {

							double salaryAfterTax = Double.parseDouble(salary[i]) * taxPercentage;

							newSalaries[i] = Double.toString(salaryAfterTax);
						}

						for (int i = 0; i < count; i++) {

							System.out.println("Citizen's Salaries after tax's:");
							System.out.printf("\n %-8s %8s", name[i], newSalaries[i]);
						}
					} catch (InputMismatchException e) {

						System.out.println("Please enter a double value percentage");
					}

				} else if (choice == 5) {
					
					System.out.println("\nChoose one of these options please:\na. All citizens who live in the same city "
							+ "\nb. All the citizins sorted according to there salary descending"
							+ "\nc.Total number of citizens and there average slaray.  ");
					char in = input.next().charAt(0);
					int counter = 0;
					if (in == 'a' || in == 'A') {
						System.out.println("Enter the city:");
						String inputCity = input.next();

						for (int i = 0; i < count; i++) {

							if (inputCity.equalsIgnoreCase(city[i])) {
								counter++;
							}
						}

						if (counter == 0) {
							System.out.println("there are no citizens are living in this city");

						}

					}

					else if (in == 'b' || in == 'B') {
						for (int i = 0; i < count - 1; i++) {
							int min_idx = i;
							for (int j = i + 1; j < count; j++)
								if (Double.parseDouble(salary[j]) < Double.parseDouble(salary[min_idx]))
									min_idx = j;

							String temp = ID[min_idx];
							ID[min_idx] = ID[i];
							ID[i] = temp;

							temp = name[min_idx];
							name[min_idx] = name[i];
							name[i] = temp;

							temp = city[min_idx];
							city[min_idx] = city[i];
							city[i] = temp;

							temp = salary[min_idx];
							salary[min_idx] = salary[i];
							salary[i] = temp;
						}

						for (int i = 0; i < count / 2; i++) {
							int i2 = count - i;
							String temp = ID[i2];
							ID[i2] = ID[i];
							ID[i] = temp;

							temp = name[i2];
							name[i2] = name[i];
							name[i] = temp;

							temp = city[i2];
							city[i2] = city[i];
							city[i] = temp;

							temp = salary[i2];
							salary[i2] = salary[i];
							salary[i] = temp;
						}
					} else if (in == 'c' || in == 'C') {
						System.out.println("The total number of citizins is " + count);
						double sumOfSalary = 0;
						for (int i = 0; i < count; i++) {
							double salaryInt = Double.parseDouble(salary[i]);
							sumOfSalary = sumOfSalary + salaryInt;
						}
						double average = sumOfSalary / count;
						System.out.println("and the average of their salary is " + average);

					}

				}

				else if (choice == 6) {
					System.out.println("Thank you!");
					System.exit(0);

				} else if (choice < 1 || choice > 6) {
					System.out.println("Enter a vaild number!");

				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
