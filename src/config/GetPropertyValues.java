package config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;

public class GetPropertyValues {

    private int[] color = new int[3];
    private static Properties prop;
    private int length;
    private int width;
    private int sleep;

    public GetPropertyValues() {
        setPropValues();
    }

    public int getSleep() {
        return sleep;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int[] getColor() {
        return color;
    }

    public static void setPropValues() {
        try {
            String propFileName = "configuration.properties";
            InputStream input = new FileInputStream(propFileName);
            prop = new Properties();

            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void setColors() {
        color[0] = Integer.parseInt(prop.getProperty("FIRST_COLOR"));
        color[1] = Integer.parseInt(prop.getProperty("SECOND_COLOR"));
        color[2] = Integer.parseInt(prop.getProperty("THIRD_COLOR"));
    }

    public void setFirstPart() {
        length = Integer.parseInt(prop.getProperty("FIRST_LENGTH"));
        width = Integer.parseInt(prop.getProperty("FIRST_WIDTH"));
        sleep = Integer.parseInt(prop.getProperty("FIRST_SLEEP_TIME"));
    }

    public void setSecondPart() {
        length = Integer.parseInt(prop.getProperty("SECOND_LENGTH"));
        width = Integer.parseInt(prop.getProperty("SECOND_WIDTH"));
        sleep = Integer.parseInt(prop.getProperty("SECOND_SLEEP_TIME"));
    }

    public void setThirdPart() {
        length = Integer.parseInt(prop.getProperty("THIRD_LENGTH"));
        width = Integer.parseInt(prop.getProperty("THIRD_WIDTH"));
        sleep = Integer.parseInt(prop.getProperty("THIRD_SLEEP_TIME"));
    }
}
