import java.util.List;
import java.util.Objects;

public class DfaValidator {

    private List<State> states;
    private final List<String> commands;
    private final List<Transition> transitions;
    private final State initialState;
    private final List<State> finalStates;

    public DfaValidator(List<State> states, List<String> commands, List<Transition> transitions, State initialState, List<State> finalStates) {
        this.states = states;
        this.commands = commands;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.setInitialState();
        this.setFinalStates();
        this.bindTransitionToStates();
    }

    private void setInitialState() {
        for (State state : states) {
            if (Objects.equals(state.getName(), initialState.getName())) {
                state.setAsInitial();
            }
        }
    }

    private void setFinalStates() {
        for (State state : states) {
            for (State finalState : finalStates) {
                if (Objects.equals(state.getName(), finalState.getName())) {
                    state.setAsFinal();
                }
            }
        }
    }


    private State getStateByName(String name, List<State> stateSet) {
        State state = null;
        for (State aStateSet : stateSet) {
            if (Objects.equals(aStateSet.getName(), name)) {
                state = aStateSet;
            }
        }
        return state;
    }

    private void bindTransitionToStates() {
        for (Transition transition : transitions) {
            String stateName = transition.getStart();
            State state = getStateByName(stateName, states);
            state.bindTransition(transition);
        }
    }

    public boolean validate(String command) {
        State currentState = initialState;
        for (int i = 0; i < command.length(); i++) {
            String name = currentState.move(String.valueOf(command.charAt(i)));
            currentState = getStateByName(name, states);
        }
        return currentState.isFinal();
    }
}
