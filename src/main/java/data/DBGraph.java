package data;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;


public class DBGraph {
	    
	    private static Driver instance;
	    private static String url = "bolt://localhost:7687";
	    private static String username = "neo4j";
	    private static String password = "class";

	    public static Driver getInstance() {
	        try{
	        if (instance == null) {
	            System.out.println("SUCCESS");
	            instance = GraphDatabase.driver(url, AuthTokens.basic( username, password));;
	        }
	        }catch(Exception e){
	            System.out.println(e.toString());
	        }
	                
	        return instance;
	    }

	    public static void closeDriver() {
	        instance.close();
	        instance = null;
	}
}

