package anaptec.com.spark;

//Importing all libraries from core spark
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
//Importing Arrays from java
import java.util.Arrays;

/**
 * This class is a simple demonstration for using apache spark on a cluster on
 * a local development environment. It will count the number of words in a given
 * file and create the results after the process finishes
 */
public class SparkWordCount {
    //Class fields
    private static JavaRDD<String> input;
    private static JavaRDD<String> words;
    private static JavaPairRDD<String, Integer> counts;
    //Path to the input file to be processed (this is linux path)
    public static final String INPUT_FILE = "/tmp/in.txt";
    //Path to ouptut directory for spark results (this folder needs to be deleted before every run)
    public static final String OUTPUT_FILE = "/tmp/output";

    public static void countWords(){
        // Define a configuration to use to interact with Spark
        SparkConf conf = new SparkConf().setAppName("Word Count");
        // Create a Java version of the Spark Context from the configuration
        JavaSparkContext sc = new JavaSparkContext(conf);
        // Load the input data, which is a text file read from /tmp/in.txt
        // in.txt should be created first before running the app
        input = sc.textFile(INPUT_FILE);

        // Java 8 with lambdas: split the input string into words
        words = input.flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        // Java 8 with lambdas: transform the collection of words into pairs (word and 1) and then count them
        counts = words.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        // Save the word count back out to a text file.
        counts.saveAsTextFile( OUTPUT_FILE);

        //Very important to close the resource or else you will get all sorts of errors
        sc.close();
    }
}
