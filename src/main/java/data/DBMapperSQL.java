package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Nodes;
import java.util.List;

public class DBMapperSQL implements IMapper{

	private DBConnector sqlCon;

	public DBMapperSQL(DBConnector sqlCon) {
		this.sqlCon = sqlCon;
	}

	public Nodes getRandom(int id) {
		Nodes p = null;

		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes WHERE id ='" + id + "' ";
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				String name = res.getString("name");
				String job = res.getString("job");
				String bday = res.getString("birthday");
				p = new Nodes(id + "", name, job, bday);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return p;
	}

	public List<Nodes> getAll() {
		List<Nodes> list = new ArrayList();

		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes";
			ResultSet res = stmt.executeQuery(query);
			list = this.getResults(res);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	
	public List<Nodes> depthOne(String name) {
		List<Nodes> list = new ArrayList();

		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes a JOIN  (select * FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name='"
					+ name + "') b ON a.id=b.target_node_id LIMIT 5;";
			ResultSet res = stmt.executeQuery(query);
			list = this.getResults(res);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public List<Nodes> depthTwo(String name) {
		List<Nodes> list = new ArrayList();
		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
					+ name + "')) LIMIT 5;";
			ResultSet res = stmt.executeQuery(query);
			list = this.getResults(res);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public List<Nodes> depthThree(String name) {
		List<Nodes> list = new ArrayList();
		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
					+ name + "'))) LIMIT 5;";
			ResultSet res = stmt.executeQuery(query);
			list = this.getResults(res);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public List<Nodes> depthFour(String name) {
		List<Nodes> list = new ArrayList();
		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
					+ name + "')))) LIMIT 5;";
			ResultSet res = stmt.executeQuery(query);

			list = this.getResults(res);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	public List<Nodes> depthFive(String name) {
		List<Nodes> list = new ArrayList();
		try {
			Connection connection = this.sqlCon.getConnection();
			Statement stmt = connection.createStatement();
			String query = "SELECT * FROM Nodes WHERE id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges WHERE source_node_id IN (SELECT target_node_id FROM Edges e JOIN Nodes p ON e.source_node_id = p.id WHERE p.name = '"
					+ name + "'))))) LIMIT 5;";
			ResultSet res = stmt.executeQuery(query);

			list = this.getResults(res);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return list;
	}

	private List<Nodes> getResults(ResultSet res) throws SQLException {
		List<Nodes> list = new ArrayList();
		while (res.next()) {
			String id = res.getString("id");
			String name = res.getString("name");
			String job = res.getString("job");
			String bday = res.getString("birthday");
			Nodes p = new Nodes(id, name, job, bday);
			list.add(p);
		}
		return list;
	}
}