package hu.evocelot.template.sample.jpaservice.service;

import java.util.List;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import hu.evocelot.template.sample.jpaservice.repository.SampleEntityRepository;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;
import hu.evocelot.template.common.system.jpa.service.BaseService;
import hu.evocelot.template.dto.exception.enums.FaultType;
import hu.evocelot.template.model.sample.SampleEntity;
import hu.evocelot.template.model.sample.enums.SampleStatus;

/**
 * Service for {@link SampleEntity} querying.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Model
public class SampleEntityService extends BaseService<SampleEntity> {

    @Inject
    private SampleEntityRepository sampleEntityRepository;

    @Override
    protected Enum<?> getDefaultNotFoundFaultTypeEnum() {
        return FaultType.SAMPLE_NOT_FOUND;
    }

    /**
     * Queries the Sample entities with the specified status.
     *
     * @param status
     *         - the status.
     * @return - with the list of the entities.
     * @throws BaseException
     *         - when error occurs.
     */
    public List<SampleEntity> findAllByStatus(SampleStatus status) throws BaseException {
        return wrapListValidated(sampleEntityRepository::findAllByStatus, status, "findAllByStatus", "status");
    }
}
