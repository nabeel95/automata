import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class State {

    private final String name;
    private Boolean isInitial = false;
    private Boolean isFinal = false;
    private List<Transition> transitionlist = new ArrayList<>();

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean isFinal() {
        return isFinal;
    }

    public Boolean isInitial() {
        return isInitial;
    }

    public void setAsInitial() { this.isInitial = true; }

    public void setAsFinal() { this.isFinal = true; }

    public void bindTransition(Transition transition) {
        this.transitionlist.add(transition);
    }

    public List<Transition> getBindedTransition() {
        return transitionlist;
    }

    public String move(String command) {
        String movedTo = "";
        for (Transition aTransitionlist : transitionlist) {
            if (Objects.equals(command, aTransitionlist.getCommand())) {
                movedTo = aTransitionlist.getEnd();
            }
        }
        return movedTo;
    }
}
