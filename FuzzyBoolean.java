/**
 * FuzzyBoolean - understand yes/no, 1/0, true/false as booleans...
 * because there are so many ways to say yes.
 * 
 * This is a class I find use for in almost every project, for
 * reading config files or third-party xml or whatever.
 * 
 * there's a default config for a static instance, and you can use
 * FuzzyBoolean.sParse("true")
 * to get that, or you can configure your own instance, using
 * new FuzzyBoolean("1", "true", "yes").parse("yes")
 * 
 * you can also supply a default value, especially if you're using
 * actual booleans rather than Booleans. So for example
 * boolean s = FuzzyBoolean.sParse("unknown", false);
 * will give you s==false rather than an error in (boolean)null.
 * 
 * @author kai
 *
 */
public class FuzzyBoolean {
	
	public static FuzzyBoolean DEFAULT_PARSER = new FuzzyBoolean();
	
	private static final String[] defaultTrues = new String[] {
		"true", "1", "t", "y", "yes", "approve"
	};
	private static final String[] defaultFalses= new String[] {
		"false", "0", "f", "n", "no", "deny", "decline", ""
	};
    
    private Boolean defaultValue;
    private String[] trueValues;
    private String[] falseValues;
    
    /**
     * default trues and falses, returns null if it is none of the above 
     */
    public FuzzyBoolean() {
    	this(defaultTrues, defaultFalses, null);
    }
    /**
     * true if any of the values are a match, false otherwise
     * @param trueValues
     */
    public FuzzyBoolean(String... trueValues) {
    	this(trueValues, new String[0], false);
    }
    /**
     * true if  arg matches any falses, false if arg matches any falses, null otherwise
     * @param trues
     * @param falses
     */
    public FuzzyBoolean(String[] trues, String[] falses) {
    	this(trues, falses, null);
    }
    /**
     * true if  arg matches any falses, false if arg matches any falses, defaultValue otherwise
     * @param trues
     * @param falses
     */
    public FuzzyBoolean(String[] trues, String[] falses, Boolean defaultValue) {
    	this.trueValues = trues;
    	this.falseValues = falses;
    	this.defaultValue = null;
    }
    
    /**
     * parses with the default parser
     * @param value
     * @return
     */
    public static Boolean sParse(String value) {
    	return DEFAULT_PARSER.parse(value);
    }

    /**
     * uses default parser instance to parse the value, returning the default if no matches
     *  are found 
     * @param value
     * @param defaultValue
     * @return
     */
    public static Boolean sParse(String value, Boolean defaultValue) {
    	return DEFAULT_PARSER.parse(value, defaultValue);
    }
    
    /**
     * parse according to the specific rules of this parser, returning the default
     * according to the parser defaultValue
     * @param value
     * @return
     */
    public Boolean parse(String value) {
    	return parse(value, defaultValue);
    }
    
    /**
     * parse according to the specific rules of this parser, returning the supplied default
     * if none match
     * @param value
     * @return
     */
    public Boolean parse(String value, Boolean defaultValue) {
        
        if (null == value) {
            return defaultValue;
        }
        
        value = value.toLowerCase();
        
        for (String s : trueValues) {
        	if (value.equals(s))
        		return true;
        }

        for (String s : falseValues) {
        	if (value.equals(s))
        		return false;
        }

        return defaultValue;
    }
}
