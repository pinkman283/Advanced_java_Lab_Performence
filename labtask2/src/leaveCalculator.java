import java.time.LocalDate;
import java.time.Period;

public class leaveCalculator <T>{
    private T employeeType;
    public leaveCalculator(T employeeType){
        this.employeeType=employeeType;
    }
    public int calculate(LocalDate joiningDate,int totaleave){
        LocalDate endDate=LocalDate.of(2025,12,31);
        Period daysWorked = Period.between(joiningDate,endDate);
        int days=daysWorked.getDays();
        boolean isLeap=LocalDate.of(2025,1,1).isLeapYear();
        double denominator= isLeap? 366.0:365.0;
        double raw=(days*totaleave)/denominator;
        return (raw<0.5)?(int)Math.floor(raw):(int)Math.ceil(raw);
    }
        public int getVacationTotal(){
            if (employeeType instanceof officer)
            {
                return ((officer)employeeType).getVacation();

            }
            else
                return ((staff)employeeType).getVacation();
        }
    public int getSickTotal(){
        if (employeeType instanceof officer)
        {
            return ((officer)employeeType).getSick();

        }
        else
            return ((staff)employeeType).getSick();
    }


}
