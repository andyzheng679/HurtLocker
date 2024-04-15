import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hurtlocker {

    private Main main = new Main();

    private String rawData = main.readRawDataToString();

    private String doublePound = "##";

    private String nameRegex = "[nN][aA][mM][eE]"; ///start

    private String separators = "[!@;^%*;:]";

    private String milkRegex = "[mM][iI][lL][kK]";
    private int milkCounter = 0;
    private String milkPriceRegex1 = "3.23";
    private int milkPriceCounter1 = 0;
    private String milkPriceRegex2 = "1.23";
    private int milkPriceCounter2 = 0;



    private String breadRegex = "[bB][rR][eE][aA][dD]";
    private int breadCounter = 0;
    private String cookiesRegex = "[cC][oO0][oO0][kK][iI][eE][sS]";
    private int cookiesCounter = 0;

    private int applesCounter = 0;



    public Hurtlocker() throws Exception {
    }

    public String getRawData() {
        return rawData;
    }

    public String getMilkRegex(){
        return milkRegex;
    }

    public String getMilkPriceRegex1() {
        return milkPriceRegex1;
    }

    public String getMilkPriceRegex2() {
        return milkPriceRegex2;
    }

    public String getBreadRegex(){
        return breadRegex;
    }

    public String getCookiesRegex(){
        return cookiesRegex;
    }

    public String[] splitAtPound(){

        String[] split = rawData.split(doublePound);

        return split;
    }

//    public String[] splitAtSeparators(String[] splitAtPound){
//
//        String[] split = Arrays.toString(splitAtPound).split(separators);
//
//        return split;
//    }

    public String[][] splitAtSeparator(String[] splitAtPound){
        List<String[]> results = new ArrayList<>();

        for(String item : splitAtPound){
            String[] splits = item.split(separators);
            results.add(splits);
        }

        String[][] finalResult = new String[results.size()][];
        for(int i = 0; i < results.size(); i++){
            finalResult[i] = results.get(i);
        }
        return finalResult;
    }

    public int counter(String[][] splitAtSeparator, String regex){
        Pattern pattern = Pattern.compile(regex);
        int counter = 0;

        for(int i = 0; i < splitAtSeparator.length; i++){
            boolean emptyElement = false;
            for (int j = 0; j < splitAtSeparator[i].length; j++){
                if(splitAtSeparator[i][j].isEmpty()){
                    emptyElement = true;
                    break;
                }
            }
            if(!emptyElement){
                for(int k = 0; k < splitAtSeparator[i].length; k++){
                    String string = splitAtSeparator[i][k];
                    Matcher matcher = pattern.matcher(string);
                    if(matcher.find()){
                        counter++;
                    }
                }
            }
        }
        return counter;
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
