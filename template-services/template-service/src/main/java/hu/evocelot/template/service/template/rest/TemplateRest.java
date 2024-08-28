package hu.evocelot.template.service.template.rest;

import jakarta.enterprise.context.ApplicationScoped;

import hu.evocelot.template.api.rest.jee10.ITemplateRest;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.CreateTemplateDataRequest;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateDataResponse;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateRenderRequest;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.TemplateRenderResponse;
import hu.evocelot.template.api.templatedata._1_0.rest.templatedata.UpdateTemplateDataRequest;
import hu.evocelot.template.common.system.rest.rest.BaseRestService;
import hu.icellmobilsoft.coffee.dto.common.commonservice.BaseResponse;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

@ApplicationScoped
public class TemplateRest extends BaseRestService implements ITemplateRest {
    @Override
    public TemplateDataResponse createTemplateData(CreateTemplateDataRequest createTemplateDataRequest) throws BaseException {
        return null;
    }

    @Override
    public TemplateDataResponse getTemplateData(String templateDataId) throws BaseException {
        return null;
    }

    @Override
    public TemplateDataResponse updateTemplateData(String templateDataId, UpdateTemplateDataRequest updateTemplateDataRequest) throws BaseException {
        return null;
    }

    @Override
    public BaseResponse deleteTemplateData(String templateDataId) throws BaseException {
        return null;
    }

    @Override
    public TemplateRenderResponse renderTemplate(String templateKey, TemplateRenderRequest templateRenderRequest) throws BaseException {
        return null;
    }
}
