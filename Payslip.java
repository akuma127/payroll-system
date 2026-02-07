
public class Payslip {

    private final String payslipID;
    private final Employee employee;
    private final double grossAmount;
    private final double deductions;
    private final double netAmount;

    public Payslip(String payslipID, Employee employee, double grossAmount, double deductions) {
        if (grossAmount < 0 || deductions < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }
        if (deductions > grossAmount) {
            throw new IllegalArgumentException("Deductions cannot exceed gross salary");
        }

        this.payslipID = payslipID;
        this.employee = employee;
        this.grossAmount = grossAmount;
        this.deductions = deductions;
        this.netAmount = grossAmount - deductions;
    }

    public String getPayslipID() {
        return payslipID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetAmount() {
         return netAmount;
    }

    public String generatePayslip() {
          return  "Payslip ID: "    + payslipID +
                  "\nEmployee: " + employee.getName() +
                  "\nGross: " + grossAmount +
                  "\nDeductions: " + deductions +
                  "\nNet: " + netAmount;
    }
}
