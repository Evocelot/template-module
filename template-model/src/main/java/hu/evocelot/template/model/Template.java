package hu.evocelot.template.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import hu.icellmobilsoft.coffee.model.base.javatime.AbstractIdentifiedAuditEntity;

/**
 * The Template entity.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Entity
@Table(name = "template")
public class Template extends AbstractIdentifiedAuditEntity {

    @Column(name = "template_name", nullable = false, length = 100, unique = true)
    @Size(max = 100)
    @NotNull
    private String templateName;

    @Column(name = "subject", nullable = false, length = 150)
    @Size(max = 150)
    @NotNull
    private String subject;

    @Column(name = "content", nullable = false)
    @NotNull
    private String content;

    @Column(name = "valid_from", nullable = false)
    @NotNull
    private OffsetDateTime validFrom;

    @Column(name = "valid_to")
    private OffsetDateTime validTo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public @Size(max = 100) String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(@Size(max = 100) String templateName) {
        this.templateName = templateName;
    }

    public @Size(max = 150) String getSubject() {
        return subject;
    }

    public void setSubject(@Size(max = 150) String subject) {
        this.subject = subject;
    }

    public OffsetDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(OffsetDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public OffsetDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(OffsetDateTime validTo) {
        this.validTo = validTo;
    }
}
