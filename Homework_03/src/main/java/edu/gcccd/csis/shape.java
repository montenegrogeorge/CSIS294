package edu.gcccd.csis;

class Shape {
    protected int vertices;

    public Shape(final int n) {
        this.vertices = n;
    }

    public int getNumberOfVertices() {
        return vertices;
    }

    public String toString(final String s) {
        return String.format(s, vertices);
    }

    public static void main (String[] args) {
        System.out.println(new Shape(24).toString("%d"));
    }
}