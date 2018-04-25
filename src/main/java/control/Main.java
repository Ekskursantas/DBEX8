package control;

import java.util.ArrayList;
import java.util.List;

import data.*;
import model.Nodes;
import java.util.Random;

public class Main {

	private static ArrayList<Long> sqlResTime = new ArrayList<Long>();
	private static ArrayList<Long> graphResTime = new ArrayList<Long>();

	public static void main(String[] args) throws Exception {
		DBMapperSQL sqlCon = new DBMapperSQL(new DBConnector());
		GraphMapper graphCon = new GraphMapper(new DBGraph());
		List<Nodes> sqlPersons = sqlCon.getAll();

		System.out.println("DEPTH ONE");

		// MYSQL
		long startTime = System.nanoTime();
		List<Nodes> depth1Sql = sqlCon.depthOne("Rossana Gunsolley");
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		sqlResTime.add(totalTime);

		// GRAPH;
		startTime = System.nanoTime();
		List<Nodes> depth1Grpah = graphCon.depthOne("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		graphResTime.add(totalTime);

		System.out.println("DEPTH TWO");
		startTime = System.nanoTime();
		List<Nodes> depth2Sql = sqlCon.depthTwo("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		sqlResTime.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth2Grpah = graphCon.depthTwo("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		graphResTime.add(totalTime);

		System.out.println("DEPTH THREE");
		startTime = System.nanoTime();
		List<Nodes> depth3Sql = sqlCon.depthThree("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		sqlResTime.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth3Grpah = graphCon.depthThree("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		graphResTime.add(totalTime);

		System.out.println("DEPTH FOUR");
		startTime = System.nanoTime();
		List<Nodes> depth4Sql = sqlCon.depthFour("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		sqlResTime.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth4Grpah = graphCon.depthFour("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		graphResTime.add(totalTime);

		System.out.println("DEPTH FIVE");
		startTime = System.nanoTime();
		List<Nodes> depth5Sql = sqlCon.depthFive("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		sqlResTime.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth5Grpah = graphCon.depthFive("Rossana Gunsolley");
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		graphResTime.add(totalTime);
		

		 List<Nodes> randomFromGraph = graphCon.get20RandomIndexes();
		 System.out.println("------------------20 RANDOM USING GRAPH - NEO4J------------------");
		 for (Nodes graphPerson : randomFromGraph) {
		 printPerson(graphPerson);
		 }

		List<Nodes> randomFromSQL = new ArrayList<Nodes>();
		Random generator = new Random();
		for (int i = 0; i < 20; i++) {

			int index = generator.nextInt(sqlPersons.size() - 1);
			// System.out.println("INDEX" + index);
			// Person p = sqlCon.getRandom(index);
			Nodes p = new Nodes(sqlPersons.get(index).getNode_id(), sqlPersons.get(index).getName(),
					sqlPersons.get(index).getJob(), sqlPersons.get(index).getBirthday());
			randomFromSQL.add(p);

		}
		System.out.println("------------------20 RANDOM USING SQL - POSTGRESQL------------------");
		for (Nodes sqlPerson : randomFromSQL) {
			System.out.println(sqlPerson);
		}

		// display();

	}

	// private static void display() {
	//
	// String format = "%-20s%-20s%-20s\n";
	// // System.out.printf("%-35s%-20s%-20s\n", "", "PostGreSQL", "Neo4J");
	// System.out.printf("%-20s%-20s%-20s\n", "", "PostGreSQL Time", "Neo4J Time");
	//
	// String[] depthsname = new String[5];
	// depthsname[0] = "one";
	// depthsname[1] = "two";
	// depthsname[2] = "three";
	// depthsname[3] = "four";
	// depthsname[4] = "five";
	//
	// DepthMeasure mes = new DepthMeasure();
	// double ave1 = mes.getAverage(sqlResTime);
	//
	// for (int i = 0; i < 5; i++) {
	// String prefix = "Depth " + depthsname[i];
	// System.out.printf(format, prefix, sqlResTime.get(i), graphResTime.get(i));
	// }
	//
	// }

	private static void printPerson(Nodes p) {
		String format = "%-15s%-30s%-40s%-20s\n";
		System.out.printf(format, p.getNode_id(), p.getName(), p.getJob(), p.getBirthday());
	}

	// List<Nodes> list = new ArrayList();
	// DBMapperSQL mapper = new DBMapperSQL(new DBConnector());
	// GraphMapper gmapper = new GraphMapper(new DBGraph());
	// list=gmapper.get20RandomIndexes();
	// for(Nodes nodes:list)
	// {
	// System.out.println(nodes.getBirthday());
	// }

	// Nodes p = mapper.getRandom(5);
	// list = mapper.depthOne("Rossana Gunsolley");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthTwo("Rossana Gunsolley");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthThree("Rossana Gunsolley");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthFour("Rossana Gunsolley");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthFive("Rossana Gunsolley");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// System.out.println(p.getBirthday());
}
