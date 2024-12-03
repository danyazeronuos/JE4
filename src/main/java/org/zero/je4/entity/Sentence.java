package org.zero.je4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sentence")
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "sentence", nullable = false, length = Integer.MAX_VALUE)
    private String sentence;

    @ColumnDefault("0")
    @Column(name = "views", nullable = false)
    private Integer views;

    @Column(name = "translate", nullable = false, length = Integer.MAX_VALUE)
    private String translate;

    @ManyToMany(mappedBy = "sentences")
    private List<Vocabulary> vocabularies;
}