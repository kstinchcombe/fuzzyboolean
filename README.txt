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
