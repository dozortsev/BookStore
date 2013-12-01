package dozortsev.bookstore.util;

import java.util.Random;

public class Util {

        public static final String DATE_SEPARATOR = "-";

        private static Random rand = new Random();

        public static String getRandPassword() {
                return String.valueOf(rand.nextInt(1000000000));
        }

        public static int[] dateParser(String date) {

                int i = 0; int[] arrDate = new int[3];

                for (String s : date.split(DATE_SEPARATOR))
                        arrDate[i++] = Integer.valueOf(s);

                return arrDate;
        }
}
