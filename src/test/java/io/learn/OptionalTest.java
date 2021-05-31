package io.learn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class OptionalTest {



    @Test
    @DisplayName("Exception on empty")
    void whenEmptyExceptionThen()
    {
        Optional<String> optional=Optional.empty();
        assertThrows(NoSuchElementException.class,()-> optional.get());
    }

    @Test
    @DisplayName("NPE validation")
    void whenNullValueIsPassed()
    {
        String name=null;
        //Optional<String> optional=Optional.of(name);
        assertThrows(NullPointerException.class,()->Optional.of(name));
    }

    @Test
    @DisplayName("Value is present")
    void testWhenValueIsProvided()
    {
        Optional<String> option=Optional.of("User");
        assertEquals("User",option.get());
    }

    @Test
    @DisplayName("Null value is accepted")
    void testWhenNullAbleAllowed()
    {
       String name=null;
       Optional<String> optional=Optional.ofNullable(name);
       assertEquals(Optional.empty(),optional);
    }

    @Test
    @DisplayName("Optional Value is present")
    void testOptionalIsPresent()
    {
        String name="dinesh";
        Optional<String> optional=Optional.ofNullable(name);
        assertTrue(optional.isPresent());
    }

    @Test
    @DisplayName("Optional value is not present")
    void testOptionalIsPresentFalse()
    {
        String name=null;
        Optional<String> optional=Optional.ofNullable(name);
        assertFalse(optional.isPresent());
    }

    @Test
    @DisplayName("OptionalInt value is not present")
    void testOptionalInt()
    {
        OptionalInt optionalInt=OptionalInt.empty();
        assertFalse(optionalInt.isPresent());
    }


    @Test
    @DisplayName("Optional value is not present")
    void testOptionalValuePresentOrNot()
    {
        String name=null;
        Optional<String> optional=Optional.ofNullable(name);
        optional.ifPresent(p->assertTrue(p!=null));
    }
}
