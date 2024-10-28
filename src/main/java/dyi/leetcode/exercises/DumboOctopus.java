package dyi.leetcode.exercises;

public class DumboOctopus {//TODO migrate to leetcode class

    private static int dumboOctopus(int[][] octopi, int steps) {
        int totalFlashes = 0;

        for (int step = 0; step < steps; step++) {

            boolean[][] hasFlashed = new boolean[octopi.length][octopi[0].length];

            //increase all octopi
            for (int i = 0; i < octopi.length; i++) {
                for (int j = 0; j < octopi[0].length; j++) {
                    octopi[i][j]++;
                }
            }

            for (int i = 0; i < octopi.length; i++) {
                for (int j = 0; j < octopi[0].length; j++) {
                    if (octopi[i][j] > 9) {
                        totalFlashes += flashOctopus(octopi, i, j, hasFlashed);
                    }
                }
            }
        }

        return totalFlashes;
    }

    private static int flashOctopus(int[][] octopi, int i, int j, boolean[][] hasFlashed) {
        if (i < 0 || i >= octopi.length || j < 0 || j >= octopi[0].length || hasFlashed[i][j]) {
            return 0;
        }

        int flashes = 0;

        if (octopi[i][j] > 9) {
            hasFlashed[i][j] = true;
            octopi[i][j] = 0;
            flashes++;

            //coordinates of octopi impacted by flash
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int d = 0; d < 8; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];

                //only propagate if the neighbor hasn't flashed yet
                if (ni >= 0 && ni < octopi.length && nj >= 0 && nj < octopi[0].length && !hasFlashed[ni][nj]) {
                    octopi[ni][nj]++;  // Increase energy of the neighbor
                    flashes += flashOctopus(octopi, ni, nj, hasFlashed);  // Recursively flash if necessary
                }
            }
        }

        return flashes;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {5, 4, 8, 3, 1, 4, 3, 2, 2, 3},
                {2, 7, 4, 5, 8, 5, 4, 7, 1, 1},
                {5, 2, 6, 4, 5, 5, 6, 1, 7, 3},
                {6, 1, 4, 1, 3, 3, 6, 1, 4, 6},
                {6, 3, 5, 7, 3, 8, 5, 4, 7, 8},
                {4, 1, 6, 7, 5, 2, 4, 6, 4, 5},
                {2, 1, 7, 6, 8, 4, 1, 7, 2, 1},
                {6, 8, 8, 2, 8, 8, 1, 1, 3, 4},
                {4, 8, 4, 6, 8, 4, 8, 5, 5, 4},
                {5, 2, 8, 3, 7, 5, 1, 5, 2, 6}
        };

        int steps = 100;
        int totalFlashes = dumboOctopus(grid, steps);

        System.out.println("Total flashes after " + steps + " steps: " + totalFlashes);
    }
}
