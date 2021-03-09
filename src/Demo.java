import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.stream.Stream;

public class Demo {
	
	
	
	public static void main(String[] args) throws IOException {
		Demo d=new Demo();
		QueryBuilder h=new QueryBuilder();
		// TODO Auto-generated method stub
		/*Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		String timeString = "15:05:10";
		int hour = Integer.parseInt(timeString.split(":")[0]);
		int min = Integer.parseInt(timeString.split(":")[1]);
		int seconds = Integer.parseInt(timeString.split(":")[2]);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, seconds);
		long expectedTime = cal.getTimeInMillis();
		File f = new File("/Users/vivekkulkarni/eclipse-workspace/CalendarDemo/src/Demo.java");
		long actualFileTime = f.lastModified();
		if(actualFileTime < expectedTime) {
			System.out.println("File is Intime");
		}else {
			System.out.println("File is LATE");
		}*/
		
			
		String[] values= {"hello","ko","jio","jihu"};
		// int [] fieldLen = Stream.of(properties.getProperty("lenGN.txt").split(",")).mapToInt(Integer::parseInt).toArray();
		//String[] f=properties.getProperty("A.txt").split(",");
		
		//h.createTable("A.txt",d.getFieldVal(),d.getFieldType());*/
	d.insertIntoQuery("yxu.txt",5);
		
		
		
	}
	public String insertIntoQuery(String name,int len)
	{ String fname =name.substring(0,name.indexOf("."));
	String sql="",val="";
	int i=0;
	while(i!=(len-1)) {
		
		val=val+"?,";
	}
	val+="?";
		  sql="insert into "+fname+" values( "+val+");";
	         
	           System.out.println(sql);
	             
	            
		 return sql;
	}


}


