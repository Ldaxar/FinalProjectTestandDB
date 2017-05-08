package core.DBproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by CosticaTeodor on 08/05/2017.
 */
public class testFunctIT {

    @Test
    public void testFunctionality() {
        assertEquals(10, functionality.giveMeTen());
    }

}
