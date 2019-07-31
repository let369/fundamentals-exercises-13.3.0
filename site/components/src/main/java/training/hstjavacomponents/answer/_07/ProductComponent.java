package training.hstjavacomponents.answer._01;
/*
 * Copyright 2014-2019 BloomReach B.V. (http://www.bloomreach.com)
 * Usage is prohibited except for people attending a training given or authorised by BloomReach B.V., and only for that purpose.
 */

import org.hippoecm.hst.container.RequestContextProvider;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.onehippo.cms7.essentials.components.EssentialsContentComponent;
import org.onehippo.forge.selection.hst.contentbean.ValueList;
import org.onehippo.forge.selection.hst.util.SelectionUtil;

public class ProductComponent extends EssentialsContentComponent {

    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) {
        super.doBeforeRender(request, response);

        final ValueList valueList = SelectionUtil.getValueListByIdentifier("categories", RequestContextProvider.get());
        if (valueList != null) {
            request.setAttribute("categoriesMap", SelectionUtil.valueListAsMap(valueList));
        }
    }

}
