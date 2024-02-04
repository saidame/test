public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public Double calculateArea(){
        return length * width;
    }
    public void displayInfo(){
        System.out.println("Rectangle Dimensions: Length = " + length + ", Width = " + width);
        System.out.println("Rectangle Area: " + calculateArea());
    }
    public static void main(String[] args) {
        // Creating a Rectangle object with length 5.0 and width 3.0
        Rectangle myRectangle = new Rectangle(5.0, 3.0);

        // Displaying information about the rectangle
        myRectangle.displayInfo();
    }
}
