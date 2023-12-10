package com.example.doan2.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="reading_passage",schema = "doan2")
@Data
public class PassageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="passage1")
    private String passage1;
    @Column(name="passage2")
    private String passage2;
    @Column(name="passage3")
    private String passage3;
    @OneToMany(mappedBy = "passageEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReadingQuesEntity> readingQuesEntities = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassage1() {
        return passage1;
    }

    public void setPassage1(String passage1) {
        this.passage1 = passage1;
    }

    public String getPassage2() {
        return passage2;
    }

    public void setPassage2(String passage2) {
        this.passage2 = passage2;
    }

    public String getPassage3() {
        return passage3;
    }

    public void setPassage3(String passage3) {
        this.passage3 = passage3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassageEntity that)) return false;
        return getId().equals(that.getId()) && getPassage1().equals(that.getPassage1()) && getPassage2().equals(that.getPassage2()) && getPassage3().equals(that.getPassage3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassage1(), getPassage2(), getPassage3());
    }
}
