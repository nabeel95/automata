import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DfaValidatorTest {
    State q1 = new State("q1");
    State q2 = new State("q2");
    Transition q10 = new Transition("q1", "0", "q2");
    Transition q11 = new Transition("q1", "1", "q1");
    Transition q20 = new Transition("q2", "0", "q1");
    Transition q21 = new Transition("q2", "1", "q2");
    List<State> states = new ArrayList<>();
    List<String> commands = new ArrayList<>();
    List<Transition> transitions = new ArrayList<>();
    List<State> finalStates = new ArrayList<>();
    private DfaValidator validator;
    @Before
    public void setUp() throws Exception {
        states.add(q1);
        states.add(q2);
        commands.add("0");
        commands.add("1");
        transitions.add(q10);
        transitions.add(q11);
        transitions.add(q20);
        transitions.add(q21);
        finalStates.add(q2);
        validator = new DfaValidator(states, commands, transitions, q1, finalStates);
    }

    @Test
    public void validatorShouldValidate() {
        Assert.assertTrue(validator.validate("0"));
        Assert.assertTrue(validator.validate("000"));
        Assert.assertTrue(validator.validate("00000"));
        Assert.assertTrue(validator.validate("10"));
        Assert.assertTrue(validator.validate("101010"));
        Assert.assertTrue(validator.validate("010101"));

        Assert.assertFalse(validator.validate("00"));
        Assert.assertFalse(validator.validate("0000"));
        Assert.assertFalse(validator.validate("1001"));
        Assert.assertFalse(validator.validate("1010"));
        Assert.assertFalse(validator.validate("001100"));
    }
}