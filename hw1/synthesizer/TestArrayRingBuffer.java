package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        arb.enqueue("a");   //231
        arb.enqueue("b");
        arb.dequeue();
        arb.dequeue();
        arb.enqueue("c");
        arb.enqueue("d");
        arb.enqueue("e");
        arb.dequeue();
        arb.enqueue("f");

        for(Object s: arb) {
            System.out.println(s);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
