package com.lynn.alexa_app.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.lynn.alexa_app.model.Attributes;

import java.util.Map;
import java.util.Optional;

import static com.lynn.alexa_app.model.Constants.proef11;
import static com.amazon.ask.request.Predicates.intentName;


public class startReadingIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {

        return input.matches(intentName("startReadingIntent")
                .or(input.matches(intentName("AMAZON.StartOverIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(Attributes.COUNTER_KEY, 0);

        String speechText = proef11[Integer.parseInt(sessionAttributes.get(Attributes.COUNTER_KEY).toString())];

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("startReading", speechText)
                .withShouldEndSession(false)
                .build();
    }

}
