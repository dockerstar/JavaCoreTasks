package school.sorokin.javacore.Testing.Mockito.Pay;

public class SBPPay implements PaymentService{
    private final String typePay = "SBP";

    @Override
    public String pay() {
        return "SBP";
    }

    public String getTypePay() {
        return typePay;
    }
}
