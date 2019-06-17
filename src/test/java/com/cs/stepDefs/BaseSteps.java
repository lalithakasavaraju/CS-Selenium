package com.cs.stepDefs;

import ru.yandex.qatools.allure.annotations.Step;

public class BaseSteps {

    @Step(value = "{0}")
    public void logString(String log) {
        System.out.println(log);
    }

    @Step(value = "{0}")
    public void documentStep(String documentation) {
        // nothing to do here
    }
}
