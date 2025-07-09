class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }


    @Override
    public double earnings() {
        return (grossSales * commissionRate)/100;
    }

    @Override
    public String toString() {
        return String.format("Commission Employee: %n%s%nGross Sales: $%.2f; %nCommission Rate: %.2f",
                super.toString(), grossSales, commissionRate);
    }
}