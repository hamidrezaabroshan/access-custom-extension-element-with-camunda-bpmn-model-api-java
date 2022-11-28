package com.github.bpmnInterpreter.model;

import org.camunda.bpm.model.bpmn.instance.BpmnModelElementInstance;

public interface Header extends BpmnModelElementInstance  {
    public String getKey();
    public void setKey(String key);
    public String getValue();
    public void setValue(String value);
}
