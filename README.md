# spark

This is a simple word count project using spark.

Run on a cluster
================

Start master
------------
Assuming that spark dir is: spark-2.3.0-bin-hadoop2.7
Run:
    ./spark-2.3.0-bin-hadoop2.7/sbin/start-master.sh
Go to: 
    locahost:8080
And find spark master URL

Start slave
-----------
Assuming that spark dir is: spark-2.3.0-bin-hadoop2.7
Run:
    ./spark-2.3.0-bin-hadoop2.7/sbin/start-slave.sh spark:master-URL

Run App
-------
Now we are ready to install our app and submit it. To do that
clone the project and build it with maven. Then get the .jar file
created and put it somewhere we can submit it with spark-submit.

In this example spark is installed in linux and this is an example working in bash.
To run the project jar we do:
    spark-submit --master spark://master-URL --class anaptec.com.spark.App spark-1.0-SNAPSHOT.jar | less
There is a lot of console output when running apa with in spark so to see all the output we pipe it 
to less command.

Output
------
In the linux environment we should have a file named in.txt in the dir /tmp/in.txt
In the linux environment after running the app we should have a dir /tmp/output created. in there
we have the spark results. open the files to see the result.

