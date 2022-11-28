package com.github.bpmnInterpreter.model;

import java.io.File;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.xml.ModelBuilder;

import com.github.bpmnInterpreter.model.imple.HeaderImpl;
import com.github.bpmnInterpreter.model.imple.TaskHeadersImpl;

public class CustomBpmn extends Bpmn {
    public static CustomBpmn INSTANCE = new CustomBpmn();
    public CustomBpmn() {
        super();
        System.out.println("constructor");
    }
    @Override
    protected void doRegisterTypes(ModelBuilder modelBuilder) {
      super.doRegisterTypes(modelBuilder);
      System.out.println("registering");
      HeaderImpl.registerType(modelBuilder);
      TaskHeadersImpl.registerType(modelBuilder);
    }
    


}
