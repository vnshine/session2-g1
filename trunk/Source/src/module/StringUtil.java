package module;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil  {

    /**
     * filter nhung ki tu dac biet
     *
     */
    public static String filter(String value) {
        byte newLine[] = { 10 };
        if (value == null)
            return null;
        value = value.trim();
        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++)
            switch (content[i]) {
                case 59: // ';'
                    result.append("&#59;");
                    break;
                case 60: // '<'
                    result.append("&lt;");
                    break;

                case 62: // '>'
                    result.append("&gt;");
                    break;

                case 38: // '&'
                    result.append("&amp;");
                    break;

                case 34: // '"'
                    result.append("&quot;");
                    break;

                case 39: // '\''
                    result.append("&rsquo;");
                    break;

                case 37: // '%''
                    result.append("&#37;");
                    break;
                case 92: // '\\'
                    result.append("&#92;");
                    break;
                    // End of add
                case 58: // ':'
                    result.append("&#58;");
                    break;
                case 13:
                    result.append(new String(newLine));
                    break;

                case 10:
                    if ((i > 0) && (content[i - 1] != 13)) {
                        result.append(new String(newLine));
                    }
                    break;

                default:
                    result.append(content[i]);
                    break;
            }

        return result.toString();
    }

    public static boolean findPercentage(String value) {
        if (isNullOrBlankString(value))
            return false;
        value = value.trim();
        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case 37: // '%'
                    return true;
            }
        }
        return false;

    }

    /*
     * This function get THONG_KE_CA_NHAN_FORM
     */
    public static String findSpecific(String value) {
        if (isNullOrBlankString(value))
            return null;
        value = value.trim();
        char content[] = new char[value.length()];
        value.getChars(0, value.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
                case 92: // '\'
                    result.append("\\\\");
                    break;
                case 37: // '%'
                    result.append("/%");
                    break;
                default:
                    result.append(content[i]);
                    break;
            }
        }
        return result.toString();
    }

    /**
     * Get filter some specific character
     *
     */
    public static String getfilter(String value) {
        // Check null value
        if (isNullOrBlankString(value))
            return "";
        value = value.trim();
        // Get specific character
        value = value.replaceAll("&lt;", "<");
        value = value.replaceAll("&gt;", ">");
        value = value.replaceAll("&amp;", "&");
        value = value.replaceAll("&rsquo;", "\'");
        value = value.replaceAll("&#58;", ":");
        value = value.replaceAll("&#37;", "%");
        // Process " char
        char data[] = { '"' };
        String str = new String(data);
        value = value.replaceAll("&quot;", str);

        // char a[] = {'\\'};
        // str = new String(a);
        // value = value.replaceAll("&#92;",str);
        return value;
    }

    /**
     * This method confirm condition get information from and validate phone
     * number
     *
     * @throws NumberFormatException
     *             return number confirm
     */
    public static boolean isValidEmail(String str) {
        // Pattern uses confirm Email
        String regex = "^([a-zA-Z0-9_])+\\@(([a-zA-Z0-9-])+\\.)+([a-zA-Z]{2,4})$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * This method confirm String is not null or "" number
     *
     * return boolean value
     */
    public static boolean isValidString(String str) {
        boolean result = false;
        if (!"".equals(str) && str != null) {
            result = true;
        }
        return result;
    }

    /**
     * This method confirm String is null or "" number
     *
     * return boolean value
     */
    public static boolean isNullOrBlankString(String str) {
        boolean result = false;
        if ("".equals(str) || str == null) {
            result = true;
        }
        return result;
    }

    /**
     * This method confirm condition get information from and validate email
     *
     * @throws NumberFormatException
     *             return number confirm email if validate email is true return
     *             1 else return 0
     */
    public static int confirmFormatEmail(String email) {
        // This method uses object Stringtokennizer to split THONG_KE_CA_NHAN_FORM
        StringTokenizer subEmail = new StringTokenizer(email, "@");
        if (subEmail.countTokens() != 2)
            return 0;
        // This variable find '.' in next Stringtokenizer
        String confirmEmai = (String) subEmail.nextToken();
        confirmEmai = (String) subEmail.nextToken();
        // Confirm have more than 2 ".."
        subEmail = new StringTokenizer(confirmEmai, ".");
        if (subEmail.countTokens() != 2)
            return 0;
        if (!isValidEmail(email))
            return 0;
        return 1;
    }

    public static boolean isPhoneFormat(String strValue) {
        String regex = "^\\d{1,4}+-\\d{1,4}+-\\d{1,4}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(strValue);
        return m.matches();
    }

    /**
     * This method confirm condition get information from and validate phone
     * number
     *
     * @throws NumberFormatException
     *             return number confirm if validate is true return 1 else
     *             return 0
     */
    public static int confirmphonenumber(String phoneNumber) {
        // Confirm length of phone number
        if (phoneNumber.length() > 14)
            return 0;
        StringTokenizer subPhonenumber = new StringTokenizer(phoneNumber, "-");
        // Confirm phone number haves more than 2 @
        if (subPhonenumber.countTokens() != 3)
            return 0;
        // Confirm String is Number
        String confirmNumber;
        while (subPhonenumber.hasMoreTokens()) {
            confirmNumber = subPhonenumber.nextToken();
            // Confirm THONG_KE_CA_NHAN_FORM is an Interger
            try {
                Integer.parseInt(confirmNumber);
            } catch (NumberFormatException nfe) {
                return 0;
            }
        }
        if (!isPhoneFormat(phoneNumber))
            return 0;
        return 1;
    }

    /**
     * Read user name
     *
     * @param fileName
     *            this parameter is path os file
     * @return get user name
     */
    public static String readUsername(String fileName) {
        String line;
        String username = "";
        String data = "";
        // Get name of user and throws exception if have errors
        try {
            // Create BufferedReader
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            // Read file
            line = in.readLine();
            data = (String.valueOf(line));
            int index = data.indexOf("=");
            if (index != -1) {
                username = data.substring(index + 1, data.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
        }
        return username;
    }

    /**
     * Read password of admin
     *
     * @param fileName
     *            this parameter is path of file
     * @return get password of admin
     */
    public static String readPassword(String fileName) {
        String line;
        String password = "";
        String data = "";
        try {
            // Create BufferedReader
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            // Read file
            line = in.readLine();
            line = in.readLine();
            data = (String.valueOf(line));

            int index = data.indexOf("=");
            if (index != -1) {
                password = data.substring(index + 1, data.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
        }
        return password;
    }

    public static Long convertToLong(String stringValue){
        if(stringValue==null)
            return Long.reverse(0);
        try{
            return Long.parseLong(stringValue);
        }
        catch(Exception e){
//            e.printStackTrace();
            return Long.reverse(0);
        }
    }


    public static String parseLong(Long longValue) {
        return longValue!=null?longValue.toString():null;
    }

    public static String trimString(String string){
        if(string==null )
            return null;
        String result =string.trim();
        if(result.equals(""))
            result=null;
        return result;
    }




     public static String toString(String str, int length) {
        if (null == str) {
            return "";
        }
        if (str.length() > length) {
            return str.substring(0, length) + "...";
        }
        return str;
    }

    public static boolean isStringLonger(String str, int maxLength) {
        if (str != null) {
            String tempString = str;
            tempString = tempString.replaceAll("&quot;", "1").replaceAll("&gt;", "<").replaceAll("&lt;", ">")
                    .replaceAll("&#39;", "1").replaceAll("&amp;", "&");
            return (tempString.length() > maxLength) ? true : false;
        } else {
            return false;
        }
    }
    
    public static String formatNumber(String s) {

          String tempResult = s;
          if (s == null || s.length() == 0 || s.length() < 4)
              return tempResult;

          String COMMA = ",";
          StringBuffer buff = new StringBuffer();

          Map map = new HashMap();

          int length = tempResult.length();
          int l = 0;

          while (true) {
              if (length < 4) {
                  map.put(new Integer(l), tempResult);
                  break;
              } else {
                  String s1 = tempResult.substring(length - 3);
                  map.put(new Integer(l), s1);
                  l++;
                  tempResult = tempResult.substring(0, length - 3);
                  length = tempResult.length();
              }
          }          
          for (int i = map.size() - 1; i >= 0; i--) {
              buff.append((String) map.get(new Integer(i)));
              if (i > 0) {
                  buff.append(COMMA);
              }
          }
          return buff.toString();
      }


    public static String checkString(String str) {
        String[] old = { "&", "<", ">", "\n" };
        String[] strNew = { "&amp;", "&lt;", "&gt;", "<br>" };
        return replace(str, old, strNew);
    }


    public static String replace(String s, char oldSub, char newSub) {
        return replace(s, oldSub, new Character(newSub).toString());
    }

    public static String replace(String s, char oldSub, String newSub) {
        if ((s == null) || (newSub == null)) {
            return null;
        }

        char[] c = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == oldSub) {
                sb.append(newSub);
            } else {
                sb.append(c[i]);
            }
        }

        return sb.toString();
    }

    public static String replace(String s, String oldSub, String newSub) {
        if ((s == null) || (oldSub == null) || (newSub == null)) {
            return null;
        }

        int y = s.indexOf(oldSub);

        if (y >= 0) {
            StringBuffer sb = new StringBuffer();
            int length = oldSub.length();
            int x = 0;

            while (x <= y) {
                sb.append(s.substring(x, y));
                sb.append(newSub);
                x = y + length;
                y = s.indexOf(oldSub, x);
            }

            sb.append(s.substring(x));

            return sb.toString();
        } else {
            return s;
        }
    }

    public static String replace(String s, String[] oldSubs, String[] newSubs) {
        if ((s == null) || (oldSubs == null) || (newSubs == null)) {
            return null;
        }

        if (oldSubs.length != newSubs.length) {
            return s;
        }

        for (int i = 0; i < oldSubs.length; i++) {
            s = replace(s, oldSubs[i], newSubs[i]);
        }

        return s;
    }


    public static String getNull(Integer parameter){
        if(parameter == null) return "";
        return parameter.toString();
    }

    public static String getNameWithNotBlank(String parameter){
        if(StringUtil.isNullOrBlankString(parameter)) return null;
        parameter = TextConverter.toEnglish(parameter).toUpperCase();
        parameter = parameter.trim();
        int y = parameter.length();
        if (y >= 0) {
            StringBuffer sb = new StringBuffer();
            char[] c = parameter.toCharArray();
            for(int i =0;i<y;i++){
                if(c[i] != ' '){
                      sb.append(c[i]);
                }
            }
            return sb.toString();
        } else {
            return parameter;
        }
    }
    public static String getName(String parameter){
        if(StringUtil.isNullOrBlankString(parameter))return null;
        parameter = parameter.trim();
        parameter = TextConverter.toEnglish(parameter).toUpperCase();
        int i = parameter.lastIndexOf(" ") + 1;
        parameter = parameter.substring(i);
        return parameter;
    }




}