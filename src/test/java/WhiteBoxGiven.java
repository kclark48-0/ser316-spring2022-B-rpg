package test.java;

import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class WhiteBoxGiven {

    Cart cart;
    Cart cart1;
    Cart cart2;
    Cart cart3;
    Cart cart4;
    Cart cart5;
    Cart cart6;

    @Before
    public void setUp() throws Exception {
        cart = new Cart(45);
        cart.addItem(new Produce());

        cart1 = new Cart(40);

        cart2 = new Cart(20);
        for (int i = 0; i < 3; i++) {
            cart2.addItem(new Produce());
        }
        cart2.addItem(new Alcohol());

        cart3 = new Cart(21);
        for (int i = 0; i < 3; i++) {
            cart3.addItem(new Produce());
        }
        cart3.addItem(new Alcohol());
        cart3.addItem(new FrozenFood());

        cart4 = new Cart(18);
        cart4.addItem(new Dairy());

        cart5 = new Cart(22);
        cart5.addItem(new Produce());
        cart5.addItem(new Alcohol());
        cart5.addItem(new FrozenFood());

        cart6 = new Cart(50);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getTaxAZ() {
        assertEquals(4.0, cart.getTax(50, "AZ"), .01);
    }

    //Addresses sequence ii.a from document
    @Test
    public void emptyCart() throws UnderAgeException {
        assertEquals(0.0, cart1.Amount_saved(), 0.01);
    }

    //Addresses sequence i.a and ii.b from document
    @Test
    public void underAgeWithProduceCombo() throws UnderAgeException {
        exceptionRule.expect(UnderAgeException.class);
        assertEquals(1.00, cart2.Amount_saved(), 0.01);
    }

    //Addresses sequence i.b from document
    @Test
    public void alcFrzProdCombos() throws UnderAgeException {
        assertEquals(4.00, cart3.Amount_saved(), 0.01);
    }

    //Addresses sequence ii.c from document
    @Test
    public void noCombosJustDairy() throws UnderAgeException {
        assertEquals(0.00, cart4.Amount_saved(), 0.01);
    }

    //Addresses sequence ii.d from document
    @Test
    public void alcFrzComboWithOneProduce() throws UnderAgeException {
        assertEquals(3.00, cart5.Amount_saved(), 0.01);
    }

    @Test
    public void getTaxCA() {
        assertEquals(4.5, cart.getTax(50, "CA"), .01);
    }

    @Test
    public void getTaxNY() {
        assertEquals(5.0, cart.getTax(50, "NY"), .01);
    }

    @Test
    public void getTaxCO() {
        assertEquals(3.5, cart.getTax(50, "CO"), .01);
    }

    @Test
    public void getTaxOther() {
        assertEquals(50.0, cart.getTax(50, "UT"), .01);
    }

    @Test
    public void addItem() {
        assertTrue(cart.cart.get(0) instanceof Produce);
    }

    @Test
    public void removeItemSuccess() {
        Alcohol hendricks = new Alcohol();
        cart.addItem(hendricks);
        assertTrue(cart.removeItem(hendricks));
    }

    @Test
    public void removeItemFailure() {
        Alcohol hendricks = new Alcohol();
        Alcohol bulleit = new Alcohol();
        cart6.addItem(hendricks);
        assertFalse(cart.removeItem(bulleit));
    }

}