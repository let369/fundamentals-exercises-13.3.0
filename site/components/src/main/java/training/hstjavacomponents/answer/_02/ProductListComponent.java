package training.hstjavacomponents.answer._02;
/*
 * Copyright 2015-2019 BloomReach B.V. (http://www.bloomreach.com)
 * Usage is prohibited except for people attending a training given or authorised by BloomReach B.V., and only for that purpose.
 */

import java.util.List;

import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.exceptions.FilterException;
import org.hippoecm.hst.content.beans.query.filter.BaseFilter;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.onehippo.cms7.essentials.components.EssentialsListComponent;
import org.onehippo.cms7.essentials.components.info.EssentialsListComponentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = EssentialsListComponentInfo.class)
public class ProductListComponent extends EssentialsListComponent {

    private static Logger log = LoggerFactory.getLogger(ProductListComponent.class);

    @Override
    protected void contributeAndFilters(final List<BaseFilter> filters, final HstRequest request, final HstQuery query) {
        try {
            Filter filter = query.createFilter();
            filter.addGreaterThan("myproject:instock", 0);
            filters.add(filter);
        } catch (FilterException e) {
            log.error("An exception occurred while trying to create a query filter for instock greater than zero: {}", e);
        }
    }

}
