import org.jarotball.ds.ArrayExercise;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayExerciseTest {
    // Create an ArrayExercise instance
    ArrayExercise arrayExercise = new ArrayExercise();

    // Test1- Converting the array elements into uppercase
    @Test
    public void testArrayToUpperCase(){
        String[] input={"cat","dog","fish"};
        arrayExercise.arrayToUpperCase(input);
        assertArrayEquals(new String[]{"CAT","DOG","FISH"},input);
    }


    // Test2- Incrementing the array elements by +1
    @Test
    public void testIncrementArray(){
        int[] input={1,2,3,4,5,6};
        arrayExercise.incrementArray(input);
        assertArrayEquals(new int[]{2,3,4,5,6,7}, input);

    }
}
