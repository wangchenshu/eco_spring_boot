package com.sminizen.eco.eco.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.sminizen.eco.eco.repository.InspirationalsRepository;
import com.sminizen.eco.eco.repository.PhorismsRepository;
import com.sminizen.eco.eco.repository.WisdomAdagesRepository;
import com.sminizen.eco.eco.repository.WordsRepository;

@LineMessageHandler
public class LineBotController {

    @Autowired
    WordsRepository wordsRepository;

    @Autowired
    WisdomAdagesRepository wisdomAdagesRepository;

    @Autowired
    PhorismsRepository phorismsRepository;

    @Autowired
    InspirationalsRepository inspirationalsRepository;

	@EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		String eventStr = event.getMessage().getText();
		String retStr = "只要輸入 好語、勵志語、自在語 或是 靜思語";
		
		if (eventStr.contains("好語")) {
	        retStr = wordsRepository.findByRandom().get().getWords();
		} else if(eventStr.contains("自在")) {
			retStr = wisdomAdagesRepository.findByRandom().get().getWords();
		} else if(eventStr.contains("靜思")) {
			retStr = phorismsRepository.findByRandom().get().getWords();
		} else if(eventStr.contains("勵志")) {
			retStr = inspirationalsRepository.findByRandom().get().getWords();
		}

		return new TextMessage(retStr);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
