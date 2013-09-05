package freemarker.core.builtIn;

import freemarker.core.CollectionAndSequence;
import freemarker.core.Environment;
import freemarker.core._ErrorDescriptionBuilder;
import freemarker.core.exception.InvalidReferenceException;
import freemarker.core.exception.UnexpectedTypeException;
import freemarker.core.nodes.BuiltIn;
import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateException;
import freemarker.template.template_model.TemplateHashModelEx;
import freemarker.template.template_model.TemplateModel;
import freemarker.template.template_model.TemplateModelException;
import freemarker.template.template_model.TemplateSequenceModel;

/**
 * A holder for builtins that operate exclusively on hash left-hand value.
 */
public class HashBuiltins {

    // Can't be instantiated
    private HashBuiltins() { }
    
    private static abstract class HashExBuiltin extends BuiltIn {

        public TemplateModel _eval(Environment env) throws TemplateException {
            TemplateModel model = target.eval(env);
            if (model instanceof TemplateHashModelEx) {
                return calculateResult((TemplateHashModelEx) model, env);
            }
            throw new UnexpectedTypeException(target, model, "extended hash", env);
        }
        
        abstract TemplateModel calculateResult(TemplateHashModelEx hashExModel, Environment env)
                throws TemplateModelException, InvalidReferenceException;
        
        protected InvalidReferenceException newNullPropertyException(
                String propertyName, TemplateModel tm, Environment env) {
            if (env.getFastInvalidReferenceExceptions()) {
                return InvalidReferenceException.FAST_INSTANCE;
            } else {
                return new InvalidReferenceException(
                        new _ErrorDescriptionBuilder(new Object[] {
                            "The exteneded hash (of class ", tm.getClass().getName(), ") has returned null for its \"",
                            propertyName,
                            "\" property. This is maybe a bug. The extended hash was returned by this expression:" })
                        .blame(target),
                        env);
            }
        }
        
    }

    public static class keysBI extends HashExBuiltin {

        TemplateModel calculateResult(TemplateHashModelEx hashExModel, Environment env)
                throws TemplateModelException, InvalidReferenceException {
            TemplateCollectionModel keys = hashExModel.keys();
            if (keys == null) throw newNullPropertyException("keys", hashExModel, env);
            return keys instanceof TemplateSequenceModel ? keys : new CollectionAndSequence(keys);
        }
        
    }

    public static class valuesBI extends HashExBuiltin {
        TemplateModel calculateResult(TemplateHashModelEx hashExModel, Environment env)
                throws TemplateModelException, InvalidReferenceException {
            TemplateCollectionModel values = hashExModel.values();
            if (values == null) throw newNullPropertyException("values", hashExModel, env);
            return values instanceof TemplateSequenceModel ? values : new CollectionAndSequence(values);
        }
    }
    
}
