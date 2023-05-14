import java.util.ArrayList;
import java.util.List;

public class DepthFirst {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path) {
        if(maze[x][y] == 9) {
            //we successfully reached our destination
            path.add(x);
            path.add(y);
            return true;
        }

        if(maze[x][y] == 0) {
            //we have to try moving all four direction
            maze[x][y] = 2;
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if(searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if(searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if(searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

        }

        return false;
    }
}
