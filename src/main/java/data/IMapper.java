package data;

import java.util.List;
import model.Nodes;

public interface IMapper {

    public List<Nodes> getAllPersonsDepthOne(String name);

    public List<Nodes> getAllPersonsDepthTwo(String name);

    public List<Nodes> getAllPersonsDepthThree(String name);

    public List<Nodes> getAllPersonsDepthFour(String name);

    public List<Nodes> getAllPersonsDepthFive(String name);

    public String getName();
}