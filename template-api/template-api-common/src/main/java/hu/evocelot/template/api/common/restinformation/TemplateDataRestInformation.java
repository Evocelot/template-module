package hu.evocelot.template.api.common.restinformation;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Class for defining the rest information.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@ApplicationScoped
public class TemplateDataRestInformation {
    /**
     * {@value }
     */
    public static final String TAG = "Template data management";

    /**
     * {@value }
     */
    public static final String DESCRIPTION = "Template data management for handling the template data operations.";

    /**
     * {@value }
     */
    public static final String TEMPLATE_DATA_ID_PARAM_DESCRIPTION = "The unique identifier of the template data.";

    /**
     * {@value }
     */
    public static final String TEMPLATE_KEY_PARAM_DESCRIPTION = "The key of the template data.";

    /**
     * {@value }
     */
    public static final String CREATE_TEMPLATE_DATA_SUMMARY = "Create template data";

    /**
     * {@value }
     */
    public static final String CREATE_TEMPLATE_DATA_DESCRIPTION = "Endpoint for creating new template data.";

    /**
     * {@value }
     */
    public static final String GET_TEMPLATE_DATA_SUMMARY = "Get template data";

    /**
     * {@value }
     */
    public static final String GET_TEMPLATE_DATA_DESCRIPTION = "Endpoint for getting the details of the template data.";

    /**
     * {@value }
     */
    public static final String UPDATE_TEMPLATE_DATA_SUMMARY = "Update template data";

    /**
     * {@value }
     */
    public static final String UPDATE_TEMPLATE_DATA_DESCRIPTION = "Endpoint for updating the details of the template data.";

    /**
     * {@value }
     */
    public static final String DELETE_TEMPLATE_DATA_SUMMARY = "Delete template data";

    /**
     * {@value }
     */
    public static final String DELETE_TEMPLATE_DATA_DESCRIPTION = "Endpoint for deleting the template data.";

    /**
     * {@value }
     */
    public static final String RENDER_TEMPLATE_SUMMARY = "Render template data (text)";

    /**
     * {@value }
     */
    public static final String RENDER_TEMPLATE_DESCRIPTION = "Endpoint for rendering the text based template based on the parameters.";
}
