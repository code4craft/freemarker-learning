package freemarker.test.templatesuite.models;

import freemarker.template.TemplateBooleanModel;
import freemarker.template.template_model.TemplateModelException;
import freemarker.template.template_model.TemplateScalarModel;

public class BooleanAndStringTemplateModel implements TemplateBooleanModel, TemplateScalarModel {

    public String getAsString() throws TemplateModelException {
        return "theStringValue";
    }

    public boolean getAsBoolean() throws TemplateModelException {
        return true;
    }

}
