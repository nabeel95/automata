import java.util.ArrayList;
import java.util.List;

public class State {

    private final String name;
    private final Boolean isInitial;
    private final Boolean isFinal;
    private List<Transition> transitionlist = new ArrayList<>();

    public State(String name, Boolean isInitial, Boolean isFinal) {
        this.name = name;
        this.isInitial = isInitial;
        this.isFinal = isFinal;
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

    public void bindTransition(Transition transition) {
        this.transitionlist.add(transition);
    }

    public List<Transition> getBindedTransition() {
        return transitionlist;
    }

    public String move(String command) {
        String movedTo = "";
        for (int i = 0; i < transitionlist.size(); i++) {
            if (command == transitionlist.get(i).getCommand()) {
                movedTo = transitionlist.get(i).getEnd();
            }
        }
        return movedTo;
    }
}
