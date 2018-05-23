package com.lynn.alexa_app.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.lynn.alexa_app.model.Attributes;

import java.util.Map;
import java.util.Optional;

import static com.lynn.alexa_app.model.Constants.proef11;
import static com.amazon.ask.request.Predicates.intentName;

public class NextIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {

        return input.matches(intentName("AMAZON.NextIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        int counter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);
        counter++;
        sessionAttributes.put(Attributes.COUNTER_KEY, counter);
        String speechText = proef11[counter];

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withReprompt(speechText)
                .withSimpleCard("Proef 11", speechText)
                .withShouldEndSession(false)
                .build();
    }
}