import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
    private State state;

    @Before
    public void setUp() {
        state = new State("q1", false, false);
    }

    @Test
    public void shouldReturnNameOfState() {
        Assert.assertEquals("q1", state.getName());
    }

    @Test
    public void shouldReturnFalseForIsInitial() {
        Assert.assertFalse(state.isInitial());
    }

    @Test
    public void shouldReturnFalseForIsFinal() {
        Assert.assertFalse(state.isFinal());
    }

    @Test
    public void shouldBindTransition() {
        state.bindTransition(new Transition("q1", "0", "q2"));
        Assert.assertEquals(1, state.getBindedTransition().size());
        state.bindTransition(new Transition("q1", "1", "q3"));
        Assert.assertEquals(2, state.getBindedTransition().size());
    }

    @Test
    public void shouldReturnMovedToState() {
        state.bindTransition(new Transition("q1", "0", "q2"));
        state.bindTransition(new Transition("q1", "1", "q3"));
        Assert.assertEquals("q3", state.move("1"));
    }
}