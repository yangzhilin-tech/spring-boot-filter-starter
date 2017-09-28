package com.wgmf.starter.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableConfigurationProperties(FilterProperties.class)
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Autowired
	private FilterProperties properties;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@ConditionalOnProperty(prefix = "server", value = "enabled", havingValue = "true")
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("properties:" + properties.getContext());
		jdbcTemplate.execute("insert into AAA(id) values(13)");
		registry.addInterceptor(new MyInterceptor1(jdbcTemplate)).//addPathPatterns("**");
				pathMatcher(new AntPathMatcher("/**"));
		super.addInterceptors(registry);
	}

}
