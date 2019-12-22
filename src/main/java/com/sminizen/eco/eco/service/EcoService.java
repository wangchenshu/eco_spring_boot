package com.sminizen.eco.eco.service;

import com.sminizen.eco.eco.model.Inspirationals;
import com.sminizen.eco.eco.model.Phorisms;
import com.sminizen.eco.eco.model.WisdomAdages;
import com.sminizen.eco.eco.model.Words;
import com.sminizen.eco.eco.repository.InspirationalsRepository;
import com.sminizen.eco.eco.repository.PhorismsRepository;
import com.sminizen.eco.eco.repository.WisdomAdagesRepository;
import com.sminizen.eco.eco.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcoService {

    @Autowired
    private WordsRepository wordsRepository;

    @Autowired
    private PhorismsRepository phorismsRepository;

    @Autowired
    private InspirationalsRepository inspirationalsRepository;

    @Autowired
    private WisdomAdagesRepository wisdomAdagesRepository;

    public Optional<Words> findByRandomWords() {
        return wordsRepository.findByRandom();
    }

    public Optional<Phorisms> findByRandomPhorisms() {
        return phorismsRepository.findByRandom();
    }

    public Optional<Inspirationals> findByRandomInspirationals() {
        return inspirationalsRepository.findByRandom();
    }

    public Optional<WisdomAdages> findByRandomWisdomAdages() {
        return wisdomAdagesRepository.findByRandom();
    }

}
