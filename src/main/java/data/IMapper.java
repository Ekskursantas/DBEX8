package data;

import java.util.List;
import model.Nodes;

public interface IMapper {

    public List<Nodes> depthOne(String name);

    public List<Nodes> depthTwo(String name);

    public List<Nodes> depthThree(String name);

    public List<Nodes> depthFour(String name);

    public List<Nodes> depthFive(String name);
}