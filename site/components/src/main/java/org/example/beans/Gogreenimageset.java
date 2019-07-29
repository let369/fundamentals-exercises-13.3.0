package org.example.beans;

import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSet;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageBean;

@HippoEssentialsGenerated(internalName = "myproject:gogreenimageset")
@Node(jcrType = "myproject:gogreenimageset")
public class Gogreenimageset extends HippoGalleryImageSet {
    @HippoEssentialsGenerated(internalName = "myproject:featured")
    public HippoGalleryImageBean getFeatured() {
        return getBean("myproject:featured", HippoGalleryImageBean.class);
    }
}
