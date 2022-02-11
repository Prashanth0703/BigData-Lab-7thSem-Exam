package avg;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class mapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{
	public void map(LongWritable key,Text value,Context con) throws IOException,InterruptedException{
		String s = value.toString();
		String data[] = s.split("\t");
		double sal = Double.parseDouble(data[8]);
		con.write(new Text(data[3]),new DoubleWritable(sal));
	}
}
