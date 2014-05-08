/**
 * Created by ullink on 08/05/14.
 */
class SquareCountry {

    final int MAX_SIZE = 600000;
    int[] minCertStore = new int[MAX_SIZE];
    List<Integer> [] minCertCombinationStore = new List<Integer>[MAX_SIZE];

    public SquareCountry()
    {
        for (int i=1;i<=MAX_SIZE;i++)
        {
            lookupCertificate(i);
        }
    }

    public void dumpArray()
    {
        for (int i=1;i<=MAX_SIZE;i++)
        {
            System.out.println(i + " with min Cert: " + minCertStore[i-1] + "|" + minCertCombinationStore[i-1]);

            if (minCertStore[i-1] > 4)
            {
                break;
            }
        }

    }
    public int lookupCertificate(int quadrics)
    {
        //TODO

        if (minCertStore[quadrics-1] != 0)
        {
            return minCertStore[quadrics-1];
        }

        int minCert = quadrics + 1;
        int minCertCombinationQuadrics = -1;
        int minSquareRt = -1;

        try
        {
            int squareRt = Math.sqrt(quadrics);
            for (int i=squareRt; i> 0;i--)
            {
                int square = i*i;
                int nextQuadrics = quadrics - square;

                if (nextQuadrics == 0)
                {
                    minCert = 1;
                    minSquareRt = i;
                    break;
                }
                else
                {
                    int cert = lookupCertificate(nextQuadrics) + 1;
                    if (minCert > cert)
                    {
                        minSquareRt = i;
                        minCertCombinationQuadrics = nextQuadrics;
                        minCert = cert;
                    }
                }
            }
            return minCert;

        }
        finally
        {
            minCertCombinationStore[quadrics-1] = new ArrayList<>();
            minCertCombinationStore[quadrics-1].add(minSquareRt);
            if (minCertCombinationQuadrics != -1)
            {
                minCertCombinationStore[quadrics-1].addAll(minCertCombinationStore[minCertCombinationQuadrics-1]);
            }

            minCertStore[quadrics-1] = minCert;
        }
    }

}
