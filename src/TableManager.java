import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TableManager {
	
	 ResultSet rs;
	 Statement statement;
	 PreparedStatement ps;
	 static Connection con;
	static 
	{
		 try{
	            Class.forName("org.postgresql.Driver");
	            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/FileReader","postgres","1234");
	            //con.setAutoCommit(false);
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 

	}
	
	
	public String createTable(String query) {
		try {
			   statement = con.createStatement( );
			   
			   statement.executeQuery(query);
			   
			}catch(Exception e) {System.out.println(e.getMessage());
			e.printStackTrace();}
		return "updated success!";
	}
	
	
	public void insertTable(String name,ArrayList<String>fields,ArrayList<String>val,String[] lineFields)
	{
		int diff=lineFields.length-fields.size();
		int noOfClm=0;
		String fname =name.substring(0,name.indexOf("."));
		String values="?";
		
			try {
				 for(int i=fields.size();i<lineFields.length;i++)
				 {
					String sql=" ALTER TABLE "+fname+" ADD COLUMN Extra"+i+" CHAR(50);";
					
					statement = con.createStatement( );
					   
					   statement.execute(sql);
							
				 }}catch(Exception e) {e.printStackTrace();}
			
			noOfClm=fields.size()+diff;
			for(int i=1;i<noOfClm;i++)
			{
				values+=",?";
			}
			
		
		
		try {
		String sql="insert into "+fname+" values("+values+");";
		 ps = con.prepareStatement(sql);
		for(int i=0;i<noOfClm;i++)
		{try {
			ps.setString(i+1,lineFields[i]);
			
			if(lineFields.length<=i)
			{
				ps.setString(i+1, null);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		 ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	/*void alterTable(String name,String[] fields,ArrayList<String> data) {
		String fname =name.substring(0,name.indexOf("."));
		try {
		 for(int i=data.size();i<fields.length;i++)
		 {
			String sql=" ALTER TABLE "+fname+" ADD COLUMN Extra"+i+" CHAR(50);";
			
			statement = con.createStatement( );
			   
			   statement.execute(sql);
					
		 }}catch(Exception e) {e.printStackTrace();}
	}*/
	/*public String insertToTable(String query,String[] values,ArrayList<String> type) {
		//String sql="insert into "+tbl+"("+fields+") values ("+values+");";
		System.out.println(query);
		
		 try{
	             ps = con.prepareStatement(query);
	           for(int i=0;i<type.size();i++) 
	           {
	        	   if(type.get(i).equals("INT"))
	        	   {
	        		   ps.setInt(i+1,Integer.parseInt(values[i]));
	        		   System.out.println(i+1+" "+Integer.parseInt(values[i]));
	        	   }
	        	   else if(i>=values.length)
	        	   {
	        		   ps.setString(i+1,null);
	        	   }
	        	   
	        	   else { ps.setString(i+1,values[i]);
	        	   System.out.println(i+1+" "+values[i]);}
	           }
	           if(values.length>type.size())
        	   {
        		   //int diff=values.);
        		   for(int k=type.size();k<values.length;k++)
        			 {
        			   ps.setString(k+1, values[k]);
        			 }
        	   }
	             ps.setString(1,values[0]);
	             ps.setInt(2,Integer.parseInt(values[1]));
	             ps.setString(3,values[2]);
	           
	            ps.executeUpdate();
	           
	            }catch(Exception e) {System.out.println(e);
	            e.printStackTrace();}
		 return "data added successfully!";
	}*/
}
	


