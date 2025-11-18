import java.time.LocalDate;

public class Employee {
    String id,name,date_of_birth,email,type;
    LocalDate joining_date;
    int vacationLeave,sickLeave;
    public Employee(String id, String name, String date_of_birth, String email, LocalDate joining_date,String type){
        this.id=id;
        this.name=name;
        this.date_of_birth=date_of_birth;
        this.email=email;
        this.joining_date=joining_date;
        this.type=type;
    }
}
