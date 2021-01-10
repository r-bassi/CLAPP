package ui;


import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;

public class UserDetails extends Observable implements Serializable {
    private String customerName;
    private int customerNumber;
    private Double customerSpent;
    public int customerDiscount;

    public UserDetails(String customerName, int customerNumber, Double customerSpent, int customerDiscount) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerSpent = customerSpent;
        this.customerDiscount = customerDiscount;
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

    public int getCustomerDiscount() {
        return this.customerDiscount;
    }

    public void setCustomerSpent(Double newnum) {
        this.customerSpent = this.customerSpent + newnum;
    }

    public int setCustomerDiscount(int newnum) {
        return this.customerDiscount;
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
        return  "Customer Name: " + customerName + "\n"
                + "Customer Number: " + customerNumber + "\n"
                + "Customer Spent: $" + customerSpent + "\n"
                + "Customer Discount: " + customerDiscount + "%";
    }
}
