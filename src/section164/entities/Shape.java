package section164.entities;

import section164.entities.enums.Color;

public abstract class Shape {
    private Color color;

    public Shape() {
    }
    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double area(); //método abstrato, pois cada area depende da forma da forma que está sendo calculada
                                    //isso obriga as classes extendidas a implementar o método área com sua devida fórmula
}
