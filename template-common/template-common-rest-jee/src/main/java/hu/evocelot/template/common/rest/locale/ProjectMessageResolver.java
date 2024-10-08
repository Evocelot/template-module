package hu.evocelot.template.common.rest.locale;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.interceptor.Interceptor;

import org.apache.deltaspike.core.api.message.MessageContext;
import org.apache.deltaspike.core.impl.message.DefaultMessageResolver;
import org.apache.deltaspike.core.util.message.ClassUtils;

/**
 * {@code MessageResolver} for resolving localized messages with custom fallback locale logic.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Dependent
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 10)
public class ProjectMessageResolver extends DefaultMessageResolver {

    /**
     * Default bundle controller.
     */
    private final ResourceBundleControl resourceBundleControl = new ResourceBundleControl();

    @Override
    public String getMessage(MessageContext messageContext, String messageTemplate, String category) {
        // we can use {{ as escaping for now
        if (messageTemplate.startsWith("{{")) {
            // in which case we just cut of the first '{'
            return messageTemplate.substring(1);
        }

        if (messageTemplate.startsWith("{") && messageTemplate.endsWith("}")) {
            String resourceKey = messageTemplate.substring(1, messageTemplate.length() - 1);

            List<String> messageSources = getMessageSources(messageContext);

            if (messageSources == null || messageSources.isEmpty()) {
                // using {} without a bundle is always an error
                return null;
            }

            // NOTE: Deltaspike does not handle concurrent message reading; a copy list is required to avoid ConcurrentModificationException
            // In case of high load, it may occur if multiple fault types are generated within one service instance
            List<String> copy = new ArrayList<>(messageSources);
            Iterator<String> messageSourceIterator = copy.iterator();

            Locale locale = messageContext.getLocale();

            String currentMessageSource;
            while (messageSourceIterator.hasNext()) {
                currentMessageSource = messageSourceIterator.next();

                try {
                    // this is the line we want to override from the DefaultMessageResolver
                    ResourceBundle messageBundle = getResourceBundle(locale, currentMessageSource);

                    if (category != null && category.length() > 0) {
                        try {
                            return messageBundle.getString(resourceKey + "_" + category);
                        } catch (MissingResourceException e) {
                            // we fallback on the version without the category
                            return messageBundle.getString(resourceKey);
                        }
                    }

                    return messageBundle.getString(resourceKey);
                } catch (MissingResourceException e) {
                    if (!messageSourceIterator.hasNext()) {
                        return null;
                    }
                }
            }
        }

        return messageTemplate;
    }

    private ResourceBundle getResourceBundle(Locale locale, String currentMessageSource) {
        return ResourceBundle.getBundle(currentMessageSource, locale, ClassUtils.getClassLoader(null), resourceBundleControl);
    }

    private static class ResourceBundleControl extends ResourceBundle.Control {
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            return isDefault(locale) ? null : getDefaultLocale();
        }

        private boolean isDefault(Locale locale) {
            return locale.toString().equals(ProjectLocaleResolver.DEFAULT_LANGUAGE.toLowerCase());
        }

        private Locale getDefaultLocale() {
            return new Locale(ProjectLocaleResolver.DEFAULT_LANGUAGE);
        }
    }
}
