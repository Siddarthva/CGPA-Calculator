import java.util.Scanner;

class Sem {
    int n, SGPA;
    Sub[] subject;
    int numerator = 0;
    int denominator = 0;

    // Method to get the number of subjects in a semester
    public void getNumofSub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects in this semester: ");
        n = sc.nextInt();
        subject = new Sub[n];
    }

    // Method to get information about each subject
    public void getSubjectInfo() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            subject[i] = new Sub();
            System.out.println("\nEnter details for subject " + (i + 1) + ":");
            subject[i].getsubinfo();
        }
    }

    // Method to calculate SGPA for the semester
    public void CalcSGPA() {
        for (int i = 0; i < n; i++) {
            numerator += (subject[i].credit * subject[i].grade);
            denominator += (subject[i].credit * 10);  // assuming 10 is the total credits for each subject
        }
        SGPA = (denominator != 0) ? numerator / denominator : 0;
    }

    // Method to display the subject details and SGPA
    public void display() {
        for (int i = 0; i < n; i++) {
            subject[i].displaysubinfo();
        }
        System.out.println("SGPA for this semester: " + SGPA);
    }
}

class Sub {
    int credit, grade;
    String subname;

    // Method to get information about the subject
    public void getsubinfo() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();  // Clear the buffer
        System.out.print("Enter the name of the Subject: ");
        subname = sc.nextLine();
        System.out.print("Enter the Credits for " + subname + ": ");
        credit = sc.nextInt();
        System.out.print("Enter the Grade point for " + subname + ": ");
        grade = sc.nextInt();
    }

    // Method to display the subject details
    public void displaysubinfo() {
        System.out.println("\nSubject Name: " + subname);
        System.out.println("Credits: " + credit);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, USN, Degree;
        int numofsem;

        System.out.println("****** Welcome to CGPA Calculator ******\n");

        // User Input
        System.out.print("Enter your Name: ");
        name = sc.nextLine();

        System.out.print("Enter your USN: ");
        USN = sc.nextLine();

        System.out.print("Enter your Degree Program: ");
        Degree = sc.nextLine();

        System.out.print("Enter the number of semesters: ");
        numofsem = sc.nextInt();

        // Create an array to store Semester objects
        Sem[] Semester = new Sem[numofsem];

        // Loop through each semester and gather details
        for (int i = 0; i < numofsem; i++) {
            System.out.println("\nEnter the details for Semester " + (i + 1) + ":");
            Semester[i] = new Sem();
            Semester[i].getNumofSub();
            Semester[i].getSubjectInfo();
            Semester[i].CalcSGPA();
        }

        // Calculate CGPA
        int CGPA = 0;
        for (int i = 0; i < numofsem; i++) {
            CGPA += Semester[i].SGPA;
        }

        CGPA = (numofsem > 0) ? CGPA / numofsem : 0;

        // Display the performance report
        System.out.println("\n***** Performance Report *****");
        System.out.println("Student: " + name);
        System.out.println("Degree: " + Degree);
        System.out.println("USN: " + USN);
        System.out.println("\nDetails for each semester:\n");

        for (int i = 0; i < numofsem; i++) {
            System.out.println("Semester " + (i + 1) + " Report:");
            Semester[i].display();
            System.out.println("------------------------------------");
        }

        // Display CGPA
        System.out.println("\nTotal CGPA: " + CGPA);
        System.out.println("*************************************");
    }
}
