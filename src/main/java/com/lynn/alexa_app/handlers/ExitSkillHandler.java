package com.lynn.alexa_app.handlers;

import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.lynn.alexa_app.model.Constants;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ExitSkillHandler implements RequestHandler {

    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.StopIntent")
        .or(intentName("AMAZON.CancelIntent")));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(Constants.EXIT_SKILL_MESSAGE)
                .withShouldEndSession(true)
                .build();
    }
}