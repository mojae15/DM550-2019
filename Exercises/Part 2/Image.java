import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
    
/**
 * Simple class to represent images (as bitmaps).
 */

public class Image {

    int[][][] matrix;
    int width;
    int height;

    /**
     * Creates a new, black, image with given dimensions.
     * @param width the width of the image
     * @param height the height of the image
     */
    public Image(int width, int height) {
	this.width = width;
	this.height = height;
	matrix = new int[width][height][];
	for (int i=0; i<width; i++)
	    for (int j=0; j<height; j++)
		matrix[i][j] = new int[]{0,0,0};
    }

    /**
     * Creates an image from a file.
     * If reading fails, it returns an empty image (0x0).
     * @param file the name of the file to read from
     */
    public Image(String filename) {
	try {
	    BufferedImage image = ImageIO.read(new File(filename));
	    this.width = image.getWidth();
	    this.height = image.getHeight();
	    this.matrix = new int[width][height][3];
	    for (int i=0; i<width; i++)
		for (int j=0; j<height; j++) {
		    int rgb = image.getRGB(i,j);
		    matrix[i][j][0] = (rgb >> 16)&0xff;
		    matrix[i][j][1] = (rgb >> 8)&0xff;
		    matrix[i][j][2] = rgb&0xff;
		}
	}
	catch (IOException e) {
	    System.err.println("Error reading - creating empty image.");
	    this.width = 0;
	    this.height = 0;
	    this.matrix = new int[0][0][3];
	}
    }
    
    /**
     * Returns this image's width.
     * @return this image's width
     */
    public int width() {
	return width;
    }

    /**
     * Returns this image's height.
     * @return this image's height
     */
    public int height() {
	return height;
    }

    /**
     * Returns the red component of a pixel in this image.<br />
     * <b>Precondition:</b> 0 &leq; x &lt; width and 0 &leq; y &lt; height
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return the red component of pixel (x,y)
     */
    public int red(int x, int y) {
	return matrix[x][y][0];
    }

    /**
     * Returns the green component of a pixel in this image.<br />
     * <b>Precondition:</b> 0 &leq; x &lt; width and 0 &leq; y &lt; height
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return the green component of pixel (x,y)
     */
    public int green(int x, int y) {
	return matrix[x][y][1];
    }

    /**
     * Returns the blue component of a pixel in this image.<br />
     * <b>Precondition:</b> 0 &leq; x &lt; width and 0 &leq; y &lt; height
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return the blue component of pixel (x,y)
     */
    public int blue(int x, int y) {
	return matrix[x][y][2];
    }
    
    /**
     * Sets the desired pixel in this image to the desired color.<br />
     * <b>Precondition:</b> 0 &leq; x &lt; width and 0 &leq; y &lt; height
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @param red the red component
     * @param green the green component
     * @param blue the blue component
     */
    public void setPixel(int x, int y, int red, int green, int blue) {
	matrix[x][y] = new int[]{red,green,blue};
    }
    
    /**
     * Shows the image on the screen.
     */
    public void display() {
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	for (int i=0; i<width; i++)
	    for (int j=0; j<height; j++)
		image.setRGB(i,j,(matrix[i][j][0]<<16)|(matrix[i][j][1]<<8)|matrix[i][j][2]);
	JOptionPane.showMessageDialog(null,new ImageIcon(image));
    }

    public static void main(String[] args) {
	Image image = new Image("test.jpg");
	image.display();
    }
}
