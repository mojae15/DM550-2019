public class ImageCoder{

    
    public static void main(String[] args) {

        Image img = new Image(2,2);

        for (int i = 0; i < img.height(); i++){
            for (int j = 0; j < img.width(); j++){

                img.setPixel(i, j, 100, 100, 100);

            }
        }

        // addRectangle(img, 50, 50, 20, 20, 255, 255, 255);
        
        // addCircle(img, 0, 0, 20, 255, 255, 255);

        img.display();
        encrypt(img, "Hejsa");
        img.display();

        decrypt(img, "Hejsa");
        img.display();
        

    }


    /**
     * Draw a rectangle on a given Image image
     */
    public static void addRectangle(Image image, int x, int y, int width, int height, int red, int green, int blue){

        int i = x;
        while (i < x+width && i < image.width()){
            int j = y;
            while (j < y+height && j < image.height()){

                image.setPixel(i, j, red, green, blue);
                j++;
            }
            i++;

        }
    }
    
    /**
     * Draw a circle on a given Image image
     */
    public static void addCircle(Image image, int x, int y, int radius, int red, int green, int blue){

        int minX = x-radius;
        int maxX = x+radius;

        int minY = y-radius;
        int maxY = 0;

        if ( x < radius){
            minX = 0;
        }

        if (x+radius > image.width()){
            maxX = image.width();
        }

        if ( Y < radius){
            minY = 0;
        }

        if (Y+radius > image.height()){
            maYX = image.height();
        }

        for (int i = minX; i < maxX; i++){
            for (int j = minY; j < maxY; j++){
                if ((x-i)*(x-i)+(y-j)*(y-j) <=radius*radius){
                    image.setPixel(i, j, red, green, blue);
                }
            }
        }
    }

    /**
     * Encrypt a given Image image with a given String key
     */
    public static void encrypt(Image image, String key){
        int red = 0;
        int green = 0;
        int blue = 0;
        int keyIndex = 0;

        for (int i = 0; i < image.width(); i++){
            for (int j = 0; j < image.height(); j++){
                
                red = (red + image.red(i, j) +key.charAt(keyIndex%key.length()))%256;
                keyIndex++;

                green = (green + image.green(i, j) +key.charAt(keyIndex%key.length()))%256;
                keyIndex++;

                blue = (blue + image.blue(i, j) +key.charAt(keyIndex%key.length()))%256;
                keyIndex++;
                
                image.setPixel(i, j, red, green, blue);
                

            }
        }


    }

    /**
     * Decrypt a given Image image with a given String key
     */
    public static void decrypt(Image image, String key){
        int red = 0;
        int green = 0;
        int blue = 0;

        int oldRed = 0;
        int oldGreen = 0;
        int oldBlue = 0;

        int keyIndex = 0;

        for (int i = 0; i < image.width(); i++){
            for (int j = 0; j < image.height(); j++){


                red = (512 + image.red(i,j) - oldRed - key.charAt(keyIndex%key.length()))%256;
                keyIndex ++;

                green = (512 + image.green(i,j) - oldGreen - key.charAt(keyIndex%key.length()))%256;
                keyIndex ++;

                blue = (512 + image.blue(i,j) - oldBlue - key.charAt(keyIndex%key.length()))%256;
                keyIndex ++;

                oldRed = image.red(i,j);
                oldGreen = image.green(i,j);
                oldBlue = image.blue(i,j);
                
                image.setPixel(i,j,red,green,blue);
            
            }
        }
    }
    
}