import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    //* You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

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
        CharacterComparator cc = new OffByOne();

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("yuuy"));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("APPPPA"));
        assertTrue(palindrome.isPalindrome("AaaA"));
        assertTrue(palindrome.isPalindrome("a  a"));
        assertTrue(palindrome.isPalindrome("abbba"));

        assertFalse(palindrome.isPalindrome("dog"));
        assertFalse(palindrome.isPalindrome("ccccca"));
        assertFalse(palindrome.isPalindrome("yuuyy"));
        assertFalse(palindrome.isPalindrome("loveu"));
        assertFalse(palindrome.isPalindrome("FOLISH"));

        assertFalse(palindrome.isPalindrome("AaAa"));
        assertFalse(palindrome.isPalindrome("AaAa"));

        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome(" ", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("stegosaur", cc));
        assertTrue(palindrome.isPalindrome("ardeb", cc));
        assertFalse(palindrome.isPalindrome("yy", cc));
        assertFalse(palindrome.isPalindrome("uiop", cc));
        assertFalse(palindrome.isPalindrome("[][]", cc));
        assertFalse(palindrome.isPalindrome("0987", cc));
    }
}
