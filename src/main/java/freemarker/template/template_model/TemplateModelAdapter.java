package freemarker.template.template_model;

/**
 * Implemented by classes that serve as adapters for template model objects in
 * some other object model. Actually a functional inverse of 
 * {@link freemarker.template.AdapterTemplateModel}. You will rarely implement this interface
 * directly. It is usually implemented by unwrapping adapter classes of various 
 * object wrapper implementations.
 * @author Attila Szegedi
 */
public interface TemplateModelAdapter {
    /**
     * @return the template model this object is wrapping.
     */
    public TemplateModel getTemplateModel();
}
