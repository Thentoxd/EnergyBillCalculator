package com.alexnicklin;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Calculator {

    public int oldGasMeterReading;
    public int newGasMeterReading;

    public int oldElectricMeterReading;
    public int newElectricMeterReading;

    public Calculator(int oldGasMeterReading, int oldElectricMeterReading) {
        this.oldGasMeterReading = oldGasMeterReading;
        this.oldElectricMeterReading = oldElectricMeterReading;

        print("What is the new meter reading?\n ");

        Scanner scanner = new Scanner(System.in);
        int newMeterReading = scanner.nextInt();

        this.newGasMeterReading = newMeterReading;

        print("What is the new electric meter reading?\n ");

        int newElectricReading = scanner.nextInt();

        this.newElectricMeterReading = newElectricReading;
    }

    public int lengthOfDays(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, 29);
        cal.set(Calendar.MONTH, 6);
        cal.set(Calendar.YEAR, 2022);
        Date firstDate = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        Date secondDate = cal.getTime();

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return (int) diff;
    }

    public double getGasBill() {
        int unitsUsed = newGasMeterReading - oldGasMeterReading;
        double killWattsUsed = unitsUsed * 1.02264 * 39.7 / 3.6;

        return (killWattsUsed * 7.503) / 100;
    }

    public double getElectricBill() {
        double killWattsUsed = newElectricMeterReading - oldElectricMeterReading;

        return (killWattsUsed * 28.545) / 100;
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
