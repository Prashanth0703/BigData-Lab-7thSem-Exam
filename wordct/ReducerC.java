package wc;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class ReducerC extends Reducer<Text,IntWritable,Text,IntWritable>{
	public void reduce(Text key,Iterable<IntWritable> vals,Context con) throws IOException,InterruptedException{
		int c=0;
		for(IntWritable val:vals){
			c+=1;
		}
		con.write(key,new IntWritable(c));
	}
}
