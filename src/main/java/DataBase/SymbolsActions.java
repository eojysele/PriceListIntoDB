package DataBase;

public class SymbolsActions {
    private String symb1 = ">";
    private String symb2 = "<";
    private String symb3 = "-";
    private int lenghtDescr = 512;

    public String deletingSymbols (String availability){

        StringBuilder strBuilder = new StringBuilder(availability);
        if (availability.contains(symb1)==true) {
            availability=deleteSymbols(availability,symb1,strBuilder);
        }
        if (availability.contains(symb2)==true) {
            availability=deleteSymbols(availability,symb3,strBuilder);
        }
        if (availability.contains(symb3)==true) {
            availability=deleteSymbols(availability,symb3,strBuilder);
        }
        return availability;

    }

    public String lineReduction(String description){
        int lengthD = description.length();
        if (lengthD >lenghtDescr){
            StringBuilder strBuilder = new StringBuilder(description);
            strBuilder.replace(lenghtDescr, lengthD, "");
            description = strBuilder.toString();
        }
        return description;
    }

    public String forDecimal(String decimalValue){
        String result = decimalValue.replaceAll("[,]", ".");
        decimalValue = result;
        return decimalValue;
    }

    public String searchLine(String searchL){
        String result = searchL.replaceAll("[^\\p{L}\\p{N}]+", "");
        searchL = result.toUpperCase();
        return searchL;
    }

    private String deleteSymbols(String str, String symbols, StringBuilder strBuilder){
        int i = str.indexOf(symbols);
        strBuilder.replace(0, i + 1, "");
        str = strBuilder.toString();
        return str;
    }





}
