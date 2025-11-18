import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ArrayList<Employee> employees=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("enter 1 for employee vacation, enter 2 for exit");
            int a= Integer.parseInt(sc.nextLine());
            if(a==1) {
                System.out.println("\nEnter information for Employee ");

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Date of Birth (dd/MM/yyyy): ");
                String date_of_birth = sc.nextLine();


                System.out.println("Email: ");
                String email = sc.nextLine();

                System.out.print("Employee Type (officer / staff): ");
                String type = sc.nextLine();

                System.out.print("Joining Date (dd/MM/yyyy): ");
                LocalDate joinDate = LocalDate.parse(sc.nextLine(), formatter);

                employees.add(new Employee(id, name, date_of_birth, email, joinDate, type));
            }
            else {
                break;
            }
            }

            if(employees.isEmpty()) {
                System.out.println("exit successful");
            }
            else {
                System.out.println("Employee Leave Information");
            }

            for (Employee emp : employees) {

                if (emp.type.equalsIgnoreCase("Officer")) {

                    leaveCalculator<officer> calc = new leaveCalculator<>(new officer());
                    emp.vacationLeave = calc.calculate(emp.joining_date, calc.getVacationTotal());
                    emp.sickLeave = calc.calculate(emp.joining_date, calc.getSickTotal());

                } else {

                    leaveCalculator<staff> calc = new leaveCalculator<>(new staff());
                    emp.vacationLeave = calc.calculate(emp.joining_date, calc.getVacationTotal());
                    emp.sickLeave = calc.calculate(emp.joining_date, calc.getSickTotal());
                }

                // Print final details
                System.out.println("\nID: " + emp.id);
                System.out.println("Name: " + emp.name);
                System.out.println("DOB: " + emp.date_of_birth);
                System.out.println("Email: " + emp.email);
                System.out.println("Employee Type: " + emp.type);
                System.out.println("Joining Date: " + emp.joining_date.format(formatter));
                System.out.println("Vacation Leave: " + emp.vacationLeave);
                System.out.println("Sick Leave: " + emp.sickLeave);
            }

            sc.close();
    }
}