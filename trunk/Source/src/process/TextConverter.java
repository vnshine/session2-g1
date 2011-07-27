package process;
import java.util.Hashtable;
public class TextConverter {
    private static TextConverter soleInstance = new TextConverter();

    private char[][] vietNameseChars = 
    {
            {'Ã€', 'Ã�', 'áº¢', 'Ãƒ', 'áº ', 'Ä‚', 'áº°', 'áº®', 'áº²', 'áº´', 'áº¶', 'Ã‚', 'áº¦', 'áº¤', 'áº¨', 'áºª', 'áº¬'}
            , {'Ãˆ', 'Ã‰', 'áºº', 'áº¼', 'áº¸', 'ÃŠ', 'á»€', 'áº¾', 'á»‚', 'á»„', 'á»†'}
            , {'ÃŒ', 'Ã�', 'á»ˆ', 'Ä¨', 'á»Š'}
            , {'á»²', 'Ã�', 'á»¶', 'á»¸', 'á»´'}
            , {'Ã™', 'Ãš', 'á»¦', 'Å¨', 'á»¤', 'Æ¯', 'á»ª', 'á»¨', 'á»¬', 'á»®', 'á»°'}
            , {'Ã’', 'Ã“', 'á»Ž', 'Ã•', 'á»Œ', 'Ã”', 'á»’', 'á»�', 'á»”', 'á»–', 'á»˜', 'Æ ', 'á»œ', 'á»š', 'á»ž', 'á» ', 'á»¢'}
            , {'Ä�'},
            {'Ã ', 'Ã¡', 'áº£', 'Ã£', 'áº¡', 'Äƒ', 'áº±', 'áº¯', 'áº³', 'áºµ', 'áº·', 'Ã¢', 'áº§', 'áº¥', 'áº©', 'áº«', 'áº­'}
            , {'Ã¨', 'Ã©', 'áº»', 'áº½', 'áº¹', 'Ãª', 'á»�', 'áº¿', 'á»ƒ', 'á»…', 'á»‡'}
            , {'Ã¬', 'Ã­', 'á»‰', 'Ä©', 'á»‹'}
            , {'á»³', 'Ã½', 'á»·', 'á»¹', 'á»µ'}
            , {'Ã¹', 'Ãº', 'á»§', 'Å©', 'á»¥', 'Æ°', 'á»«', 'á»©', 'á»­', 'á»¯', 'á»±'}
            , {'Ã²', 'Ã³', 'á»�', 'Ãµ', 'á»�', 'Ã´', 'á»“', 'á»‘', 'á»•', 'á»—', 'á»™', 'Æ¡', 'á»�', 'á»›', 'á»Ÿ', 'á»¡', 'á»£'}
            , {'Ä‘'}
                     
    };

    private char englishChars[] = {
            'A', 'E', 'I', 'Y', 'U', 'O', 'D', 'a', 'e', 'i', 'y', 'u', 'o', 'd'
    };

    private Hashtable converterHash = new Hashtable();

    private char getEnglishChar(char vietNameseChar) {
        for (int i = 0; i < vietNameseChars.length; i++) {
            char[] oneCharLine = vietNameseChars[i];
            for (int j = 0; j < oneCharLine.length; j++) {
                char oneChar = oneCharLine[j];
                if (oneChar == vietNameseChar)
                    return englishChars[i];
            }
        }

        return vietNameseChar;
    }

    private String convertToEn(String str) {
        if (str == null)
            return null;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            char oneChar = str.charAt(i);
            result.append(getEnglishChar(oneChar));

        }

        return result.toString();
    }

    private TextConverter() {
        for (int i = 0; i < vietNameseChars.length; i++)
            for (int j = 0; j < vietNameseChars[i].length; j++)
                converterHash.put(new Character(vietNameseChars[i][j])
                        , new Character(englishChars[i]));
    }

    public static String toEnglish(String str) {
        return str == null ? "" : getInstance().convertToEn(str);
    }

    public static boolean compareVietAnh(String tenViet, String tenAnh) {
        return getInstance().compareVietAnhImpl(tenViet, tenAnh);
    }

    private boolean compareVietAnhImpl(String tenViet, String tenAnh) {
        if (tenViet == null && tenAnh == null)
            return true;
        else if (tenViet == null || tenAnh == null)
            return false;

        tenViet = convertToEn(tenViet.trim());
        tenAnh = tenAnh.trim();

        if (tenViet.equals("") && tenAnh.equals(""))
            return true;
        else if (tenViet.equals("") || tenAnh.equals(""))
            return false;

        int spaceId = tenViet.indexOf(' ') == tenAnh.indexOf(' ') ? tenViet.indexOf(' ') : -1;

        if (spaceId == -1)
            return tenViet.equalsIgnoreCase(tenAnh);

        if (! tenViet.substring(0, spaceId).equalsIgnoreCase(tenAnh.substring(0, spaceId)))
            return false;

        return compareVietAnhImpl(tenViet.substring(spaceId).trim(), tenAnh.substring(spaceId).trim());
    }

    public static String removeRedundantSpace(String text) {
        return getInstance().removeRedundantSpaceImpl(text);
    }

    private String removeRedundantSpaceImpl(String text) {
        if (text == null)
            return null;

        text = text.trim();

        if (text.indexOf("  ") == -1)
            return text;

        text = text.replaceAll("  ", " ");

        return removeRedundantSpaceImpl(text);
    }

    public static String removeCharacter(String text, char aChar){
        return getInstance().removeCharacterImpl(text,aChar);
    }

    private String removeCharacterImpl(String text, char aChar){
        if(text==null)
            return null;

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char one = text.charAt(i);
            if(one!=aChar)
                result.append(aChar);
        }

        return result.toString();
    }

    public static String capitalizeWords(String text) {
        return getInstance().capitalizeWordsImpl(text);
    }

    private String capitalizeWordsImpl(String text) {
        if (text == null)
            return null;

        text = removeRedundantSpaceImpl(text);

        if (text.equals(""))
            return text;

        text = text.toLowerCase();

        int spaceId = text.indexOf(" ");

        if (spaceId == -1)
            return text.substring(0, 1).toUpperCase() + text.substring(1);

        String first = text.substring(0, spaceId);
        String second = text.substring(spaceId);

        return first.substring(0, 1).toUpperCase() + first.substring(1) + " " + capitalizeWordsImpl(second);
    }

    private static TextConverter getInstance() {
        return soleInstance;
    }

}
