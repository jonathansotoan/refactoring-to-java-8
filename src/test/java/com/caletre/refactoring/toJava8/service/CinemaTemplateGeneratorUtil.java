package com.caletre.refactoring.toJava8.service;

import com.caletre.refactoring.toJava8.model.Seat;

import static com.caletre.refactoring.toJava8.model.Seat.createAisle;
import static com.caletre.refactoring.toJava8.model.Seat.createAvailable;
import static com.caletre.refactoring.toJava8.model.Seat.createReserved;

public final class CinemaTemplateGeneratorUtil {

    private CinemaTemplateGeneratorUtil() {
    }

    private static final int DEFAULT_COLUMNS = 26;
    private static final int DEFAULT_ROWS = 10;

    private static final int[][] STANDARD_PREFERENCE_POINTS = new int[][]{
            new int[]{56, 60, 64, 68, 0, 0, 0, 84, 88, 92, 96, 96, 96, 96, 96, 96, 93, 90, 87, 0, 0, 0, 75, 72, 69, 66},
            new int[]{57, 61, 65, 69, 0, 0, 0, 85, 89, 93, 97, 97, 97, 97, 97, 97, 94, 91, 88, 0, 0, 0, 76, 73, 70, 67},
            new int[]{58, 62, 66, 70, 0, 0, 0, 86, 90, 94, 98, 98, 98, 98, 98, 98, 95, 92, 89, 0, 0, 0, 77, 74, 71, 68},
            new int[]{59, 63, 67, 71, 0, 0, 0, 87, 91, 95, 99, 99, 99, 99, 99, 99, 96, 93, 90, 0, 0, 0, 78, 75, 72, 69},
            new int[]{60, 64, 68, 72, 0, 0, 0, 88, 92, 96, 100, 100, 100, 100, 100, 100, 97, 94, 91, 0, 0, 0, 79, 76, 73, 70},
            new int[]{60, 64, 68, 72, 0, 0, 0, 88, 92, 96, 100, 100, 100, 100, 100, 100, 97, 94, 91, 0, 0, 0, 79, 76, 73, 70},
            new int[]{55, 59, 63, 67, 0, 0, 0, 83, 87, 91, 95, 95, 95, 95, 95, 95, 92, 89, 86, 0, 0, 0, 74, 71, 68, 65},
            new int[]{50, 54, 58, 62, 0, 0, 0, 78, 82, 86, 90, 90, 90, 90, 90, 90, 87, 84, 81, 0, 0, 0, 69, 66, 63, 60},
            new int[]{45, 49, 53, 57, 0, 0, 0, 73, 77, 81, 85, 85, 85, 85, 85, 85, 82, 79, 76, 0, 0, 0, 64, 61, 58, 55},
            new int[]{40, 44, 48, 52, 0, 0, 0, 68, 72, 76, 80, 80, 80, 80, 80, 80, 77, 74, 71, 0, 0, 0, 59, 56, 53, 50},
    };

    public static Seat[][] getByTemplateType(CinemaTemplateType type) {
        switch (type) {
            case ALL_AVAILABLE:
                return getEmptyScenario();
            case FULL_SCENARIO:
                return getScenarioWithoutAnyAvailableSeat();
            case ONE_SCENARIO:
                return getOneScenario();
            case TWO_CONSECUTIVE_SCENARIO:
                return getTwoConsecutiveScenario();
            case THREE_CONSECUTIVE_SCENARIO:
                return getThreeConsecutiveScenario();
            case FOUR_CONSECUTIVE_SCENARIO:
                return getFourConsecutiveScenario();
            case FIVE_CONSECUTIVE_SCENARIO:
                return getFiveConsecutiveScenario();
            case SIX_CONSECUTIVE_SCENARIO:
                return getSixConsecutiveScenario();
            case TWO_RANDOM_SCENARIO:
                return getTwoRandomScenario();
            case THREE_RANDOM_SCENARIO:
                return getThreeRandomScenario();
            case FOUR_RANDOM_SCENARIO:
                return getFourRandomScenario();
            case FIVE_RANDOM_SCENARIO:
                return getFiveRandomScenario();
            case SIX_RANDOM_SCENARIO:
                return getSixRandomScenario();
            default:
                return getEmptyScenario();
        }

    }

