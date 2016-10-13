public class Transition {
    private final String start;
    private final String command;
    private final String end;

    public Transition(String start, String command, String end) {
        this.start = start;
        this.command = command;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getCommand() {
        return command;
    }

    public String getEnd() {
        return end;
    }
}
