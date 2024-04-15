import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.lang.reflect.Array;
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

        System.out.println(Arrays.toString(testing.splitAtPound()));
        System.out.println(Arrays.deepToString(testing.splitAtSeparator(testing.splitAtPound())));

        System.out.println(testing.counter(testing.splitAtSeparator(testing.splitAtPound()), testing.getMilkRegex())); //milk
        System.out.println(testing.counter(testing.splitAtSeparator(testing.splitAtPound()), testing.getBreadRegex())); //bread
        System.out.println(testing.counter(testing.splitAtSeparator(testing.splitAtPound()), testing.getCookiesRegex())); //cookie

    }







}
