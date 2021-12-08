package lab4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class LabTest {
    @Test
    public void WorkerNameTest() {
        new Worker.Builder().withName("Eugen").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void WorkerNameFailTest() {
        new Worker.Builder().withName("eugen").build();
    }

    @Test
    public void WorkerSurNameTest() {
        new Worker.Builder().withSurname("Grod").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void WorkerSurNameFailTest() {
        new Worker.Builder().withSurname("grod").build();
    }

    @Test
    public void WorkerMiddleNameTest() {
        new Worker.Builder().withMiddleName("Volodumurovich").build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void WorkerMiddleNameFailTest() {
        new Worker.Builder().withMiddleName("volodumurobich").build();
    }

    @Test
    public void WorkerAgeTest() {
        new Worker.Builder().withAge(23).build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void WorkerAgeFailTest() {
        new Worker.Builder().withAge(-5).build();
    }
}
