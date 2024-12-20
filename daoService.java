package LearnSE.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import LearnSE.dbConnection;
//import LearnSE.model.cybermodel;
//import LearnSE.model.getcourselistmodel;
import LearnSE.model.mainEntryModel;
import LearnSE.model.processtypedata;

public class daoService {


	//add main page content method
	public void addmainContent(mainEntryModel fieldsEntry) throws SQLException
	{
		dbConnection conn = new dbConnection("web_maincontent", "root", "Mereja0728$"); /**create an instance of the database-connection
		class with the database name, username, and the password */
		Connection cnn = conn.create_connection_string();//execute the connection to the database
		//getting the datas from the model
		String strTitle= fieldsEntry.getContentTitle();
		String strDetails = fieldsEntry.getContentDetails();
		//creating SQL insert statement
		String insertContent = "INSERT INTO main_p_content (title, details) VALUES(?,?)";
			try
			{
				PreparedStatement prestmt = cnn.prepareStatement(insertContent);
				prestmt.setString(1, strTitle);
				prestmt.setString(2, strDetails);
				prestmt.execute();//execute statement
			}
			catch(Exception ex) //catch error if found
			{
			}
			//cnn.close(); //close the connection
	}

	public ArrayList<processtypedata> getprocesstypedata()
	{
		Statement stmt = null;
		ResultSet rs;
		ArrayList<processtypedata> processdataarray = new ArrayList<>();
		try
		{
			dbConnection conn = new dbConnection("web_maincontent", "root", "Mereja0728$");
			/**create an instance of the database-connection class with the database name, username, and the password */
			Connection cnn = conn.create_connection_string();//execute the connection to the database
			String getprocessestypes = "SELECT * FROM main_p_content";
			stmt= cnn.createStatement();
			rs = stmt.executeQuery(getprocessestypes);
			while(rs.next())
				{
					processtypedata settypesdata = new processtypedata();
					settypesdata.setTitletypetext(rs.getString(2));
					settypesdata.setDetailtypetext(rs.getString(3));
					processdataarray.add(settypesdata);

				}
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
		}
		//Collections.sort(processdataarray);
		return processdataarray;

	
	}
}