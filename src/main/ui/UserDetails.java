package ui;


import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;

public class UserDetails extends Observable implements Serializable {
    private String customerName;
    private int customerNumber;
    private Double customerSpent;

    public UserDetails(String customerName, int customerNumber, Double customerSpent) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerSpent = customerSpent;
    }

    public UserDetails() {
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public Double getCustomerSpent() {
        return this.customerSpent;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerSpent(Double newnum) {
        this.customerSpent = this.customerSpent + newnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDetails that = (UserDetails) o;
        return customerNumber == that.customerNumber
                &&
                Objects.equals(customerName, that.customerName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerName, customerNumber);
    }

    @Override
    public String toString() {
        return "UserDetails{"
                + "customerName='" + customerName + '\''
                + ", customerNumber=" + customerNumber
                + ", customerSpent=" + customerSpent
                + '}';
    }
}
