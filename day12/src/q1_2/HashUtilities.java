package q1_2;

public class HashUtilities {

    public int shortHash(int input) {
        return Math.abs(input % 1000);
    }

}