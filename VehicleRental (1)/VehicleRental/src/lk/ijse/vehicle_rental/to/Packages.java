package lk.ijse.vehicle_rental.to;
/**
 * @author:Malsha Ekanayake
 */
public class Packages {
    private String id;
    private String name;
    private String price;

    public String getPackage_id() {
        return id;
    }

    public void setPackage_id(String package_id) {
        this.id = package_id;
    }

    public Packages(String package_id, String package_name, String price) {
        this.id = package_id;
        this.name = package_name;
        this.price = price;
    }

    public String getPackage_name() {
        return name;
    }

    public void setPackage_name(String package_name) {
        this.name = package_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
