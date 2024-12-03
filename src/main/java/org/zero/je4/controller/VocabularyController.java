package org.zero.je4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zero.je4.model.VocabularyDTO;
import org.zero.je4.service.VocabularyService;

@Controller
@RequiredArgsConstructor
public class VocabularyController {
    private final VocabularyService vocabularyService;

    @GetMapping
    public String index(Model model) {
        var vocabularyList = vocabularyService.getVocabularyList();
        model.addAttribute("items", vocabularyList);

        return "index";
    }

    @GetMapping("/{id}")
    public String getVocabularySentences(@PathVariable Integer id, Model model) {
        var vocabulary = vocabularyService.getVocabulary(id);
        model.addAttribute("vocabulary", vocabulary);
        model.addAttribute("items", vocabulary.getSentences());

        return "sentences";
    }

    @PostMapping("/add")
    public String addVocabulary(
            @RequestParam String word,
            @RequestParam String translate,
            @RequestParam Integer speechPartId,
            Model model
    ) {
        var vocabularyDTO = VocabularyDTO.builder()
                .word(word)
                .translate(translate)
                .speechPartId(speechPartId)
                .build();
        var updatedVocabularyList = vocabularyService.addVocabulary(vocabularyDTO);
        model.addAttribute("items", updatedVocabularyList);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String addVocabulary(
            @RequestParam Integer id,
            Model model
    ) {
        var updatedVocabularyList = vocabularyService.deleteVocabulary(id);
        model.addAttribute("items", updatedVocabularyList);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateVocabulary(
            @PathVariable Integer id,
            Model model
    ) {
        var editVocabulary = vocabularyService.getVocabulary(id);
        model.addAttribute("item", editVocabulary);

        return "update";
    }

    @PostMapping("/update")
    public String addVocabulary(
            @RequestParam Integer id,
            @RequestParam String word,
            @RequestParam String translate,
            @RequestParam Integer speechPartId,
            Model model
    ) {
        var updatedVocabulary = VocabularyDTO.builder()
                .id(id)
                .word(word)
                .translate(translate)
                .speechPartId(speechPartId)
                .build();

        var updatedVocabularyList = vocabularyService.updateVocabulary(updatedVocabulary);
        model.addAttribute("item", updatedVocabularyList);

        return "redirect:/";
    }

}
