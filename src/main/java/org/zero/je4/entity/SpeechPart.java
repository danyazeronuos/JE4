package org.zero.je4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "speech_part")
public class SpeechPart {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "translate", nullable = false, length = Integer.MAX_VALUE)
    private String translate;

    @Column(name = "answers_to", nullable = false, length = Integer.MAX_VALUE)
    private String answersTo;

}