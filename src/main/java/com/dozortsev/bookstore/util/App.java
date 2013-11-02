package com.dozortsev.bookstore.util;

import java.util.HashMap;
import java.util.Map;


public class App {

        public static void main(String[] args) {

                HashMap<String, Boolean> map = new HashMap<String, Boolean>() {
                        {
                                put("1 book", true);
                                put("2 book", false);
                                put("6 book", true);
                        }
                };

                for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + "\t" + entry.getValue());
                }
        }
}
