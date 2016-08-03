package com.caletre.refactoring.toJava8.service;

import com.caletre.refactoring.toJava8.model.Seat;

public interface SeatsSelector {
    Seat[] getBest(Seat[][] allSeats, int quantityOfSeats);
}
