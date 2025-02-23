package org.leetvision.parser.meta.mapper;

import org.leetvision.parser.meta.MetaLanguage;

import java.util.HashMap;
import java.util.Map;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class JavaScriptLanguageMapper extends LanguageMapper {
    public static final JavaScriptLanguageMapper INSTANCE = new JavaScriptLanguageMapper(new HashMap<>() {{
        put("program", MetaNode.PROGRAM);
        put("sourceElement", MetaNode.STATEMENT);
        put("statement", MetaNode.STATEMENT);
        put("block", MetaNode.BLOCK);
        put("statementList", MetaNode.BLOCK);
        put("importStatement", VOID_MAPPING);
        put("importFromBlock", VOID_MAPPING);
        put("importModuleItems", VOID_MAPPING);
        put("importAliasName", VOID_MAPPING);
        put("moduleExportName", VOID_MAPPING);
        put("importedBinding", VOID_MAPPING);
        put("importDefault", VOID_MAPPING);
        put("importNamespace", VOID_MAPPING);
        put("importFrom", VOID_MAPPING);
        put("aliasName", VOID_MAPPING);
        put("exportStatement", MetaNode.STATEMENT);
        put("exportFromBlock", VOID_MAPPING);
        put("exportModuleItems", VOID_MAPPING);
        put("exportAliasName", VOID_MAPPING);
        put("declaration", MetaNode.VARIABLE_DECLARATORS); // hack
        put("variableStatement", MetaNode.VARIABLE_DECLARATORS);
        put("variableDeclarationList", MetaNode.VARIABLE_DECLARATORS);
        put("variableDeclaration", MetaNode.VARIABLE_DECLARATOR);
        put("emptyStatement_", VOID_MAPPING);
        put("expressionStatement", MetaNode.STATEMENT); // TODO
        put("ifStatement", MetaNode.STATEMENT);
        put("iterationStatement", MetaNode.STATEMENT);
        put("varModifier", MetaNode.VARIABLE_MODIFIER);
        put("continueStatement", MetaNode.STATEMENT);
        put("breakStatement", MetaNode.STATEMENT);
        put("returnStatement", MetaNode.STATEMENT);
        put("yieldStatement", MetaNode.STATEMENT);
        put("withStatement", MetaNode.STATEMENT);
        put("switchStatement", MetaNode.STATEMENT);
        put("caseBlock", MetaNode.SWITCH_BLOCK_STATEMENT_GROUP);
        put("caseClauses", MetaNode.BLOCK);
        put("caseClause", MetaNode.SWITCH_LABEL);
        put("defaultClause", MetaNode.SWITCH_LABEL);
        put("labelledStatement", MetaNode.STATEMENT);
        put("throwStatement", MetaNode.STATEMENT);
        put("tryStatement", MetaNode.STATEMENT);
        put("catchProduction", MetaNode.CATCH_CLAUSE);
        put("finallyProduction", MetaNode.FINALLY_BLOCK);
        put("debuggerStatement", VOID_MAPPING);
        put("functionDeclaration", MetaNode.METHOD_DECLARATION);
        put("classDeclaration", MetaNode.CLASS_DECLARATION);
        put("classTail", MetaNode.CLASS_DECLARATION);
        put("classElement", MetaNode.MEMBER_DECLARATION);
        put("methodDefinition", MetaNode.METHOD_DECLARATION);
        put("fieldDefinition", MetaNode.FIELD_DECLARATION);
        put("classElementName", MetaNode.IDENTIFIER);
        put("privateIdentifier", MetaNode.IDENTIFIER);
        put("formalParameterList", MetaNode.FORMAL_PARAMETERS);
        put("formalParameterArg", MetaNode.FORMAL_PARAMETER);
        put("lastFormalParameterArg", MetaNode.FORMAL_PARAMETER);
        put("functionBody", MetaNode.METHOD_BODY);
        put("sourceElements", MetaNode.BLOCK);
        put("arrayLiteral", MetaNode.ARRAY_CREATOR_REST);
        put("elementList", MetaNode.ARRAY_CREATOR_REST);
        put("arrayElement", MetaNode.EXPRESSION);
        put("propertyAssignment", MetaNode.VARIABLE_DECLARATOR);
    }});

    private JavaScriptLanguageMapper(final Map<String, MetaLanguage.MetaNode> mappings) {
        super(mappings);
    }
}
