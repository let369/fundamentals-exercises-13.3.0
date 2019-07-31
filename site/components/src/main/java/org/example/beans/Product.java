package org.example.beans;
/*
 * Copyright 2016-2019 BloomReach B.V. (http://www.bloomreach.com)
 * Usage is prohibited except for people attending a training given or authorised by BloomReach B.V., and only for that purpose.
 */
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;

@HippoEssentialsGenerated(internalName = "myproject:product")
@Node(jcrType = "myproject:product")
public class Product extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "myproject:title")
    public String getTitle() {
        return getProperty("myproject:title");
    }

    @HippoEssentialsGenerated(internalName = "myproject:introduction")
    public String getIntroduction() {
        return getProperty("myproject:introduction");
    }

    @HippoEssentialsGenerated(internalName = "myproject:price")
    public Double getPrice() {
        return getProperty("myproject:price");
    }

    @HippoEssentialsGenerated(internalName = "myproject:rating")
    public Double getRating() {
        return getProperty("myproject:rating");
    }

    @HippoEssentialsGenerated(internalName = "myproject:instock")
    public Long getInstock() {
        return getProperty("myproject:instock");
    }

    @HippoEssentialsGenerated(internalName = "myproject:categories")
    public String[] getCategories() {
        return getProperty("myproject:categories");
    }

    @HippoEssentialsGenerated(internalName = "myproject:description")
    public HippoHtml getDescription() {
        return getHippoHtml("myproject:description");
    }

}
