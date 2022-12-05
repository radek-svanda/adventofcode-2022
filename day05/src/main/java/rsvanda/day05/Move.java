package rsvanda.day05;

public record Move (

    Integer count,
    Integer from,
    Integer to

) {

    public static Move parse(String row) {
        String[] chunks = row.split(" ");
        return new Move(
                Integer.parseInt(chunks[1]),
                Integer.parseInt(chunks[3]),
                Integer.parseInt(chunks[5])
        );
    }

}
