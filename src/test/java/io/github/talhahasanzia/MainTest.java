package io.github.talhahasanzia;

import io.github.talhahasanzia.annotation.Boost;
import io.github.talhahasanzia.booster.PojoBooster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MainTest {

    @Boost
    SampleDto sampleDto;

    @Boost
    Sample sample;

    @Before
    public void setUp() throws Exception {
        PojoBooster.boost(this);
    }

    @Test
    public void main() {

        System.out.println(sampleDto.name + ", " + sampleDto.age + ", " + sampleDto.id);

        System.out.println(sample.toString());
    }

    class TestDto extends SampleDto {

    }
}