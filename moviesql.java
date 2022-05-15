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
   	     String jdbcUrl="jdbc:sqlite:/D:\\SQLITE\\sqlite-tools-win32-x86-3380500\\moviedb.db";
   	     try
   	     {
   		    Connection connection=DriverManager.getConnection(jdbcUrl);
   		    statement= connection.createStatement();
   		    System.out.println("Connection Successfull");
   	     }
   	     catch(SQLException e)
   	     {
   		   e.printStackTrace();
   	     }
	}
     public static void main(String[] args)
     {
    	
    	 moviesql db=new moviesql();
    	 db.createtable();
    	 boolean flag=true;
    	 do
    	 {   Scanner obj=new Scanner(System.in);
    		 System.out.println("Enter your choice ");
        	 System.out.println("1.Insert Data in Table\n2.Display complete data\n3.Display data of particular Actors\n4.Exit");
        	 int choice=5;
        	 try
        	 {
        		 choice=obj.nextInt();
        	 }
        	 catch(Exception e)
        	 {
        		 System.out.println("Please Enter valid datatype");
//        		 e.printStackTrace();
        	 }
        	 switch(choice)
        	 {
        	 case 1:insert();
        	 break;
        	 case 2: db.query1();
        	 break;
        	 case 3: db.query2();
        	 break;
        	 case 4:
        		 flag=false;
        		 db.droptable();
        		 break;
        	 case 5:
        		 System.out.println("Please Enter a Valid operation type");
        		 break;
        	 }
    	 }while(flag==true);
		 System.exit(0);
    	 return ;
    	
     }
     public void createtable()
     {
    	 try
		 {
			 String table="CREATE TABLE moviedatabase (moviename varchar(30),lead_actor varchar(30),lead_actress varchar(30), release_date date, dir_name varchar(30))";
			 statement.executeUpdate(table);
			 System.out.println("Table Created Successfully ");
			 System.out.println();
		 }
		 catch(SQLException e)
		 {
			 System.out.println("Table Not Created : ERROR");
			 System.exit(0);
//			 e.printStackTrace();
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
    		 String insert="SELECT * FROM moviedatabase WHERE lead_actor='"+name+"'";
    		 ResultSet result = statement.executeQuery(insert);
    		 int id=1;
    		 while(result.next())
    		 {
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
    			 id=id+1;
    		 }
    		 if(id==0)
    		 {
    			 System.out.println("No Data to Display");
    		 }
    		 System.out.println("------------------------------------------");
    		 System.out.println();
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     public  static void insert()
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
			 System.out.println();
			 System.out.println("------------------------------------------");
			 System.out.println();
		 }
		 catch(SQLException e)
		 {
			 System.out.println("ERROR  ");
			 e.printStackTrace();
		 }
    	 return ;
     }
     public  void query1()
     {
    	 String sql="SELECT rowid,* FROM  moviedatabase";
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
		 System.out.println("------------------------------------------");
		 System.out.println();
    	 }
    	 catch(SQLException e)
    	 {
    		 System.out.println("ERROR");
    		 e.printStackTrace();
    	 } 
     }
     public void droptable()
     {
    	 String q="drop table moviedatabase";
    	 try
    	 {
    		 statement.executeUpdate(q);
    		 System.out.println("Table Dropped");
    		 System.out.println("---------Program Ends--------");
    	 }
    	 catch(SQLException e)
    	 {
    		 System.out.println("Drop Query Error");
    		 e.printStackTrace();
    	 }
     }
}

