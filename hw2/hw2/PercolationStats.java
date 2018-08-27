package hw2;

public class PercolationStats {
    double[] stats;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if(N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N and T must be above 0");
        }
        stats = new double[T];
        for(int i = 0; i < T; i++) {
            Percolation percolation = pf.make(N);
            while(!percolation.percolates()) {
                int row = (int) (Math.random() * N);
                int col = (int) (Math.random() * N);
                percolation.open(row, col);
            }
            stats[i] = (double) percolation.numberOfOpenSites() / (N * N);
        }
    }

    public double mean() {
        double total = 0;
        for (int i = 0; i < stats.length; i++) {
            total += stats[i];
        }
        return total / stats.length;
    }

    public double stddev() {
        double total = 0;
        double mean = mean();
        for(int i = 0; i < stats.length; i++) {
            total += Math.pow((stats[i] - mean), 2);
        }
        return total / (stats.length - 1);
    }

    public double confidenceLow() {
        return mean() - (1.96 * stddev() / Math.sqrt(stats.length));
    }

    public double confidenceHigh() {
        return mean() + (1.96 * stddev() / Math.sqrt(stats.length));
    }

    public static void main(String[] args) {
        PercolationFactory percFac = new PercolationFactory();
        PercolationStats percStats = new PercolationStats(10, 5, percFac);
        System.out.println(percStats.mean());
        System.out.println(percStats.stddev());
        System.out.println(percStats.confidenceLow());
        System.out.println(percStats.confidenceHigh());
    }
}

