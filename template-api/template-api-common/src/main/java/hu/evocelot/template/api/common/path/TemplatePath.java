package hu.evocelot.template.api.common.path;

import jakarta.enterprise.context.ApplicationScoped;

import hu.icellmobilsoft.coffee.dto.url.BaseServicePath;

/**
 * Class for storing the paths.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@ApplicationScoped
public class TemplatePath extends BaseServicePath {

    /**
     * The {@value } path.
     */
    public static final String BASE_PATH = "/template-service";

    /**
     * The {@value } path.
     */
    public static final String TEMPLATE_DATA_MANAGEMENT = BASE_PATH + "/template-data";

    /**
     * The {@value } path.
     */
    public static final String TEMPLATE_PARAMETER_MANAGEMENT = BASE_PATH + "/template-parameter";

    /**
     * The {@value } param.
     */
    public static final String PARAM_TEMPLATE_KEY = "template-key";

    /**
     * The {@value } sub-path.
     */
    public static final String TEMPLATE_KEY = "/{" + PARAM_TEMPLATE_KEY + "}";

    /**
     * The {@value } sub-path.
     */
    public static final String RENDER = "/render";

    /**
     * The {@value } sub-path.
     */
    public static final String TEXT = "/text";

    /**
     * The {@value } sub-path.
     */
    public static final String HTML = "/html";
}
