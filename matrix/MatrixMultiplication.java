package Matrix;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
public class MatrixMultiplication{
public static void main(String args[]){
try{
Configuration conf= new Configuration();
conf.set("m","2");
conf.set("n","5");
conf.set("p","3");
Job job= Job.getInstance(conf);
job.setJarByClass(MatrixMultiplication.class);
job.setMapperClass(MatrixMapper.class);
job.setReducerClass(MatrixReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);
Path pi=new Path(args[0]);
Path po=new Path(args[1]);
FileInputFormat.addInputPath(job,pi);
FileOutputFormat.setOutputPath(job,po);
job.waitForCompletion(true);
}
catch(Exception e){
e.printStackTrace();
}
}
}
