package com.caletre.refactoring.toJava8.service;

import com.caletre.refactoring.toJava8.model.Seat;
import com.caletre.refactoring.toJava8.model.ShowTime;

public class DefaultSeatRecommendationsService implements SeatRecommendationsService {

    public Seat[] recommendSeats(ShowTime showTime, int quantityOfSeats) {
        // We could change the SeatsSelector interface to have no parameters and use the external method variables
        // instead
        SeatsSelector selector = (allSeats, internalQuantityOfSeats) -> {
            Seat[] currentBestSeats = new Seat[0];

            for(int row = 0; row < allSeats.length; ++row) {
                for(int column = 0; column < allSeats[row].length; ++column) {
                    Seat[] possibleBetterGroup = getSeatsGroup(row, column, allSeats, internalQuantityOfSeats);
                    if(getPreferencePoints(possibleBetterGroup) > getPreferencePoints(currentBestSeats)) {
                        currentBestSeats = possibleBetterGroup;
                    }
                }
            }

            return currentBestSeats;
        };

        return selector.getBest(showTime.getSeats(), quantityOfSeats);
    }

    private int getPreferencePoints(Seat[] seatsGroup) {
        int preferencePoints = 0;

        for(int seatIndex = 0; seatIndex < seatsGroup.length; ++seatIndex) {
            if(seatsGroup[seatIndex] == null
                    || seatsGroup[seatIndex].isAisle()
                    || seatsGroup[seatIndex].isBooked()) {
                return 0;
            }

            preferencePoints += seatsGroup[seatIndex].getPreferencePoints();
        }

        return preferencePoints;
    }

    private Seat[] getSeatsGroup(int targetRow, int startingColumn, Seat[][] allSeats, int quantityOfSeats) {
        Seat[] seatGroup = new Seat[quantityOfSeats];

        if(startingColumn + quantityOfSeats >= allSeats[targetRow].length){
            return seatGroup;
        }

        for (int seatIndex = 0; seatIndex < quantityOfSeats; ++seatIndex) {
            seatGroup[seatIndex] = allSeats[targetRow][startingColumn + seatIndex];
        }

        return seatGroup;
    }
}
