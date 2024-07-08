package hu.evocelot.template.api.common.restinformation;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Class for defining the rest information.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@ApplicationScoped
public class TemplateParameterRestInformation {

    /**
     * {@value }
     */
    public static final String TAG = "Template parameter management";

    /**
     * {@value }
     */
    public static final String DESCRIPTION = "Template parameter management for handling the template parameter operations.";

    /**
     * {@value }
     */
    public static final String TEMPLATE_PARAMETER_ID_PARAM_DESCRIPTION = "The unique identifier of the template parameter.";

    /**
     * {@value }
     */
    public static final String TEMPLATE_PARAMETER_KEY_PARAM_DESCRIPTION = "The key of the template parameter.";

    /**
     * {@value }
     */
    public static final String CREATE_TEMPLATE_PARAMETER_SUMMARY = "Create template parameter";

    /**
     * {@value }
     */
    public static final String CREATE_TEMPLATE_PARAMETER_DESCRIPTION = "Endpoint for creating new template parameter.";

    /**
     * {@value }
     */
    public static final String GET_TEMPLATE_PARAMETER_SUMMARY = "Get template parameter";

    /**
     * {@value }
     */
    public static final String GET_TEMPLATE_PARAMETER_DESCRIPTION = "Endpoint for getting the details of the template parameter.";

    /**
     * {@value }
     */
    public static final String UPDATE_TEMPLATE_PARAMETER_SUMMARY = "Update template parameter";

    /**
     * {@value }
     */
    public static final String UPDATE_TEMPLATE_PARAMETER_DESCRIPTION = "Endpoint for updating the details of the template parameter.";

    /**
     * {@value }
     */
    public static final String DELETE_TEMPLATE_PARAMETER_SUMMARY = "Delete template parameter";

    /**
     * {@value }
     */
    public static final String DELETE_TEMPLATE_PARAMETER_DESCRIPTION = "Endpoint for deleting the template parameter.";
}
