package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestClassDescriptionLernejoTests {




    @Test
    public void ListMethodTest() throws NoSuchMethodException {

        final List<Method> expected = new ArrayList<Method>(Arrays.asList(
            SomeLernejoTests.class.getMethod("ok"),
            SomeLernejoTests.class.getMethod("ko")));
        List<Method> test = new TestClassDescription(SomeLernejoTests.class).listTestMethods();
        Assert.assertEquals(expected, test);


    }


}
