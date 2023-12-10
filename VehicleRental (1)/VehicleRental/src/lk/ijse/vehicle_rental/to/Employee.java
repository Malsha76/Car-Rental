package lk.ijse.vehicle_rental.to;
/**
 * @author:Malsha Ekanayake
 */
public class Employee {
    private String id;
    private String name;
    private String role;
    private String contact;
    private String address;
    private String salary;

    public Employee(String id, String name, String role, String contact, String address, String salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.address = address;
        this.salary = salary;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


}
