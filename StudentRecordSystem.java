import java.util.*;

public class StudentRecordSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    list.add(new Student(id, name, marks));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Student s : list) {
                        if (s.id == searchId) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    Iterator<Student> it = list.iterator();

                    boolean deleted = false;
                    while (it.hasNext()) {
                        Student s = it.next();
                        if (s.id == deleteId) {
                            it.remove();
                            deleted = true;
                            System.out.println("Student Deleted.");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + " Name: " + name + " Marks: " + marks);
    }
}