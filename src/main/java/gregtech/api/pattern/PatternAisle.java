package gregtech.api.pattern;

public class PatternAisle {
    // not final because of setRepeatable and i need to have compat
    // actualRepeats stores the information for multiblock checks, while minRepeats and maxRepeats are rules
    protected int minRepeats, maxRepeats, actualRepeats;
    protected final String[] pattern;
    public PatternAisle(int minRepeats, int maxRepeats, String[] pattern) {
        this.minRepeats = minRepeats;
        this.maxRepeats = maxRepeats;
        this.pattern = pattern;
    }

    public PatternAisle(int repeats, String[] pattern) {
        this.minRepeats = this.maxRepeats = repeats;
        this.pattern = pattern;
    }

    public void setRepeats(int minRepeats, int maxRepeats) {
        this.minRepeats = minRepeats;
        this.maxRepeats = maxRepeats;
    }

    public void setRepeats(int repeats) {
        this.minRepeats = this.maxRepeats = repeats;
    }

    public void setActualRepeats(int actualRepeats) {
        this.actualRepeats = actualRepeats;
    }

    public int getActualRepeats() {
        return this.actualRepeats;
    }

    /**
     * Gets the first instance of the char in the pattern
     * @param c The char to find
     * @return An int array in the form of [ index into String[], index into String#charAt ], or null if it was not found
     */
    public int[] firstInstanceOf(char c) {
        for (int strI = 0; strI < pattern.length; strI++) {
            for (int chrI = 0; chrI < pattern[0].length(); chrI++) {
                if (pattern[strI].charAt(chrI) == c) return new int[] { strI, chrI };
            }
        }
        return null;
    }
}
