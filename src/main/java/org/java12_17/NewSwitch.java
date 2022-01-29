package org.java12_17;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class NewSwitch {

    /* Compared to a traditional switch, the new switch expression

    Uses “->” instead of “:”
    Allows multiple constants per case
    Does not have fall-through semantics (i.e., doesn’t require breaks)
    Makes variables defined inside a case branch local to this branch

    Moreover, the compiler guarantees switch exhaustiveness in that
    exactly one of the cases gets executed, meaning that either:
    - All possible values are listed as cases (as with the above enum consisting of eight planets), or
    - A “default” branch has to be provided

*/

    public static void main(String[] args) {
        // assign the group of the given planet to a variable
        String planet = "MERCURY";
        String group = switch (planet) {
            case "MERCURY", "VENUS", "EARTH", "MARS" -> "inner planet";
            case "JUPITER", "SATURN", "URANUS", "NEPTUNE" -> "outer planet";
            default -> "whatever";
        };

        System.out.println(group);

        // replaces this:
        if(planet.equals("MERCURY") || planet.equals("VENUS"))
            group = "inner planet";
        else if (planet.equals("JUPITER") || planet.equals("SATURN"))
            group = "outer planet";

        //-------------------------------------------------------------------------
        /* If the right-hand side of a single case requires more code, it can be written inside a block,
        and the value returned using yield: */

        // print the group of the given planet, and some more info,
        // and assign the group of the given planet to a variable
        String group2 = switch (planet) {
            case "MERCURY", "VENUS" -> {
                System.out.println("inner planet");
                System.out.println("made up mostly of rock");
                yield "inner";
            }
            case "JUPITER", "SATURN" -> {
                System.out.println("outer planet");
                System.out.println("ball of gas");
                yield "outer";
            }
            default -> throw new IllegalStateException("Unexpected value");
        };

        System.out.println(group2);

        //------------- switching with the new arrow labels does not require returning a value, just like a void expression:
        switch (planet) {
            case "MERCURY", "VENUS" -> System.out.println("inner planet");
            case "JUPITER", "SATURN" -> System.out.println("outer planet");
        }

        // old
        switch (planet) {
            case "MERCURY", "VENUS": System.out.println("inner planet");
            case "JUPITER", "SATURN": System.out.println("outer planet");
        }



        // OLD VERSION
        // public enum DayOfWeek
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        String typeOfDay = "";
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                typeOfDay = "Working Day";
                break;
            case SATURDAY:
            case SUNDAY:
                typeOfDay = "Day Off";
        }

        typeOfDay = switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };

    }

    public void whenSwitchingOnOperationSquareMe_thenWillReturnSquare() {
        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                yield me * 2;
            }
            case "squareMe" -> {
                yield me * me;
            }
            default -> me;
        };

        //assertEquals(16, result);
    }

    private void daysOfWeek(String day){
        boolean isTodayHoliday = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };
    }
}
