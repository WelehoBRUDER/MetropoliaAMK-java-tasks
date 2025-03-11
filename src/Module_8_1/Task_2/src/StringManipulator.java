public class StringManipulator {
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    } // - Concatenates two input strings and returns the result.

    public int findLength(String str) {
        return str.length();
    } // - Returns the length of the input string.

    public String convertToUpperCase(String str) {
        return str.toUpperCase();
    } // - Converts the input string to uppercase and returns the result.

    public String convertToLowerCase(String str) {
        return str.toLowerCase();
    } // - Converts the input string to lowercase and returns the result.

    public boolean containsSubstring(String str, String subStr) {
        return str.contains(subStr);
    } // - Checks if the input string contains the given substring and returns true if it does, otherwise returns false.
}