/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Dama Putra
 */
public class EdegeDetecCanny {
    //Canny parameters
    private static final double CANNY_THRESHOLD_RATIO = .2; //Suggested range .2 - .4
    private static final int CANNY_STD_DEV = 1;             //Range 1-3
    
 
    public static void main(String[] args) throws IOException {
        //Read input file name and create output file name
        System.out.println("Started");
        String filename = "C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\burung.jpg";
        
        File file = new File(filename);
        BufferedImage image = ImageIO.read(file);
        
        File outputfile = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\burungCanny.jpg");
        ImageIO.write(image, "png", outputfile);
        
        //Sample JCanny usage
        try {
            BufferedImage input = ImageIO.read(new File(filename));
            BufferedImage output = JCanny.CannyEdges(input, CANNY_STD_DEV, CANNY_THRESHOLD_RATIO);
            ImageIO.write(output, "png", outputfile);
            System.out.println("Successfully converted a image into a Canny Detection Edege");
        } catch (Exception ex) {
            System.out.println("ERROR ACCESING IMAGE FILE:\n" + ex.getMessage());
        }
    }       
}
