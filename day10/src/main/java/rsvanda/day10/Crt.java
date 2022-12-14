package rsvanda.day10;

public class Crt implements Timed {

    private final Cpu cpu;
    private final Sprite sprite = new Sprite();

    private int position = 0;

    public Crt(Cpu cpu) {
        this.cpu = cpu;
    }

    @Override
    public void tick() {
        if (position >= 40) {
            position = 0;
            System.out.println();
        }
        sprite.moveTo(cpu.x());
        draw();
        position += 1;
    }

    private void draw() {
        char c = sprite.isVisibleAt(position) ? '#' : '.';
        System.out.print(c);
    }
}
