import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class moviesql {
	static Statement statement;
	moviesql()
	{
		System.out.println("DD");
   	     String jdbcUrl="jdbc:sqlite:/D:\\SQLITE\\sqlite-tools-win32-x86-3380500\\usersdb.db";
   	     try
   	     {
   		    Connection connection=DriverManager.getConnection(jdbcUrl);
   		    statement= connection.createStatement();
   		    System.out.println("Connection Succesfull");
   	     }
   	     catch(SQLException e)
   	     {
   		   e.printStackTrace();
   	     }
	}
     public static void main(String[] args)
     {
    	 Scanner obj=new Scanner(System.in);
    	 moviesql db=new moviesql();
    	 db.createtable();
    	 boolean flag=true;
    	 int choice;
    	 while(flag==true)
    	 {
    		
    		 System.out.println("Enter your choice ");
        	 System.out.println("1.Insert Data in Table");
        	 choice=4;
        	 System.out.println("WW");
        	 choice=obj.nextInt();
        	 System.out.println("WW2");
        	 switch(choice)
        	 {
        	 case 1:db.insert();
        	 break;
        	 case 2: db.query1();
        	 break;
        	 case 3: db.query2();
        	 break;
        	 case 4:
        		 flag=false;
        		 break;
        	 }
    	 }
    	 obj.close();
     }
     public void createtable()
     {
    	 try
		 {
			 String table="CREATE TABLE moviedatabase (moviename varchar(30),lead_actor varchar(30),lead_actress varchar(30), release_date date, dir_name varchar(30))";
			 statement.executeUpdate(table);
			 System.out.println("Table Inserted Successfully ");
		 }
		 catch(SQLException e)
		 {
			 System.out.println("Table Not Created : ERROR");
			 e.printStackTrace();
		 }
    	 return ;
     }
     public  void query2()
     {
    	 Scanner obj=new Scanner (System.in);
    	 try
    	 {
    		 System.out.println("Enter the name of the Actor whose data is to be retrieved");
    		 String name=obj.next();
    		 String insert="SELECT * FROM moviedatabase WHERE name='"+name+"'";
    		 ResultSet result = statement.executeQuery(insert);
    		 while(result.next())
    		 {
    			 Integer id=result.getInt("rowid");
    			 String moviename=result.getString("moviename");
    			 String actressname=result.getString("lead_actress");
    			 String date=result.getString("release_date");
    			 String dirname=result.getString("dir_name");
    			 String leadactor=result.getString("lead_actor");
    			 System.out.println("Sr No: " + id);
    			 System.out.println("MOVIENAME :" + moviename);
    			 System.out.println("LeadActor :" + leadactor);
    			 System.out.println("LeadActress :" + actressname);
    			 System.out.println("ReleaseDate :" + date);
    			 System.out.println("Director :" + dirname);
    			 System.out.println();
    		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 obj.close();
     }
     public  void insert()
     {
    	 Scanner obj=new Scanner(System.in);
    	 try
		 {
			 System.out.println("Enter the values to be inserted ");
			 System.out.println("Enter the Movie Name ");
			 String movie=obj.next();
			 System.out.println("Enter the Lead Actor Name ");
			 String leadm=obj.next();
			 System.out.println("Enter the Lead Actress Name ");
			 String lead_f=obj.next();
			 System.out.println("Enter the Release Date ");
			 String date=obj.next();
			 System.out.println("Enter the Director Name ");
			 String dir=obj.next();
			 String insert1="INSERT INTO `moviedatabase` (moviename,lead_actor,lead_actress,release_date,dir_name) VALUES ('"+ movie +"','"+leadm+"','"+lead_f+"','"+date+"','"+dir+"')";
			 statement.executeUpdate(insert1);
			 System.out.println("Values Inserted Successfully ");
		 }
		 catch(SQLException e)
		 {
			 System.out.println("ERROR  ");
			 e.printStackTrace();
		 }
    	 obj.close();
    	 return ;
     }
     public  void query1()
     {
    	 String sql="SELECT rowid,* FROM  moviesdatabase";
    	 try
    	 {
		 ResultSet result = statement.executeQuery(sql);
		 while(result.next())
		 {
			 Integer id=result.getInt("rowid");
			 String moviename=result.getString("moviename");
			 String actressname=result.getString("lead_actress");
			 String date=result.getString("release_date");
			 String dirname=result.getString("dir_name");
			 String leadactor=result.getString("lead_actor");
			 System.out.println("Sr No: " + id);
			 System.out.println("MOVIENAME :" + moviename);
			 System.out.println("LeadActor :" + leadactor);
			 System.out.println("LeadActress :" + actressname);
			 System.out.println("ReleaseDate :" + date);
			 System.out.println("Director :" + dirname);
			 System.out.println();
		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 System.out.println("ERROR");
    		 e.printStackTrace();
    	 }
     }
}



