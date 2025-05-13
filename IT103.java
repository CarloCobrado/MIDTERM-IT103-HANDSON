import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IT103 {
    public static void calculateAverageGrade() {
		File file = new File("Grades.txt");
		float Sum = 0;
		int StudentCount = 0;

			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNext()) {
					if (scanner.hasNextInt()) {
						int Grades = scanner.nextInt();
						Sum += Grades;
						StudentCount++;
					}
					else {
                    	scanner.next();
                	}
				}
				double TotalAverage = Sum / StudentCount;
				System.out.printf("Average Grade: " + "%.2f\n", TotalAverage);
				scanner.close();
			}
			catch (FileNotFoundException e) {
				System.err.println("File not found.");
		}
	}

	public static void printStudentGrades() {
		File file = new File("Grades.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				if (scanner.hasNextLine()) {
					String Student = scanner.next();
						if (scanner.hasNextInt()) {
							int Grades = scanner.nextInt();
							System.out.printf ("%s: %d\n", Student, Grades);
						}
				}
				else {
					scanner.next();
				}
			}
			scanner.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("File not found.");
		}
	}
	public static void main(String[] args) {
		printStudentGrades();
		System.out.println();
		calculateAverageGrade();
	}
}