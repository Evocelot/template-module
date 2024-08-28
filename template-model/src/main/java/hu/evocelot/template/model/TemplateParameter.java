package hu.evocelot.template.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import hu.icellmobilsoft.coffee.model.base.javatime.AbstractIdentifiedAuditEntity;

/**
 * The Template parameter entity.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Entity
@Table(name = "template")
public class TemplateParameter extends AbstractIdentifiedAuditEntity {

    @Column(name = "template_name", length = 100, nullable = false)
    @Size(max = 100)
    @NotNull
    private String templateName;

    @Column(name = "pattern", length = 128, nullable = false)
    @Size(max = 128)
    @NotNull
    private String pattern;

    @Column(name = "default_value", length = 255)
    @Size(max = 255)
    private String defaultValue;

    public @Size(max = 100) String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(@Size(max = 100) String templateName) {
        this.templateName = templateName;
    }

    public @Size(max = 128) String getPattern() {
        return pattern;
    }

    public void setPattern(@Size(max = 128) String pattern) {
        this.pattern = pattern;
    }

    public @Size(max = 255) String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(@Size(max = 255) String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
