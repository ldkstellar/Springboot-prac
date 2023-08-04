package dev.ldkstellar.mybatis.dto;

public class BoardDto {
    private int id;
    private String name;

    public BoardDto() {

    }

    public BoardDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
