import org.junit.Assert

class TestSquareCountry extends GroovyTestCase {


    void test()
    {
        def squareCountry = new SquareCountry();
        Assert.assertEquals(3, squareCountry.lookupCertificate(344));
    }

}
