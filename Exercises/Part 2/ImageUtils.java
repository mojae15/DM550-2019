public class ImageUtils{

    public Image flipHorizontal(Image image){

        int w = image.width();
        int h = image.height();

        Image flipped = new Image(w, h);

        for (int i = 0; i < w; i++){

            for (int j = 0; j < h; j++){

                flipped.setPixel(w-i-1, j, image.red(i, j), image.green(i,j), image.blue(i, j));

            }

        }

        return flipped;

    }

    public Image flipVertical(Image image){
        int w = image.width();
        int h = image.height();

        Image flipped = new Image(w, h);

        for (int i = 0; i < w; i++){

            for (int j = 0; j < h; j++){

                flipped.setPixel(i, h-j-1, image.red(i, j), image.green(i,j), image.blue(i, j));

            }

        }

        return flipped;


    }


    public static Image rotateLeft(Image image){;
        int width = image.width();
        int height = image.height();
        Image rotated = new Image(height, width);

        for (int i = 0; i < width; i++){;

            for (int j = 0; j < height; j++){

                rotated.setPixel(j, width-i-1, image.red(i, j), image.green(i,j), image.blue(i, j));

            }

        }

        return rotated;



    };

    public static Image rotateHalf(Image image) {
        int width = image.width();
        int height = image.height();
        Image rotated = new Image(width,height);

        for (int i=0; i<width; i++){

            for (int j=0; j<height; j++){

                rotated.setPixel(width-i-1,height-j-1,image.red(i,j),image.green(i,j),image.blue(i,j));

            }

        }
        return rotated;
    }

    public static Image rotateRight(Image image) {
        int width = image.width();
        int height = image.height();
        Image rotated = new Image(height,width);
        
        for (int i=0; i<width; i++){

            for (int j=0; j<height; j++){

                rotated.setPixel(height-j-1,i,image.red(i,j),image.green(i,j),image.blue(i,j));

            }

        }
        return rotated;
    }


    public static Image stretchHorizontally(Image image){

        int w = image.width();
        int h = image.height();
        Image stretched = new Image(w*2, h);

        for (int i = 0; i < (w*2); i++) {
            for (int j = 0; j < h; j++) {
                stretched.setPixel(i,j, image.red(i/2, j), image.green(i/2, j), image.blue(i/2, j));
            }
        }

        return stretched;
    }

    public static Image stretchVertically(Image image){

        int w = image.width();
        int h = image.height();
        Image stretched = new Image(w, h*2);

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h*2; j++) {
                stretched.setPixel(i,j, image.red(i, j/2), image.green(i/2, j/2), image.blue(i/2, j/2));
            }
        }

        return stretched;
    }

    public static Image switchRedGreen(Image image){
        int width = image.width();
        int height = image.height();
        Image switched = new Image(height, width);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                
                switched.setPixel(i, j, image.green(i, j), image.red(i,j), image.blue(i, j));

            }
        }

        return switched;
    }
    
    public static Image switchRedBlue(Image image){
        int width = image.width();
        int height = image.height();
        Image switched = new Image(height, width);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                
                switched.setPixel(i, j, image.blue(i, j), image.green(i,j), image.red(i, j));
                
            }
        }

        return switched;
    }
    
    public static Image switchGreenBlue(Image image){
        int width = image.width();
        int height = image.height();
        Image switched = new Image(height, width);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                
                switched.setPixel(i, j, image.red(i, j), image.blue(i,j), image.green(i, j));

            }
        }

        return switched;
    }


    public static int[] histogram(Image image){
        int[] res = new int[]{0,0,0};


        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                int red = image.red(i,j);
                int green = image.green(i,j);
                int blue = image.blue(i,j);

                if (red > green && red > blue){
                    res[0]++;
                } else if (green > red && green > blue){
                    res[1]++;
                } else if (blue > red && blue > green){
                    res[2]++;
                }
            }
        }


        return res;
    }

    public static int[] average(Image image){
        int[] res = new int[]{0,0,0};

        for (int i = 0; i < image.width(); i++){
            for (int j = 0; j < image.height(); j++){

                res[0] = res[0] + image.red(i,j);
                res[1] = res[1] + image.blue(i,j);
                res[2] = res[2] + image.green(i,j);

            }
        }

        res[0] = res[0]/(image.width()*image.height());
        res[1] = res[1]/(image.width()*image.height());
        res[2] = res[2]/(image.width()*image.height());


        return res;
    }

    public static Image resample(Image image){
        int width = image.width();
        int height = image.height();
        Image resample = new Image(height, width);

        //Set the borders
        for (int i = 0; i < width; i++) {
            resample.setPixel(i, 0, image.red(i,0), image.green(i,0), image.blue(i,0));
            resample.setPixel(i, height-1, image.red(i,height-1), image.green(i,height-1), image.blue(i,height-1));
        }
        for (int j = 0; j < height; j++) { 
            resample.setPixel(0, j, image.red(0, j), image.green(0, j), image.blue(0, j));
            resample.setPixel(width-1, j, image.red(width-1, j), image.green(width-1, j), image.blue(width-1, j));
            
        }

        //Go through the rest of the picture

        for (int i = 1; i < width-1; i++) {
            for (int j = 1; j < height-1; j++) {
                int red = 0;
                int green = 0;
                int blue = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int n = -1; n <= 1; n++) {
                        red = red + image.red(i+k, j+n);
                        green = green + image.green(i+k, j+n);
                        blue = blue + image.blue(i+k, j+n);

                    }
                    
                }

                resample.setPixel(i, j, red/9, green/9, blue/9);


            }
        }


        return resample;
    }
    

    public static void main(String[] args) {

        Image img = new Image("temp.png");
        
        img = resample(img);
    
        img.display();





    }

}