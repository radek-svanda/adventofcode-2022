package rsvanda.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {

    private final List<Rucksack> members = new ArrayList<>();

    public void add(Rucksack member) {
        members.add(member);
    }

    public int size() {
        return members.size();
    }

    public List<Rucksack> getMembers() {
        return Collections.unmodifiableList(members);
    }
}
