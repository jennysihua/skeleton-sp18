import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(2);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("bob"));
        assertFalse(palindrome.isPalindrome("nope"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));

    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("sbbecar", offByOne));
        assertFalse(palindrome.isPalindrome("slake", offByOne));
        assertFalse(palindrome.isPalindrome("spacecar", offByOne));

    }

    @Test
    public void testIsPalindromeOffByN() {
        assertTrue(palindrome.isPalindrome("gmake", offByN));
        assertTrue(palindrome.isPalindrome("tcaecar", offByN));
        assertFalse(palindrome.isPalindrome("glake", offByN));
        assertFalse(palindrome.isPalindrome("spacecar", offByN));
    }

}
