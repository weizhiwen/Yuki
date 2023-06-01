package com.yuki.common.config;

import com.yuki.common.core.dao.BaseRepoImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.yuki"}, repositoryBaseClass = BaseRepoImpl.class)
public class JpaConfig {
}
