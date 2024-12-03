package org.zero.je4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zero.je4.entity.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
}
