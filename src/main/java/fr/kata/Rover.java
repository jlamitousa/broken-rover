package fr.kata;

public class Rover {
    private int x;
    private int y;
    private String direction;

    public void setX(int i) {
        x = i;
    }

    public void setY(int i) {
        y = i;
    }

    public void setOrientation(String s) {
        direction = s;
    }

    public void process(String commands) {
        for (Character c : commands.toCharArray()) {
            switch (c) {
                case 'R':
                    switch (direction) {
                        case "NORTH":
                            direction = "EAST";
                            break;
                        case "EAST":
                            direction = "SOUTH";
                            break;
                        case "SOUTH":
                            direction = "OUEST";
                            break;
                    }
                    break;
                case 'L':
                    switch (direction) {
                        case "NORTH":
                            direction = "WEST";
                            break;
                        case "WEST":
                            direction = "SOUTH";
                            break;
                        case "SOUTH":
                            direction = "EAST";
                            break;
                        case "EAST":
                            direction = "NORTH";
                            break;
                    }
                    break;
                case 'F':
                    switch (direction) {
                        case "NORTH":
                            y++;
                            break;
                        case "WEST":
                            x--;
                            break;
                        case "SOUTH":
                            y--;
                            break;
                        case "EAST":
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

    public String getOrientation() {
        return direction;
    }
}
