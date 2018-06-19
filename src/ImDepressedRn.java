import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static java.lang.Thread.sleep;
import static org.opencv.imgproc.Imgproc.rectangle;

public class ImDepressedRn {

    static CascadeClassifier classifier;
    static Mat matrix;
    static MatOfRect rects;
    static Point Pointx,Pointy;
    static Scalar godcolor = new Scalar(1,2,3);

    public static void main(String[] args){
        JFrame godframe = new JFrame("im watching you -.-");
        godframe.setSize(500,500);
        DispPanel plebpanel = new DispPanel();
        godframe.setContentPane(plebpanel);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture capture = new VideoCapture(0);
        System.out.print(capture.isOpened());
        godframe.setVisible(true);
        classifier=new CascadeClassifier("C:\\pat\\OpenCV Test\\NEW openCVTest\\src\\haarcascade_smile.xml");

        while(true) {
            capture.read(matrix);

            classifier.detectMultiScale(matrix,rects);
            for(Rect cur:rects.toArray()){
                Pointx = new Point(cur.x,cur.y);
                Pointy = new Point(cur.x+cur.width,cur.y+cur.height);
                rectangle(matrix, Pointx, Pointy, godcolor, 2);
            }

            plebpanel.image = RandomMethods.matToBufferedImage(matrix);
            plebpanel.repaint();
            try{
                sleep(500);}
            catch(Exception e){}
        }
    }
}
