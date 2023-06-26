package dev.ldkstellar.controllerdemo;

import org.springframework.web.bind.annotation.GetMapping;

public class SamplePayload {
    private String name;
    private  int age;
    private String Occupation;

    public SamplePayload() {
    }

    public SamplePayload(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        Occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    @Override
    public String toString() {
        return "SamplePayload{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Occupation=" + Occupation +
                '}';
    }

}
