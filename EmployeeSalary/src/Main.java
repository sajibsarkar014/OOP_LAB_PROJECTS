public class Main {

    public static void main(String[] args) {


        Employee[] employeeList = new Employee[4];

        employeeList[0] = new HourlyEmployee("Rahim", "Mia", "1234-45-6789", 5000, 7.4);
        employeeList[1] = new CommissionEmployee("Raju", "Mahmud", "4321-65-0987", 250000, 15);
        employeeList[2] = new SalariedEmployee("Roushan", "Rahat","7654-23-9876",15000);
        employeeList[3] = new BasePlusCommissionEmployee("Kevin", "de Bruyne","1234-09-7896",900000,12.5, 120000);


        for(Employee employee : employeeList){
            if(employee instanceof BasePlusCommissionEmployee){
                ( (BasePlusCommissionEmployee) employee).increaseBaseSalary(10);
            }
        }

        for(Employee employee : employeeList){
            System.out.println(employee.toString());
            System.out.println("Earning : Tk." + employee.earnings());
            System.out.println();
            System.out.println();
        }


    }
}
