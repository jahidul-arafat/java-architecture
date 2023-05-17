package org.jarotball.bufferoverflow;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeBufferOverflow {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafeInstance();

        long bufferAddress = unsafe.allocateMemory(8); // Allocate memory for 8 bytes
        unsafe.putLong(bufferAddress + 12, 123456789L); // Buffer overflow occurs here

        long value = unsafe.getLong(bufferAddress + 12); // Read the value from the modified memory location
        System.out.println("Value: " + value);

        unsafe.freeMemory(bufferAddress); // Free the allocated memory

    }
    private static Unsafe getUnsafeInstance() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(null);
    }
}
