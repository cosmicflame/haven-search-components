/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.hod.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hp.autonomy.hod.client.api.textindex.query.search.Print;
import com.hp.autonomy.hod.client.api.textindex.query.search.Sort;
import com.hp.autonomy.hod.client.api.textindex.query.search.Summary;
import com.hp.autonomy.searchcomponents.core.search.SuggestRequest;
import com.hp.autonomy.searchcomponents.hod.search.HodDocumentsService;
import com.hp.autonomy.searchcomponents.hod.search.HodQueryRestrictions;
import com.hp.autonomy.searchcomponents.hod.search.HodSuggestRequest;
import com.hp.autonomy.searchcomponents.hod.search.HodSuggestRequestBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Collection;

/**
 * Default implementation of {@link HodSuggestRequest}
 */
@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = HodSuggestRequestImpl.HodSuggestRequestImplBuilder.class)
class HodSuggestRequestImpl implements HodSuggestRequest {
    private static final long serialVersionUID = -6338199353489914631L;

    private final String reference;
    private final HodQueryRestrictions queryRestrictions;
    private final int start;
    private final int maxResults;
    private final Summary summary;
    private final Integer summaryCharacters;
    private final Sort sort;
    private final boolean highlight;
    private final Print print;
    @Singular
    private final Collection<String> printFields;

    @SuppressWarnings({"FieldMayBeFinal", "unused"})
    @JsonPOJOBuilder(withPrefix = "")
    static class HodSuggestRequestImplBuilder implements HodSuggestRequestBuilder {
        private int start = DEFAULT_START;
        private int maxResults = DEFAULT_MAX_RESULTS;
        private Print print = DEFAULT_PRINT;
    }
}
