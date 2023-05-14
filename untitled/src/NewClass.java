import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass extends JFrame {
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public List<Integer> path = new ArrayList<>();

    public NewClass() {
        setTitle("Maze Solver");
        setSize(640, 720);
        DepthFirst.searchPath(maze, 1, 1,path);
        System.out.println(path);
    }

    //we can use the inbuilt Graphics object to create the graphics for the maze
    @Override
    public void paint(Graphics g) {
        //for placing the grid center of the screen
        g.translate(50, 50);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1 : color = Color.BLACK;break;
                    case 9 : color = Color.RED;break;
                    default: color = Color.white;break;
                }

                g.setColor(color);
                //filling the rectangle with that specified color
                g.fillRect(30 * j, 30 * i, 30, 30);
                //now we have to set the boundary color to distinguish each grid
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }

        for (int i = 0; i < path.size(); i = i + 2) {
            int pathy = path.get(i);
            int pathx = path.get(i + 1);

            System.out.println("X coordinate - " + pathx);
            System.out.println("Y coordinate - " + pathy);

            g.setColor(Color.green);
            g.fillRect(30 * pathx, 30 * pathy, 20, 20);
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
