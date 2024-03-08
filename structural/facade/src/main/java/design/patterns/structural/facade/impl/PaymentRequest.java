package design.patterns.structural.facade.impl;

public class PaymentRequest {

    private Long customerId;
    private double amount;
    private String cardNumber;
    private String cardName;
    private String cardExpDate;
    private String cardSecureNumber;

    public PaymentRequest() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public void setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
    }

    public String getCardSecureNumber() {
        return cardSecureNumber;
    }

    public void setCardSecureNumber(String cardSecureNumber) {
        this.cardSecureNumber = cardSecureNumber;
    }
    
}
