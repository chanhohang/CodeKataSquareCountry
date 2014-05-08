import org.junit.Assert

class TestSquareCountry extends GroovyTestCase {


    void test()
    {
        def squareCountry = new SquareCountry();
        Assert.assertEquals(4, squareCountry.lookupCertificate(7));
        Assert.assertEquals(3, squareCountry.lookupCertificate(11));
        Assert.assertEquals(1, squareCountry.lookupCertificate(256));

        Assert.assertEquals(3, squareCountry.lookupCertificate(344));

        Assert.assertEquals(2, squareCountry.lookupCertificate(200));

        Assert.assertEquals(2, squareCountry.lookupCertificate(200));

        Assert.assertEquals(1, squareCountry.lookupCertificate((int)Math.pow(200,2)));

        Assert.assertEquals(1, squareCountry.lookupCertificate((int)Math.pow(230,2)));

        squareCountry.dumpArray();
    }

}
