package freemarker.ext.beans;

import java.util.AbstractList;

import freemarker.template.template_model.TemplateModel;
import freemarker.template.template_model.TemplateModelAdapter;
import freemarker.template.template_model.TemplateModelException;
import freemarker.template.template_model.TemplateSequenceModel;
import freemarker.template.utility.UndeclaredThrowableException;

/**
 * @author Attila Szegedi
 */
class SequenceAdapter extends AbstractList implements TemplateModelAdapter {
    private final BeansWrapper wrapper;
    private final TemplateSequenceModel model;
    
    SequenceAdapter(TemplateSequenceModel model, BeansWrapper wrapper) {
        this.model = model;
        this.wrapper = wrapper;
    }
    
    public TemplateModel getTemplateModel() {
        return model;
    }
    
    public int size() {
        try {
            return model.size();
        }
        catch(TemplateModelException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
    
    public Object get(int index) {
        try {
            return wrapper.unwrap(model.get(index));
        }
        catch(TemplateModelException e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
