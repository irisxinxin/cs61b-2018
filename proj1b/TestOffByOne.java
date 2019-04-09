import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        OffByOne a = new OffByOne();
        assertTrue(a.equalChars('a', 'b'));
        assertTrue(a.equalChars('b', 'a'));
        assertTrue(a.equalChars('A', 'B'));
        assertTrue(a.equalChars('X', 'Y'));
        assertTrue(a.equalChars('a', 'z'));
        assertTrue(offByOne.equalChars('(', ')'));
        assertTrue(offByOne.equalChars('=', '>'));
        assertTrue(offByOne.equalChars('@', 'A'));

        assertFalse(a.equalChars('a', 'a'));
        assertFalse(a.equalChars('a', 'c'));
        assertFalse(a.equalChars('9', 'b'));
        assertFalse(a.equalChars('[', 'A'));
        assertFalse(a.equalChars('a', 'B'));
        assertFalse(a.equalChars('3', 'A'));
        assertFalse(offByOne.equalChars('A', 'b'));
        assertFalse(offByOne.equalChars('Z', 'a'));
        assertTrue(offByOne.equalChars('(', ')'));
        assertTrue(offByOne.equalChars('=', '>'));
        assertTrue(offByOne.equalChars('@', 'A'));
        assertFalse(offByOne.equalChars('&', ')'));
        assertFalse(offByOne.equalChars('!', '?'));
        assertFalse(a.equalChars(' ', 'a'));
    }
}
