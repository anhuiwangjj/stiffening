package com.forezp.servicehi.dto;

/**
 * @author wjj
 * @date 2019/11/5
 */
public class StudentDto {

    private String id;

    private String name;

    private Integer age;

    private String gradeAndClass;

    public StudentDto(String id, String name, Integer age, String gradeAndClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gradeAndClass = gradeAndClass;
    }

    public String getId() {
        return id;
    }

    public StudentDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getGradeAndClass() {
        return gradeAndClass;
    }

    public StudentDto setGradeAndClass(String gradeAndClass) {
        this.gradeAndClass = gradeAndClass;
        return this;
    }
}