    public static Seat[][] getEmptyScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, false, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, false, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, false, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, false, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, false, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, false, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, false, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, false, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, false, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, false, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, false, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, false, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, false, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, false, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, false, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, false, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, false, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, false, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, false, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, false, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, false, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, false, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, false, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, false, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, false, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, false, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, false, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, false, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, false, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, false, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, false, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, false, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, false, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, false, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, false, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, false, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, false, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, false, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, false, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, false, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, false, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, false, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, false, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, false, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, false, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, false, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, false, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, false, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, false, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, false, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, false, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, false, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, false, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, false, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, false, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, false, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, false, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, false, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, false, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, false, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, false, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, false, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, false, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, false, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, false, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, false, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, false, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, false, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, false, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, false, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, false, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, false, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, false, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, false, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, false, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, false, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, false, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, false, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, false, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, false, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, false, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, false, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, false, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, false, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, false, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, false, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, false, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, false, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, false, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, false, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, false, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, false, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, false, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, false, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, false, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, false, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, false, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, false, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, false, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, false, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, false, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, false, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, false, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, false, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, false, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, false, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, false, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, false, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, false, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, false, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, false, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, false, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, false, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, false, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, false, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, false, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, false, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, false, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, false, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, false, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, false, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, false, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, false, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, false, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, false, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, false, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, false, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, false, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, false, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, false, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, false, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, false, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, false, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, false, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, false, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, false, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, false, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, false, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, false, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, false, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, false, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, false, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, false, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, false, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, false, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, false, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, false, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, false, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, false, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, false, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, false, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, false, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, false, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, false, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, false, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, false, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, false, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, false, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, false, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, false, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, false, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, false, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, false, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, false, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, false, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, false, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, false, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, false, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, false, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, false, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, false, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, false, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, false, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, false, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, false, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, false, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, false, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, false, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, false, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, false, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, false, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, false, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, false, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, false, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, false, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, false, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, false, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, false, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, false, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, false, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, false, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, false, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, false, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, false, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, false, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, false, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, false, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, false, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, false, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, false, 50);

        return scenarioStructure;
    }

    public static Seat[][] getScenarioWithoutAnyAvailableSeat() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getOneScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, false, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getTwoConsecutiveScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, false, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, false, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getThreeConsecutiveScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, false, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, false, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, false, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getFourConsecutiveScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, false, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, false, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, false, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, false, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getFiveConsecutiveScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, false, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, false, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, false, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, false, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, false, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getSixConsecutiveScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, false, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, false, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, false, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, false, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, false, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, false, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getTwoRandomScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, false, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, false, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getThreeRandomScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, false, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, false, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, false, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getFourRandomScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, false, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, false, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, false, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, false, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getFiveRandomScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, false, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, true, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, true, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, true, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, false, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, true, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, false, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, false, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, true, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, true, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getSixRandomScenario() {
        Seat[][] scenarioStructure = new Seat[10][26];

        // Row in the top (0)
        scenarioStructure[0][0] = new Seat(0, 0, false, true, 56);
        scenarioStructure[0][1] = new Seat(0, 1, false, true, 60);
        scenarioStructure[0][2] = new Seat(0, 2, false, true, 64);
        scenarioStructure[0][3] = new Seat(0, 3, false, true, 68);
        scenarioStructure[0][4] = new Seat(0, 4, true, false, 0);
        scenarioStructure[0][5] = new Seat(0, 5, true, false, 0);
        scenarioStructure[0][6] = new Seat(0, 6, true, false, 0);
        scenarioStructure[0][7] = new Seat(0, 7, false, true, 84);
        scenarioStructure[0][8] = new Seat(0, 8, false, true, 88);
        scenarioStructure[0][9] = new Seat(0, 9, false, true, 92);
        scenarioStructure[0][10] = new Seat(0, 10, false, true, 96);
        scenarioStructure[0][11] = new Seat(0, 11, false, true, 96);
        scenarioStructure[0][12] = new Seat(0, 12, false, true, 96);
        scenarioStructure[0][13] = new Seat(0, 13, false, true, 96);
        scenarioStructure[0][14] = new Seat(0, 14, false, true, 96);
        scenarioStructure[0][15] = new Seat(0, 15, false, true, 96);
        scenarioStructure[0][16] = new Seat(0, 16, false, true, 93);
        scenarioStructure[0][17] = new Seat(0, 17, false, true, 90);
        scenarioStructure[0][18] = new Seat(0, 18, false, true, 87);
        scenarioStructure[0][19] = new Seat(0, 19, true, false, 0);
        scenarioStructure[0][20] = new Seat(0, 20, true, false, 0);
        scenarioStructure[0][21] = new Seat(0, 21, true, false, 0);
        scenarioStructure[0][22] = new Seat(0, 22, false, true, 75);
        scenarioStructure[0][23] = new Seat(0, 23, false, true, 72);
        scenarioStructure[0][24] = new Seat(0, 24, false, true, 69);
        scenarioStructure[0][25] = new Seat(0, 25, false, true, 66);

        // row 1
        scenarioStructure[1][0] = new Seat(1, 0, false, true, 57);
        scenarioStructure[1][1] = new Seat(1, 1, false, true, 61);
        scenarioStructure[1][2] = new Seat(1, 2, false, true, 65);
        scenarioStructure[1][3] = new Seat(1, 3, false, true, 69);
        scenarioStructure[1][4] = new Seat(1, 4, true, false, 0);
        scenarioStructure[1][5] = new Seat(1, 5, true, false, 0);
        scenarioStructure[1][6] = new Seat(1, 6, true, false, 0);
        scenarioStructure[1][7] = new Seat(1, 7, false, true, 85);
        scenarioStructure[1][8] = new Seat(1, 8, false, true, 89);
        scenarioStructure[1][9] = new Seat(1, 9, false, true, 93);
        scenarioStructure[1][10] = new Seat(1, 10, false, true, 97);
        scenarioStructure[1][11] = new Seat(1, 11, false, true, 97);
        scenarioStructure[1][12] = new Seat(1, 12, false, true, 97);
        scenarioStructure[1][13] = new Seat(1, 13, false, true, 97);
        scenarioStructure[1][14] = new Seat(1, 14, false, true, 97);
        scenarioStructure[1][15] = new Seat(1, 15, false, true, 97);
        scenarioStructure[1][16] = new Seat(1, 16, false, true, 94);
        scenarioStructure[1][17] = new Seat(1, 17, false, true, 91);
        scenarioStructure[1][18] = new Seat(1, 18, false, true, 88);
        scenarioStructure[1][19] = new Seat(1, 19, true, false, 0);
        scenarioStructure[1][20] = new Seat(1, 20, true, false, 0);
        scenarioStructure[1][21] = new Seat(1, 21, true, false, 0);
        scenarioStructure[1][22] = new Seat(1, 22, false, true, 76);
        scenarioStructure[1][23] = new Seat(1, 23, false, true, 73);
        scenarioStructure[1][24] = new Seat(1, 24, false, true, 70);
        scenarioStructure[1][25] = new Seat(1, 25, false, true, 67);

        // row 2
        scenarioStructure[2][0] = new Seat(2, 0, false, true, 58);
        scenarioStructure[2][1] = new Seat(2, 1, false, true, 62);
        scenarioStructure[2][2] = new Seat(2, 2, false, true, 66);
        scenarioStructure[2][3] = new Seat(2, 3, false, true, 70);
        scenarioStructure[2][4] = new Seat(2, 4, true, false, 0);
        scenarioStructure[2][5] = new Seat(2, 5, true, false, 0);
        scenarioStructure[2][6] = new Seat(2, 6, true, false, 0);
        scenarioStructure[2][7] = new Seat(2, 7, false, true, 86);
        scenarioStructure[2][8] = new Seat(2, 8, false, true, 90);
        scenarioStructure[2][9] = new Seat(2, 9, false, true, 94);
        scenarioStructure[2][10] = new Seat(2, 10, false, true, 98);
        scenarioStructure[2][11] = new Seat(2, 11, false, true, 98);
        scenarioStructure[2][12] = new Seat(2, 12, false, true, 98);
        scenarioStructure[2][13] = new Seat(2, 13, false, true, 98);
        scenarioStructure[2][14] = new Seat(2, 14, false, true, 98);
        scenarioStructure[2][15] = new Seat(2, 15, false, true, 98);
        scenarioStructure[2][16] = new Seat(2, 16, false, true, 95);
        scenarioStructure[2][17] = new Seat(2, 17, false, true, 92);
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][19] = new Seat(2, 19, true, false, 0);
        scenarioStructure[2][20] = new Seat(2, 20, true, false, 0);
        scenarioStructure[2][21] = new Seat(2, 21, true, false, 0);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);
        scenarioStructure[2][24] = new Seat(2, 24, false, true, 71);
        scenarioStructure[2][25] = new Seat(2, 25, false, true, 68);

        // row 3
        scenarioStructure[3][0] = new Seat(3, 0, false, true, 59);
        scenarioStructure[3][1] = new Seat(3, 1, false, true, 63);
        scenarioStructure[3][2] = new Seat(3, 2, false, true, 67);
        scenarioStructure[3][3] = new Seat(3, 3, false, true, 71);
        scenarioStructure[3][4] = new Seat(3, 4, true, false, 0);
        scenarioStructure[3][5] = new Seat(3, 5, true, false, 0);
        scenarioStructure[3][6] = new Seat(3, 6, true, false, 0);
        scenarioStructure[3][7] = new Seat(3, 7, false, true, 87);
        scenarioStructure[3][8] = new Seat(3, 8, false, true, 91);
        scenarioStructure[3][9] = new Seat(3, 9, false, true, 95);
        scenarioStructure[3][10] = new Seat(3, 10, false, true, 99);
        scenarioStructure[3][11] = new Seat(3, 11, false, true, 99);
        scenarioStructure[3][12] = new Seat(3, 12, false, true, 99);
        scenarioStructure[3][13] = new Seat(3, 13, false, true, 99);
        scenarioStructure[3][14] = new Seat(3, 14, false, false, 99);
        scenarioStructure[3][15] = new Seat(3, 15, false, false, 99);
        scenarioStructure[3][16] = new Seat(3, 16, false, true, 96);
        scenarioStructure[3][17] = new Seat(3, 17, false, true, 93);
        scenarioStructure[3][18] = new Seat(3, 18, false, true, 90);
        scenarioStructure[3][19] = new Seat(3, 19, true, false, 0);
        scenarioStructure[3][20] = new Seat(3, 20, true, false, 0);
        scenarioStructure[3][21] = new Seat(3, 21, true, false, 0);
        scenarioStructure[3][22] = new Seat(3, 22, false, true, 78);
        scenarioStructure[3][23] = new Seat(3, 23, false, true, 75);
        scenarioStructure[3][24] = new Seat(3, 24, false, true, 72);
        scenarioStructure[3][25] = new Seat(3, 25, false, true, 69);

        // row 4
        scenarioStructure[4][0] = new Seat(4, 0, false, true, 60);
        scenarioStructure[4][1] = new Seat(4, 1, false, true, 64);
        scenarioStructure[4][2] = new Seat(4, 2, false, false, 68);
        scenarioStructure[4][3] = new Seat(4, 3, false, true, 72);
        scenarioStructure[4][4] = new Seat(4, 4, true, false, 0);
        scenarioStructure[4][5] = new Seat(4, 5, true, false, 0);
        scenarioStructure[4][6] = new Seat(4, 6, true, false, 0);
        scenarioStructure[4][7] = new Seat(4, 7, false, true, 88);
        scenarioStructure[4][8] = new Seat(4, 8, false, true, 92);
        scenarioStructure[4][9] = new Seat(4, 9, false, true, 96);
        scenarioStructure[4][10] = new Seat(4, 10, false, true, 100);
        scenarioStructure[4][11] = new Seat(4, 11, false, true, 100);
        scenarioStructure[4][12] = new Seat(4, 12, false, true, 100);
        scenarioStructure[4][13] = new Seat(4, 13, false, true, 100);
        scenarioStructure[4][14] = new Seat(4, 14, false, true, 100);
        scenarioStructure[4][15] = new Seat(4, 15, false, true, 100);
        scenarioStructure[4][16] = new Seat(4, 16, false, true, 97);
        scenarioStructure[4][17] = new Seat(4, 17, false, true, 94);
        scenarioStructure[4][18] = new Seat(4, 18, false, true, 91);
        scenarioStructure[4][19] = new Seat(4, 19, true, false, 0);
        scenarioStructure[4][20] = new Seat(4, 20, true, false, 0);
        scenarioStructure[4][21] = new Seat(4, 21, true, false, 0);
        scenarioStructure[4][22] = new Seat(4, 22, false, true, 79);
        scenarioStructure[4][23] = new Seat(4, 23, false, true, 76);
        scenarioStructure[4][24] = new Seat(4, 24, false, true, 73);
        scenarioStructure[4][25] = new Seat(4, 25, false, true, 70);

        // row 5
        scenarioStructure[5][0] = new Seat(5, 0, false, true, 60);
        scenarioStructure[5][1] = new Seat(5, 1, false, false, 64);
        scenarioStructure[5][2] = new Seat(5, 2, false, true, 68);
        scenarioStructure[5][3] = new Seat(5, 3, false, true, 72);
        scenarioStructure[5][4] = new Seat(5, 4, true, false, 0);
        scenarioStructure[5][5] = new Seat(5, 5, true, false, 0);
        scenarioStructure[5][6] = new Seat(5, 6, true, false, 0);
        scenarioStructure[5][7] = new Seat(5, 7, false, true, 88);
        scenarioStructure[5][8] = new Seat(5, 8, false, true, 92);
        scenarioStructure[5][9] = new Seat(5, 9, false, true, 96);
        scenarioStructure[5][10] = new Seat(5, 10, false, true, 100);
        scenarioStructure[5][11] = new Seat(5, 11, false, true, 100);
        scenarioStructure[5][12] = new Seat(5, 12, false, true, 100);
        scenarioStructure[5][13] = new Seat(5, 13, false, true, 100);
        scenarioStructure[5][14] = new Seat(5, 14, false, true, 100);
        scenarioStructure[5][15] = new Seat(5, 15, false, true, 100);
        scenarioStructure[5][16] = new Seat(5, 16, false, true, 97);
        scenarioStructure[5][17] = new Seat(5, 17, false, true, 94);
        scenarioStructure[5][18] = new Seat(5, 18, false, true, 91);
        scenarioStructure[5][19] = new Seat(5, 19, true, false, 0);
        scenarioStructure[5][20] = new Seat(5, 20, true, false, 0);
        scenarioStructure[5][21] = new Seat(5, 21, true, false, 0);
        scenarioStructure[5][22] = new Seat(5, 22, false, true, 79);
        scenarioStructure[5][23] = new Seat(5, 23, false, true, 76);
        scenarioStructure[5][24] = new Seat(5, 24, false, true, 73);
        scenarioStructure[5][25] = new Seat(5, 25, false, true, 70);

        // row 6
        scenarioStructure[6][0] = new Seat(6, 0, false, true, 55);
        scenarioStructure[6][1] = new Seat(6, 1, false, true, 59);
        scenarioStructure[6][2] = new Seat(6, 2, false, true, 63);
        scenarioStructure[6][3] = new Seat(6, 3, false, true, 67);
        scenarioStructure[6][4] = new Seat(6, 4, true, false, 0);
        scenarioStructure[6][5] = new Seat(6, 5, true, false, 0);
        scenarioStructure[6][6] = new Seat(6, 6, true, false, 0);
        scenarioStructure[6][7] = new Seat(6, 7, false, true, 83);
        scenarioStructure[6][8] = new Seat(6, 8, false, true, 87);
        scenarioStructure[6][9] = new Seat(6, 9, false, true, 91);
        scenarioStructure[6][10] = new Seat(6, 10, false, true, 95);
        scenarioStructure[6][11] = new Seat(6, 11, false, true, 95);
        scenarioStructure[6][12] = new Seat(6, 12, false, true, 95);
        scenarioStructure[6][13] = new Seat(6, 13, false, true, 95);
        scenarioStructure[6][14] = new Seat(6, 14, false, true, 95);
        scenarioStructure[6][15] = new Seat(6, 15, false, true, 95);
        scenarioStructure[6][16] = new Seat(6, 16, false, false, 92);
        scenarioStructure[6][17] = new Seat(6, 17, false, true, 89);
        scenarioStructure[6][18] = new Seat(6, 18, false, true, 86);
        scenarioStructure[6][19] = new Seat(6, 19, true, false, 0);
        scenarioStructure[6][20] = new Seat(6, 20, true, false, 0);
        scenarioStructure[6][21] = new Seat(6, 21, true, false, 0);
        scenarioStructure[6][22] = new Seat(6, 22, false, true, 74);
        scenarioStructure[6][23] = new Seat(6, 23, false, true, 71);
        scenarioStructure[6][24] = new Seat(6, 24, false, true, 68);
        scenarioStructure[6][25] = new Seat(6, 25, false, true, 65);

        // row 7
        scenarioStructure[7][0] = new Seat(7, 0, false, true, 50);
        scenarioStructure[7][1] = new Seat(7, 1, false, true, 54);
        scenarioStructure[7][2] = new Seat(7, 2, false, true, 58);
        scenarioStructure[7][3] = new Seat(7, 3, false, true, 62);
        scenarioStructure[7][4] = new Seat(7, 4, true, false, 0);
        scenarioStructure[7][5] = new Seat(7, 5, true, false, 0);
        scenarioStructure[7][6] = new Seat(7, 6, true, false, 0);
        scenarioStructure[7][7] = new Seat(7, 7, false, true, 78);
        scenarioStructure[7][8] = new Seat(7, 8, false, true, 82);
        scenarioStructure[7][9] = new Seat(7, 9, false, true, 86);
        scenarioStructure[7][10] = new Seat(7, 10, false, true, 90);
        scenarioStructure[7][11] = new Seat(7, 11, false, true, 90);
        scenarioStructure[7][12] = new Seat(7, 12, false, true, 90);
        scenarioStructure[7][13] = new Seat(7, 13, false, true, 90);
        scenarioStructure[7][14] = new Seat(7, 14, false, true, 90);
        scenarioStructure[7][15] = new Seat(7, 15, false, true, 90);
        scenarioStructure[7][16] = new Seat(7, 16, false, true, 87);
        scenarioStructure[7][17] = new Seat(7, 17, false, true, 84);
        scenarioStructure[7][18] = new Seat(7, 18, false, true, 81);
        scenarioStructure[7][19] = new Seat(7, 19, true, false, 0);
        scenarioStructure[7][20] = new Seat(7, 20, true, false, 0);
        scenarioStructure[7][21] = new Seat(7, 21, true, false, 0);
        scenarioStructure[7][22] = new Seat(7, 22, false, true, 69);
        scenarioStructure[7][23] = new Seat(7, 23, false, true, 66);
        scenarioStructure[7][24] = new Seat(7, 24, false, true, 63);
        scenarioStructure[7][25] = new Seat(7, 25, false, true, 60);

        // row 8
        scenarioStructure[8][0] = new Seat(8, 0, false, true, 45);
        scenarioStructure[8][1] = new Seat(8, 1, false, true, 49);
        scenarioStructure[8][2] = new Seat(8, 2, false, true, 53);
        scenarioStructure[8][3] = new Seat(8, 3, false, true, 57);
        scenarioStructure[8][4] = new Seat(8, 4, true, false, 0);
        scenarioStructure[8][5] = new Seat(8, 5, true, false, 0);
        scenarioStructure[8][6] = new Seat(8, 6, true, false, 0);
        scenarioStructure[8][7] = new Seat(8, 7, false, true, 73);
        scenarioStructure[8][8] = new Seat(8, 8, false, true, 77);
        scenarioStructure[8][9] = new Seat(8, 9, false, true, 81);
        scenarioStructure[8][10] = new Seat(8, 10, false, true, 85);
        scenarioStructure[8][11] = new Seat(8, 11, false, true, 85);
        scenarioStructure[8][12] = new Seat(8, 12, false, true, 85);
        scenarioStructure[8][13] = new Seat(8, 13, false, true, 85);
        scenarioStructure[8][14] = new Seat(8, 14, false, true, 85);
        scenarioStructure[8][15] = new Seat(8, 15, false, true, 85);
        scenarioStructure[8][16] = new Seat(8, 16, false, true, 82);
        scenarioStructure[8][17] = new Seat(8, 17, false, true, 79);
        scenarioStructure[8][18] = new Seat(8, 18, false, true, 76);
        scenarioStructure[8][19] = new Seat(8, 19, true, false, 0);
        scenarioStructure[8][20] = new Seat(8, 20, true, false, 0);
        scenarioStructure[8][21] = new Seat(8, 21, true, false, 0);
        scenarioStructure[8][22] = new Seat(8, 22, false, true, 64);
        scenarioStructure[8][23] = new Seat(8, 23, false, true, 61);
        scenarioStructure[8][24] = new Seat(8, 24, false, true, 58);
        scenarioStructure[8][25] = new Seat(8, 25, false, true, 55);

        // row 9
        scenarioStructure[9][0] = new Seat(9, 0, false, true, 40);
        scenarioStructure[9][1] = new Seat(9, 1, false, true, 44);
        scenarioStructure[9][2] = new Seat(9, 2, false, true, 48);
        scenarioStructure[9][3] = new Seat(9, 3, false, true, 52);
        scenarioStructure[9][4] = new Seat(9, 4, true, false, 0);
        scenarioStructure[9][5] = new Seat(9, 5, true, false, 0);
        scenarioStructure[9][6] = new Seat(9, 6, true, false, 0);
        scenarioStructure[9][7] = new Seat(9, 7, false, true, 68);
        scenarioStructure[9][8] = new Seat(9, 8, false, true, 72);
        scenarioStructure[9][9] = new Seat(9, 9, false, true, 76);
        scenarioStructure[9][10] = new Seat(9, 10, false, true, 80);
        scenarioStructure[9][11] = new Seat(9, 11, false, true, 80);
        scenarioStructure[9][12] = new Seat(9, 12, false, true, 80);
        scenarioStructure[9][13] = new Seat(9, 13, false, true, 80);
        scenarioStructure[9][14] = new Seat(9, 14, false, true, 80);
        scenarioStructure[9][15] = new Seat(9, 15, false, false, 80);
        scenarioStructure[9][16] = new Seat(9, 16, false, true, 77);
        scenarioStructure[9][17] = new Seat(9, 17, false, true, 74);
        scenarioStructure[9][18] = new Seat(9, 18, false, true, 71);
        scenarioStructure[9][19] = new Seat(9, 19, true, false, 0);
        scenarioStructure[9][20] = new Seat(9, 20, true, false, 0);
        scenarioStructure[9][21] = new Seat(9, 21, true, false, 0);
        scenarioStructure[9][22] = new Seat(9, 22, false, true, 59);
        scenarioStructure[9][23] = new Seat(9, 23, false, true, 56);
        scenarioStructure[9][24] = new Seat(9, 24, false, true, 53);
        scenarioStructure[9][25] = new Seat(9, 25, false, true, 50);

        return scenarioStructure;
    }

    public static Seat[][] getScenarioWithoutSeatsAvailableWithAisleBetween() {
        Seat[][] scenarioStructure = new Seat[10][26];
        scenarioStructure = getScenarioWithoutAnyAvailableSeat();
        // row 4, three seats available but aisle between
        scenarioStructure[2][18] = new Seat(2, 18, false, true, 89);
        scenarioStructure[2][22] = new Seat(2, 22, false, true, 77);
        scenarioStructure[2][23] = new Seat(2, 23, false, true, 74);

        return scenarioStructure;
    }


    private static final SeatMap FULL_HOUSE_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap EMPTY_FIRST_ROW_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap EMPTY_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
    });

    private static final SeatMap THREE_CONSECUTIVE_AVALILABLE_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap BEST_SEATS_RESERVED_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - * * * * * * - - - / / / - - - -",
            "- - - - / / / - - - * * * * * * - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
            "- - - - / / / - - - - - - - - - - - - / / / - - - -",
    });

    private static final SeatMap SEATS_BLOCKED_BY_AISLE_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * - / / / - - * * * * * * - - - * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap MORE_THAN_ONCE_GROUP_OF_SEATS_IN_ROW_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * - / / / - - * * * * * * - - - * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * - - - * - - - * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap MORE_THAN_ONCE_GROUP_OF_SEATS_IN_FIRST_ROW_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * - / / / * - - - * - - - * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / - - - *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    private static final SeatMap SEAT_AVAILABLE_BEHIND_AISLE_SCENARIO_MAP = new SeatMap(DEFAULT_ROWS, DEFAULT_COLUMNS, new String[]{
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * - / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
            "* * * * / / / * * * * * * * * * * * * / / / * * * *",
    });

    public static Seat[][] fullHouseScenario() {
        return mapScenarioTransformer(FULL_HOUSE_SCENARIO_MAP);
    }

    public static Seat[][] emptyScenario() {
        return mapScenarioTransformer(EMPTY_SCENARIO_MAP);
    }

    public static Seat[][] threeConsecutiveAvalilableScenario() {
        return mapScenarioTransformer(THREE_CONSECUTIVE_AVALILABLE_SCENARIO_MAP);
    }

    public static Seat[][] bestSeatsReservedScenario() {
        return mapScenarioTransformer(BEST_SEATS_RESERVED_SCENARIO_MAP);
    }

    public static Seat[][] firstSeatsBlockedByAisleScenario() {
        return mapScenarioTransformer(SEATS_BLOCKED_BY_AISLE_SCENARIO_MAP);
    }

    public static Seat[][] moreThanOnceGroupOfSeatsInRow() {
        return mapScenarioTransformer(MORE_THAN_ONCE_GROUP_OF_SEATS_IN_ROW_SCENARIO_MAP);
    }

    public static Seat[][] moreThanOnceGroupOfSeatsInFirstRow() {
        return mapScenarioTransformer(MORE_THAN_ONCE_GROUP_OF_SEATS_IN_FIRST_ROW_SCENARIO_MAP);
    }

    public static Seat[][] emptyFirstRowScenario() {
        return mapScenarioTransformer(EMPTY_FIRST_ROW_SCENARIO_MAP);
    }

    public static Seat[][] seatAvailableBehindAilseScenario() {
        return mapScenarioTransformer(SEAT_AVAILABLE_BEHIND_AISLE_SCENARIO_MAP);
    }


    private static Seat[][] mapScenarioTransformer(SeatMap seatMap) {
        Seat[][] scenarioStructure = new Seat[seatMap.rows][seatMap.columns];
        for (int i = 0; i < seatMap.map.length; i++) {
            String[] columns = seatMap.map[i].split(SeatMap.SEAT_SEPARATOR);
            for (int j = 0; j < columns.length; j++) {
                String seatSymbol = columns[j];
                if (SeatMap.RESERVED_SYMBOL.equals(seatSymbol)) {
                    scenarioStructure[i][j] = createReserved(i, j, STANDARD_PREFERENCE_POINTS[i][j]);
                } else if (SeatMap.AVAILABLE_SYMBOL.equals(seatSymbol)) {
                    scenarioStructure[i][j] = createAvailable(i, j, STANDARD_PREFERENCE_POINTS[i][j]);
                } else if (SeatMap.AISLE_SYMBOL.equals(seatSymbol)) {
                    scenarioStructure[i][j] = createAisle(i, j);
                } else {
                    throw new IllegalArgumentException(String.format("Symbol not recognized %s", seatSymbol));
                }
            }
        }
        return scenarioStructure;
    }

    private static class SeatMap {

        private static final String SEAT_SEPARATOR = " ";

        private static final String RESERVED_SYMBOL = "*";
        private static final String AVAILABLE_SYMBOL = "-";
        private static final String AISLE_SYMBOL = "/";

        private final String[] map;
        private final int rows;
        private final int columns;

        private SeatMap(int rows, int columns, String[] map) {
            this.rows = rows;
            this.columns = columns;
            this.map = map;
        }

    }
}
