public class Exercise6 {
    public static class Rectangle {
        private double width;
        private double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return width + height;
        }
    }

    public static class Circle {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public double area() {
            return Math.pow(radius, 2);
        }

        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public static void main(String[] args) {
        System.out.println("+ Rectangle:");
        Rectangle rec = new Rectangle(10, 20);
        System.out.println("Width: " + rec.getWidth() + ", Height: " + rec.getHeight());
        System.out.println("Perimeter: " + rec.perimeter());
        System.out.println("Area: " + rec.area());
        System.out.println();

        System.out.println("+ Circle:");
        Circle cir = new Circle(5);
        System.out.println("Radius: " + cir.getRadius());
        System.out.println("Perimeter: " + cir.perimeter());
        System.out.println("Area: " + cir.area());
    }
}
