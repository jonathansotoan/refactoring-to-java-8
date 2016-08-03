package com.caletre.refactoring.toJava8.service;

import com.caletre.refactoring.toJava8.model.Seat;
import com.caletre.refactoring.toJava8.model.ShowTime;

public interface SeatRecommendationsService {
    Seat[] recommendSeats(ShowTime showTime, int numberOfSeats);
}
