package wc;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MapperC extends Mapper<LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key,Text value,Context con) throws IOException,InterruptedException{
		String s=value.toString();
		String data[]=s.split(" ");
		System.out.println(data[1]);
		for(String d:data){
			con.write(new Text(d),new IntWritable(1));
		}
	}
}
