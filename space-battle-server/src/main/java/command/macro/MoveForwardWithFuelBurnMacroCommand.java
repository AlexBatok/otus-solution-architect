package command.macro;

import command.simple.BurnFuelCommand;
import command.simple.CheckFuelCommand;
import command.simple.MoveCommand;

import java.util.List;

public class MoveForwardWithFuelBurnMacroCommand extends MacroCommand {

    public MoveForwardWithFuelBurnMacroCommand(
            CheckFuelCommand checkFuelCommand,
            MoveCommand moveCommand,
            BurnFuelCommand burnFuelCommand) {
        super(List.of(checkFuelCommand, moveCommand, burnFuelCommand));
    }
}
