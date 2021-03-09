import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Stream;

public class WorkerThread extends Thread {
	private String filePath;
	private  String fileName;
	private Properties properties;
	
	static QueryBuilder qb=new QueryBuilder();
	TableManager tm=new TableManager();
	BufferedReader br;
	FileReader fr;
	File file;
	
	WorkerThread(String filePath){
		this.filePath = filePath;
		
	}
		
	{
		properties = new Properties();
		try {
			properties.load(new FileReader("FileValidity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void run() {
		System.out.println("Worker Thread started for file "+filePath);
		readFile(Paths.get(filePath));
		
	}
	
	private void readFile(Path filePath2) {
		String line;
		try {
		    file = new File(filePath); 
		    fr =new FileReader(file);
		    br = new BufferedReader(fr);
		    tm.createTable(qb.createTableQuery("Valid"+file.getName(),getFieldVal(), getFieldType()));
		    tm.createTable(qb.createTableQuery("Invalid"+file.getName(),getFieldVal(), getFieldType()));
				
		while((line=br.readLine())!=null)  
		{  
		    transferLine(line);
		}  
		}catch(Exception e) {e.printStackTrace();}	
	}
	
	
	private void transferLine(String line) {
		FileWriter fw=null;
		String[] fields=line.split(",");
		try {
		if(isValid(line))
		{
			tm.insertTable("Valid"+file.getName(), getFieldType(),getFieldVal(), fields);
		}
		else {

			tm.insertTable("Invalid"+file.getName(), getFieldType(),getFieldVal(), fields);
			
		}}catch(Exception e) {System.out.println(e.getMessage());
		e.printStackTrace();}
		finally {
			
			}	
	}
	
	private boolean isValid(String line) {
		int i=0;
		String[] fields=line.split(",");
		String[] filedata=properties.getProperty(file.getName()).split(",");
		int [] fieldLen = Stream.of(properties.getProperty("len"+file.getName()).split(","))
				  .mapToInt(Integer::parseInt)
				  .toArray();
		if(fields.length==filedata.length)
		{
			while(i!=filedata.length)
			{
				if(!(fields[i].length()==fieldLen[i]))
				{
					return false;
				}
				i++;
			}
			
		}else {return false;}
		return true;
	}

	private ArrayList<String> getFieldType() {
		
		int i=0;
		ArrayList<String> type=new ArrayList<String>();
		String[] f=properties.getProperty(file.getName()).split(",");
		while(i!=f.length)
		{
	     type.add(f[i].split(":")[1]);
		i++;
	}
		return type;
	}
	
    private ArrayList<String> getFieldVal() {
		
		int i=0;
		ArrayList<String> val=new ArrayList<String>();
		String[] f=properties.getProperty(file.getName()).split(",");
		while(i!=f.length)
		{
		
	     val.add(f[i].split(":")[0]);
		i++;
	}
		return val;
	}
}
