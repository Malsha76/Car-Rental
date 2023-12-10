package lk.ijse.vehicle_rental.to;
/**
 * @author:Malsha Ekanayake
 */
public class Booking {
    private String book_id;
    private String reg_id;
    private String cus_id;
    private String book_date;
    private String return_date;

    public Booking() {
    }

    public Booking(String book_id, String reg_id, String cus_id, String book_date, String return_date) {
        this.book_id = book_id;
        this.reg_id = reg_id;
        this.cus_id = cus_id;
        this.book_date = book_date;
        this.return_date = return_date;
    }



    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }
    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getBook_date() {
        return book_date;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "book_id='" + book_id + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", cus_id='" + cus_id + '\'' +
                ", book_date='" + book_date + '\'' +
                ", return_date='" + return_date + '\'' +
                '}';
    }
}
