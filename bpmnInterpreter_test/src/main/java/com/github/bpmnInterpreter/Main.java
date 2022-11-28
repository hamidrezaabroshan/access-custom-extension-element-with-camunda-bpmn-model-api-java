package com.github.bpmnInterpreter;

import java.io.InputStream;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.ServiceTask;

import com.github.bpmnInterpreter.model.CustomBpmn;
import com.github.bpmnInterpreter.model.TaskHeaders;

public class Main {


    public static void main(String[] args) {
        InputStream is = Main.class.getResourceAsStream("/dclm-addservice.bpmn");
        BpmnModelInstance model =CustomBpmn.readModelFromStream(is );
        ServiceTask serviceTask=model.getModelElementById("ServiceTask_1jn441o");
        int count=serviceTask.getExtensionElements().getElementsQuery().filterByType(TaskHeaders.class).count();
        System.out.println(count);
        count=serviceTask.getExtensionElements().getElementsQuery().count();
        System.out.println(count);
        
    }

}
