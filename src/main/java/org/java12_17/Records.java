package org.java12_17;

public class Records {

    private record Customer(String name, int age) {
    }

    public static void main(String[] args) {

        record Point(int x, int y) {
        }
        /*This one-liner results in a record class that automatically defines
                Fields for x and y (both private and final)
                A canonical constructor for all fields
                Getters for all fields
                equals, hashCode, and toString (taking all fields into account)
        */

        // canonical constructor
        Point p = new Point(1, 2);

        // getters - without "get" prefix
        p.x();
        p.y();

        // equals / hashCode / toString
        p.equals(new Point(1, 2)); // true
        p.hashCode();              // depends on values of x and y
        p.toString();           // Point[x=1, y=2]


        /* Some of the most important restrictions of record classes are that they

    Are immutable (since their fields are private and final)
    Are implicitly final
    Cannot define additional instance fields
    Always extend the Record class

        However, it is possible to

    Define additional methods
    Implement interfaces
    Customize the canonical constructor and accessors
*/
        record PointImproved(int x, int y)  {

            // constructor - we can add validation & adjustments
            PointImproved {
                if (x < 0 || y < 0)
                    throw new IllegalArgumentException("no negative points allowed");

                x += 1000;
                y += 1000;
                // assignment to fields happens automatically at the end
            }

            // explicit accessor
            public int getX() {
                // custom code here...
                return this.x;
            }

            // explicit accessor
            public int setX(int x) {
                // custom code here...
                // this.x = x; not possible - fields are final!!!!!!!!!!!!!!!!!!!!!!!11
                return 2 + x;
            }

        }
    }

    // it is possible to define a local record inside a method:
    public void withLocalRecord() {
        record Point(int x, int y) { };
        Point p = new Point(1, 2);
    }


}
