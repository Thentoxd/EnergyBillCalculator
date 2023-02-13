package com.alexnicklin;

import java.util.Calendar;

public class Main {

    public static Calculator calculator;

    public static void main(String[] args) {
        calculator = new Calculator(435, 1628);

        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        double bill = ((calculator.lengthOfDays(dayOfMonth, month, year) * 30.506) / 100 + (calculator.lengthOfDays(dayOfMonth, month, year) * 46.767) / 100) + calculator.getGasBill() + calculator.getElectricBill();

        print("Gas Standing charge: " + (calculator.lengthOfDays(dayOfMonth, month, year) * 30.506) / 100);
        print("Gas Bill: " + calculator.getGasBill());
        print("Electric Standing Charge: " + (calculator.lengthOfDays(dayOfMonth, month, year) * 46.767) / 100);
        print("Electric Bill: " + calculator.getElectricBill());
        print("\n Total: " + bill);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
