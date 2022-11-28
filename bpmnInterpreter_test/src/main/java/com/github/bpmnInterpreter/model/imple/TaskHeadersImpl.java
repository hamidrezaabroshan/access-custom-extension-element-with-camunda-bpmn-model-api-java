package com.github.bpmnInterpreter.model.imple;

import org.camunda.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.child.ChildElementCollection;
import org.camunda.bpm.model.xml.type.child.SequenceBuilder;

import com.github.bpmnInterpreter.model.Header;
import com.github.bpmnInterpreter.model.TaskHeaders;
import static com.github.bpmnInterpreter.model.Constants.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TaskHeadersImpl extends BpmnModelElementInstanceImpl implements TaskHeaders {
    protected static ChildElementCollection<Header> headerCollection;
    public static void registerType(ModelBuilder modelBuilder) {
        ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(TaskHeaders.class, TASK_HEADERS)
                .namespaceUri(ZEEBE_SCHEMA)
                .instanceProvider(new ModelTypeInstanceProvider<TaskHeaders>() {
                    public TaskHeaders newInstance(ModelTypeInstanceContext instanceContext) {
                        return new TaskHeadersImpl(instanceContext);
                    }
                });
        SequenceBuilder sequenceBuilder = typeBuilder.sequence();
        headerCollection =sequenceBuilder.elementCollection(Header.class)
                .build();
        typeBuilder.build();
    }
    public TaskHeadersImpl(ModelTypeInstanceContext instanceContext) {
        super(instanceContext);
    }
    @Override
    public Collection<Header> getHeaders() {
        return headerCollection.get(this);
    }
    @Override
    public void addHeader(Header header) {
        getHeaders().add(header);
    }
    @Override
    public boolean addHeaders(List<Header> headers) {
        return getHeaders().addAll(headers);
    }
    @Override
    public List<Header> findByKey(String key) {
        return getHeaders().stream().filter(header -> header.getKey().equals(key)).collect(Collectors.toList());
    }


}
