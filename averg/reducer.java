package avg;
import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class reducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable>{
        public void reduce(Text key,Iterable<DoubleWritable> values,Context con) throws IOException,InterruptedException{
		String s=key.toString();
		if(s.equals("M")){
			double c=0.0,tot=0.0,av=0.0;
			for(DoubleWritable v:values){
				c+=1;
				tot+=v.get();
			}
			av=tot/c;
			con.write(key,new DoubleWritable(av));
			con.write(key,new DoubleWritable(c));
		}
		else{
			double c=0.0,tot=0.0,av=0.0;
                        for(DoubleWritable v:values){
                                c+=1;
                                tot+=v.get();
                        }
                        av=tot/c;
                        con.write(key,new DoubleWritable(av));
                        con.write(key,new DoubleWritable(c));
                }
	}
}
