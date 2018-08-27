package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.util.Arrays;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private int openSites;
    private int size;
    private int outside;
    private int virtualTop;
    private int virtualBottom;

    public Percolation(int N) {
        size = N;
        outside = N * N;
        virtualTop = N * N + 1;
        virtualBottom = N * N + 2;
        grid = new WeightedQuickUnionUF(N * N + 2);
        for (int i = 0; i < size; i++) {
            grid.union(i, outside);
        }
        openSites = 0;
    }

    //the component of each open cell should be the lowest number row possible. Grab the min from 4 direction compar?
    //What is considered open in this case? Each site is initialized as its own number I think...
    //All sites need to be connected with an outsider component.
    public void open(int row, int col) {
        grid.union(xyTo1D(row, col), xyTo1D(row, col));
        if(row == 0) grid.union(xyTo1D(row, col), virtualTop);
        if(row == size) grid.union(xyTo1D(row, col), virtualBottom);

        if(isOpen(row - 1, col)) {
            grid.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if(isOpen(row + 1, col)) {
            grid.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if(isOpen(row, col - 1)) {
            grid.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if(isOpen(row, col + 1)) {
            grid.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }

        openSites ++;
    }

  public boolean isOpen(int row, int col) {
        return !grid.connected(xyTo1D(row, col), outside);
  }

  public int numberOfOpenSites() {
        return openSites;
  }

  public boolean percolates() {
        return grid.connected(virtualTop, virtualBottom);
  }

  public boolean isFull(int row, int col) {
        return grid.connected(xyTo1D(row, col), virtualTop);
  }

  public int xyTo1D(int row, int col) {
        return row * size + col;
  }
}
