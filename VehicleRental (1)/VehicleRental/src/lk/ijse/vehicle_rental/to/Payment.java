package lk.ijse.vehicle_rental.to;
/**
 * @author:Malsha Ekanayake
 */
public class Payment {
    private String id;
    private  String date;
    private String advance;
    private  String payment;
    private  String cusID;

    public Payment() {
    }

    public Payment(String id, String date, String advance, String payment, String cusID) {
        this.id = id;
        this.date = date;
        this.advance = advance;
        this.payment = payment;
        this.cusID = cusID;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }
}
