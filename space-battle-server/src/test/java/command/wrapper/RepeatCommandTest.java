package command.wrapper;

import command.Command;
import command.simple.MoveCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RepeatCommandTest {
    Command repeatCommand;
    Command someCommand;

    @BeforeEach
    void setUp() {
        someCommand = mock(MoveCommand.class);
        repeatCommand = new RepeatCommand(someCommand);
    }

    @Test
    void test1() {
        repeatCommand.execute();

        verify(someCommand).execute();
    }
}