package org.leetvision.parser.meta.mapper;

import java.util.HashMap;
import java.util.Map;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class CLanguageMapper extends LanguageMapper {
    public static final CLanguageMapper INSTANCE = new CLanguageMapper(new HashMap<>() {{
        put("primaryExpression", MetaNode.EXPRESSION);
        put("genericSelection", MetaNode.METHOD_DECLARATION);
        put("genericAssocList", MetaNode.FORMAL_PARAMETERS);
        put("genericAssociation", MetaNode.FORMAL_PARAMETER);
        put("postfixExpression", MetaNode.EXPRESSION);
        put("argumentExpressionList", MetaNode.EXPRESSION_LIST);
        put("unaryExpression", MetaNode.EXPRESSION);
        put("unaryOperator", MetaNode.OP_ADD);  // hack
        put("castExpression", MetaNode.EXPRESSION);
        put("multiplicativeExpression", MetaNode.EXPRESSION);
        put("additiveExpression", MetaNode.EXPRESSION);
        put("shiftExpression", MetaNode.EXPRESSION);
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
        put("declaration", MetaNode.MEMBER_DECLARATION);  // hack
        put("declarationSpecifiers", MetaNode.CLASS_MODIFIER);  // hack
        put("declarationSpecifiers2", MetaNode.CLASS_MODIFIER);  // hack
        put("declarationSpecifier", MetaNode.CLASS_MODIFIER);
        put("initDeclaratorList", MetaNode.INITIALIZER_LIST);
        put("initDeclarator", MetaNode.INITIALIZER);
        put("storageClassSpecifier", VOID_MAPPING);
        put("typeSpecifier", MetaNode.TYPE);  // hack
        put("structOrUnionSpecifier", MetaNode.MEMBER_DECLARATION);
        put("structOrUnion", MetaNode.TYPE_STRUCT);
        put("structDeclarationList", MetaNode.MEMBER_DECLARATION_LIST);
        put("structDeclaration", MetaNode.MEMBER_DECLARATION_LIST);
        put("specifierQualifierList", MetaNode.MODIFIER_LIST);
        put("structDeclaratorList", MetaNode.VARIABLE_DECLARATORS);
        put("structDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("enumSpecifier", MetaNode.ENUM_DECLARATION);
        put("enumeratorList", MetaNode.ENUM_CONSTANTS);
        put("enumerator", MetaNode.ENUM_CONSTANT);
        put("enumerationConstant", MetaNode.ENUM_CONSTANT);
        put("atomicTypeSpecifier", MetaNode.TYPE);
        put("typeQualifier", MetaNode.MODIFIER_CONST);
        put("functionSpecifier", VOID_MAPPING);
        put("alignmentSpecifier", VOID_MAPPING);
        put("declarator", MetaNode.VARIABLE_DECLARATOR);
        put("directDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("vcSpecificModifer", VOID_MAPPING);
        put("gccDeclaratorExtension", VOID_MAPPING);
        put("gccAttributeSpecifier", VOID_MAPPING);
        put("gccAttributeList", VOID_MAPPING);
        put("gccAttribute", VOID_MAPPING);
        put("nestedParenthesesBlock", VOID_MAPPING);
        put("pointer", MetaNode.OP_POINTER_DEREF);
        put("typeQualifierList", MetaNode.MODIFIER_LIST);
        put("parameterTypeList", MetaNode.FORMAL_PARAMETERS);
        put("parameterList", MetaNode.FORMAL_PARAMETERS);
        put("parameterDeclaration", MetaNode.FORMAL_PARAMETER);
        put("identifierList", MetaNode.EXPRESSION_LIST);
        put("typeName", MetaNode.TYPE);
        put("abstractDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("directAbstractDeclarator", MetaNode.VARIABLE_DECLARATOR);
        put("typedefName", MetaNode.IDENTIFIER);
        put("initializer", MetaNode.INITIALIZER);
        put("initializerList", MetaNode.INITIALIZER_LIST);
        put("designation", MetaNode.EXPRESSION);
        put("designatorList", MetaNode.EXPRESSION_LIST);
        put("designator", MetaNode.EXPRESSION);
        put("staticAssertDeclaration", MetaNode.STATEMENT_ASSERT);
        put("statement", MetaNode.STATEMENT);
        put("labeledStatement", MetaNode.STATEMENT);
        put("compoundStatement", MetaNode.BLOCK);
        put("blockItemList", MetaNode.BLOCK);
        put("blockItem", MetaNode.STATEMENT);
        put("expressionStatement", MetaNode.STATEMENT);
        put("selectionStatement", MetaNode.STATEMENT);
        put("iterationStatement", MetaNode.STATEMENT);
        put("forCondition", MetaNode.FOR_CONTROL);
        put("forDeclaration", MetaNode.LOCAL_VARIABLE_DECLARATION);
        put("forExpression", MetaNode.EXPRESSION);
        put("jumpStatement", MetaNode.STATEMENT);
        put("compilationUnit", MetaNode.PROGRAM);
        put("translationUnit", MetaNode.PROGRAM);
        put("externalDeclaration", MetaNode.METHOD_DECLARATION);
        put("functionDefinition", MetaNode.METHOD_DECLARATION);
        put("declarationList", MetaNode.DECLARATION_LIST);

        put("null", MetaNode.NULL_LITERAL);
        put("Auto", MetaNode.TYPE_VAR);
        put("Break", MetaNode.STATEMENT_BREAK);
        put("Case", MetaNode.STATEMENT_CASE);
        put("Char", MetaNode.TYPE_CHAR);
        put("Const", MetaNode.MODIFIER_CONST);
        put("Continue", MetaNode.STATEMENT_CONTINUE);
        put("Default", MetaNode.STATEMENT_DEFAULT);
        put("Do", MetaNode.STATEMENT_DO);
        put("Double", MetaNode.TYPE_DOUBLE);
        put("Else", MetaNode.STATEMENT_ELSE);
        put("Enum", MetaNode.TYPE_ENUM);
        put("Extern", VOID_MAPPING);
        put("Float", MetaNode.TYPE_FLOAT);
        put("For", MetaNode.STATEMENT_FOR);
        put("Goto", MetaNode.STATEMENT_GOTO);
        put("If", MetaNode.STATEMENT_IF);
        put("Inline", VOID_MAPPING);
        put("Int", MetaNode.TYPE_INT);
        put("Long", MetaNode.TYPE_LONG);
        put("Register", VOID_MAPPING);
        put("Restrict", VOID_MAPPING);
        put("Return", MetaNode.STATEMENT_RETURN);
        put("Short", MetaNode.TYPE_SHORT);
        put("Signed", MetaNode.TYPE_SIGNED);
        put("Sizeof", MetaNode.OP_SIZEOF);
        put("Static", MetaNode.MODIFIER_STATIC);
        put("Struct", MetaNode.TYPE_STRUCT);
        put("Switch", MetaNode.STATEMENT_SWITCH);
        put("Typedef", MetaNode.TYPEDEF);
        put("Union", VOID_MAPPING);
        put("Unsigned", MetaNode.TYPE_UNSIGNED);
        put("Void", MetaNode.TYPE_VOID);
        put("Volatile", VOID_MAPPING);
        put("While", MetaNode.STATEMENT_WHILE);
        put("Alignas", VOID_MAPPING);
        put("Alignof", VOID_MAPPING);
        put("Atomic", VOID_MAPPING);
        put("Bool", MetaNode.TYPE_BOOLEAN);
        put("Complex", VOID_MAPPING);
        put("Generic", VOID_MAPPING);
        put("Imaginary", VOID_MAPPING);
        put("Noreturn", VOID_MAPPING);
        put("StaticAssert", MetaNode.STATEMENT_ASSERT);
        put("ThreadLocal", VOID_MAPPING);
        put("LeftParen", VOID_MAPPING);
        put("RightParen", VOID_MAPPING);
        put("LeftBracket", MetaNode.L_SQUARE);
        put("RightBracket", MetaNode.R_SQUARE);
        put("LeftBrace", VOID_MAPPING);
        put("RightBrace", VOID_MAPPING);
        put("Less", MetaNode.OP_LT);
        put("LessEqual", MetaNode.OP_LE);
        put("Greater", MetaNode.OP_GT);
        put("GreaterEqual", MetaNode.OP_GE);
        put("LeftShift", MetaNode.OP_LSHIFT);
        put("RightShift", MetaNode.OP_RSHIFT);
        put("Plus", MetaNode.OP_ADD);
        put("PlusPlus", MetaNode.OP_INC);
        put("Minus", MetaNode.OP_SUB);
        put("MinusMinus", MetaNode.OP_DEC);
        put("Star", MetaNode.OP_MUL);
        put("Div", MetaNode.OP_DIV);
        put("Mod", MetaNode.OP_MOD);
        put("And", MetaNode.OP_BITAND);
        put("Or", MetaNode.OP_BITOR);
        put("AndAnd", MetaNode.OP_AND);
        put("OrOr", MetaNode.OP_OR);
        put("Caret", MetaNode.OP_XOR);
        put("Not", MetaNode.OP_NOT);
        put("Tilde", MetaNode.OP_BITNOT);
        put("Question", MetaNode.OP_TERNARY);
        put("Colon", VOID_MAPPING);
        put("Semi", VOID_MAPPING);
        put("Comma", VOID_MAPPING);
        put("Assign", MetaNode.OP_ASSIGN);
        put("StarAssign", MetaNode.OP_MUL_ASSIGN);
        put("DivAssign", MetaNode.OP_DIV_ASSIGN);
        put("ModAssign", MetaNode.OP_MOD_ASSIGN);
        put("PlusAssign", MetaNode.OP_ADD_ASSIGN);
        put("MinusAssign", MetaNode.OP_SUB_ASSIGN);
        put("LeftShiftAssign", MetaNode.OP_LSHIFT_ASSIGN);
        put("RightShiftAssign", MetaNode.OP_RSHIFT_ASSIGN);
        put("AndAssign", MetaNode.OP_AND_ASSIGN);
        put("XorAssign", MetaNode.OP_XOR_ASSIGN);
        put("OrAssign", MetaNode.OP_OR_ASSIGN);
        put("Equal", MetaNode.OP_EQUAL);
        put("NotEqual", MetaNode.OP_NOTEQUAL);
        put("Arrow", MetaNode.OP_DEREF_ACCESS);
        put("Dot", MetaNode.DOT);
        put("Ellipsis", MetaNode.MODIFIER_VARARGS);
        put("Identifier", MetaNode.IDENTIFIER);
        put("Constant", MetaNode.DECIMAL_LITERAL);
        put("DigitSequence", MetaNode.DECIMAL_LITERAL);
        put("StringLiteral", MetaNode.STRING_LITERAL);
        put("MultiLineMacro", VOID_MAPPING);
        put("Directive", MetaNode.DIRECTIVE);
        put("AsmBlock", VOID_MAPPING);
        put("Whitespace", VOID_MAPPING);
        put("Newline", VOID_MAPPING);
        put("BlockComment", VOID_MAPPING);
        put("LineComment", VOID_MAPPING);
        put("EOF", VOID_MAPPING);
    }});

    private CLanguageMapper(final Map<String, MetaNode> mappings) {
        super(mappings);
    }
}
