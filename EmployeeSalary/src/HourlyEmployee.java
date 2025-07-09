class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public double earnings() {
        if (hours <= 40) {
            return wage * hours;
        } else {
            return (40*wage+(hours-40)*wage)* 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("Hourly Employee: %n%s%nHourly Wage: $%.2f; Hours Worked: %.2f",
                super.toString(), wage, hours);
    }
}