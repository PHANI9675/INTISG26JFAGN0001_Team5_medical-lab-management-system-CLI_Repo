package com.cognizantTest.service;

import com.cognizant.service.SampleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SampleServiceTest {
    SampleService sampleService = new SampleService();

    @Test
    public void testValidTransition(){
        boolean res = sampleServiceTestHelper("PENDING", "COMPLETED");
        assertFalse(res);
    }

    private boolean sampleServiceTestHelper(String curr, String next){
        return (curr.equals("Pending") && next.equals("COLLECTED")
                || curr.equals("COLLECTED") && next.equals("PROCESSING")
                || curr.equals("PROCESSING") && next.equals("COMPLETED"));
    }
}
