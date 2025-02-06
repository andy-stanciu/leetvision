package org.leetvision.parser.meta.mapper;

import java.util.HashMap;
import java.util.Map;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class JavaLanguageMapper extends LanguageMapper {
    public static final JavaLanguageMapper INSTANCE = new JavaLanguageMapper(new HashMap<>() {{
        put("compilationUnit", MetaNode.PROGRAM);
        put("importDeclaration", MetaNode.IMPORT);

        put("typeDeclaration", MetaNode.TYPE_DECLARATION);
        put("modifier", MetaNode.MODIFIER);
        put("classOrInterfaceModifier", MetaNode.CLASS_MODIFIER);
        put("variableModifier", MetaNode.VARIABLE_MODIFIER);
        put("classDeclaration", MetaNode.CLASS_DECLARATION);
        put("localTypeDeclaration", MetaNode.CLASS_DECLARATION);
        put("typeParameters", MetaNode.TYPE_PARAMETERS);
        put("typeParameter", MetaNode.TYPE_PARAMETER);
        put("typeBound", MetaNode.UNION_TYPE);

        put("enumDeclaration", MetaNode.ENUM_DECLARATION);
        put("enumConstants", MetaNode.ENUM_CONSTANTS);
        put("enumConstant", MetaNode.ENUM_CONSTANT);
        put("enumBodyDeclarations", MetaNode.ENUM_BODY_DECLARATIONS);

        put("interfaceDeclaration", MetaNode.INTERFACE_DECLARATION);
        put("classBody", MetaNode.CLASS_BODY);
        put("interfaceBody", MetaNode.INTERFACE_BODY);

        put("classBodyDeclaration", MetaNode.BODY_DECLARATION);
        put("interfaceBodyDeclaration", MetaNode.BODY_DECLARATION);
        put("interfaceCommonBodyDeclaration", MetaNode.BODY_DECLARATION);

        put("memberDeclaration", MetaNode.MEMBER_DECLARATION);
        put("interfaceMemberDeclaration", MetaNode.MEMBER_DECLARATION);

        put("methodDeclaration", MetaNode.METHOD_DECLARATION);
        put("genericMethodDeclaration", MetaNode.METHOD_DECLARATION);
        put("interfaceMethodDeclaration", MetaNode.METHOD_DECLARATION);
        put("genericInterfaceMethodDeclaration", MetaNode.METHOD_DECLARATION);

        put("methodBody", MetaNode.METHOD_BODY);

        put("typeTypeOrVoid", MetaNode.TYPE);
        put("typeArgument", MetaNode.TYPE);
        put("typeList", MetaNode.TYPE_LIST);
        put("typeType", MetaNode.TYPE);
        put("primitiveType", MetaNode.TYPE_PRIMITIVE);
        put("typeArguments", MetaNode.TYPE_ARGUMENTS);

        put("genericConstructorDeclaration", MetaNode.CONSTRUCTOR_DECLARATION);
        put("constructorDeclaration", MetaNode.CONSTRUCTOR_DECLARATION);
        put("compactConstructorDeclaration", MetaNode.CONSTRUCTOR_DECLARATION);

        put("fieldDeclaration", MetaNode.FIELD_DECLARATION);
        put("constDeclaration", MetaNode.CONST_DECLARATION);  // field that is initialized

        put("constantDeclarator", MetaNode.CONSTANT_DECLARATOR);
        put("variableDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("variableDeclarators", MetaNode.VARIABLE_DECLARATORS);

        put("variableDeclaratorId", MetaNode.IDENTIFIER);

        put("variableInitializer", MetaNode.VARIABLE_INITIALIZER);
        put("arrayInitializer", MetaNode.ARRAY_INITIALIZER);

        put("classOrInterfaceType", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("classType", MetaNode.CLASS_TYPE);

        put("qualifiedName", MetaNode.QUALIFIED_NAME);
        put("qualifiedNameList", MetaNode.QUALIFIED_NAME_LIST);

        put("formalParameters", MetaNode.FORMAL_PARAMETERS);
        put("receiverParameter", MetaNode.FORMAL_PARAMETER);
        put("formalParameterList", MetaNode.FORMAL_PARAMETERS);
        put("formalParameter", MetaNode.FORMAL_PARAMETER);
        put("lastFormalParameter", MetaNode.FORMAL_PARAMETER);
        put("lambdaLVTIList", MetaNode.LAMBDA_PARAMETERS);
        put("lambdaParameters", MetaNode.LAMBDA_PARAMETERS);
        put("lambdaLVTIParameter", MetaNode.LAMBDA_PARAMETER);

        put("elementValuePairs", MetaNode.EXPRESSION_VALUE_PAIRS);
        put("elementValuePair", MetaNode.EXPRESSION_VALUE_PAIR);

        put("elementValue", MetaNode.EXPRESSION);
        put("expressionList", MetaNode.EXPRESSION_LIST);
        put("expression", MetaNode.EXPRESSION);
        put("primary", MetaNode.EXPRESSION);
        put("pattern", MetaNode.PATTERN);
        put("guardedPattern", MetaNode.GUARDED_PATTERN);
        put("lambdaExpression", MetaNode.LAMBDA_EXPRESSION);
        put("lambdaBody", MetaNode.LAMBDA_BODY);
        put("methodCall", MetaNode.METHOD_CALL);

        put("switchExpression", MetaNode.SWITCH_EXPRESSION);
        put("switchLabeledRule", MetaNode.SWITCH_LABELED_RULE);
        put("switchRuleOutcome", MetaNode.SWITCH_RULE_OUTCOME);

        put("elementValueArrayInitializer", MetaNode.EXPRESSION_VALUE_ARRAY_INITIALIZER);

        put("defaultValue", MetaNode.DEFAULT_VALUE);

        put("recordDeclaration", MetaNode.RECORD_DECLARATION);
        put("recordHeader", MetaNode.RECORD_HEADER);
        put("recordComponentList", MetaNode.RECORD_COMPONENT_LIST);
        put("recordComponent", MetaNode.RECORD_COMPONENT);
        put("recordBody", MetaNode.RECORD_BODY);

        put("block", MetaNode.BLOCK);
        put("blockStatement", MetaNode.STATEMENT);
        put("localVariableDeclaration", MetaNode.LOCAL_VARIABLE_DECLARATION);
        put("typeIdentifier", MetaNode.TYPE_IDENTIFIER);

        put("statement", MetaNode.STATEMENT);
        put("catchClause", MetaNode.CATCH_CLAUSE);
        put("catchType", MetaNode.CATCH_TYPE);
        put("finallyBlock", MetaNode.FINALLY_BLOCK);

        put("resourceSpecification", MetaNode.TRY_RESOURCE_SPECIFIER);
        put("resources", MetaNode.TRY_RESOURCES);
        put("resource", MetaNode.TRY_RESOURCE);

        put ("switchBlockStatementGroup", MetaNode.SWITCH_BLOCK_STATEMENT_GROUP);
        put("switchLabel", MetaNode.SWITCH_LABEL);
        put("forControl", MetaNode.FOR_CONTROL);
        put("forInit", MetaNode.FOR_INIT);
        put("enhancedForControl", MetaNode.FOREACH_CONTROL);

        put("creator", MetaNode.CREATOR);
        put("createdName", MetaNode.CREATED_NAME);
        put("innerCreator", MetaNode.INNER_CREATOR);
        put("arrayCreatorRest", MetaNode.ARRAY_CREATOR_REST);
        put("classCreatorRest", MetaNode.CLASS_CREATOR_REST);

        put("explicitGenericInvocation", MetaNode.EXPLICIT_GENERIC_INVOCATION);

        put("superSuffix", MetaNode.SUPER_SUFFIX);
        put("explicitGenericInvocationSuffix", MetaNode.EXPLICIT_GENERIC_INVOCATION_SUFFIX);
        put("arguments", MetaNode.ARGUMENTS);

        // terminals
        put("IDENTIFIER", MetaNode.IDENTIFIER);

        put("DECIMAL_LITERAL", MetaNode.DECIMAL_LITERAL);
        put("HEX_LITERAL", MetaNode.HEX_LITERAL);
        put("OCT_LITERAL", MetaNode.OCT_LITERAL);
        put("BINARY_LITERAL", MetaNode.BINARY_LITERAL);
        put("FLOAT_LITERAL", MetaNode.FLOAT_LITERAL);
        put("HEX_FLOAT_LITERAL", MetaNode.HEX_FLOAT_LITERAL);
        put("BOOL_LITERAL", MetaNode.BOOL_LITERAL);
        put("CHAR_LITERAL", MetaNode.CHAR_LITERAL);
        put("STRING_LITERAL", MetaNode.STRING_LITERAL);
        put("TEXT_BLOCK", MetaNode.MULTILINE_STRING_LITERAL);
        put("NULL_LITERAL", MetaNode.NULL_LITERAL);

        put("ABSTRACT", MetaNode.MODIFIER_ABSTRACT);
        put("CONST", MetaNode.MODIFIER_CONST);
        put("EXTENDS", MetaNode.MODIFIER_EXTENDS);
        put("IMPLEMENTS", MetaNode.MODIFIER_IMPLEMENTS);
        put("FINAL", MetaNode.MODIFIER_FINAL);
        put("NATIVE", MetaNode.MODIFIER_NATIVE);
        put("PRIVATE", MetaNode.MODIFIER_PRIVATE);
        put("PROTECTED", MetaNode.MODIFIER_PROTECTED);
        put("PUBLIC", MetaNode.MODIFIER_PUBLIC);
        put("STATIC", MetaNode.MODIFIER_STATIC);
        put("STRICTFP", MetaNode.MODIFIER_STRICTFP);
        put("SYNCHRONIZED", MetaNode.MODIFIER_SYNCHRONIZED);
        put("THROWS", MetaNode.MODIFIER_THROWS);
        put("TRANSIENT", MetaNode.MODIFIER_TRANSIENT);
        put("VOLATILE", MetaNode.MODIFIER_VOLATILE);
        put("SEALED", MetaNode.MODIFIER_SEALED);
        put("ELLIPSIS", MetaNode.MODIFIER_VARARGS);

        put("ASSERT", MetaNode.STATEMENT_ASSERT);
        put("BREAK", MetaNode.STATEMENT_BREAK);
        put("CONTINUE", MetaNode.STATEMENT_CONTINUE);
        put("SWITCH", MetaNode.STATEMENT_SWITCH);
        put("CASE", MetaNode.STATEMENT_CASE);
        put("DEFAULT", MetaNode.STATEMENT_DEFAULT);
        put("TRY", MetaNode.STATEMENT_TRY);
        put("CATCH", MetaNode.STATEMENT_CATCH);
        put("DO", MetaNode.STATEMENT_DO);
        put("ELSE", MetaNode.STATEMENT_ELSE);
        put("FINALLY", MetaNode.STATEMENT_FINALLY);
        put("FOR", MetaNode.STATEMENT_FOR);
        put("IF", MetaNode.STATEMENT_IF);
        put("GOTO", MetaNode.STATEMENT_GOTO);
        put("RETURN", MetaNode.STATEMENT_RETURN);
        put("THROW", MetaNode.STATEMENT_THROW);
        put("WHILE", MetaNode.STATEMENT_WHILE);
        put("YIELD", MetaNode.STATEMENT_YIELD);

        put("INSTANCEOF", MetaNode.EXPR_INSTANCEOF);
        put("NEW", MetaNode.EXPR_NEW);
        put("SUPER", MetaNode.EXPR_SUPER);
        put("THIS", MetaNode.EXPR_THIS);

        put("ASSIGN", MetaNode.OP_ASSIGN);
        put("ADD_ASSIGN", MetaNode.OP_ADD_ASSIGN);
        put("SUB_ASSIGN", MetaNode.OP_SUB_ASSIGN);
        put("MUL_ASSIGN", MetaNode.OP_MUL_ASSIGN);
        put("DIV_ASSIGN", MetaNode.OP_DIV_ASSIGN);
        put("AND_ASSIGN", MetaNode.OP_AND_ASSIGN);
        put("OR_ASSIGN", MetaNode.OP_OR_ASSIGN);
        put("XOR_ASSIGN", MetaNode.OP_XOR_ASSIGN);
        put("MOD_ASSIGN", MetaNode.OP_MOD_ASSIGN);
        put("LSHIFT_ASSIGN", MetaNode.OP_LSHIFT_ASSIGN);
        put("RSHIFT_ASSIGN", MetaNode.OP_RSHIFT_ASSIGN);
        put("URSHIFT_ASSIGN", MetaNode.OP_URSHIFT_ASSIGN);
        put("GT", MetaNode.OP_GT);
        put("LT", MetaNode.OP_LT);
        put("BANG", MetaNode.OP_NOT);
        put("TILDE", MetaNode.OP_BITNOT);
        put("QUESTION", MetaNode.OP_TERNARY);
        put("EQUAL", MetaNode.OP_EQUAL);
        put("LE", MetaNode.OP_LE);
        put("GE", MetaNode.OP_GE);
        put("NOTEQUAL", MetaNode.OP_NOTEQUAL);
        put("AND", MetaNode.OP_AND);
        put("OR", MetaNode.OP_OR);
        put("CARET", MetaNode.OP_XOR);
        put("INC", MetaNode.OP_INC);
        put("DEC", MetaNode.OP_DEC);
        put("ADD", MetaNode.OP_ADD);
        put("SUB", MetaNode.OP_SUB);
        put("MUL", MetaNode.OP_MUL);
        put("DIV", MetaNode.OP_DIV);
        put("MOD", MetaNode.OP_MOD);
        put("BITAND", MetaNode.OP_BITAND);
        put("BITOR", MetaNode.OP_BITOR);
        put("ARROW", MetaNode.OP_LAMBDA);
        put("COLONCOLON", MetaNode.OP_METHOD_REFERENCE);

        put("BOOLEAN", MetaNode.TYPE_BOOLEAN);
        put("BYTE", MetaNode.TYPE_BYTE);
        put("CHAR", MetaNode.TYPE_CHAR);
        put("CLASS", MetaNode.TYPE_CLASS);
        put("INTERFACE", MetaNode.TYPE_INTERFACE);
        put("DOUBLE", MetaNode.TYPE_DOUBLE);
        put("ENUM", MetaNode.TYPE_ENUM);
        put("FLOAT", MetaNode.TYPE_FLOAT);
        put("INT", MetaNode.TYPE_INT);
        put("LONG", MetaNode.TYPE_LONG);
        put("SHORT", MetaNode.TYPE_SHORT);
        put("VOID", MetaNode.TYPE_VOID);
        put("VAR", MetaNode.TYPE_VAR);
        put("RECORD", MetaNode.TYPE_RECORD);

        // hacky terminals
        put("LBRACK", MetaNode.L_SQUARE);
        put("RBRACK", MetaNode.R_SQUARE);
        put("DOT", MetaNode.DOT);

        // irrelevant terminals
        put("LBRACE", VOID_MAPPING);
        put("LPAREN", VOID_MAPPING);
        put("RBRACE", VOID_MAPPING);
        put("RPAREN", VOID_MAPPING);
        put("SEMI", VOID_MAPPING);
        put("COLON", VOID_MAPPING);
        put("AT", VOID_MAPPING);
        put("WS", VOID_MAPPING);
        put("EOF", VOID_MAPPING);
        put("IMPORT", VOID_MAPPING);
        put("MODULE", VOID_MAPPING);
        put("OPEN", VOID_MAPPING);
        put("REQUIRES", VOID_MAPPING);
        put("EXPORTS", VOID_MAPPING);
        put("OPENS", VOID_MAPPING);
        put("TO", VOID_MAPPING);
        put("USES", VOID_MAPPING);
        put("PROVIDES", VOID_MAPPING);
        put("WITH", VOID_MAPPING);
        put("TRANSITIVE", VOID_MAPPING);
        put("PERMITS", VOID_MAPPING);
        put("NON_SEALED", VOID_MAPPING);
        put("PACKAGE", VOID_MAPPING);
        put("COMMA", VOID_MAPPING);

        // pruned non-terminals
        put("literal", VOID_MAPPING);
        put("integerLiteral",VOID_MAPPING);
        put("floatLiteral", VOID_MAPPING);

        put("typeArgumentsOrDiamond", VOID_MAPPING);
        put("nonWildcardTypeArguments", VOID_MAPPING);
        put("nonWildcardTypeArgumentsOrDiamond", VOID_MAPPING);
        put("parExpression", VOID_MAPPING);

        // don't care
        put("packageDeclaration", VOID_MAPPING);
        put("requiresModifier", VOID_MAPPING);

        // annotations
        put("altAnnotationQualifiedName", VOID_MAPPING);
        put("annotation", VOID_MAPPING);
        put("annotationTypeDeclaration", VOID_MAPPING);
        put("annotationTypeBody", VOID_MAPPING);
        put("annotationTypeElementDeclaration", VOID_MAPPING);
        put("annotationTypeElementRest", VOID_MAPPING);
        put("annotationMethodOrConstantRest", VOID_MAPPING);
        put("annotationMethodRest", VOID_MAPPING);
        put("annotationConstantRest", VOID_MAPPING);

        // modules - wtf is this?
        put("moduleDeclaration", VOID_MAPPING);
        put("moduleBody", VOID_MAPPING);
        put("moduleDirective", VOID_MAPPING);
    }});

    private JavaLanguageMapper(final Map<String, MetaNode> mappings) {
        super(mappings);
    }
}
