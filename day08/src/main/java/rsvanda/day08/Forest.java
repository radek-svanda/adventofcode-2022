package rsvanda.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record Forest(Collection<Tree> trees) {

    public Collection<Tree> getVisible() {
        return trees.stream().filter(Tree::isVisible).toList();
    }

    public int maxView() {
        return trees.stream().mapToInt(Tree::view).max().orElse(-1);
    }

    public static Forest read(InputStream stream) {
        List<List<Tree>> grid = readStream(stream);
        for (int y = 0; y < grid.size(); y++) {
            List<Tree> thisRow = grid.get(y);
            for (int x = 0; x < grid.get(y).size(); x++) {
                Tree thisTree = thisRow.get(x);
                if (y > 0) {
                    thisTree.setUp(grid.get(y - 1).get(x));
                }
                if (x > 0) {
                    thisTree.setLeft(thisRow.get(x - 1));
                }
            }
        }
        return new Forest(grid.stream().flatMap(Collection::stream).toList());
    }

    private static List<List<Tree>> readStream(InputStream stream) {
        List<List<Tree>> grid = new ArrayList<>();
        try (var buffer = new BufferedReader(new InputStreamReader(stream))) {

            String line;
            while ((line = buffer.readLine()) != null) {
                grid.add(line.chars()
                        .map(it -> it - 48)
                        .mapToObj(Tree::new)
                        .toList()
                );
            }

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return grid;
    }

}