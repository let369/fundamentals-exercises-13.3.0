package org.example.components;
/*
 * Copyright 2018-2019 BloomReach B.V. (http://www.bloomreach.com)
 * Usage is prohibited except for people attending a training given or authorised by BloomReach B.V., and only for that purpose.
 */

import java.util.List;

import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.content.beans.query.HstQuery;
import org.hippoecm.hst.content.beans.query.HstQueryResult;
import org.hippoecm.hst.content.beans.query.exceptions.FilterException;
import org.hippoecm.hst.content.beans.query.exceptions.QueryException;
import org.hippoecm.hst.content.beans.query.filter.BaseFilter;
import org.hippoecm.hst.content.beans.query.filter.Filter;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.parameters.ParametersInfo;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.onehippo.cms7.essentials.components.CommonComponent;
import org.onehippo.cms7.essentials.components.EssentialsListComponent;
import org.onehippo.cms7.essentials.components.info.EssentialsListComponentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ParametersInfo(type = ProductListComponentInfo.class)
public class ProductListComponent extends EssentialsListComponent{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListComponent.class);


    // TODO 2a uncomment this block

    @Override
    protected void contributeAndFilters(final List<BaseFilter> filters, final HstRequest request, final HstQuery query) {
        final ProductListComponentInfo info  = getComponentParametersInfo(request);
        if(info.isHideOutOfStock()) {
            try {
                // TODO 2a create a new Filter and add it to the list filters
                Filter filter = query.createFilter();
                filter.addGreaterThan("myproject:instock", 0);
                filters.add(filter);
            } catch (FilterException e) {
                LOGGER.error("An exception occurred while trying to create a query filter for instock greater than zero: {}", e);
            }
        }
    }

    // TODO 2b uncomment this block and complete the TODOs below
    /*
    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {


        HstRequestContext requestContext = request.getRequestContext();

        HippoBean scope = requestContext.getContentBean();

        try {

            //TODO create the query from the query manager that you get from the request context. Pass in the scope bean
            HstQuery query = requestContext.getQueryManager().createQuery(scope);

            //TODO set the query limit to 5
            query.setLimit(5);

            query.addOrderByAscending("myproject:title");

            //TODO create a filter from the query
            Filter outOfStockFilter = query.createFilter();

            // TODO set the filter to greater than 0L for the JCR property "myproject:instock"
            outOfStockFilter.addGreaterThan("myproject:instock",0L);

            //TODO set the query's filter to the outOfStockFilter
            query.setFilter(outOfStockFilter);

            //TODO execute the query and store the result
            HstQueryResult result = query.execute();

            //TODO put the result's hippo bean iterator on the request
            request.setAttribute("products", result.getHippoBeans());


        } catch (QueryException e) {
            LOGGER.error("Exception executing query", e);
        }

    }
    */



}
