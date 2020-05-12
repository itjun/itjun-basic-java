package io.itjun.examples.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonPut {

    public static void main(String[] args) throws JsonProcessingException {
        child();
    }

    /**
     * 创建一个 json，并向该 json 添加内容
     */
    private static void child() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectNode root1 = mapper.createObjectNode();
        root1.put("nodekey1", 1);
        root1.put("nodekey2", 2);
        System.out.println(mapper.writeValueAsString(root1));
        System.out.println(root1.toString());
        System.out.println(new Gson().toJson(root1.toString()));

        //Create the root node
        ObjectNode root = mapper.createObjectNode();
        //Create a child node
        ObjectNode node1 = mapper.createObjectNode();
        node1.put("nodekey1", 1);
        node1.put("nodekey2", 2);
        //Bind the child nodes
        root.set("child", node1);

        //Array of nodes
        ArrayNode arrayNode = mapper.createArrayNode();
        arrayNode.add(node1);
        arrayNode.add(1);
        //Bind array node
        root.set("arraynode", arrayNode);

        System.out.println(mapper.writeValueAsString(root));
        // 得到的输出信息
        // {"child":{"nodekey1":1,"nodekey2":2},"arraynode":[{"nodekey1":1,"nodekey2":2},1]}

    }

    private static void person() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //构建 ObjectNode
        ObjectNode personNode = mapper.createObjectNode();

        //添加/更改属性
        personNode.put("name", "Tom");
        personNode.put("age", 40);

        ObjectNode addressNode = mapper.createObjectNode();
        addressNode.put("zip", "000000");
        addressNode.put("street", "Road NanJing");

        //设置子节点
        personNode.set("address", addressNode);
        log.info("personNode \r\n {}", mapper.writeValueAsString(personNode));

        JsonNode node = mapper.readTree(personNode.toString());
        System.out.println(node.has("name"));

        System.out.println(node.get("name").asText());
        System.out.println(node.get("age").asInt());
        System.out.println(node.get("address").get("zip").asText());
        System.out.println(node.get("address").get("street").asText());

        // 通过 path 查找节点
        JsonNode searchNode = personNode.path("street");
        System.out.println(searchNode);
        // 删除属性
        ((ObjectNode) personNode).remove("address");

        //读取 json
        JsonNode rootNode = mapper.readTree(personNode.toString());
        //JsonNode 转换成 java 对象
        Person person = mapper.treeToValue(personNode, Person.class);
        //java 对象转换成 JsonNode
//        JsonNode node = mapper.valueToTree(person);
    }
}


