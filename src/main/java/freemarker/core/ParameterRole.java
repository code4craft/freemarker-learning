package freemarker.core;

// Change this to an Enum in Java 5
/**
 * @see TemplateObject#getParameterRole(int)
 */
public final class ParameterRole {
    
    private final String name;

    public static final ParameterRole UNKNOWN = new ParameterRole("[unknown role]");
    
    // When figuring out the names of these, always read them after the possible getName() values. It should sound OK.
    // Like "`+` left hand operand", or "`#if` parameter". That is, the roles (only) have to make sense in the
    // context of the possible TemplateObject classes.
    public static final ParameterRole LEFT_HAND_OPERAND = new ParameterRole("left-hand operand"); 
    public static final ParameterRole RIGHT_HAND_OPERAND = new ParameterRole("right-hand operand"); 
    public static final ParameterRole ENCLOSED_OPERAND = new ParameterRole("enclosed operand"); 
    public static final ParameterRole ITEM_VALUE = new ParameterRole("item value"); 
    public static final ParameterRole ITEM_KEY = new ParameterRole("item key");
    public static final ParameterRole ASSIGNMENT_TARGET = new ParameterRole("assignment target");
    public static final ParameterRole ASSIGNMENT_SOURCE = new ParameterRole("assignment source");
    public static final ParameterRole VARIABLE_SCOPE = new ParameterRole("variable scope");
    public static final ParameterRole NAMESPACE = new ParameterRole("namespace");
    public static final ParameterRole ERROR_HANDLER = new ParameterRole("error handler");
    public static final ParameterRole PASSED_VALUE = new ParameterRole("passed value");
    public static final ParameterRole CONDITION = new ParameterRole("condition"); 
    public static final ParameterRole VALUE = new ParameterRole("value");
    public static final ParameterRole AST_NODE_SUBTYPE = new ParameterRole("AST-node subtype");
    public static final ParameterRole PLACEHOLDER_VARIABLE = new ParameterRole("placeholder variable");
    public static final ParameterRole EXPRESSION_TEMPLATE = new ParameterRole("expression template");
    public static final ParameterRole LIST_SOURCE = new ParameterRole("list source");
    public static final ParameterRole TARGET_LOOP_VARIABLE = new ParameterRole("target loop variable");
    public static final ParameterRole TEMPLATE_NAME = new ParameterRole("template name");
    public static final ParameterRole PARSE_PARAMETER = new ParameterRole("\"parse\" parameter");
    public static final ParameterRole ENCODING_PARAMETER = new ParameterRole("\"encoding\" parameter");
    public static final ParameterRole PARAMETER_NAME = new ParameterRole("parameter name");
    public static final ParameterRole PARAMETER_DEFAULT = new ParameterRole("parameter default");
    public static final ParameterRole CATCH_ALL_PARAMETER_NAME = new ParameterRole("catch-all parameter name");
    public static final ParameterRole ARGUMENT_NAME = new ParameterRole("argument name");
    public static final ParameterRole ARGUMENT_VALUE = new ParameterRole("argument value");
    public static final ParameterRole CONTENT = new ParameterRole("content");
    public static final ParameterRole EMBEDDED_TEMPLATE = new ParameterRole("embedded template");
    public static final ParameterRole MINIMUM_DECIMALS = new ParameterRole("minimum decimals");
    public static final ParameterRole MAXIMUM_DECIMALS = new ParameterRole("maximum decimals");
    public static final ParameterRole NODE = new ParameterRole("node");
    public static final ParameterRole CALLEE = new ParameterRole("callee");
    public static final ParameterRole MESSAGE = new ParameterRole("message");
    
    private ParameterRole(String name) {
        this.name = name;
    }
    
    public static ParameterRole forBinaryOperatorOperand(int paramIndex) {
        switch (paramIndex) {
        case 0: return LEFT_HAND_OPERAND;
        case 1: return RIGHT_HAND_OPERAND;
        default: throw new IndexOutOfBoundsException();
        }
    }
    
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
    
}
