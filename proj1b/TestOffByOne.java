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
        assertFalse(a.equalChars('a', 'a'));
        assertFalse(a.equalChars('a', 'c'));
    }
}
