package command.macro;

import command.simple.BurnFuelCommand;
import command.simple.CheckFuelCommand;
import command.simple.MoveCommand;
import exception.CommandException;
import exception.NotEnoughFuelException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MoveForwardWithFuelBurnMacroCommandTest {
    MoveForwardWithFuelBurnMacroCommand macroCommand;
    CheckFuelCommand checkFuelCommand;
    MoveCommand moveCommand;
    BurnFuelCommand burnFuelCommand;

    @BeforeEach
    void setUp() {
        checkFuelCommand = Mockito.mock(CheckFuelCommand.class);
        moveCommand = Mockito.mock(MoveCommand.class);
        burnFuelCommand = Mockito.mock(BurnFuelCommand.class);
        macroCommand = new MoveForwardWithFuelBurnMacroCommand(checkFuelCommand, moveCommand, burnFuelCommand);
    }

    @Test
    @DisplayName("Проверка метода execute: должны быть выполнены команды checkFuelCommand, moveCommand и burnFuelCommand")
    void test1() {
        doNothing()
                .when(checkFuelCommand)
                .execute();
        doNothing()
                .when(moveCommand)
                .execute();
        doNothing()
                .when(burnFuelCommand)
                .execute();

        macroCommand.execute();

        verify(checkFuelCommand).execute();
        verify(moveCommand).execute();
        verify(burnFuelCommand).execute();
    }

    @Test
    @DisplayName("Проверка метода execute: когда при выполнении checkFuelCommand выброшено исключение, moveCommand и burnFuelCommand не выполняются")
    void test2() {
        doThrow(new NotEnoughFuelException())
                .when(checkFuelCommand)
                .execute();

        assertThrows(CommandException.class, () -> macroCommand.execute());

        verify(checkFuelCommand).execute();
        verifyNoInteractions(moveCommand);
        verifyNoInteractions(burnFuelCommand);
    }
}