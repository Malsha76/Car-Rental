package lk.ijse.vehicle_rental.to;
/**
 * @author:Malsha Ekanayake
 */
public class Managevehicle {
    private String resigter_id;
    private String model;
    private String colour;
    private String veh_name;
    private String availability;
    private String insurance;
    private String transmission;

    public Managevehicle(String resigter_id, String model, String colour, String veh_name, String availability, String insurance, String transmission) {
        this.resigter_id = resigter_id;
        this.model = model;
        this.colour = colour;
        this.veh_name = veh_name;
        this.availability = availability;
        this.insurance = insurance;
        this.transmission = transmission;
    }

    public Managevehicle() {
    }

    public String getResigter_id() {
        return resigter_id;
    }

    public void setResigter_id(String resigter_id) {
        this.resigter_id = resigter_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getVeh_name() {
        return veh_name;
    }

    public void setVeh_name(String veh_name) {
        this.veh_name = veh_name;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}

