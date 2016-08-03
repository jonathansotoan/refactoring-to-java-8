package com.caletre.refactoring.toJava8.model;

public class Seat {
    private int row;
    private int column;
    private boolean isAisle;
    private boolean isBooked;
    private int preferencePoints;

    public Seat(int row, int column, boolean isAisle, boolean isBooked, int preferencePoints) {
        this.row = row;
        this.column = column;
        this.isAisle = isAisle;
        this.isBooked = isBooked;
        this.preferencePoints = preferencePoints;
    }

    public boolean isAisle() {
        return isAisle;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int getPreferencePoints() {
        return preferencePoints;
    }

    public static Seat createReserved(int row, int column, int preferencePoints) {
        return new Seat(row, column, false, true, preferencePoints);
    }

    public static Seat createAvailable(int row, int column, int preferencePoints) {
        return new Seat(row, column, false, false, preferencePoints);
    }

    public static Seat createAisle(int row, int column) {
        return new Seat(row, column, true, false, 0);
    }
}
