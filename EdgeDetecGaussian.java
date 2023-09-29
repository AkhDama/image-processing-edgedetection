/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Dama Putra
 */

public class EdgeDetecGaussian {
  public static void main(String[] args) {
  File img = new File( "C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\burung.jpg" );
  BufferedImage a = null;
  try{ 
      a= ImageIO.read( img );
  }
  catch( Exception e ){
      System.out.print( e.toString() );
      return;
  }
  BufferedImage a9 = new BufferedImage( a.getWidth() , a.getHeight() , a.getType() ); 
  float[] matrix = {
             0,  -1, 0,
             -1,  4,  -1,
            0,  -1,  0
    };
    BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, matrix));

    a9 = op.filter( a, a9 );
    try{
        ImageIO.write( a9 , "jpg" ,new File( "C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\burungGaussian.jpg" ));
    }catch( Exception e ){
        System.out.println( e );
    }
    }
}

