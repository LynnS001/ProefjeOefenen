package com.lynn.alexa_app;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

import com.lynn.alexa_app.handlers.*;

public class DressageStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new startReadingIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedHandler(),
                        new NextIntentHandler(),
                        new ExitSkillHandler(),
                        new RepeatIntentHandler(),
                        new PreviousIntentHandler())
                // Add your skill id below
                //.withSkillId("amzn1.ask.skill.e7a7bd2a-09fd-4b2e-8b26-7f35f000e247")
                .build();
    }

    public DressageStreamHandler() {
        super(getSkill());
    }

}
