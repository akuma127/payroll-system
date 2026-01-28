import java.util.Date;

public class Payment {

    // Encapsulation: private fields
    private String paymentID;
    private float amount;
    private Date date;
    private PaymentMethod method;

    // Constructor
    public Payment(String paymentID, float amount, Date date, PaymentMethod method) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    // Getters
    public String getPaymentID() {
        return paymentID;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    // Returns readable payment info
    public String getDetails() {
        return "Payment ID: " + paymentID +
                "\nAmount: " + amount +
                "\nDate: " + date +
                "\nPayment Method: " + method;
    }
}

