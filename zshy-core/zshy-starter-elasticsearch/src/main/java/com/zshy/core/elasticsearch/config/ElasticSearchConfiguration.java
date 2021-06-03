package com.zshy.core.elasticsearch.config;

import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import com.zshy.core.common.util.StringPool;
import com.zshy.core.elasticsearch.props.ElasticSearchProperties;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(ElasticSearchProperties.class)
public class ElasticSearchConfiguration extends AbstractElasticsearchConfiguration {

    private final ElasticSearchProperties elasticSearchProperties;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(StringUtils.join(elasticSearchProperties.getUris(), StringPool.COMMA))
                .withBasicAuth(elasticSearchProperties.getUsername(), elasticSearchProperties.getPassword())
                .withSocketTimeout(elasticSearchProperties.getReadTimeout())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
