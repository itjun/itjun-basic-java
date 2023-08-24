package io.itjun.basic.xml.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JacksonXmlRootElement(localName = "Class")
public class Group {

    @JacksonXmlProperty(localName = "Teacher")
    private Teacher teacher;  //教师

    @JacksonXmlElementWrapper(localName = "Students")
    @JacksonXmlProperty(localName = "Stu")
    private List<Student> student;  //学生列表

}
