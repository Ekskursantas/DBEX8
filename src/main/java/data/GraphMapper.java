

	package data;

	import model.Nodes;
	import org.neo4j.driver.v1.Driver;
	import org.neo4j.driver.v1.Record;
	import org.neo4j.driver.v1.Session;
	import org.neo4j.driver.v1.StatementResult;

	import java.util.ArrayList;
	import java.util.List;

	public class GraphMapper {
	    private DBGraph graphCon;

	    public GraphMapper(DBGraph graphCon) {
	        this.graphCon = graphCon;
	    }
	    
	    
	    public List<Nodes> getAll() {
	        List<Nodes> list = new ArrayList();

	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH (n) RETURN n.name as name, n.job as job, n.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);
	            list = getResults(result);
	            session.close();
	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthOne" + e.toString());
	        }
	        return list;
	    }

	    public List<Nodes> depthOne(String Nodes) {
	        List<Nodes> list = new ArrayList();

	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH ({name:\""+Nodes+"\"})-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);
	            list = getResults(result);
	            session.close();
	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthOne" + e.toString());
	        }
	        return list;
	    }

	    public List<Nodes> depthTwo(String Nodes) {
	        List<Nodes> list = new ArrayList();

	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH ({name:\""+Nodes+"\"})-[:ENDORSES]->()-[:ENDORSES]->(other_other) RETURN other_other.name as name, other_other.job as job, other_other.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);
	            list = getResults(result);
	            session.close();
	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthTwo" + e.toString());
	        }
	        return list;
	    }


	    public List<Nodes> depthThree(String Nodes) {
	        List<Nodes> list = new ArrayList();

	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH ({name:\""+Nodes+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);
	            list = getResults(result);
	            session.close();

	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthThree" + e.toString());
	        }
	        return list;

	    }

	    public List<Nodes> depthFour(String Nodes) {
	        List<Nodes> list = new ArrayList();
	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH ({name:\""+Nodes+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);

	            list = getResults(result);
	            session.close();
	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthFour" + e.toString());
	        }
	        return list;
	    }


	    public List<Nodes> depthFive(String Nodes) {
	        List<Nodes> list = new ArrayList();

	        try {
	            Driver driver = graphCon.getInstance();
	            String query = "MATCH ({name:\""+Nodes+"\"})-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->()-[:ENDORSES]->(other) RETURN other.name as name, other.job as job, other.birthday as birthday LIMIT 5;";
	            Session session = driver.session();
	            StatementResult result = session.run(query);
	            list = getResults(result);
	            session.close();
	        } catch (Exception e) {
	            System.out.println("ERROR FOUND IN getAllNodessDepthFive" + e.toString());
	        }
	        return list;
	    }

	    public List get20RandomIndexes() {
	        List<Nodes> list = new ArrayList<Nodes>();
	        Driver driver = graphCon.getInstance();
	        Session session = driver.session();
	        StatementResult result = session.run(
	                "MATCH(a:Person) WITH a, rand() AS number RETURN a.name as name, a.job as job, a.birthday as birthday ORDER BY number LIMIT 20");

	        list = getResults(result);
	        session.close();
	        graphCon.closeDriver();
	        System.out.println("DONE");

	        return list;

	}
	    
	    private List<Nodes> getResults(StatementResult res) {
	        List<Nodes> list = new ArrayList();
	        while (res.hasNext()) {
	            Record record = res.next();
	                String id = record.get("id").asString();
	                String name = record.get("name").asString();
	                String job = record.get("job").asString();
	                String bday = record.get("birthday").asString();
	                
//	                System.out.println("HERE:..." + name);
	                Nodes p = new Nodes(id, name, job, bday);
	                list.add(p);
	            }
	        return list;
	    }

	    public void close() {
	        Driver driver = graphCon.getInstance();
	        driver.close();

	    }


	}

