import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionTest {
    private Transition transition;

    @Before
    public void setUp() {
        transition = new Transition("q1", "0", "q2");
    }

    @Test
    public void getStart() {
        Assert.assertEquals("q1", transition.getStart());
    }

    @Test
    public void getCommand() {
        Assert.assertEquals("0", transition.getCommand());
    }

    @Test
    public void getEnd() {
        Assert.assertEquals("q2", transition.getEnd());
    }

}