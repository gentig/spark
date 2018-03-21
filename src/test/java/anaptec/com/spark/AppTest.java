package anaptec.com.spark;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Word Count");
        // Create a Java version of the Spark Context from the configuration
        JavaRDD<String> input;
        JavaRDD<String> words;
        JavaPairRDD<String, Integer> counts;
        JavaSparkContext sc = new JavaSparkContext(conf);
        // Load the input data, which is a text file read from the command line
        input = sc.textFile("src/main/resources/in.txt");

        sc.close();
        assertTrue( true );
    }
}
