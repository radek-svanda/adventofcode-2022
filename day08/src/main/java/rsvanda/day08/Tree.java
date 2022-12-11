package rsvanda.day08;

import java.util.Objects;
import java.util.function.UnaryOperator;

public final class Tree {
    private final int height;
    private Tree left;
    private Tree right;
    private Tree up;
    private Tree down;

    public Tree(int height) {
        this.height = height;
    }

    public Tree left() {
        return left;
    }

    public Tree right() {
        return right;
    }

    public Tree up() {
        return up;
    }

    public Tree down() {
        return down;
    }

    public void setLeft(Tree that) {
        this.left = that;
        that.right = this;
    }

    public void setUp(Tree that) {
        this.up = that;
        that.down = this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Tree) obj;
        return this.height == that.height &&
                this.left == that.left &&
                this.right == that.right &&
                this.up == that.up &&
                this.down == that.down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, left, right, up, down);
    }

    @Override
    public String toString() {
        return "Orange[" +
                "height=" + height + ", " +
                "right=" + right + ", " +
                "down=" + down + ']';
    }

    public boolean isVisible() {
        return visible(Tree::right)
                || visible(Tree::left)
                || visible(Tree::up)
                || visible(Tree::down);
    }

    public int view() {
        return view(Tree::right)
                * view(Tree::left)
                * view(Tree::up)
                * view(Tree::down);
    }

    private int view(UnaryOperator<Tree> next) {
        Tree current = next.apply(this);
        int i = 0;
        while (current != null) {
            i += 1;
            if (current.height >= this.height) {
                return i;
            }
            current = next.apply(current);
        }
        return i;
    }

    private boolean visible(UnaryOperator<Tree> next) {
        Tree current = next.apply(this);
        while (current != null) {
            if (current.height >= this.height) {
                return false;
            }
            current = next.apply(current);
        }
        return true;
    }
}
