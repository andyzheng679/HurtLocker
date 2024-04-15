import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hurtlocker {

    private Main main = new Main();

    private String rawData = main.readRawDataToString();

    private String doublePound = "##";

    private String nameRegex = "[nN][aA][mM][eE]"; ///start

    private String fieldSeparators = "[!@;^%*]";

    //private String kvSeparators =


    public Hurtlocker() throws Exception {
    }

    public String getRawData() {
        return rawData;
    }

    public String[] splitAtPound(){

        String[] split = rawData.split(doublePound);

        return split;
    }

    public int test(){
        String text = rawData;
        String patternString = "[mM][iI][lL][kK]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        int nameCounter = 0;
        for (int i = 0; matcher.find(); i++) {
            nameCounter++;
        }
        return  nameCounter;
    }






    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return "";
    }
}
