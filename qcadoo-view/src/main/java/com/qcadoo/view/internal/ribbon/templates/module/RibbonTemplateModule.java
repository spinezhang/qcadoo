package com.qcadoo.view.internal.ribbon.templates.module;

import org.springframework.core.io.Resource;
import org.w3c.dom.Node;

import com.qcadoo.plugin.api.Module;
import com.qcadoo.view.internal.ribbon.templates.RibbonTemplatesService;
import com.qcadoo.view.internal.ribbon.templates.model.RibbonTemplate;
import com.qcadoo.view.internal.ribbon.templates.model.TemplateRibbonGroup;
import com.qcadoo.view.internal.xml.ViewDefinitionParser;
import com.qcadoo.view.internal.xml.ViewDefinitionParserException;
import com.qcadoo.view.internal.xml.ViewDefinitionParserNodeException;

public class RibbonTemplateModule extends Module {

    final RibbonTemplate template;

    final RibbonTemplatesService ribbonTemplatesService;

    public RibbonTemplateModule(final String pluginIdentifier, final Resource xmlFile, final ViewDefinitionParser parser,
            final RibbonTemplatesService ribbonTemplatesService) {
        this.ribbonTemplatesService = ribbonTemplatesService;

        String fileName = xmlFile.getFilename();
        try {

            Node root = parser.getRootOfXmlDocument(xmlFile);
            parser.checkState("ribbonTemplate".equals(root.getNodeName()), root, "Wrong root node name '" + root.getNodeName()
                    + "'");

            String templateName = parser.getStringAttribute(root, "name");
            parser.checkState(templateName != null, root, "Ribbon template error: name not defined");

            template = new RibbonTemplate(pluginIdentifier, templateName);

            for (Node groupNode : parser.geElementChildren(root)) {
                String groupName = parser.getStringAttribute(groupNode, "name");
                parser.checkState(groupName != null, groupNode, "Ribbon template error: group name not defined");
                TemplateRibbonGroup templateGroup = new TemplateRibbonGroup(groupName);

                for (Node itemNode : parser.geElementChildren(groupNode)) {
                    templateGroup.addActionItem(parser.parseRibbonItem(itemNode, null));
                }

                template.addTemplateGroup(templateGroup);
            }

        } catch (ViewDefinitionParserNodeException e) {
            throw ViewDefinitionParserException.forFileAndNode(fileName, e);
        } catch (Exception e) {
            throw ViewDefinitionParserException.forFile(fileName, e);
        }
    }

    @Override
    public void enableOnStartup() {
        enable();
    }

    @Override
    public void enable() {
        ribbonTemplatesService.addRibbonTemplate(template);
    }

    @Override
    public void disable() {
        ribbonTemplatesService.removeRibbonTemplate(template);
    }
}
