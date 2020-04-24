import java.util.List;

public class Builder {




private static String program="";
//pin configuration
    private  static int redPins[] = {12,13};
    private  static int greenPins[] = {27,14};
    private  static int bluePins[] = {32,33};
    private  static int hsyncPin = 18;
    private  static int vsyncPin = 19;

    //pins for the joystick-input
    private  static int inputPins[] = {21,15,22,23};

    private static List<GameObject> gameObjects;



public static void buildFile() {
writeImports();
writeSprites();
writePinConfig();
writeVariables();
writeSetUp();
writeLoop();
System.out.print(program);
}


    public static void setGameObjects(List<GameObject> gameObjects) {
        Builder.gameObjects = gameObjects;
    }

    private static void writeImports(){
    program+="#include <ESP32Lib.h>\n";
    program+="#include <Ressources/Font6x8.h>\n";
}

private static void writePinConfig(){
    program+="const int redPins[] = {"+redPins[0]+" , "+redPins[1]+"};\n";
    program+="const int greenPins[] = {"+greenPins[0]+" , "+greenPins[1]+"};\n";
    program+="const int bluePins[] = {"+bluePins[0]+" , "+bluePins[1]+"};\n";
    program+="const int hsyncPin = "+hsyncPin+";\n";
    program+="const int vsyncPin = "+vsyncPin+";\n";
    program+="int inputPins[] = {"+inputPins[0]+","+inputPins[1]+","+inputPins[2]+","+inputPins[3]+"};\n";
}

private static void writeVariables(){
    program+="int animationState=0;\n";
    program+="VGA6Bit vga;\n";
}

private static void writeSetUp(){



    program+="void setup() {\n" +
            " Serial.begin(9600);\n" +
            "//need double buffering \n" +
            "vga.setFrameBufferCount(2);\n" +
            "//initializing i2s \n" +
            "vga.init(vga.MODE320x240, redPins, greenPins, bluePins, hsyncPin, vsyncPin);\n" +
            "//setting the font\n" +
            "vga.setFont(Font6x8);\n" +
            " for(int i = 0; i< 4; i++){\n" +
            " pinMode(inputPins[i], INPUT_PULLDOWN); \n" +
            "}\n"+
            "}\n";
    }

    private static void writeSprites(){

        for (GameObject object:gameObjects) {
            program+="\n";
            program+=SpriteHandler.createSpriteCode(object.getAnimation(),object.getName()+"Sprite");
            program+="\n";
        }


    }

    private static void writeLoop(){

    program+= "void loop(){\n";
       program+=" rockSprite.drawMix(vga, 0, 100, 100);\n";
        program+= "delay(20);\n";
        program+= "}\n";

    }




}
