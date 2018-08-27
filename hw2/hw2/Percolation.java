package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF full;
    private int openSites;
    private int size;
    private int virtualTop;
    private int virtualBottom;
    private boolean percolated;
    private int[] trackOpen;

    public Percolation(int N) {
        size = N;
        virtualTop = N * N;
        virtualBottom = N * N + 1;
        percolated = false;
        grid = new WeightedQuickUnionUF(N * N + 2);
        full = new WeightedQuickUnionUF(N * N + 1);
        trackOpen = new int[N * N];
        openSites = 0;
    }

    public void open(int row, int col) {
        if(isOpen(row, col)) return;
        trackOpen[xyTo1D(row, col)] = 1;
        if(row == 0) {
            grid.union(xyTo1D(row, col), virtualTop);
            full.union(xyTo1D(row, col), virtualTop);
        }
        if(row == size - 1) grid.union(xyTo1D(row, col), virtualBottom);

        if((row - 1 > 0) && isOpen(row - 1, col)) {
            grid.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            full.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if((row + 1 < size) && isOpen(row + 1, col)) {
            grid.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            full.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if((col - 1 > 0) && isOpen(row, col - 1)) {
            grid.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            full.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if((col + 1 < size) && isOpen(row, col + 1)) {
            grid.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            full.union(xyTo1D(row, col), xyTo1D(row, col + 1));

        }
        openSites++;
    }

  public boolean isOpen(int row, int col) {
        return trackOpen[xyTo1D(row, col)] == 1;
  }

  public int numberOfOpenSites() {
        return openSites;
  }

  public boolean percolates() {
        percolated = grid.connected(virtualTop, virtualBottom);
        return percolated;
  }

  public boolean isFull(int row, int col) {
        return full.connected(xyTo1D(row, col), virtualTop);
  }

  public int xyTo1D(int row, int col) {
        return row * size + col;
  }
}
