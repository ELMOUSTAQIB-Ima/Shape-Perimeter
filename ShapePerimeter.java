import edu.duke.*;
import java.io.File;
import java.la

public class ShapePerimeter {
    
    public java.lang.Iterable<java.io.File> selectedFiles(){}

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int  getNumPoints (Shape s) {
        int NumPoints = 0;
        /*FileResource fr = new FileResource();
        Shape s = new Shape(fr);*/
        for(Point P :s.getPoints())
        {
            NumPoints++;
        }
        System.out.println("NumPoints = " + NumPoints);
        return NumPoints;
    }

    public void getAverageLength() {
        
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double LengthSides = getPerimeter(s);
        int NumSides = getNumPoints(s);
        double AverageLength = LengthSides / NumSides;
        
        System.out.println("AverageLength = " + AverageLength);
        
        //return AverageLength;
    }

    public void getLargestSide() {
        // return the longest side in the Shape S
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double LongestSide = 0.0;
        // Start with prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update prevPt to be currPt
            prevPt = currPt;
        if ( currDist > LongestSide){
            LongestSide = currDist;
        }    
        }
         
        System.out.println(" LongestSide = " + LongestSide );
        
        
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public void getLargestPerimeterMultipleFiles() {
        /*CREATE a DirectoryResource (so you can select multiple files)
        and then iterates over thes files */
        double LargestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        FileResource fr = null;
        
        for(File f : dr.selectedFiles()){
            fr = new FileResource(f);
            Shape s = new Shape(fr);
            double ShapePerimeter = getPerimeter(s);
            if(ShapePerimeter > LargestPerimeter){
               LargestPerimeter = ShapePerimeter;
            }
            
        }
        
        System.out.println(" LargestPerimeter = " + LargestPerimeter);
        // Put code here
        //return ;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }
    


    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {

        ShapePerimeter pr = new ShapePerimeter();
        pr.getLargestPerimeterMultipleFiles();
    }
}
