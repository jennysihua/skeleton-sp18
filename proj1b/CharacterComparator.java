/** This interface defines a method for determining equality of characters. */
//Interesting that all methods are public by default. Interfaces seem to specify an API.

public interface CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    boolean equalChars(char x, char y);
}
