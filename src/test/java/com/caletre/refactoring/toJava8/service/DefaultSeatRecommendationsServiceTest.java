package com.caletre.refactoring.toJava8.service;

import java.util.Date;

import com.caletre.refactoring.toJava8.model.Seat;
import com.caletre.refactoring.toJava8.model.ShowTime;
import org.junit.Assert;
import org.junit.Test;

public class DefaultSeatRecommendationsServiceTest {

    private DefaultSeatRecommendationsService recommendationService =
            new DefaultSeatRecommendationsService();
    private ShowTime showTime = new ShowTime();

    @Test
    public void testFullHouseDoesNotRecommendAnything() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.fullHouseScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(0, recommendedSeats.length);
    }

    @Test
    public void testEmptyHouseRecommendsBestSeats() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.emptyScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(3, recommendedSeats.length);

        Assert.assertEquals(100, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[2].getPreferencePoints());
    }

    @Test
    public void testNoRecommendationWhenThereAreNotEnoughSeats() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.seatAvailableBehindAilseScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 2);

        // verify
        Assert.assertEquals(0, recommendedSeats.length);
    }

    @Test
    public void testMoreThanOnceGroupOfSeatsInFirstRowScenarioRecommendsTheBest() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.moreThanOnceGroupOfSeatsInRow());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(3, recommendedSeats.length);

        Assert.assertEquals(100, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[2].getPreferencePoints());
    }

    @Test
    public void testEmptyFirstRowScenarioRecommendsTheBest() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.emptyFirstRowScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 4);

        // verify
        Assert.assertEquals(4, recommendedSeats.length);

        Assert.assertEquals(96, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[2].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[3].getPreferencePoints());
    }

    @Test
    public void testMoreThanOnceGroupOfSeatsInRowScenarioRecommendsTheBest() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.moreThanOnceGroupOfSeatsInRow());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(3, recommendedSeats.length);

        Assert.assertEquals(100, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(100, recommendedSeats[2].getPreferencePoints());
    }

    @Test
    public void testScenarioWithBestSeatsReservedAndMultipleOptionsRecommendsTheBestAvailable() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.bestSeatsReservedScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 7);

        // verify
        Assert.assertEquals(7, recommendedSeats.length);

        Assert.assertEquals(99, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[2].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[3].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[4].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[5].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[6].getPreferencePoints());
    }

    @Test
    public void testSeatsBlockedByAisleAreNotRecommended() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.firstSeatsBlockedByAisleScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(3, recommendedSeats.length);

        Assert.assertEquals(96, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(93, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(90, recommendedSeats[2].getPreferencePoints());
    }

    @Test
    public void testMoreThanMaximumContiguousSeatsSeatsDoesNotRecommendAnything() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.emptyFirstRowScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 13);

        // verify
        Assert.assertEquals(0, recommendedSeats.length);
    }

    @Test
    public void testMaximumQuantityOfSeatsRecommendsWholePartialRowOnEmptyFirstRowScenario() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.emptyFirstRowScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 12);

        // verify
        Assert.assertEquals(12, recommendedSeats.length);

        Assert.assertEquals(84, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(88, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(92, recommendedSeats[2].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[3].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[4].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[5].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[6].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[7].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[8].getPreferencePoints());
        Assert.assertEquals(93, recommendedSeats[9].getPreferencePoints());
        Assert.assertEquals(90, recommendedSeats[10].getPreferencePoints());
        Assert.assertEquals(87, recommendedSeats[11].getPreferencePoints());
    }

    @Test
    public void testMaximumQuantityOfSeatsRecommendsWholePartialRowOnBestSeatsReservedScenario() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.bestSeatsReservedScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 12);

        // verify
        Assert.assertEquals(12, recommendedSeats.length);

        Assert.assertEquals(87, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(91, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(95, recommendedSeats[2].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[3].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[4].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[5].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[6].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[7].getPreferencePoints());
        Assert.assertEquals(99, recommendedSeats[8].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[9].getPreferencePoints());
        Assert.assertEquals(93, recommendedSeats[10].getPreferencePoints());
        Assert.assertEquals(90, recommendedSeats[11].getPreferencePoints());
    }

    @Test
    public void testScenarioWithOnePossibleOptionRecommendsIt() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.threeConsecutiveAvalilableScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 3);

        // verify
        Assert.assertEquals(3, recommendedSeats.length);

        Assert.assertEquals(69, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(66, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(63, recommendedSeats[2].getPreferencePoints());
    }

    @Test
    public void testEmptyFirstRowScenarioAndMultiplePossibleOptionsRecommendsTheBest() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.emptyFirstRowScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 9);

        // verify
        Assert.assertEquals(9, recommendedSeats.length);

        Assert.assertEquals(92, recommendedSeats[0].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[1].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[2].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[3].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[4].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[5].getPreferencePoints());
        Assert.assertEquals(96, recommendedSeats[6].getPreferencePoints());
        Assert.assertEquals(93, recommendedSeats[7].getPreferencePoints());
        Assert.assertEquals(90, recommendedSeats[8].getPreferencePoints());
    }

    @Test
    public void testSeatAvailableBehindAisleScenarioMap() {
        // setup
        showTime.setSeats(CinemaTemplateGeneratorUtil.seatAvailableBehindAilseScenario());

        // execute
        Seat[] recommendedSeats = recommendationService.recommendSeats(showTime, 1);

        // verify
        Assert.assertEquals(1, recommendedSeats.length);
        Assert.assertEquals(91, recommendedSeats[0].getPreferencePoints());
    }
}