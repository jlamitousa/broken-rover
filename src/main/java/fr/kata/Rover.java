package fr.kata;

public class Rover {
    private int x;
    private int y;
    private Orientation direction;

    public void setX(int i) {
        x = i;
    }

    public void setY(int i) {
        y = i;
    }

    public void setOrientation(Orientation d) {
        direction = d;
    }

    public void process(String commands) {
        for (Character c : commands.toCharArray()) {
            switch (c) {
                case 'R':
                    switch (direction) {
                        case NORTH:
                            direction = Orientation.EAST;
                            break;
                        case EAST:
                            direction = Orientation.SOUTH;
                            break;
                        case SOUTH:
                            direction = Orientation.WEST;
                            break;
                        case WEST:
                            direction = Orientation.NORTH;
                            break;
                    }
                    break;
                case 'L':
                    switch (direction) {
                        case NORTH:
                            direction = Orientation.WEST;
                            break;
                        case WEST:
                            direction = Orientation.SOUTH;
                            break;
                        case SOUTH:
                            direction = Orientation.EAST;
                            break;
                        case EAST:
                            direction = Orientation.NORTH;
                            break;
                    }
                    break;
                case 'F':
                    switch (direction) {
                        case NORTH:
                            y++;
                            break;
                        case WEST:
                            x--;
                            break;
                        case SOUTH:
                            y--;
                            break;
                        case EAST:
                            x++;
                            break;
                    }
                    break;
            }
        }

        if (x == -1) {
            x = 0;
        }

        if (y == -1) {
            y = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return direction;
    }
}
