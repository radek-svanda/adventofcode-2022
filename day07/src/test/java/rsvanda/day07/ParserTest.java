package rsvanda.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ParserTest {

    private final String source = """
            $ cd /
            $ ls
            dir a
            14848514 b.txt
            8504156 c.dat
            dir d
            $ cd a
            $ ls
            dir e
            29116 f
            2557 g
            62596 h.lst
            $ cd e
            $ ls
            584 i
            $ cd ..
            $ cd ..
            $ cd d
            $ ls
            4060174 j
            8033020 d.log
            5626152 d.ext
            7214296 k
            """;

    Parser parser = new Parser();

    @Test
    void testCollect() {
        var list = Arrays.stream(source.split("\n")).toList();
        parser.parse(list);
        DirectoryDumper.dump(parser.root());
        Assertions.assertEquals(48381165, parser.root().size());
    }

    @Test
    void collectDirs() {
        parser.parse(Arrays.stream(source.split("\n")).toList());
        List<Node.Dir> dirs = parser.root().getDirs();
        Assertions.assertAll(
                () -> Assertions.assertEquals(4, dirs.size())
        );
    }

}