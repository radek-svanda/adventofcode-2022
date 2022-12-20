package rsvanda.day13;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static rsvanda.day13.ListItem.read;

class ListItemTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "[1,1,3,1,1]",
            "[[1],[2,3,4]]",
            "[[[]]]",
            "[1,[2,[3,[4,[5,6,7]]]],8,9]",
            "[[10]]",
            "[[3,[],[7,4,8,[]],1]]"
    })
    void parser(String source) {
        assertEquals(source, read(source).asString());
    }


    @ParameterizedTest
    @ValueSource(strings = {
            """
                    [1,1,3,1,1]
                    [1,1,5,1,1]
                    """,
            """
                    [[1],[2,3,4]]
                    [[1],4]
                    """,
            """
                    [[4,4],4,4]
                    [[4,4],4,4,4]
                    """,
            """
                    []
                    [3]
                    """,
            """
                    [[8,[[7,10,10,5],[8,4,9]],3,5],[[[3,9,4],5,[7,5,5]],[[3,2,5],[10],[5,5],0,[8]]],[4,2,[],[[7,5,6,3,0],[4,4,10,7],6,[8,10,9]]],[[4,[],4],10,1]]
                    [[[[8],[3,10],[7,6,3,7,4],1,8]]]
                    """,
            """
                    [[],1]
                    [[],2]""",
            """
                    [[8,[[7,10,10,5],[8,4,9]],3,5],[[[3,9,4],5,[7,5,5]],[[3,2,5],[10],[5,5],0,[8]]],[4,2,[],[[7,5,6,3,0],[4,4,10,7],6,[8,10,9]]],[[4,[],4],10,1]]
                    [[[[8],[3,10],[7,6,3,7,4],1,8]]]
                    """

    })
    void correct(String input) {
        String[] chunks = input.split("\n");
        assertTrue(
                new ItemPair(read(chunks[0]), read(chunks[1])).correctOrder()
        );
        assertFalse(
                new ItemPair(read(chunks[1]), read(chunks[0])).correctOrder()
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            """
                    [9]
                    [[8,7,6]]
                    """,
            """
                    [7,7,7,7]
                    [7,7,7]
                    """,
            """
                    [[[]]]
                    [[]]
                    """,
            """
                    [1,[2,[3,[4,[5,6,7]]]],8,9]
                    [1,[2,[3,[4,[5,6,0]]]],8,9]
                    """,
            """
                    [[8,[[7]]]]
                    [[[[8]]]]"""
    })
    void incorrect(String input) {
        String[] chunks = input.split("\n");
        assertFalse(
                new ItemPair(read(chunks[0]), read(chunks[1])).correctOrder()
        );
        assertTrue(
                new ItemPair(read(chunks[1]), read(chunks[0])).correctOrder()
        );
    }

}