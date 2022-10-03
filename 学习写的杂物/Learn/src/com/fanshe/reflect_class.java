package com.fanshe;

import static java.lang.Class.*;

public class reflect_class {
    public static void main(String[] args) throws Exception {
        Class c =Class.forName("com.fanshe.student");
        System.out.println(c);

    }

}
