package com.example.producer;

import org.junit.Assert;
import org.junit.Test;

public class ReservationPojoTest {

    @Test
    public void create() throws Exception {
        Reservation r = new Reservation("1", "sohel");

        Assert.assertEquals("sohel", r.getName());
        Assert.assertNotNull(r.getId());


    }
}
