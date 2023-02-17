
public class SquarePyramid {
	private int id;
    private static int nextId;
    private double side;
    private double height;

    public SquarePyramid(){
        this.id = nextId;
        nextId++; 
    }

    public SquarePyramid(double side, double height) {
        this.side = side;
        this.height = height;
        this.id = nextId;
        nextId++;
    }
    
    public double getSide(){
        return this.side;
    }
    
    public void setSide(double side) {
        this.side = side;
        return;
    }
    
    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
        return;
    }

    public double getVolume(){
        return 1/3 * side * side * height;
    }

    public double getSurfaceArea(){
        return Math.pow(side, 2) + 2 * side * Math.sqrt(Math.pow(side, 2) / 4 + Math.pow(height, 2));
    }

    public int getID(){
        return this.id;
    }

    public static void main(String[] args) {
        SquarePyramid a1 = new SquarePyramid(1, 1);
        SquarePyramid a2 = new SquarePyramid(2, 2);
        SquarePyramid a3 = new SquarePyramid(2, 2);
        System.out.println(a1.getID() + " " + a2.getID()+ " " + a3.getID());
    }
}
