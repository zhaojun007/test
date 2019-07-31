package test.com.sysware.test;

import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

/**
 * Hello world!
 *
 */
public class Neo4jTest {
    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://192.168.5.200:7687", AuthTokens.basic("neo4j", "sysware`"));
        Session session = driver.session();
      
        session.run("CREATE (a:Node {label: {label}, id: {id},name:{name},category:{category}})",
                parameters("label", "X射线望远镜", "id", "1","name","X射线望远镜","category","0"));
        
        session.run("CREATE (a:Node {label: {label}, id: {id},name:{name},category:{category}})",
                parameters("label", "显微镜", "id", "2","name","显微镜","category","1"));
        
        session.run("CREATE (a:Node {label: {label}, id: {id},name:{name},category:{category}})",
                parameters("label", "望远镜", "id", "3","name","望远镜","category","2"));
        
        session.run("CREATE (a:Node {label: {label}, id: {id},name:{name},category:{category}})",
                parameters("label", "变焦距目镜", "id", "4","name","变焦距目镜","category","3"));
        session.run("CREATE (a:Node {label: {label}, id: {id},name:{name},category:{category}})",
                parameters("label", "xianweijing", "id", "5","name","xianweijing","category","2"));
    //边关系
        session.run("CREATE (a:edge {source: {source}, target: {target},type:{type},label:{label}})",
                parameters("source", "1", "target", "0","type","英文","label","英文"));
        
        session.run("CREATE (a:edge {source: {source}, target: {target},type:{type},label:{label}})",
                parameters("source", "1", "target", "2","type","属项","label","属项"));
        
        session.run("CREATE (a:edge {source: {source}, target: {target},type:{type},label:{label}})",
                parameters("source", "1", "target", "5","type","参项","label","参项"));
        
        session.run("CREATE (a:edge {source: {source}, target: {target},type:{type},label:{label}})",
                parameters("source", "2", "target", "3","type","代项","label","代项"));
        
        session.run("CREATE (a:edge {source: {source}, target: {target},type:{type},label:{label}})",
                parameters("source", "2", "target", "4","type","参项","label","参项"));
        //类型
        session.run("CREATE (a:type {label: {label}, id:{id}})",
                parameters("label", "参项", "id", "3"));
        session.run("CREATE (a:type {label: {label}, id:{id}})",
                parameters("label", "代项", "id", "3"));
        session.run("CREATE (a:type {label: {label}, id:{id}})",
                parameters("label", "英文", "id", "0"));
        session.run("CREATE (a:type {label: {label}, id:{id}})",
                parameters("label", "属项", "id", "2"));
        
        String rel="MATCH(a:node),(b:node) WHERE ID(a)= {a} AnD ID(b)= {b} CREATE (b)-[:R]->(a)";
        session.run("MATCH(a:node),(b:node) WHERE ID(a)= {a} AnD ID(b)= {b} CREATE (b)-[:R]->(a)",
                parameters("a", "1", "b", "5"));
        System.out.println("finish!");
    /*    StatementResult result = session.run(
                "MATCH (a:node) WHERE a.name = {name} " + "RETURn a.name AS name, a.title AS title",
                parameters("name", "瞄准具"));*/
      /*  
        while (result.hasnext()) {
            Record record = result.next();
            node defaultValue = null;
            node node = record.get("", defaultValue);
            node value = record.get("title").asnode();
            System.out.println(record.get("title").asString() + " " + record.get("name").asString());
        }*/
        session.close();
        driver.close();
    }
}
