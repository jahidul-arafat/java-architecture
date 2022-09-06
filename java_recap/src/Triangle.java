public class Triangle {
    // class variables - <static>
    public final static int howManySidesOfATriangle=3;

    // instance variable - <non-static>
    private final double base;
    private final double height;
    private final double sideLenOne;
    private final double sideLenTwo;
    private final double sideLenThree;

    // class method - <static>
    // class_method_01: myClassMethod()
    public static String myClassMethod(String name){
        return name;
    }

    public Triangle(double base,
                    double height,
                    double sideLenOne,
                    double sideLenTwo,
                    double sideLenThree)
    {
        this.base = base;
        this.height = height;
        this.sideLenOne = sideLenOne;
        this.sideLenTwo = sideLenTwo;
        this.sideLenThree = sideLenThree;
        
    }

    // instance Method - <non-static>
    // instance_method_01: findArea()
    public double findArea(){
        return (this.base * this.height)/2;
    }

    // instance_method_02: calculateTriangleType()
    public String calculateTriangleType(){
        return null;
    }

    @Override
    public String toString(){
        String output= "{Triangle +\n"+
                "no_of_sides= "+ howManySidesOfATriangle +"\n" +
                "base= " + this.base +"\n"+
                "height= "+ this.height + "\n"+
                "side_len_one= "+ this.sideLenOne+"\n"+
                "side_len_two= "+ this.sideLenTwo+"\n"+
                "side_len_one= "+ this.sideLenThree+"\n";
        return output;
    }
}
