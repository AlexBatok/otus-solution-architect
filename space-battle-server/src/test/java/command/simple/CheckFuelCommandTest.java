package command.simple;

import entity.Fuelable;
import exception.command.CheckFuelCommandException;
import exception.command.CommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CheckFuelCommandTest {

    private Fuelable fuelable;

    private CheckFuelCommand checkFuelCommand;

    @BeforeEach
    void setUp() {
        fuelable = Mockito.mock(Fuelable.class);
        checkFuelCommand = new CheckFuelCommand(fuelable);
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 2 проверка уровня топлива не бросает исключений")
    void test1() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(2)
                .when(fuelable)
                .getFuelConsumptionRate();

        Assertions.assertDoesNotThrow(()-> checkFuelCommand.execute());
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 5 проверка уровня топлива не бросает исключений")
    void test2() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(2)
                .when(fuelable)
                .getFuelConsumptionRate();

        Assertions.assertDoesNotThrow(()-> checkFuelCommand.execute());
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 6 проверка уровня топлива бросает NotEnoughFuelException")
    void test3() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(6)
                .when(fuelable)
                .getFuelConsumptionRate();

        CommandException e = Assertions.assertThrows(CommandException.class, ()-> checkFuelCommand.execute());
        assertTrue(e instanceof CheckFuelCommandException);
    }
}