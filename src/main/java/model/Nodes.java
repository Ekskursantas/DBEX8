package model;

public class Nodes {

    String node_id, name, job, birthday;
    public Nodes (String node_id, String name, String job, String bday){
        this.node_id = node_id;
        this.name = name;
        this.job = job;
        this.birthday = bday;
    }

    public String getNode_id() {
        return node_id;
    }
    public void setNode_id(String id) {
        this.node_id = node_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday() {
        this.birthday = birthday;
    }
}