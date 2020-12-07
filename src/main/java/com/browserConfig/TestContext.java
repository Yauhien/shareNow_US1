package com.browserConfig;

import com.enums.ApplicationVariables;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.lang.ThreadLocal.withInitial;

@Component
public class TestContext {

    private final ThreadLocal<Map<ApplicationVariables, String>> states = withInitial(HashMap::new);

    public String get(ApplicationVariables  applicationVariable) {
        return states.get().get(applicationVariable);
    }

    public String set(ApplicationVariables applicationVariable, String variableValue) {
        return states.get().put(applicationVariable, variableValue);
    }
}
