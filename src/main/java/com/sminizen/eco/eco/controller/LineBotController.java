package com.sminizen.eco.eco.controller;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
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

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@LineMessageHandler
public class LineBotController {

    @Autowired
    private WordsRepository wordsRepository;

    @Autowired
    private WisdomAdagesRepository wisdomAdagesRepository;

    @Autowired
    private PhorismsRepository phorismsRepository;

    @Autowired
    private InspirationalsRepository inspirationalsRepository;

    @EventMapping
    public List<Object> handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        String eventStr = event.getMessage().getText();
        AtomicReference<String> retStr = new AtomicReference<>("只要輸入 好語、勵志語、自在語 或是 靜思語");
        if (eventStr.contains("好語")) {
            wordsRepository.findByRandom().ifPresent(words -> retStr.set(words.getWords()));
        } else if(eventStr.contains("自在")) {
            wisdomAdagesRepository.findByRandom().ifPresent(wisdomAdages -> retStr.set(wisdomAdages.getWords()));
        } else if(eventStr.contains("靜思")) {
            phorismsRepository.findByRandom().ifPresent(phorisms -> retStr.set(phorisms.getWords()));
        } else if(eventStr.contains("勵志")) {
            inspirationalsRepository.findByRandom().ifPresent(inspirationals -> retStr.set(inspirationals.getWords()));
        }

        List<Object> list = new ArrayList<>();
        list.add(
                new TemplateMessage(retStr.get(), new ButtonsTemplate(
                        URI.create("https://firebasestorage.googleapis.com/v0/b/walter-bot-a2142.appspot.com/o/line-bot%2Fimage%2Fother%2Fgirl_img%2F27367-5nYPUB.jpg?alt=media&token=9ec89929-5b2d-478c-b8da-c37f61f338a0"),
                        "禪念 Bot 3.1 Spring",
                        retStr.get(),
                        Arrays.asList(
                                new MessageAction("好語", "好語"),
                                new MessageAction("自在語", "自在語"),
                                new MessageAction("靜思語", "靜思語"),
                                new MessageAction("勵志語", "勵志語")
                        )))
        );
        list.add(new TextMessage(retStr.get()));

        return list;
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
