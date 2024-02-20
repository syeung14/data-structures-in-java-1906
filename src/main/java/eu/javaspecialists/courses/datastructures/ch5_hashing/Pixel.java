package eu.javaspecialists.courses.datastructures.ch5_hashing;

public record Pixel(int x, int y) implements Comparable<Pixel> {
    @Override
    public int hashCode() {
        return x * 1080 + y;
        // return x << 16 ^ y;
        // return ("" + x + "-" + y).hashCode();
    }

    @Override
    public int compareTo(Pixel o) {
        int result = Integer.compare(x, o.x);
        if (result != 0) return result;
        return Integer.compare(y, o.y);
    }
}
