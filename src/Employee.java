import java.text.DecimalFormat;

/**
 * This class represents an employee at a company and defines common attributes for all employee types
 *
 * @author David Ha, Andrew McAvoy
 */
public class Employee {
    private Profile profile;
    private double payment;

    /**
     * Constructor for employee class
     */
    public Employee(Profile profile){
        this.profile = profile;
        this.payment = 0;
    }

    /**
     * Prints instance of this class in the following format
     * profile::payment
     *
     * @return textual representation of this class
     */

    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("$#.##");
        return profile + "::" + formatter.format(payment);
    }

    /**
     * Checks if two employees are equal
     *
     * @param obj object to be compared
     * @return true if equal; false if otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Employee){
            Employee temp = (Employee) obj;
            return ((profile.equals(temp)) && (payment == temp.payment));
        }
        return false;
    }
}
