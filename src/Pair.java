public class Pair {
    public int first;
    public int second;

    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
