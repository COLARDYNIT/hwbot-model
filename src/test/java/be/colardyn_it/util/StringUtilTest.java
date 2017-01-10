package be.colardyn_it.util;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by frederik on 10/01/17.
 */
public class StringUtilTest {

    @Test
    public void testMakeSafeUrl() {
        assertThat(StringUtil.makeUrlSafe("banana boat!")).isEqualTo("banana_boat");
    }

}