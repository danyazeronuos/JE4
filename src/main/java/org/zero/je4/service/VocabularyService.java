package org.zero.je4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zero.je4.entity.Sentence;
import org.zero.je4.entity.Vocabulary;
import org.zero.je4.model.VocabularyDTO;
import org.zero.je4.repository.SpeechPartRepository;
import org.zero.je4.repository.VocabularyRepository;
import org.zero.je4.utils.VocabularyMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyMapper vocabularyMapper;

    public List<Vocabulary> getVocabularyList() {
        return vocabularyRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<Vocabulary> addVocabulary(VocabularyDTO vocabulary) {
        var newVocabularyEntity = vocabularyMapper.map(vocabulary);
        vocabularyRepository.save(newVocabularyEntity);

        return this.getVocabularyList();
    }

    public List<Vocabulary> deleteVocabulary(Integer vocabularyId) {
        vocabularyRepository.deleteById(vocabularyId);

        return this.getVocabularyList();
    }

    public Vocabulary getVocabulary(Integer vocabularyId) {
        return vocabularyRepository.findById(vocabularyId).orElse(null);
    }

    public List<Vocabulary> updateVocabulary(VocabularyDTO vocabulary) {
        vocabularyRepository.save(vocabularyMapper.map(vocabulary));

        return this.getVocabularyList();
    }
}
