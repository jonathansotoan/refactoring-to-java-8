package com.caletre.refactoring.toJava8.service;

import com.caletre.refactoring.toJava8.model.Seat;
import com.caletre.refactoring.toJava8.model.ShowTime;

import java.util.Arrays;

public class DefaultSeatRecommendationsService implements SeatRecommendationsService {

    public Seat[] recommendSeats(ShowTime showTime, int quantityOfSeats) {
        SeatsSelector selector = this::getBest;

        return selector.getBest(showTime.getSeats(), quantityOfSeats);
    }

    private Seat[] getBest(Seat[][] allSeats, int internalQuantityOfSeats) {
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
    }

    private int getPreferencePoints(Seat[] seatsGroup) {
        if(seatsGroup.length == 0
                || Arrays.stream(seatsGroup).anyMatch(seat -> seat == null || seat.isAisle() || seat.isBooked())) {
            return 0;
        }

        return Arrays.stream(seatsGroup)
                .map(Seat::getPreferencePoints)
                .reduce((preferencePoints, accumulator) -> preferencePoints + accumulator)
                .get();
    }

    private Seat[] getSeatsGroup(int targetRow, int startingColumn, Seat[][] allSeats, int quantityOfSeats) {
        if(startingColumn + quantityOfSeats >= allSeats[targetRow].length){
            return new Seat[quantityOfSeats];
        }

        return Arrays.stream(allSeats[targetRow], startingColumn, startingColumn + quantityOfSeats)
                .toArray(Seat[]::new);
    }
}
