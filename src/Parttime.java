import java.text.DecimalFormat;

/**
 * This class extends the employee class and contains data elements and operations specific to a part-time employee
 *
 * @author David Ha, Andrew McAvoy
 */
public class Parttime extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    /**
     * Constructor for Parttime class
     *
     * @param profile profile for the employee
     * @param hourlyRate hourly pay of the employee
     */
    public Parttime(Profile profile, double hourlyRate) {
        super(profile);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    /**
     * Calculates payment of the employee
     */
    @Override
    public void calculatePayment(){
        if(hoursWorked > 80){
            int overtimeHours = hoursWorked - 80;
            double overtimePay = (overtimeHours) * (1.5 * hourlyRate);
            super.setPayment((hoursWorked - overtimeHours) * hourlyRate + overtimePay);
        }
        else{
            super.setPayment(hoursWorked * hourlyRate);
        }
    }

    /**
     * Setter method for hours worked
     *
     * @param hoursWorked value to be changed
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Getter method for hours worked
     *
     * @return hoursWorked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Prints instance of this class in the following format
     * profile::payment::PART TIME::hourlyRate
     *
     * @return textual representation of this class
     */
    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
        return super.toString() + "::PART TIME::" + "Hourly Rate " + formatter.format(hourlyRate) +
                "::Hours worked this period: " + hoursWorked;
    }

    /**
     * Checks if two parttime employees are equal
     *
     * @param obj parttime employee to be compared
     * @return true if equal; false if otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Parttime){
            Parttime temp = (Parttime) obj;
            return (super.equals(temp)) && (hourlyRate == temp.hourlyRate) && (hoursWorked == temp.hoursWorked);
        }
        return false;
    }
}
