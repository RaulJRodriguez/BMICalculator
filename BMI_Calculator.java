import javax.swing.JOptionPane;

public class BMI_Calculator {
    public static void main(String[] args) {

        final int MAX = 100;

        String[] customerName = new String[MAX];
        double[] customerHeight = new double[MAX];
        double[] customerWeight = new double[MAX];
        double[] customerBMI = new double[MAX];
        int numCustomer = 0;
        String BMI = " ";

        do {
            customerName[numCustomer] = JOptionPane.showInputDialog("Enter #" + (numCustomer + 1) + " customer name ");
            boolean validHeight = false;
            boolean validWeight = false;

            do {
                try {
                    customerHeight[numCustomer] = Double.parseDouble(JOptionPane.showInputDialog("Please enter customer " + (numCustomer + 1) + " height in meters: "));
                    if (customerHeight[numCustomer] > 0) {
                        validHeight = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Invalid input for height. Try again");
                    }

                    customerWeight[numCustomer] = Double.parseDouble(JOptionPane.showInputDialog("Please enter customer " + (numCustomer + 1) + " weight in kilograms: "));
                    if (customerWeight[numCustomer] > 0) {
                        validWeight = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Invalid input for weight. Try again");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error! Invalid input for height or weight. Try again");
                }
            } while (!validHeight || !validWeight);

            customerBMI[numCustomer] = customerWeight[numCustomer] / (customerHeight[numCustomer] * customerHeight[numCustomer]);

            if (customerBMI[numCustomer] >= 30) {
                BMI = "Obese";
            } else if (customerBMI[numCustomer] > 25 && customerBMI[numCustomer] < 30) {
                BMI = "Overweight";
            } else if (customerBMI[numCustomer] > 18.5 && customerBMI[numCustomer] < 25) {
                BMI = "Ideal";
            } else {
                BMI = "Underweight";
            }

            numCustomer++;
            customerName[numCustomer] = JOptionPane.showInputDialog("Enter 'Y' to enter another customer" + "\n" + " or Press 'Q' to quit");
        } while (numCustomer < MAX && !customerName[numCustomer].equalsIgnoreCase("Q"));

        String searchCustomerName = JOptionPane.showInputDialog("Enter customer name to search");
        int searchIndex = -1;

        for (int i = 0; i < numCustomer; i++) {
            if (customerName[i].equals(searchCustomerName)) {
                searchIndex = i;
                break; // Found the customer, no need to continue searching
            }
        }

        if (searchIndex == -1) {
            JOptionPane.showMessageDialog(null, "Customer was not found");
        } else {
            JOptionPane.showMessageDialog(null, "Customer was found " + customerName[searchIndex] + "\n" + "Customer height - " + customerHeight[searchIndex] + "\n" + "Customer weight - " + customerWeight[searchIndex] + "\n" + "Customer BMI - " + customerBMI[searchIndex]);
        }

        // Report
        String output = "Customer Report \n";

        for (int i = 0; i < numCustomer; i++) {
            String customerClassification = "";
            if (customerBMI[i] >= 30) {
                customerClassification = "Obese";
            } else if (customerBMI[i] > 25 && customerBMI[i] < 30) {
                customerClassification = "Overweight";
            } else if (customerBMI[i] > 18.5 && customerBMI[i] < 25) {
                customerClassification = "Ideal";
            } else {
                customerClassification = "Underweight";
            }
            output += customerName[i] + "\n" + "Customer height - " + customerHeight[i] + "\n" + "Customer weight - " + customerWeight[i] + "\n" + "Customer BMI - " + customerBMI[i] + "\n" + "BMI Classification - " + customerClassification + "\n";
        }

        JOptionPane.showMessageDialog(null, output);
    }
}
