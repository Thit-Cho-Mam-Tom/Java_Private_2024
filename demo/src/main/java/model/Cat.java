package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity

public class Cat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Khóa chính tự tăng
    private UUID id;

    private String name;
    private Boolean sex;

    public Cat(){

    }
    // Getters và Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
