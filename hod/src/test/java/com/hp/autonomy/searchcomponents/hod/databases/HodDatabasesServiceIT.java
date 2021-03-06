/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.hod.databases;

import com.hp.autonomy.hod.client.error.HodErrorException;
import com.hp.autonomy.searchcomponents.core.databases.AbstractDatabasesServiceIT;
import com.hp.autonomy.searchcomponents.hod.beanconfiguration.HavenSearchHodConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HavenSearchHodConfiguration.class)
public class HodDatabasesServiceIT extends AbstractDatabasesServiceIT<Database, HodDatabasesRequest, HodDatabasesRequestBuilder, HodErrorException> {
    @Override
    protected HodDatabasesRequest createDatabasesRequest() {
        return databasesRequestBuilderFactory.getObject()
                .publicIndexesEnabled(true)
                .build();
    }
}
