package anaptec.com.spark;
/**
 * This is the class to initialize the process of word counting applications
 */
public class App 
{
    public static void main(String [] args)
    {
        //Init the spark process
        SparkWordCount.countWords();
    }
}
