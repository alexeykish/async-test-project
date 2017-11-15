package by.kish.mano.entity;

import java.io.Serializable;

public class Order implements Serializable {

    private String name;
    private String status;
    private int increment;

    public Order() {
    }

    public Order(String name, String status, int increment) {
        this.name = name;
        this.status = status;
        this.increment = increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (increment != order.increment) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + increment;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", increment=" + increment +
                '}';
    }
}