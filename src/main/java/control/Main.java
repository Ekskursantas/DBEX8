package control;
import java.util.ArrayList;
import java.util.List;

import data.*;
import model.Nodes;
public class Main {

	public static void main(String[] args) throws Exception {
		List<Nodes> list = new ArrayList();
		DBMapperSQL mapper = new DBMapperSQL(new DBConnectorSQL());
		Nodes p = mapper.getRandom(5);
		list = mapper.getAllPersonsDepthOne("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.getAllPersonsDepthTwo("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.getAllPersonsDepthThree("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.getAllPersonsDepthFour("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		list = mapper.getAllPersonsDepthFive("Rossana Gunsolley");
		for (Nodes nodes : list) {
			System.out.println(nodes.getName());
		}
		System.out.println("-----------------");
		System.out.println(p.getBirthday());
	}

}
