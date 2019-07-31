package training.hstjavacomponents.answer._03;
/*
 * Copyright 2014-2019 BloomReach B.V. (http://www.bloomreach.com)
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParametersInfo(type = ProductListComponentInfo.class)
public class ProductListComponent extends EssentialsListComponent {

    private static Logger log = LoggerFactory.getLogger(ProductListComponent.class);

    @Override
    protected void contributeAndFilters(final List<BaseFilter> filters, final HstRequest request, final HstQuery query) {
        final ProductListComponentInfo paramInfo = getComponentParametersInfo(request);
        if (paramInfo.isHideOutOfStock()) {
            try {
                Filter filter = query.createFilter();
                filter.addGreaterThan("myproject:instock", 0);
                filters.add(filter);
            } catch (FilterException e) {
                log.error("An exception occurred while trying to create a query filter for instock greater than zero: {}", e);
            }
        }
    }

    /* 2B variant
     @Override
         public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {


             HstRequestContext requestContext = request.getRequestContext();

             HippoBean scope = requestContext.getContentBean();

             final ProductListComponentInfo paramInfo = getComponentParametersInfo(request);

             try {

                 HstQuery query = requestContext.getQueryManager().createQuery(scope);

                 query.setLimit(5);

                 query.addOrderByAscending("myproject:title");

                 if (paramInfo.isHideOutOfStock()) {
                    Filter outOfStockFilter = query.createFilter();

                    outOfStockFilter.addGreaterThan("myproject:instock",0L);

                    query.setFilter(outOfStockFilter);
                 }

                 HstQueryResult result = query.execute();

                 request.setAttribute("products", result.getHippoBeans());


             } catch (QueryException e) {
                 LOGGER.error("Exception executing query", e);
             }

         }
         */

}
