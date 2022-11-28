package com.github.bpmnInterpreter.model;

import java.util.Collection;
import java.util.List;

import org.camunda.bpm.model.bpmn.instance.BpmnModelElementInstance;

public interface TaskHeaders extends BpmnModelElementInstance {
    Collection<Header> getHeaders();
    void addHeader(Header header);
    boolean addHeaders(List<Header> headers);
    List<Header> findByKey(String key);
}
