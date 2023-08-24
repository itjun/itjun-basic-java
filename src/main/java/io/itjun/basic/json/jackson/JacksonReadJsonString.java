package io.itjun.basic.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 读取json格式的字符串并修改节点
 */
public class JacksonReadJsonString {

    public static void main(String[] args) throws JsonProcessingException {
        String str = "{\"nodekey1\":1,\"nodekey2\":2}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(str);
        ((ObjectNode) json).put("a", 2);
        System.out.println(json);
    }

}
