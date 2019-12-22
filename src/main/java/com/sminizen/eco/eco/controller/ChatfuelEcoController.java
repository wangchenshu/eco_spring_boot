package com.sminizen.eco.eco.controller;

import com.sminizen.eco.eco.model.*;
import com.sminizen.eco.eco.service.EcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ChatfuelEcoController {

    @Autowired
    private EcoService ecoService;

    @GetMapping("/chatfuel/words/rand")
    public ResponseEntity<ChatfuelMessages> showByRandWords() {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();

        Optional<Words> wordsOptional = ecoService.findByRandomWords();
        wordsOptional.ifPresent(words -> chatfuelTexts.add(new ChatfuelText(words.getWords())));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }

    @GetMapping("/chatfuel/phorisms/rand")
    public ResponseEntity<ChatfuelMessages> showByRandPhorisms() {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();

        Optional<Phorisms> phorismsOptional = ecoService.findByRandomPhorisms();
        phorismsOptional.ifPresent(phorisms -> chatfuelTexts.add(new ChatfuelText(phorisms.getWords())));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }

    @GetMapping("/chatfuel/inspirationals/rand")
    public ResponseEntity<ChatfuelMessages> showByRandInspirationals() {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();

        Optional<Inspirationals> inspirationalsOptional = ecoService.findByRandomInspirationals();
        inspirationalsOptional.ifPresent(inspirationals -> chatfuelTexts.add(new ChatfuelText(inspirationals.getWords())));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }

    @GetMapping("/chatfuel/wisdom-adages/rand")
    public ResponseEntity<ChatfuelMessages> showByRandWisdomAdages() {
        List<ChatfuelText> chatfuelTexts = new ArrayList<>();

        Optional<WisdomAdages> wisdomAdagesOptional = ecoService.findByRandomWisdomAdages();
        wisdomAdagesOptional.ifPresent(wisdomAdages -> chatfuelTexts.add(new ChatfuelText(wisdomAdages.getWords())));

        return ResponseEntity.ok(new ChatfuelMessages(chatfuelTexts));
    }
}
