package com.github.bpmnInterpreter.model.imple;

import org.camunda.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import static com.github.bpmnInterpreter.model.Constants.*;
import org.camunda.bpm.model.xml.ModelBuilder;
import org.camunda.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder;
import org.camunda.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.camunda.bpm.model.xml.type.attribute.Attribute;

import com.github.bpmnInterpreter.model.Header;

public class HeaderImpl extends BpmnModelElementInstanceImpl implements Header {
    protected static Attribute<String> keyAttribute;
    protected static Attribute<String> valueAttribute;
    public static void registerType(ModelBuilder modelBuilder) {
        ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(Header.class, HEADER)
                .namespaceUri(ZEEBE_SCHEMA)
                .instanceProvider(new ModelTypeInstanceProvider<Header>() {
                    public Header newInstance(ModelTypeInstanceContext instanceContext) {
                        return new HeaderImpl(instanceContext);
                    }
                });
        keyAttribute =typeBuilder.stringAttribute(KEY_NAME)
                .namespace(ZEEBE_SCHEMA)
                .build();
        valueAttribute =typeBuilder.stringAttribute(VALUE_NAME)
                .namespace(ZEEBE_SCHEMA)
                .build();
        typeBuilder.build();
    }
    public HeaderImpl(ModelTypeInstanceContext instanceContext) {
        super(instanceContext);
    }
    @Override
    public String getKey() {
        return keyAttribute.getValue(this);
    }
    @Override
    public void setKey(String key) {
        keyAttribute.setValue(this, key);
    }
    @Override
    public String getValue() {
        return valueAttribute.getValue(this);
    }
    @Override
    public void setValue(String value) {
        valueAttribute.setValue(this, value);
    }
    
}
