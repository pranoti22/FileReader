import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBuilder {
	
	
	public String createTableQuery(String name,ArrayList<String> fields,ArrayList<String> type)
	{ String fname =name.substring(0,name.indexOf("."));
	String sql="";
	
	            sql="CREATE TABLE "+fname+"( ";
	            for(int i=0;i<fields.size();i++)
	            {
	            	if(i==fields.size()-1)
	            	{sql=sql+fields.get(i)+" "+type.get(i)+"";}
	            	else {
	            	sql=sql+fields.get(i)+" "+type.get(i)+",";}
	            }
	            sql+= " );";
		 return sql;
	}
	
	/*public String insertIntoQuery(String name,ArrayList<String> val)
	{ String fname =name.substring(0,name.indexOf("."));
	
		  String sql="insert into "+fname+" (";
				  for(int i=0;i<val.size();i++)
				  {
					  if(i==(val.size()-1)) {
					  sql=sql+""+val.get(i)+"";}
					  else {sql=sql+""+val.get(i)+",";}
				  }
				  sql+=") values (";
				  for(int i=0;i<val.size();i++)
				  {
					  if(i==(val.size()-1)) {
					  sql=sql+"?";}
					  else {sql=sql+"?,";}
				  }
				  
				 sql+=");";
	         
	           System.out.println(sql);
	             
	            
		 return sql;
	}*/
	 
		// TODO Auto-generated method stub
		
		
	

}
