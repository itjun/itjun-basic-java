package io.itjun.basic.xml.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

    @JacksonXmlProperty(isAttribute = true, localName = "stu_id")
    private String id;  // 学号---属性

    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlProperty(localName = "Gender")
    private String gender;

    @JacksonXmlProperty(localName = "Age")
    private String age;

}
