/**
 * Modified to include diagonal connections.
 * This effectively treats 8-connectivity as a single island.
 */
public class NumOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    // Sink the island using 8-directional DFS
                    sinkIsland8Way(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    private void sinkIsland8Way(char[][] grid, int r, int c) {
        // Boundary checks
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Mark as visited by sinking the land
        grid[r][c] = '0';

        // Iterate through all 8 possible neighbors
        // Row offsets: -1 to 1, Col offsets: -1 to 1
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                // Skip the case where dr=0 and dc=0 (the current cell itself)
                if (dr == 0 && dc == 0) continue;
                
                sinkIsland8Way(grid, r + dr, c + dc);
            }
        }
    }

    public static void main(String[] args) {
        NumOfIslands sol = new NumOfIslands();
        
        // Example where diagonals connect pieces into 1 island
        char[][] diagonalGrid = {
            {'1', '0', '1'},
            {'0', '1', '0'},
            {'1', '0', '1'}
        };

        // Standard 4-way DFS would return 5 islands.
        // This 8-way DFS will return 1 island.
        System.out.println("Number of islands (including diagonals): " + sol.numIslands(diagonalGrid));
    }
}
