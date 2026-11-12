import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    public static class Shape {
        protected double area() {
            return 0;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.pow(radius, 2) * Math.PI;
        }
    }

    public static class Rectangle extends Shape {
        private double a;
        private double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double area() {
            return a * b;
        }
    }

    public static class Triangle extends Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double area() {
            return (base * height) / 2;
        }
    }

    public static void main(String[] args) {
        List<Shape> areas = new ArrayList<>();
        
        areas.add(new Circle(10));
        areas.add(new Rectangle(2.5, 3.5));
        areas.add(new Triangle(5.5, 1.25));

        System.out.println("Areas:");
        for (Shape area : areas)
            System.out.printf("- %.2f unit area\n", area.area());
    }
}
