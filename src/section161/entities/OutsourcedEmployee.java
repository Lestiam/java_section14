package section161.entities;

public class OutsourcedEmployee extends Employee{

    private Double additionalCharge;

    public OutsourcedEmployee() {
    }
    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() { //o pagamento do funcionário terceirizado é o mesmo do funcionário normal, mais 110% da taxa adicional.
        return super.payment() + additionalCharge * 1.1;
    }
}
