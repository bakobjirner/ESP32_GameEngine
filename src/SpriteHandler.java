import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteHandler {







    public String createSpriteCode(BufferedImage[] images,String name){

        String output="";

        //calculate offset
        output += "const int "+name+"Offsets[] = { 0, ";
        for (BufferedImage image:images) {
            int offset = image.getWidth()*image.getHeight();
            output+=offset+", ";
        }
        output+="}; \n";




        for (BufferedImage image:images ) {



        for(int i = 0;i<image.getHeight();i++){
    for (int j = 0;j<image.getWidth();j++){

        String[] values= new String[4];

        Color c = new Color(image.getRGB(i,j),true);
        values[3] = Integer.toBinaryString(c.getRed()/255*3);
        values[2] = Integer.toBinaryString(c.getGreen()/255*3);
        values[1] = Integer.toBinaryString(c.getBlue()/255*3);
        values[0] = Integer.toBinaryString(c.getAlpha()/255*3);

        for (int k = 0; k <values.length ; k++) {
            if(values[k].length()<2){
                values[k]="0"+values[k];
            }
        }


        String binary3Bit = values[0]+values[1]+values[2]+values[3];
        int integer3Bit = Integer.parseInt(binary3Bit,2);


    }
        }
        }
        System.out.println(output);
return output;

    }

}
