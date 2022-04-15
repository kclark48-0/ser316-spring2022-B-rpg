package test.java;

import main.java.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class costTest {
    Cart cart1;
    double cart1Expected;
    Cart cart2;
    double cart2Expected;
    Cart cart3;
    double cart3Expected;
    Cart cart4;
    double cart4Expected;
    Cart cart5;
    double cart5Expected;
    Cart cart6;
    double cart6Expected;
    Cart cart7;
    double cart7Expected;
    Cart cart8;
    double cart8Expected;
    Cart cart9;
    double cart9Expected;
    Cart cart10;
    double cart10Expected;
    Cart cart11;
    double cart11Expected;
    Cart cart12;
    double cart12Expected;
    Cart cart13;
    double cart13Expected;
    Cart cart14;
    double cart14Expected;
    Cart cart15;
    double cart15Expected;
    Cart cart16;
    double cart16Expected;
    Cart cart17;
    double cart17Expected;
    Cart cart18;
    double cart18Expected;


    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        /*
        cart1 = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart1.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart1.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart1.addItem(new Meat());
        }
        cart1Expected = 70.2;
        */
        cart1 = new Cart(40);
        cart1.addItem(new Dairy());
        cart1Expected = 3.24;

        cart2 = new Cart(40);
        cart2.addItem(new Meat());
        cart2Expected = 10.80;

        cart3 = new Cart(40);
        cart3.addItem(new Produce());
        cart3Expected = 2.16;

        cart4 = new Cart(40);
        cart4.addItem(new Alcohol());
        cart4Expected = 8.64;

        cart5 = new Cart(40);
        cart5.addItem(new FrozenFood());
        cart5Expected = 5.40;

        // cart created with an age 20 shopper
        cart6 = new Cart(20);
        cart6.addItem(new Alcohol());
        cart6Expected = 8.64;

        // alcohol cart created with an age 15 shopper
        cart7 = new Cart(15);
        cart7.addItem(new Alcohol());
        cart7Expected = 8.64;

        // empty cart created with an age 40 shopper
        cart8 = new Cart(40);
        cart8Expected = 0.00;

        // Produce combo with an age 40 shopper
        cart9 = new Cart(40);
        for (int i = 0; i < 3; i++) {
            cart9.addItem(new Produce());
        }
        cart9Expected = 5.40;

        // Alcohol + Frozen combo with an age 40 shopper
        cart10 = new Cart(40);
        cart10.addItem(new Alcohol());
        cart10.addItem(new FrozenFood());
        cart10Expected = 10.80;

        // cart created with an age 21 shopper
        cart11 = new Cart(21);
        cart11.addItem(new Alcohol());
        cart11Expected = 8.64;

        // alcohol cart created with an age 22 shopper
        cart12 = new Cart(22);
        cart12.addItem(new Alcohol());
        cart12Expected = 8.64;

        // alcohol cart created with an age 0 shopper
        cart13 = new Cart(0);
        cart13.addItem(new Alcohol());
        cart13Expected = 8.64;

        // alcohol cart created with an age 19 shopper
        cart14 = new Cart(19);
        cart14.addItem(new Alcohol());
        cart14Expected = 8.64;

        // alcohol cart created with an age 1 shopper
        cart15 = new Cart(1);
        cart15.addItem(new Alcohol());
        cart15Expected = 8.64;

        // Alcohol + Frozen combo and Produce combo with an age 40 shopper
        cart16 = new Cart(40);
        cart16.addItem(new Alcohol());
        cart16.addItem(new FrozenFood());
        for (int i = 0; i < 3; i++) {
            cart16.addItem(new Produce());
        }
        cart16Expected = 16.20;

        // Big cart with an age 40 shopper
        cart17 = new Cart(40);
        for (int i = 0; i < 10; i++) {
            cart17.addItem(new Alcohol());
        }
        for (int i = 0; i < 10; i++) {
            cart17.addItem(new Dairy());
        }
        for (int i = 0; i < 10; i++) {
            cart17.addItem(new Meat());
        }
        for (int i = 0; i < 9; i++) {
            cart17.addItem(new Produce());
        }
        for (int i = 0; i < 10; i++) {
            cart17.addItem(new FrozenFood());
        }
        cart17Expected = 264.60;

        // Produce combo with an age 40 shopper
        cart18 = new Cart(40);
        for (int i = 0; i < 4; i++) {
            cart18.addItem(new Produce());
        }
        cart18Expected = 7.56;

    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    //This test checks for correct pricing on an empty cart
    @Test
    public void emptyCart40() throws UnderAgeException {
        double amount = cart8.calcCost();
        assertEquals(cart8Expected, amount, .01);
    }

    //Tests on cart1 through cart5 test for correct individual item price and tax rate
    @Test
    public void calcCostDairy() throws UnderAgeException {
        double amount = cart1.calcCost();
        assertEquals(cart1Expected, amount, .01);
    }

    @Test
    public void calcCostMeat() throws UnderAgeException {
        double amount = cart2.calcCost();
        assertEquals(cart2Expected, amount, .01);
    }

    @Test
    public void calcCostProduce() throws UnderAgeException {
        double amount = cart3.calcCost();
        assertEquals(cart3Expected, amount, .01);
    }

    @Test
    public void calcCostAlcohol() throws UnderAgeException {
        double amount = cart4.calcCost();
        assertEquals(cart4Expected, amount, .01);
    }

    @Test
    public void calcCostFrozen() throws UnderAgeException {
        double amount = cart5.calcCost();
        assertEquals(cart5Expected, amount, .01);
    }


    //The following tests check for correct pricing on the various combo discounts
    @Test
    public void calcProduceCombo() throws UnderAgeException {
        double amount = cart9.calcCost();
        assertEquals(cart9Expected, amount, .01);
    }

    @Test
    public void calcAlcFrzCombo() throws UnderAgeException {
        double amount = cart10.calcCost();
        assertEquals(cart10Expected, amount, .01);
    }

    @Test
    public void calcAlcFrzProdCombo() throws UnderAgeException {
        double amount = cart16.calcCost();
        assertEquals(cart16Expected, amount, .01);
    }

    @Test
    public void bigCart() throws UnderAgeException {
        double amount = cart17.calcCost();
        assertEquals(cart17Expected, amount, .01);
    }

    @Test
    public void produceNonMultipleOf3() throws UnderAgeException {
        double amount = cart18.calcCost();
        assertEquals(cart18Expected, amount, .01);
    }


    //These tests check for correct throwing of the UnderAgeException
    @Test
    public void checkID20() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        double amount = cart6.calcCost();
        assertEquals(cart6Expected, amount, .01);
    }

    @Test
    public void checkID15() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        double amount = cart7.calcCost();
        assertEquals(cart7Expected, amount, .01);
    }

    @Test
    public void checkID21() throws UnderAgeException {
        double amount = cart11.calcCost();
        assertEquals(cart11Expected, amount, .01);
    }

    @Test
    public void checkID22() throws UnderAgeException {
        double amount = cart12.calcCost();
        assertEquals(cart12Expected, amount, .01);
    }

    @Test
    public void checkID0() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        double amount = cart13.calcCost();
        assertEquals(cart13Expected, amount, .01);
    }

    @Test
    public void checkID19() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        double amount = cart14.calcCost();
        assertEquals(cart14Expected, amount, .01);
    }

    @Test
    public void checkID1() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        double amount = cart15.calcCost();
        assertEquals(cart15Expected, amount, .01);
    }
}
