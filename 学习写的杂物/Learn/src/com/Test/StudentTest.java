package com.Test;

import com.fanshe.student;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class StudentTest {
    @Test
    public void TestGetconstructor(){
        Class c = student.class;
        Constructor[] constructors =c.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor.getName() + "===>" + constructor.getParameterCount());
        }
    }
}
