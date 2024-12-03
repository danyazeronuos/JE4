package org.zero.je4.utils;

import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.zero.je4.entity.SpeechPart;
import org.zero.je4.entity.Vocabulary;
import org.zero.je4.model.VocabularyDTO;
import org.zero.je4.repository.SpeechPartRepository;

@Component
@RequiredArgsConstructor
public class VocabularyMapper {
    private final SpeechPartRepository speechPartRepository;

    public Vocabulary map(VocabularyDTO vocabularyDTO) {
        var speechPartReference = speechPartRepository.getReferenceById(vocabularyDTO.speechPartId());

        return Vocabulary.builder()
                .id(vocabularyDTO.id())
                .word(vocabularyDTO.word())
                .translate(vocabularyDTO.translate())
                .speechPart(speechPartReference)
                .build();
    }
}
