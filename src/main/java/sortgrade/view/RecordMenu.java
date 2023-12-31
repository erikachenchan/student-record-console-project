package sortgrade.view;


import sortgrade.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordMenu {

    int userId;
    String userNameInput;
    double englishGradeInput;
    double mathGradeInput;
    double scienceGradeInput;

    // instantiate with an empty arrayList
    private final ArrayList<Student> studentDtoArrayList = new ArrayList<>();
    private Student student;
    private final Scanner scanner;

    // getter - returns the studentDtoArrayList variable, which is an ArrayList containing student records */
    public ArrayList<Student> getStudentDtoArrayList() {
        return studentDtoArrayList;
    }

    // RecordMenu constructor to create scanner as constructor parameter to instantiate
    // the instance variable of recordMenu scanner.
    public RecordMenu(Scanner scanner) {
        //this.scanner is from recordMenu
        this.scanner = scanner;
    }

    public void openRecordMenu() {

        while (true) {
            try {
                // * Initialize the studentDtoArrayList as a new ArrayList
                System.out.println("Enter student id");
                userId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter name: ");
                userNameInput = scanner.nextLine();

                System.out.println("Enter English score: ");
                englishGradeInput = Double.parseDouble(scanner.nextLine());

                System.out.println("Enter Maths score: ");
                mathGradeInput = Double.parseDouble(scanner.nextLine());

                System.out.println("Enter Science score: ");
                scienceGradeInput = Double.parseDouble(scanner.nextLine());

                if (userId == 0) {
                    break;
                }
                if (userNameInput.equals("")) {
                    break;
                }
                if (englishGradeInput == 0 || mathGradeInput == 0 || scienceGradeInput == 0) {
                    break;
                }

                // add new objects to studentDtoArraylist
                studentDtoArrayList.add(new Student(userId, userNameInput, englishGradeInput, mathGradeInput, scienceGradeInput));

                double calculateGrade = englishGradeInput + mathGradeInput + scienceGradeInput;
                double averageGrade = (calculateGrade / 3);

                System.out.println(userNameInput + " overall grade is " + averageGrade);

                if (averageGrade < 50) {
                    System.out.println(userNameInput + " failed all the modules");
                } else {
                    System.out.println(userNameInput + " passed all the modules");
                }
                System.out.println("");
            } catch (Exception e) {
                System.out.println("try again!");
            }
            break;
        }
    }
}
