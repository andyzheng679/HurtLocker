import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);


        Hurtlocker testing = new Hurtlocker();
        //System.out.println(testing.getRawData().replace('#', '\n'));

        System.out.println(testing.test());
        System.out.println(Arrays.toString(testing.splitAtPound()));
    }







}
