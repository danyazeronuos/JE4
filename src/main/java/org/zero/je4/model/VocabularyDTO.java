package org.zero.je4.model;

import lombok.Builder;

@Builder
public record VocabularyDTO(
        Integer id,
        String word,
        String translate,
        Integer speechPartId
) { }
