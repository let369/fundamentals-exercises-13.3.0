package training.hstjavacomponents.answer._02b;
 /*
  * Copyright 2016-2019 BloomReach B.V. (http://www.bloomreach.com)
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
 import org.onehippo.cms7.essentials.components.EssentialsListComponent;
 import org.onehippo.cms7.essentials.components.info.EssentialsListComponentInfo;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;

 public class ProductListComponent extends BaseHstComponent {

     private static final Logger LOGGER = LoggerFactory.getLogger(ProductListComponent.class);


     // TODO 2a uncomment this block
     /*
     @Override
     protected void contributeAndFilters(final List<BaseFilter> filters, final HstRequest request, final HstQuery query) {
         try {
             // TODO 2a create a new Filter and add it to the list filters

         } catch (FilterException e) {
             LOGGER.error("An exception occurred while trying to create a query filter for instock greater than zero: {}", e);
         }
     }

 */

     @Override
     public void doBeforeRender(HstRequest request, HstResponse response) throws HstComponentException {


         HstRequestContext requestContext = request.getRequestContext();

         HippoBean scope = requestContext.getContentBean();

         try {

             HstQuery query = requestContext.getQueryManager().createQuery(scope);

             query.setLimit(5);

             query.addOrderByAscending("myproject:title");

             Filter outOfStockFilter = query.createFilter();

             outOfStockFilter.addGreaterThan("myproject:instock",0L);

             query.setFilter(outOfStockFilter);

             HstQueryResult result = query.execute();

             request.setAttribute("products", result.getHippoBeans());


         } catch (QueryException e) {
             LOGGER.error("Exception executing query", e);
         }

     }



 }
