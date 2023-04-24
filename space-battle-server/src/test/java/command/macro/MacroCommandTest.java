package command.macro;

import command.Command;
import exception.command.CommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoInteractions;

class MacroCommandTest {
    MacroCommand macroCommand;
    Command command1;
    Command command2;

    @BeforeEach
    void setUp() {
        command1 = Mockito.mock(Command.class);
        command2 = Mockito.mock(Command.class);
        macroCommand = new MacroCommand(List.of(command1, command2));
    }

    @Test
    @DisplayName("Проверка метода execute: после добавления в очередь и вызова execute() должны быть выполнены команды command1 и command2")
    void test1() {
        doNothing()
                .when(command1)
                .execute();
        doNothing()
                .when(command2)
                .execute();

        macroCommand.execute();

        verify(command1).execute();
        verify(command2).execute();
    }

    @Test
    @DisplayName("Проверка метода execute: когда при выполнении command1 выброшено исключение, command2 не выполняется")
    void test2() {
        doThrow(new RuntimeException())
                .when(command1)
                .execute();

        assertThrows(CommandException.class, () -> macroCommand.execute());

        verify(command1).execute();
        verifyNoInteractions(command2);
    }
}