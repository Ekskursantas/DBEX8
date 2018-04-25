package control;

import java.util.ArrayList;
import java.util.List;

import data.*;
import model.Nodes;
import java.util.Random;

public class Main {

	private static ArrayList<Long> sqlDepthTimer = new ArrayList<Long>();
	private static ArrayList<Long> graphDepthTimer = new ArrayList<Long>();

	public static void main(String[] args) throws Exception {
		DBMapperSQL sqlCon = new DBMapperSQL(new DBConnector());
		GraphMapper graphCon = new GraphMapper(new DBGraph());
		List<Nodes> sqlPersons = sqlCon.getAll();
		long startTime;
		long endTime;
		long totalTime;
		System.out.println("DEPTH ONE");

//		// MYSQL
//		startTime = System.nanoTime();
//		List<Nodes> depth1Sql = sqlCon.depthOne("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		sqlDepthTimer.add(totalTime);

		// GRAPH;
		startTime = System.nanoTime();
		List<Nodes> depth1Graph = graphCon.depthOne("Shaunda Gabay");
		endTime = System.nanoTime();
		totalTime = (endTime - startTime)/1000000;
		
		graphDepthTimer.add(totalTime);
		for (Nodes nodes : depth1Graph) {
			printPerson(nodes);
		}
		System.out.println(totalTime);
//		System.out.println("SQL TIMER " + sqlDepthTimer.get(0) + "MS" + " GRAPH TIMER " + graphDepthTimer.get(0) + "MS");
		
		System.out.println("DEPTH TWO");
//		startTime = System.nanoTime();
//		List<Nodes> depth2Sql = sqlCon.depthTwo("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		sqlDepthTimer.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth2Graph = graphCon.depthTwo("Shaunda Gabay");
		endTime = System.nanoTime();
		totalTime = (endTime - startTime)/1000000;
		
		graphDepthTimer.add(totalTime);
		for (Nodes nodes : depth2Graph) {
			printPerson(nodes);
		}
		System.out.println(totalTime);
//		System.out.println("SQL TIMER " + sqlDepthTimer.get(1) + "MS" + " GRAPH TIMER " + graphDepthTimer.get(1) + "MS");
		
		System.out.println("DEPTH THREE");
//		startTime = System.nanoTime();
//		List<Nodes> depth3Sql = sqlCon.depthThree("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		sqlDepthTimer.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth3Graph = graphCon.depthThree("Shaunda Gabay");
		endTime = System.nanoTime();
		totalTime = (endTime - startTime)/1000000;
		graphDepthTimer.add(totalTime);
		for (Nodes nodes : depth3Graph) {
			printPerson(nodes);
		}
		System.out.println(totalTime);
//		System.out.println("SQL TIMER " + sqlDepthTimer.get(2) + "MS" + " GRAPH TIMER " + graphDepthTimer.get(2) + "MS");
		
		System.out.println("DEPTH FOUR");
//		startTime = System.nanoTime();
//		List<Nodes> depth4Sql = sqlCon.depthFour("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		sqlDepthTimer.add(totalTime);

		startTime = System.nanoTime();
		List<Nodes> depth4Graph = graphCon.depthFour("Shaunda Gabay");
		endTime = System.nanoTime();
		totalTime = (endTime - startTime)/1000000;
		graphDepthTimer.add(totalTime);
		for (Nodes nodes : depth4Graph) {
			printPerson(nodes);
		}
		System.out.println(totalTime);
//		System.out.println("SQL TIMER " + sqlDepthTimer.get(3) + "MS" + " GRAPH TIMER " + graphDepthTimer.get(3) + "MS");
		
		System.out.println("DEPTH FIVE");
//		startTime = System.nanoTime();
//		List<Nodes> depth5Sql = sqlCon.depthFive("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		sqlDepthTimer.add(totalTime);

//		startTime = System.nanoTime();
//		List<Nodes> depth5Graph = graphCon.depthFive("Shaunda Gabay");
//		endTime = System.nanoTime();
//		totalTime = (endTime - startTime)/1000000;
//		graphDepthTimer.add(totalTime);
//		for (Nodes nodes : depth5Graph) {
//			printPerson(nodes);
//		}
//		System.out.println(totalTime);
//		System.out.println("SQL TIMER " + sqlDepthTimer.get(4) + "MS" + " GRAPH TIMER " + graphDepthTimer.get(4) + "MS");
		

		 List<Nodes> randomFromGraph = graphCon.get20RandomIndexes();
		 System.out.println("RANDOM GRAPH");
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
		System.out.println("RANDOM SQL");
		for (Nodes sqlPerson : randomFromSQL) {
			printPerson(sqlPerson);
		}


	}


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
	// list = mapper.depthOne("Shaunda Gabay");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthTwo("Shaunda Gabay");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthThree("Shaunda Gabay");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthFour("Shaunda Gabay");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// list = mapper.depthFive("Shaunda Gabay");
	// for (Nodes nodes : list) {
	// System.out.println(nodes.getName());
	// }
	// System.out.println("-----------------");
	// System.out.println(p.getBirthday());
}
