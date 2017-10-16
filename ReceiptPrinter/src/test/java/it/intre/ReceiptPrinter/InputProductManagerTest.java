package it.intre.ReceiptPrinter;

import org.junit.Test;

import static it.intre.ReceiptPrinter.CommandLine.InputProductManager.*;
import static org.junit.Assert.*;

public class InputProductManagerTest {

    @Test
    public void inputNegativePriceReturnFalseTest() {
        assertFalse(checkValidInputPrice(-10));
    }

    @Test
    public void inputPositivePriceReturnTrueTest() {
        assertTrue(checkValidInputPrice(10));
    }

    @Test
    public void inputTooSmallPriceReturnFalseTest() {
        assertFalse(checkValidInputPrice(0.009));
    }

    @Test
    public void inputCategoryNumberBetween1And5ReturnTrueTest() {
        assertTrue(checkValidInputCategory(3));
    }

    @Test
    public void inputCategoryNumberGreaterThan5ReturnFalseTest() {
        assertFalse(checkValidInputCategory(6));
    }

    @Test
    public void inputCategoryNumberLessThan1ReturnFalseTest() {
        assertFalse(checkValidInputCategory(0));
    }

}