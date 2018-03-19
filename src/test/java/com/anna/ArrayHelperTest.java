package com.anna;

import org.junit.Assert;
import org.junit.Test;

public class ArrayHelperTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGenerate_startGreaterThanEnd_throwsException() {
        ArrayHelper.generate(100, 50, 10);
    }

    @Test
    public void testGenerate_startEqualsEnd_arrayOfSizeOne() {
        int[] arr = ArrayHelper.generate(50, 50, 140);
        int[] expected = new int[] {50};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testGenerate_oneStep_arrayOfSizeTwo() {
        int[] arr = ArrayHelper.generate(50, 51, 1);
        int[] expected = new int[] {50, 51};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testGenerate_tenSteps_arrayOfSizeTen() {
        int[] arr = ArrayHelper.generate(1, 28, 3);
        int[] expected = new int[] {1, 4, 7, 10, 13, 16, 19, 22, 25, 28};
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void testIsSortedArrayInRange_containsLesserThanMin_false() {
        Assert.assertEquals(false, ArrayHelper.isSortedArrayInRange(new int[] {10, 20}, 18, 23));
    }

    @Test
    public void testIsSortedArrayInRange_containsGreaterThanMax_false() {
        Assert.assertEquals(false, ArrayHelper.isSortedArrayInRange(new int[] {10, 20}, 8, 13));
    }

    @Test
    public void testIsSortedArrayInRange_notSorted_false() {
        Assert.assertEquals(false, ArrayHelper.isSortedArrayInRange(new int[] {10, 13, 15, 23, 20}, 0, 100));
    }

    @Test
    public void testIsSortedArrayInRange_sortedWithinRange_true() {
        Assert.assertEquals(true, ArrayHelper.isSortedArrayInRange(new int[] {10, 13, 15, 23}, 0, 100));
    }
}
