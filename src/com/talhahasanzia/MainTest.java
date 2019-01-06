package com.talhahasanzia;

import com.talhahasanzia.pojo.annotation.Boost;
import com.talhahasanzia.pojo.booster.PojoBooster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Random;

@RunWith(BlockJUnit4ClassRunner.class)
public class MainTest {

    // Mark this object to be boosted (initialized with dummy data)
    @Boost
    private Sample sample;

    @Before
    public void setUp() throws Exception {

        // initialize all boosters that were marked in this current class (MainTest.java)
        PojoBooster.boost(this);
    }

    @Test
    public void testValues() {
        System.out.println(sample.toString());
        // currently prints out dummy values as:
        // UserId: 23, UserType: c, User Sign: 24, UserName: sampleString

        // you can run your code and provide this object without any hassle of initializing it!
    }

}