package rsvanda.day13;

import java.util.List;

public class Task1 {

    private final List<ItemPair> pairs;

    public Task1(List<ItemPair> pairs) {
        this.pairs = pairs;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).correctOrder()) {
                score += i + 1;
            }
        }
        return score;
    }

    public List<ItemPair> getPairs() {
        return pairs;
    }
}
