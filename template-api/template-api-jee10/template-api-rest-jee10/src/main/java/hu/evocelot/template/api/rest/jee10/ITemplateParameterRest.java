package hu.evocelot.template.api.rest.jee10;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import hu.evocelot.template.api.common.path.TemplatePath;
import hu.evocelot.template.api.common.restinformation.TemplateParameterRestInformation;
import hu.evocelot.template.api.templateparameter._1_0.rest.templateparameter.TemplateParameterRequest;
import hu.evocelot.template.api.templateparameter._1_0.rest.templateparameter.TemplateParameterResponse;
import hu.evocelot.template.dto.constant.XsdConstants;
import hu.icellmobilsoft.coffee.cdi.annotation.xml.ValidateXML;
import hu.icellmobilsoft.coffee.dto.common.commonservice.BaseResponse;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Rest interface for template parameter entity management.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Tag(name = TemplateParameterRestInformation.TAG, description = TemplateParameterRestInformation.DESCRIPTION)
@Path(TemplatePath.TEMPLATE_PARAMETER_MANAGEMENT)
public interface ITemplateParameterRest {

    /**
     * HTTP POST method for creating template parameter for the template data.
     *
     * @param createTemplateParameterRequest
     *         - the request that contains the details of the template parameter.
     * @return - with {@link TemplateParameterResponse} that contains the details of the created parameter.
     * @throws BaseException
     *         - when an error occurs.
     */
    @POST
    @Operation(summary = TemplateParameterRestInformation.CREATE_TEMPLATE_PARAMETER_SUMMARY,
            description = TemplateParameterRestInformation.CREATE_TEMPLATE_PARAMETER_DESCRIPTION)
    @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    @Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    TemplateParameterResponse createTemplateParameter(
            @ValidateXML(xsdPath = XsdConstants.SUPER_XSD_PATH) TemplateParameterRequest createTemplateParameterRequest) throws BaseException;

    /**
     * HTTP GET method for getting the template parameter.
     *
     * @param templateParameterId
     *         - the id of the template parameter to get.
     * @return - with {@link TemplateParameterResponse} that contains the details of the template parameter.
     * @throws BaseException
     *         - when an error occurs.
     */
    @GET
    @Operation(summary = TemplateParameterRestInformation.GET_TEMPLATE_PARAMETER_SUMMARY,
            description = TemplateParameterRestInformation.GET_TEMPLATE_PARAMETER_DESCRIPTION)
    @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    @Path(TemplatePath.ID)
    TemplateParameterResponse getTemplateParameter(
            @Parameter(description = TemplateParameterRestInformation.TEMPLATE_PARAMETER_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateParameterId) throws BaseException;

    /**
     * HTTP POST method for updating the details of the template parameter.
     *
     * @param templateParameterId
     *         - the id of the template parameter to update.
     * @param updateTemplateParameterRequest
     *         - the request that contains the details of the updated data.
     * @return - with {@link TemplateParameterResponse} that contains the updated details.
     * @throws BaseException
     *         - when an error occurs.
     */
    @POST
    @Operation(summary = TemplateParameterRestInformation.UPDATE_TEMPLATE_PARAMETER_SUMMARY,
            description = TemplateParameterRestInformation.UPDATE_TEMPLATE_PARAMETER_DESCRIPTION)
    @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    @Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    @Path(TemplatePath.ID)
    TemplateParameterResponse updateTemplateParameter(
            @Parameter(description = TemplateParameterRestInformation.TEMPLATE_PARAMETER_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateParameterId,
            @ValidateXML(xsdPath = XsdConstants.SUPER_XSD_PATH) TemplateParameterRequest updateTemplateParameterRequest) throws BaseException;

    /**
     * HTTP DELETE method for deleting the template parameter.
     *
     * @param templateParameterId
     *         - the id of the template parameter to delete.
     * @return - with {@link BaseResponse}.
     * @throws BaseException
     *         - when an error occurs.
     */
    @DELETE
    @Operation(summary = TemplateParameterRestInformation.DELETE_TEMPLATE_PARAMETER_SUMMARY,
            description = TemplateParameterRestInformation.DELETE_TEMPLATE_PARAMETER_DESCRIPTION)
    @Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML })
    @Path(TemplatePath.ID)
    BaseResponse deleteTemplateParameter(
            @Parameter(description = TemplateParameterRestInformation.TEMPLATE_PARAMETER_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateParameterId) throws BaseException;
}
