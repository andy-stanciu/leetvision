package org.leetvision.parser.meta.mapper;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

import java.util.HashMap;
import java.util.Map;

public final class CppLanguageMapper extends LanguageMapper {
    public static final CppLanguageMapper INSTANCE = new CppLanguageMapper(new HashMap<>() {{
        put("translationUnit", MetaNode.PROGRAM);
        put("primaryExpression", MetaNode.EXPRESSION);
        put("idExpression", MetaNode.EXPRESSION);
        put("unqualifiedId", MetaNode.IDENTIFIER);
        put("qualifiedId", MetaNode.IDENTIFIER);
        put("nestedNameSpecifier", MetaNode.QUALIFIED_NAME);
        put("lambdaExpression", MetaNode.LAMBDA_EXPRESSION);
        put("lambdaIntroducer", MetaNode.LAMBDA_PARAMETERS);
        put("lambdaCapture", MetaNode.LAMBDA_PARAMETERS);
        put("captureDefault", MetaNode.LAMBDA_PARAMETERS);
        put("captureList", MetaNode.LAMBDA_PARAMETERS);
        put("capture", MetaNode.LAMBDA_PARAMETERS);
        put("simpleCapture", MetaNode.LAMBDA_PARAMETERS);
        put("initcapture", MetaNode.LAMBDA_PARAMETERS);
        put("lambdaDeclarator", MetaNode.LAMBDA_EXPRESSION);
        put("postfixExpression", MetaNode.EXPRESSION);
        put("typeIdOfTheTypeId", MetaNode.TYPE_OF);
        put("expressionList", MetaNode.EXPRESSION_LIST);
        put("pseudoDestructorName", MetaNode.DESTRUCTOR);
        put("unaryExpression", MetaNode.EXPRESSION);
        put("unaryOperator", MetaNode.OP_NOT);  // hack
        put("newExpression_", MetaNode.EXPR_NEW);
        put("newPlacement", MetaNode.EXPRESSION_LIST);
        put("newTypeId", MetaNode.CREATED_NAME);
        put("newDeclarator_", MetaNode.CREATOR);
        put("noPointerNewDeclarator", MetaNode.CREATOR);
        put("newInitializer", MetaNode.CLASS_CREATOR_REST);
        put("deleteExpression", MetaNode.EXPRESSION);
        put("noExceptExpression", MetaNode.EXPRESSION);
        put("castExpression", MetaNode.EXPRESSION);
        put("pointerMemberExpression", MetaNode.EXPRESSION);
        put("multiplicativeExpression", MetaNode.EXPRESSION);
        put("additiveExpression", MetaNode.EXPRESSION);
        put("shiftExpression", MetaNode.EXPRESSION);
        put("shiftOperator", MetaNode.OP_LT);  // hack
        put("relationalExpression", MetaNode.EXPRESSION);
        put("equalityExpression", MetaNode.EXPRESSION);
        put("andExpression", MetaNode.EXPRESSION);
        put("exclusiveOrExpression", MetaNode.EXPRESSION);
        put("inclusiveOrExpression", MetaNode.EXPRESSION);
        put("logicalAndExpression", MetaNode.EXPRESSION);
        put("logicalOrExpression", MetaNode.EXPRESSION);
        put("conditionalExpression", MetaNode.EXPRESSION);
        put("assignmentOperator", MetaNode.OP_ASSIGN);
        put("expression", MetaNode.EXPRESSION);
        put("constantExpression", MetaNode.EXPRESSION);
        put("statement", MetaNode.STATEMENT);
        put("labeledStatement", MetaNode.STATEMENT);
        put("expressionStatement", MetaNode.EXPRESSION);
        put("compoundStatement", MetaNode.BLOCK);
        put("statementSeq", MetaNode.BLOCK);
        put("selectionStatement", MetaNode.STATEMENT);
        put("condition", MetaNode.EXPRESSION);
        put("iterationStatement", MetaNode.STATEMENT);
        put("forInitStatement", MetaNode.FOR_CONTROL);
        put("forRangeDeclaration", MetaNode.FOR_CONTROL);
        put("forRangeInitializer", MetaNode.FOR_CONTROL);
        put("jumpStatement", MetaNode.STATEMENT_GOTO);  // hack
        put("declarationStatement", MetaNode.BODY_DECLARATION);
        put("declaration", MetaNode.BODY_DECLARATION);
        put("blockDeclaration", MetaNode.BODY_DECLARATION);
        put("aliasDeclaration", MetaNode.TYPE_DECLARATION);
        put("simpleDeclaration", MetaNode.LOCAL_VARIABLE_DECLARATION);
        put("staticAssertDeclaration", MetaNode.STATEMENT_ASSERT);
        put("emptyDeclaration_", VOID_MAPPING);
        put("attributeDeclaration", VOID_MAPPING);
        put("declSpecifier", MetaNode.VARIABLE_MODIFIER); // hack
        put("declSpecifierSeq", MetaNode.MODIFIER_LIST);
        put("storageClassSpecifier", MetaNode.CLASS_MODIFIER); // hack
        put("functionSpecifier", MetaNode.VARIABLE_MODIFIER);  // hack
        put("typedefName", MetaNode.IDENTIFIER);
        put("typeSpecifier", MetaNode.TYPE);
        put("trailingTypeSpecifier", MetaNode.TYPE);
        put("typeSpecifierSeq", MetaNode.TYPE_LIST);
        put("trailingTypeSpecifierSeq", MetaNode.TYPE_LIST);
        put("simpleTypeLengthModifier", MetaNode.TYPE_SHORT);
        put("simpleTypeSignednessModifier", MetaNode.TYPE_UNSIGNED);  // hack
        put("simpleTypeSpecifier", MetaNode.TYPE);
        put("theTypeName", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("decltypeSpecifier", MetaNode.TYPE_OF);
        put("elaboratedTypeSpecifier", MetaNode.TYPE_DECLARATION);
        put("enumName", MetaNode.IDENTIFIER);
        put("enumSpecifier", MetaNode.ENUM_BODY_DECLARATIONS);
        put("enumHead", MetaNode.ENUM_CONSTANT);
        put("opaqueEnumDeclaration", MetaNode.ENUM_DECLARATION);
        put("enumkey", MetaNode.TYPE_ENUM);
        put("enumbase", MetaNode.TYPE_ENUM);
        put("enumeratorList", MetaNode.ENUM_CONSTANTS);
        put("enumeratorDefinition", MetaNode.ENUM_DECLARATION);
        put("enumerator", MetaNode.IDENTIFIER);
        put("namespaceName", VOID_MAPPING); // dont care about namespace
        put("originalNamespaceName", VOID_MAPPING);
        put("namespaceDefinition", VOID_MAPPING);
        put("namespaceAlias", VOID_MAPPING);
        put("namespaceAliasDefinition", VOID_MAPPING);
        put("qualifiednamespacespecifier", VOID_MAPPING);
        put("usingDeclaration", VOID_MAPPING);  // dont care about using/imports
        put("usingDirective", VOID_MAPPING);
        put("asmDefinition", VOID_MAPPING);  // no way people use this
        put("linkageSpecification", VOID_MAPPING);
        put("attributeSpecifierSeq", VOID_MAPPING);  // don't care about attributes (annotations)
        put("attributeSpecifier", VOID_MAPPING);
        put("alignmentspecifier", VOID_MAPPING);
        put("attributeList", VOID_MAPPING);
        put("attribute", VOID_MAPPING);
        put("attributeNamespace", VOID_MAPPING);
        put("attributeArgumentClause", VOID_MAPPING);
        put("balancedTokenSeq", VOID_MAPPING);
        put("balancedtoken", VOID_MAPPING);
        put("initDeclaratorList", MetaNode.VARIABLE_DECLARATORS);
        put("initDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("declarator", MetaNode.VARIABLE_DECLARATOR);
        put("pointerDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("noPointerDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("parametersAndQualifiers", MetaNode.FORMAL_PARAMETERS);
        put("trailingReturnType", VOID_MAPPING);
        put("pointerOperator", MetaNode.OP_POINTER_ADDR);  // hack
        put("cvqualifierseq", MetaNode.MODIFIER_LIST);
        put("cvQualifier", MetaNode.MODIFIER_CONST);  // hack
        put("refqualifier", MetaNode.OP_POINTER_ADDR);
        put("declaratorid", MetaNode.IDENTIFIER);
        put("theTypeId", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("abstractDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("pointerAbstractDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("noPointerAbstractDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("abstractPackDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("noPointerAbstractPackDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("parameterDeclarationClause", MetaNode.FORMAL_PARAMETERS);
        put("parameterDeclarationList", MetaNode.FORMAL_PARAMETERS);
        put("parameterDeclaration", MetaNode.FORMAL_PARAMETER);
        put("functionDefinition", MetaNode.METHOD_DECLARATION);
        put("functionBody", MetaNode.METHOD_BODY);
        put("initializer", MetaNode.INITIALIZER);
        put("braceOrEqualInitializer", MetaNode.INITIALIZER);
        put("initializerClause", MetaNode.INITIALIZER);
        put("initializerList", MetaNode.INITIALIZER_LIST);
        put("bracedInitList", MetaNode.INITIALIZER_LIST);
        put("className", MetaNode.IDENTIFIER);
        put("classSpecifier", MetaNode.CLASS_DECLARATION);
        put("classHead", MetaNode.CLASS_DECLARATION);
        put("classHeadName", MetaNode.IDENTIFIER);
        put("classVirtSpecifier", MetaNode.CLASS_MODIFIER);
        put("classKey", MetaNode.TYPE_CLASS);
        put("memberSpecification", MetaNode.MEMBER_DECLARATION);  // hack
        put("memberdeclaration", MetaNode.MEMBER_DECLARATION);
        put("memberDeclaratorList", MetaNode.MEMBER_DECLARATION_LIST);
        put("memberDeclarator", MetaNode.MEMBER_DECLARATION);
        put("virtualSpecifierSeq", MetaNode.MODIFIER_LIST);
        put("virtualSpecifier", MetaNode.MODIFIER_FINAL);  // hack
        put("pureSpecifier", VOID_MAPPING);
        put("baseClause", MetaNode.MODIFIER_EXTENDS);
        put("baseSpecifierList", MetaNode.TYPE_LIST);
        put("baseSpecifier", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("classOrDeclType", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("baseTypeSpecifier", MetaNode.CLASS_OR_INTERFACE_TYPE);
        put("accessSpecifier", MetaNode.CLASS_MODIFIER);
        put("conversionFunctionId", VOID_MAPPING);
        put("conversionTypeId", VOID_MAPPING);
        put("conversionDeclarator", VOID_MAPPING);
        put("constructorInitializer", MetaNode.CLASS_CREATOR_REST);
        put("memInitializerList", MetaNode.CLASS_CREATOR_REST);
        put("memInitializer", MetaNode.INITIALIZER);
        put("meminitializerid", MetaNode.IDENTIFIER);
        put("operatorFunctionId", VOID_MAPPING);
        put("literalOperatorId", VOID_MAPPING);
        put("templateDeclaration", MetaNode.INTERFACE_DECLARATION);
        put("templateparameterList", MetaNode.FORMAL_PARAMETERS);
        put("templateParameter", MetaNode.FORMAL_PARAMETER);
        put("simpleTemplateId", MetaNode.IDENTIFIER);
        put("templateName", MetaNode.IDENTIFIER);
        put("templateArgumentList", MetaNode.EXPRESSION_LIST);
        put("templateArgument", MetaNode.EXPRESSION);
        put("typeNameSpecifier", MetaNode.TYPE);
        put("explicitInstantiation", MetaNode.INTERFACE_DECLARATION);
        put("explicitSpecialization", MetaNode.INTERFACE_DECLARATION);
        put("tryBlock", MetaNode.STATEMENT_TRY);
        put("functionTryBlock", MetaNode.STATEMENT_TRY);
        put("handlerSeq", MetaNode.STATEMENT_CATCH);
        put("handler", MetaNode.CATCH_CLAUSE);
        put("exceptionDeclaration", MetaNode.EXCEPTION_DECLARATION);
        put("throwExpression", MetaNode.STATEMENT_THROW);
        put("exceptionSpecification", MetaNode.STATEMENT_THROW);

    }});

    public CppLanguageMapper(Map<String, MetaNode> mappings) {
        super(mappings);
    }
}
