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
        put("newInitializer_", MetaNode.CLASS_CREATOR_REST);
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
        put("assignmentExpression", MetaNode.EXPRESSION);
        put("assignmentOperator", MetaNode.OP_ASSIGN);
        put("expression", MetaNode.EXPRESSION);
        put("constantExpression", MetaNode.EXPRESSION);
        put("statement", MetaNode.STATEMENT);
        put("labeledStatement", MetaNode.STATEMENT);
        put("expressionStatement", MetaNode.STATEMENT);
        put("compoundStatement", MetaNode.BLOCK);
        put("statementSeq", MetaNode.BLOCK);
        put("selectionStatement", MetaNode.STATEMENT);
        put("condition", MetaNode.EXPRESSION);
        put("iterationStatement", MetaNode.STATEMENT);
        put("forInitStatement", MetaNode.FOR_CONTROL);
        put("forRangeDeclaration", MetaNode.FOR_CONTROL);
        put("forRangeInitializer", MetaNode.FOR_CONTROL);
        put("jumpStatement", MetaNode.STATEMENT);
        put("declarationStatement", MetaNode.BODY_DECLARATION);
        put("declarationseq", MetaNode.DECLARATION_LIST);
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
        put("declarator", MetaNode.BODY_DECLARATION);
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
        put("className", MetaNode.TYPE_CLASS);
        put("classSpecifier", MetaNode.CLASS_DECLARATION);
        put("classHead", MetaNode.CLASS_DECLARATION);
        put("classHeadName", MetaNode.TYPE_CLASS);
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
        put("meminitializerid", MetaNode.TYPE_CLASS);
        put("operatorFunctionId", VOID_MAPPING);
        put("literalOperatorId", VOID_MAPPING);
        put("templateDeclaration", MetaNode.INTERFACE_DECLARATION);
        put("templateparameterList", MetaNode.FORMAL_PARAMETERS);
        put("templateParameter", MetaNode.FORMAL_PARAMETER);
        put("typeParameter", MetaNode.FORMAL_PARAMETER);
        put("simpleTemplateId", MetaNode.TYPE_CLASS);
        put("templateId", MetaNode.TYPE_CLASS);
        put("templateName", MetaNode.IDENTIFIER);
        put("templateArgumentList", MetaNode.TYPE_LIST);
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
        put("dynamicExceptionSpecification", MetaNode.STATEMENT_THROW);
        put("typeIdList", MetaNode.TYPE_LIST);
        put("noeExceptSpecification", MetaNode.EXPRESSION);
        put("theOperator", MetaNode.OP_ADD);  // hack
        put("literal", MetaNode.DECIMAL_LITERAL); // hack

        put("null", MetaNode.NULL_LITERAL);
        put("IntegerLiteral", MetaNode.DECIMAL_LITERAL);
        put("CharacterLiteral", MetaNode.CHAR_LITERAL);
        put("FloatingLiteral", MetaNode.FLOAT_LITERAL);
        put("StringLiteral", MetaNode.STRING_LITERAL);
        put("BooleanLiteral", MetaNode.BOOL_LITERAL);
        put("PointerLiteral", MetaNode.POINTER_LITERAL);
        put("UserDefinedLiteral", MetaNode.USER_DEFINED_LITERAL);
        put("MultiLineMacro", VOID_MAPPING);
        put("Directive", MetaNode.DIRECTIVE);
        put("Alignas", VOID_MAPPING);
        put("Alignof", MetaNode.OP_SIZEOF);
        put("Asm", VOID_MAPPING);
        put("Auto", MetaNode.TYPE_VAR);
        put("Bool", MetaNode.TYPE_BOOLEAN);
        put("Break", MetaNode.STATEMENT_BREAK);
        put("Case", MetaNode.STATEMENT_CASE);
        put("Catch", MetaNode.STATEMENT_CATCH);
        put("Char", MetaNode.TYPE_CHAR);
        put("Char16", MetaNode.TYPE_CHAR);
        put("Char32", MetaNode.TYPE_CHAR);
        put("Class", MetaNode.TYPE_CLASS);
        put("Const", MetaNode.MODIFIER_CONST);
        put("Constexpr", VOID_MAPPING);
        put("Const_cast", MetaNode.CAST);
        put("Continue", MetaNode.STATEMENT_CONTINUE);
        put("Decltype", MetaNode.TYPE_OF);
        put("Default", MetaNode.STATEMENT_DEFAULT);
        put("Delete", MetaNode.FREE);
        put("Do", MetaNode.STATEMENT_DO);
        put("Double", MetaNode.TYPE_DOUBLE);
        put("Dynamic_cast", MetaNode.CAST);
        put("Else", MetaNode.STATEMENT_ELSE);
        put("Enum", MetaNode.TYPE_ENUM);
        put("Explicit", VOID_MAPPING);
        put("Export", VOID_MAPPING);
        put("Extern", VOID_MAPPING);
        put("False_", MetaNode.BOOL_LITERAL);
        put("Final", MetaNode.MODIFIER_FINAL);
        put("Float", MetaNode.TYPE_FLOAT);
        put("For", MetaNode.STATEMENT_FOR);
        put("Friend", VOID_MAPPING);
        put("Goto", MetaNode.STATEMENT_GOTO);
        put("If", MetaNode.STATEMENT_IF);
        put("Inline", VOID_MAPPING);
        put("Int", MetaNode.TYPE_INT);
        put("Long", MetaNode.TYPE_LONG);
        put("Mutable", MetaNode.MODIFIER_MUTABLE);
        put("Namespace", VOID_MAPPING);
        put("New", MetaNode.EXPR_NEW);
        put("Noexcept", VOID_MAPPING);
        put("Nullptr", MetaNode.NULL_LITERAL);
        put("Operator", VOID_MAPPING);
        put("Override", MetaNode.MODIFIER_OVERRIDE);
        put("Private", MetaNode.MODIFIER_PRIVATE);
        put("Protected", MetaNode.MODIFIER_PROTECTED);
        put("Public", MetaNode.MODIFIER_PUBLIC);
        put("Register", VOID_MAPPING);
        put("Reinterpret_cast", MetaNode.CAST);
        put("Return", MetaNode.STATEMENT_RETURN);
        put("Short", MetaNode.TYPE_SHORT);
        put("Signed", MetaNode.TYPE_SIGNED);
        put("Sizeof", MetaNode.OP_SIZEOF);
        put("Static", MetaNode.MODIFIER_STATIC);
        put("Static_assert", MetaNode.STATEMENT_ASSERT);
        put("Static_cast", MetaNode.CAST);
        put("Struct", MetaNode.TYPE_STRUCT);
        put("Switch", MetaNode.STATEMENT_SWITCH);
        put("Template", VOID_MAPPING);
        put("This", MetaNode.EXPR_THIS);
        put("Thread_local", VOID_MAPPING);
        put("Throw", MetaNode.STATEMENT_THROW);
        put("True_", MetaNode.BOOL_LITERAL);
        put("Try", MetaNode.STATEMENT_TRY);
        put("Typedef", MetaNode.TYPEDEF);
        put("Typeid_", MetaNode.TYPE_OF);
        put("Typename_", VOID_MAPPING);
        put("Union", VOID_MAPPING);
        put("Unsigned", MetaNode.TYPE_UNSIGNED);
        put("Using", VOID_MAPPING);
        put("Virtual", MetaNode.MODIFIER_ABSTRACT);
        put("Void", MetaNode.TYPE_VOID);
        put("Volatile", VOID_MAPPING);
        put("Wchar", MetaNode.TYPE_CHAR);
        put("While", MetaNode.STATEMENT_WHILE);
        put("LeftParen", VOID_MAPPING);
        put("RightParen", VOID_MAPPING);
        put("LeftBracket", MetaNode.L_SQUARE);
        put("RightBracket", MetaNode.R_SQUARE);
        put("LeftBrace", VOID_MAPPING);
        put("RightBrace", VOID_MAPPING);
        put("Plus", MetaNode.OP_ADD);
        put("Minus", MetaNode.OP_SUB);
        put("Star", MetaNode.OP_MUL);
        put("Div", MetaNode.OP_DIV);
        put("Mod", MetaNode.OP_MOD);
        put("Caret", MetaNode.OP_XOR);
        put("And", MetaNode.OP_BITAND);
        put("Or", MetaNode.OP_BITOR);
        put("Tilde", MetaNode.OP_BITNOT);
        put("Not", MetaNode.OP_NOT);
        put("Assign", MetaNode.OP_ASSIGN);
        put("Less", MetaNode.OP_LT);
        put("Greater", MetaNode.OP_GT);
        put("PlusAssign", MetaNode.OP_ADD_ASSIGN);
        put("MinusAssign", MetaNode.OP_SUB_ASSIGN);
        put("StarAssign", MetaNode.OP_MUL_ASSIGN);
        put("DivAssign", MetaNode.OP_DIV_ASSIGN);
        put("ModAssign", MetaNode.OP_MOD_ASSIGN);
        put("XorAssign", MetaNode.OP_XOR_ASSIGN);
        put("AndAssign", MetaNode.OP_AND_ASSIGN);
        put("OrAssign", MetaNode.OP_OR_ASSIGN);
        put("LeftShiftAssign", MetaNode.OP_LSHIFT_ASSIGN);
        put("RightShiftAssign", MetaNode.OP_RSHIFT_ASSIGN);
        put("Equal", MetaNode.OP_EQUAL);
        put("NotEqual", MetaNode.OP_NOTEQUAL);
        put("LessEqual", MetaNode.OP_LE);
        put("GreaterEqual", MetaNode.OP_GE);
        put("AndAnd", MetaNode.OP_AND);
        put("OrOr", MetaNode.OP_OR);
        put("PlusPlus", MetaNode.OP_INC);
        put("MinusMinus", MetaNode.OP_DEC);
        put("Comma", VOID_MAPPING);
        put("ArrowStar", MetaNode.OP_DEREF_ACCESS);
        put("Arrow", MetaNode.OP_DEREF_ACCESS);
        put("Question", MetaNode.OP_TERNARY);
        put("Colon", VOID_MAPPING);
        put("Doublecolon", MetaNode.OP_METHOD_REFERENCE);
        put("Semi", VOID_MAPPING);
        put("Dot", MetaNode.DOT);
        put("DotStar", VOID_MAPPING);
        put("Ellipsis", MetaNode.MODIFIER_VARARGS);
        put("Identifier", MetaNode.IDENTIFIER);
        put("DecimalLiteral", MetaNode.DECIMAL_LITERAL);
        put("OctalLiteral", MetaNode.OCT_LITERAL);
        put("HexadecimalLiteral", MetaNode.HEX_LITERAL);
        put("BinaryLiteral", MetaNode.BINARY_LITERAL);
        put("Integersuffix", VOID_MAPPING);
        put("UserDefinedIntegerLiteral", MetaNode.DECIMAL_LITERAL);
        put("UserDefinedFloatingLiteral", MetaNode.FLOAT_LITERAL);
        put("UserDefinedStringLiteral", MetaNode.STRING_LITERAL);
        put("UserDefinedCharacterLiteral", MetaNode.CHAR_LITERAL);
        put("Whitespace", VOID_MAPPING);
        put("Newline", VOID_MAPPING);
        put("BlockComment", VOID_MAPPING);
        put("LineComment", VOID_MAPPING);
        put("EOF", VOID_MAPPING);
    }});

    private CppLanguageMapper(final Map<String, MetaNode> mappings) {
        super(mappings);
    }
}
