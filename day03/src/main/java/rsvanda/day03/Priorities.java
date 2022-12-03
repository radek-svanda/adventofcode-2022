package rsvanda.day03;

public class Priorities {

    private Priorities() {
    }

    public static int priorityOf(char chr) {
        if (chr >= 'a') {
            return chr - 'a' + 1;
        } else {
            return chr - ('A' - 27);
        }
    }

}
