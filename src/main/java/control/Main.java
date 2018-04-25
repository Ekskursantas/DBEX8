package control;
import java.util.ArrayList;
import java.util.List;

import data.*;
import model.Nodes;
public class Main {

	public static void main(String[] args) throws Exception {
		List<Nodes> list = new ArrayList();
		DBMapperSQL mapper = new DBMapperSQL(new DBConnector());
		Nodes p = mapper.getRandom(5);
		list = mapper.depthOne("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.depthTwo("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.depthThree("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.depthFour("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.depthFive("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		System.out.println(p.getBirthday());
	}

}
