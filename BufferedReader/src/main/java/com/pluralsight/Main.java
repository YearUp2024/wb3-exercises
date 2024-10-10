package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("employees.csv");

        BufferedReader bufReader = new BufferedReader(fileReader);
        bufReader.readLine();
        String input;

        FileWriter fw = new FileWriter("payroll-act-2024.txt");
        fw.write("id|name|gross pay\n");

        while((input = bufReader.readLine()) != null) {
            String[] tokes = input.split(Pattern.quote("|"));

            int employeeId = Integer.parseInt(tokes[0]);
            String name = tokes[1];
            float hoursWorked = Float.parseFloat(tokes[2]);
            float payRate = Float.parseFloat(tokes[3]);

            Employee theEmp = new Employee(employeeId, name, hoursWorked, payRate);
            displayEmplouee(theEmp);

            String outputData = theEmp.getEmployeeId() + '|' + theEmp.getName() + '|' + theEmp.getGrossPay()  +"\n";
            System.out.println(outputData);
            fw.write(outputData);
        }

        bufReader.close();
        fw.close();
    }
    private static void displayEmplouee(Employee employee){
        System.out.printf("%d: %s Pay this period: %.2f%n",employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
    }
}