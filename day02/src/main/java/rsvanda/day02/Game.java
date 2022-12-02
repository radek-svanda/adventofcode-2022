package rsvanda.day02;

public class Game {

    Hand me;
    Hand them;

    public Game(Hand me, Hand them) {
        this.me = me;
        this.them = them;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "them=" + them +
                ", me=" + me +
                '}';
    }

    public Integer score() {
        return me.getScore() + me.challenge(them).getScore();
    }

}
