package hw2;

public class TestPercolationStats {
    public static void main(String[] args) {
        PercolationFactory percFac = new PercolationFactory();
        PercolationStats percStats = new PercolationStats(10, 5, percFac);
        System.out.println(percStats.mean());
    }
}
