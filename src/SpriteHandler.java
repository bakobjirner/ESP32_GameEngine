import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteHandler {







    public static String createSpriteCode(BufferedImage[] images,String name){

        String output="";

        //calculate offset
        output += "const int "+name+"Offsets[] = { 0, ";
        for (BufferedImage image:images) {
            int offset = image.getWidth()*image.getHeight();
            output+=offset+", ";
        }
        output+="}; \n";

        //calculate pointOffset
        output+= "const short "+name+"PointOffsets[] = { 0, ";
        for(int i=1;i<=images.length;i++){
            output+=i+", ";
        }
        output+="}; \n";

        //calculate Resolution
        output+="const unsigned short "+name+"Res[][2] = { ";
        for (BufferedImage image:images) {
           output+= "{ "+image.getWidth()+" , "+image.getHeight()+" }, ";
        }
        output+="}; \n";

        //calculate color values
        output+="const unsigned char "+name+"Pixels[] = {\n";
        for (int l=0;l<images.length;l++ ) {
        BufferedImage image = images[l];


        for(int i = 0;i<image.getHeight();i++){
    for (int j = 0;j<image.getWidth();j++){

        String[] values= new String[4];

        Color c = new Color(image.getRGB(j,i),true);
        values[3] = Integer.toBinaryString((int)((double)c.getRed()/255*3));
        values[2] = Integer.toBinaryString((int)((double)c.getGreen()/255*3));
        values[1] = Integer.toBinaryString((int)((double)c.getBlue()/255*3));
        values[0] = Integer.toBinaryString((int)((double)c.getAlpha()/255*3));

        for (int k = 0; k <values.length ; k++) {
            if(values[k].length()<2){
                values[k]="0"+values[k];
            }
        }


        String binary3Bit = values[0]+values[1]+values[2]+values[3];
        int integer3Bit = Integer.parseInt(binary3Bit,2);



        output+=integer3Bit+", ";

    }
                output+="\n";//make sure there is a new line for each pixelRow



        }
        }
        output+="}; \n";

        //create final line for this sprite
        output+="Sprites " + name + "(" + images.length + ", " + name + "Pixels, " + name + "Offsets, " + name + "Res, " + name + "Points, " + name + "PointOffsets, Sprites::PixelFormat::" + "R2G2B2A2);\r\n";

return output;

    }

}
