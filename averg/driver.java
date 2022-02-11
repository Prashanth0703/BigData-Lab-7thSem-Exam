package avg;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
public class driver{
	public static void main(String args[]){
	try{
		Configuration conf = new Configuration();
		Job j=Job.getInstance(conf);
		j.setJarByClass(driver.class);
		j.setMapperClass(mapper.class);
		j.setReducerClass(reducer.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(DoubleWritable.class);
		Path pi = new Path(args[0]);
		Path po = new Path(args[1]);
		FileInputFormat.addInputPath(j,pi);
		FileOutputFormat.setOutputPath(j,po);
		System.exit(j.waitForCompletion(true)?1:0);
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
}
}
