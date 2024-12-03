package org.zero.je4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "word", nullable = false, length = Integer.MAX_VALUE)
    private String word;

    @Column(name = "translate", nullable = false, length = Integer.MAX_VALUE)
    private String translate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speech_part_id", nullable = false)
    private SpeechPart speechPart;

    @ManyToMany
    @JoinTable(
            name = "vocabulary_sentence",
            joinColumns = @JoinColumn(name = "vocabulary_id"),
            inverseJoinColumns = @JoinColumn(name = "sentence_id"))
    private List<Sentence> sentences;

}