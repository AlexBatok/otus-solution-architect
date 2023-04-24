package command.simple;

import entity.Fuelable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BurnFuelCommandTest {

    private Fuelable fuelable;

    private BurnFuelCommand burnFuelCommand;

    @BeforeEach
    void setUp() {
        fuelable = Mockito.mock(Fuelable.class);
        burnFuelCommand = new BurnFuelCommand(fuelable);
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 2 сжигание топлива устанавливает текущий уровень топлива 3")
    void test1() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(2)
                .when(fuelable)
                .getFuelConsumptionRate();
        doNothing()
                .when(fuelable)
                .setFuelLevel(anyInt());

        burnFuelCommand.execute();

        verify(fuelable).setFuelLevel(eq(3));
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 5 сжигание топлива устанавливает текущий уровень топлива 0")
    void test2() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(5)
                .when(fuelable)
                .getFuelConsumptionRate();
        doNothing()
                .when(fuelable)
                .setFuelLevel(anyInt());

        burnFuelCommand.execute();

        verify(fuelable).setFuelLevel(eq(0));
    }

    @Test
    @DisplayName("Для объекта с текущим уровнем топлива 5 и скоростью сжигания топлива 6 сжигание топлива устанавливает текущий уровень топлива -1")
    void test3() {
        doReturn(5)
                .when(fuelable)
                .getFuelLevel();
        doReturn(6)
                .when(fuelable)
                .getFuelConsumptionRate();
        doNothing()
                .when(fuelable)
                .setFuelLevel(anyInt());

        burnFuelCommand.execute();

        verify(fuelable).setFuelLevel(eq(-1));
    }
}