package dozortsev.bookstore.util;

import java.util.Random;

public class ClientUtil {

        private static final String BACKSPACE = " ";

        private static final Integer MIN_LENGTH = 5;
        private static final Integer MAX_LENGTH = 15;

        private static Random rand = new Random();

        public static String getRandPassword() {
                return String.valueOf(rand.nextInt(1000000000));
        }

        public static Boolean isPasswordAccept(String pwd) {

                if (pwd.contains(BACKSPACE)) return false;

                int len = pwd.length();

                if (MIN_LENGTH > len || len > MAX_LENGTH)
                        return false;

                return true;
        }
}
