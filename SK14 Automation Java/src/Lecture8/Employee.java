
        public class Employee {
            final private static int id = 1234;
            final private static String firstName = "Ana";
            final private static String lastName = "Nikolova";
            private static double salaryPerMonth = 6000;

            public Employee (int id, String firstName, String lastName, double salaryPerMonth) {
                this.salaryPerMonth = salaryPerMonth;

                Employee employee = new Employee(1234, "Petya", "Pavlova", 7000);
            }
        }

        static void getFirstNameLastName () {
            System.out.println(Employee.firstName + " " + Employee.lastName);

        }

        public static double getAnnualsalary () {
            return Employee.salaryPerMonth * 12;
        }

        public void main(String[] args) {
            getFirstNameLastName();
            getAnnualsalary();
            raiseSalary();
        }

        private void raiseSalary () {
            double percentage = 0x3;
            double salaryPerMonth = 7000;
            double raiseAmount = salaryPerMonth * percentage / 100;
            double raisePerMonth = raiseAmount;
            double monhtlyRaise = raisePerMonth + salaryPerMonth;
            double salaryPerYear = salaryPerMonth * 12;
            System.out.println(salaryPerYear);
            System.out.println(monhtlyRaise);
        }


