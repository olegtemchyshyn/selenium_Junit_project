package ua.foxminded.skarb.utils;

public class TestUtilities {

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
