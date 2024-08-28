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
import hu.evocelot.template.api.common.restinformation.TemplateDataRestInformation;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.CreateTemplateDataRequest;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateDataResponse;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateRenderRequest;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateRenderResponse;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.UpdateTemplateDataRequest;
import hu.evocelot.template.dto.constant.XsdConstants;
import hu.icellmobilsoft.coffee.cdi.annotation.xml.ValidateXML;
import hu.icellmobilsoft.coffee.dto.common.commonservice.BaseResponse;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Rest interface for template entity management.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Tag(name = TemplateDataRestInformation.TAG, description = TemplateDataRestInformation.DESCRIPTION)
@Path(TemplatePath.TEMPLATE_DATA_MANAGEMENT)
public interface ITemplateRest {

    /**
     * HTTP POST method for creating new template-data.
     *
     * @param createTemplateDataRequest - the request that contains information about the template to create.
     * @return - with {@link TemplateDataResponse} that contains the details of the created template.
     * @throws BaseException - when an error occurs.
     */
    @POST
    @Operation(summary = TemplateDataRestInformation.CREATE_TEMPLATE_DATA_SUMMARY,
            description = TemplateDataRestInformation.CREATE_TEMPLATE_DATA_DESCRIPTION)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    TemplateDataResponse createTemplateData(@ValidateXML(xsdPath = XsdConstants.SUPER_XSD_PATH) CreateTemplateDataRequest createTemplateDataRequest)
            throws BaseException;

    /**
     * HTTP GET method for getting the template data based on the id.
     *
     * @param templateDataId - the id of the template data entity.
     * @return - with {@link TemplateDataResponse} that contains the details of the template data.
     * @throws BaseException - when an error occurs.
     */
    @GET
    @Operation(summary = TemplateDataRestInformation.GET_TEMPLATE_DATA_SUMMARY,
            description = TemplateDataRestInformation.GET_TEMPLATE_DATA_DESCRIPTION)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Path(TemplatePath.ID)
    TemplateDataResponse getTemplateData(
            @Parameter(description = TemplateDataRestInformation.TEMPLATE_DATA_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateDataId) throws BaseException;

    /**
     * HTTP POST method for updating the details of the template data.
     *
     * @param templateDataId            - the id of the template data to update.
     * @param updateTemplateDataRequest - the request that contains the details of the updated template data.
     * @return - with {@link TemplateDataResponse} that contains the details of the updated template data.
     * @throws BaseException - when an error occurs.
     */
    @POST
    @Operation(summary = TemplateDataRestInformation.UPDATE_TEMPLATE_DATA_SUMMARY,
            description = TemplateDataRestInformation.UPDATE_TEMPLATE_DATA_DESCRIPTION)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Path(TemplatePath.ID)
    TemplateDataResponse updateTemplateData(
            @Parameter(description = TemplateDataRestInformation.TEMPLATE_DATA_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateDataId,
            @ValidateXML(xsdPath = XsdConstants.SUPER_XSD_PATH) UpdateTemplateDataRequest updateTemplateDataRequest) throws BaseException;

    /**
     * HTTP DELETE method for deleting template data.
     *
     * @param templateDataId - the id of the template data to delete.
     * @return - with {@link BaseResponse}.
     * @throws BaseException - when an error occurs.
     */
    @DELETE
    @Operation(summary = TemplateDataRestInformation.DELETE_TEMPLATE_DATA_SUMMARY,
            description = TemplateDataRestInformation.DELETE_TEMPLATE_DATA_DESCRIPTION)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Path(TemplatePath.ID)
    BaseResponse deleteTemplateData(
            @Parameter(description = TemplateDataRestInformation.TEMPLATE_DATA_ID_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_ID) String templateDataId) throws BaseException;

    /**
     * HTTP POST method for rendering the template with parameters.
     *
     * @param templateKey           - the key of the template to render.
     * @param templateRenderRequest - the request that contains the details of the render.
     * @return - with {@link TemplateRenderResponse} that contains the rendered data.
     * @throws BaseException - when an error occurs.
     */
    @POST
    @Operation(summary = TemplateDataRestInformation.RENDER_TEMPLATE_SUMMARY, description = TemplateDataRestInformation.RENDER_TEMPLATE_DESCRIPTION)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    @Path(TemplatePath.TEMPLATE_KEY + TemplatePath.RENDER + TemplatePath.TEXT)
    TemplateRenderResponse renderTemplate(
            @Parameter(description = TemplateDataRestInformation.TEMPLATE_KEY_PARAM_DESCRIPTION, required = true) @PathParam(
                    TemplatePath.PARAM_TEMPLATE_KEY) String templateKey,
            @ValidateXML(xsdPath = XsdConstants.SUPER_XSD_PATH) TemplateRenderRequest templateRenderRequest) throws BaseException;
}
