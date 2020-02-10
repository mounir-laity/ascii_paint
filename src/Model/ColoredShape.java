package Model;

/**
 *
 * @author laity
 */
public abstract class ColoredShape implements Shape {

    private char color;

    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.color;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColoredShape other = (ColoredShape) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }
    
    

}
