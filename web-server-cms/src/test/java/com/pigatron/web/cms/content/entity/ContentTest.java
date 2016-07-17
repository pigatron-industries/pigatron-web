package com.pigatron.web.cms.content.entity;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ContentTest {


    @Test
    public void setContent_shouldNotSetContentSummary_whenNoBreakExists() {
        Content content = new Content();
        content.setContent("<p>No Break</p>");
        assertThat(content.getContentSummary()).isNull();
    }

    @Test
    public void setContent_shouldSetContentSummary_whenBreakExists() {
        Content content = new Content();
        content.setContent("<p>Before Break</p><!--more--><p>After Break</p>");
        assertThat(content.getContentSummary()).isEqualTo("<p>Before Break</p>");
    }

}
