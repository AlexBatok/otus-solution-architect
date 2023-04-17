package command.impl;

import entity.Rotatable;
import entity.impl.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class RotateCommandTest {
    Rotatable rotatable;
    RotateCommand rotateCommand;

    @BeforeEach
    void setUp() {
        rotatable = mock();
        rotateCommand = new RotateCommand(rotatable);
    }

    @Test
    @DisplayName("Для объекта, находящегося в угловом положении 6 из 8 и поворачивающегося с угловой скоростью 4, " +
            "движение меняет угловое положение объекта на 2")
    void test1() {
        doReturn(new Direction(6))
                .when(rotatable)
                .getDirection();
        doReturn(4)
                .when(rotatable)
                .getAngularVelocity();
        doNothing()
                .when(rotatable)
                .setDirection(any());

        rotateCommand.execute();

        verify(rotatable).setDirection(eq(new Direction(2)));
    }

    @Test
    @DisplayName("Для объекта, находящегося в угловом положении 2 из 8 и поворачивающегося с угловой скоростью -4, " +
            "движение меняет угловое положение объекта на 6")
    void test2() {
        doReturn(new Direction(2))
                .when(rotatable)
                .getDirection();
        doReturn(-4)
                .when(rotatable)
                .getAngularVelocity();
        doNothing()
                .when(rotatable)
                .setDirection(any());

        rotateCommand.execute();

        verify(rotatable).setDirection(eq(new Direction(6)));
    }

    @Test
    @DisplayName("Попытка повернуть объект, у которого невозможно прочитать угловую скорость, приводит к ошибке")
    void test3() {
        doThrow(new NullPointerException())
                .when(rotatable)
                .getAngularVelocity();

        Assertions.assertThrows(Exception.class, () -> {
            rotateCommand.execute();
        });
    }

    @Test
    @DisplayName("Попытка повернуть объект, у которого невозможно прочитать направление, приводит к ошибке")
    void test4() {
        doReturn(-4)
                .when(rotatable)
                .getAngularVelocity();
        doThrow(new NullPointerException())
                .when(rotatable)
                .getDirection();

        Assertions.assertThrows(Exception.class, () -> {
            rotateCommand.execute();
        });
    }

    @Test
    @DisplayName("Попытка повернуть объект, у которого невозможно изменить направление, приводит к ошибке")
    void test5() {
        doReturn(new Direction(2))
                .when(rotatable)
                .getDirection();
        doReturn(-4)
                .when(rotatable)
                .getAngularVelocity();
        doThrow(new RuntimeException())
                .when(rotatable)
                .setDirection(any());

        Assertions.assertThrows(Exception.class, () -> {
            rotateCommand.execute();
        });
    }
}