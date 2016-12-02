/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.idol.custom;

import com.autonomy.aci.client.services.AciService;
import com.hp.autonomy.searchcomponents.core.search.fields.DocumentFieldsService;
import com.hp.autonomy.searchcomponents.idol.beanconfiguration.HavenSearchIdolConfiguration;
import com.hp.autonomy.searchcomponents.idol.databases.IdolDatabasesService;
import com.hp.autonomy.searchcomponents.idol.search.IdolQueryRestrictionsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.hp.autonomy.searchcomponents.core.test.TestUtils.CUSTOMISATION_TEST_ID;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HavenSearchIdolConfiguration.class, IdolCustomConfiguration.class, IdolCustomComponentConfiguration.class}, properties = CUSTOMISATION_TEST_ID)
public class IdolCustomisationTest {
    @Autowired
    @Qualifier("customDatabaseService")
    private IdolDatabasesService customDatabaseService;
    @Autowired
    @Qualifier("customQueryRestrictionsBuilder")
    private ObjectFactory<IdolQueryRestrictionsBuilder> customQueryRestrictionsBuilderFactory;
    @Autowired
    @Qualifier("customDocumentFieldsService")
    private DocumentFieldsService customDocumentFieldsService;
    @Autowired
    @Qualifier("contentAciService")
    private AciService contentAciService;

    @Test
    public void initialiseWithCustomConfiguration() {
        assertNotNull(customDatabaseService);
        assertNotNull(customQueryRestrictionsBuilderFactory.getObject());
        assertNotNull(customDocumentFieldsService);
        assertNull(contentAciService.executeAction(null, null)); // verify it is a mock
    }
}