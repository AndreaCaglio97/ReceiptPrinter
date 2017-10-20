package it.intre.ReceiptPrinter;

import org.junit.Test;

import static it.intre.ReceiptPrinter.CommandLine.FetchProductManager.*;
import static org.junit.Assert.*;
public class FetchProductManagerTest {

    @Test
    public void exceptionHandledOnInputIdProductReturnFalseTest() {
        assertFalse(checkValidInputProductId(-1));
    }

    @Test
    public void inputNegativeIdProductReturnFalseTest() {
        assertFalse(checkValidInputProductId(-10));
    }
}