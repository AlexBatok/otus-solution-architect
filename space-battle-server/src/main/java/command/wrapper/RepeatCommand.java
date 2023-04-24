package command.wrapper;

import command.Command;

public class RepeatCommand implements CommandWrapper {

    private final Command cmd;

    public RepeatCommand(Command cmd) {
        this.cmd = cmd;
    }

    @Override
    public void execute() {
        cmd.execute();
    }

    @Override
    public Command getSourceCommand() {
        return cmd;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RepeatCommand{");
        sb.append("cmd=").append(cmd);
        sb.append('}');
        return sb.toString();
    }
}
