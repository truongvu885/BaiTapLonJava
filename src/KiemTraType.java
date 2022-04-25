package src;

public class KiemTraType {
    public  boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isFloat(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isInt(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean isBoolean(String s){
        try {
            Boolean.parseBoolean(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
