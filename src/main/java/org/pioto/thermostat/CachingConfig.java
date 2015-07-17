package org.pioto.thermostat;

import net.sf.ehcache.config.CacheConfiguration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {

	@Bean(destroyMethod="shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager() {
		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();

		CacheConfiguration tstatCacheConfig = new CacheConfiguration("tstat", 50);
		tstatCacheConfig.setTimeToLiveSeconds(10);
		config.addCache(tstatCacheConfig);

		CacheConfiguration deviceCacheConfig = new CacheConfiguration("devices", 50);
		deviceCacheConfig.setTimeToLiveSeconds(5 * 60);
		config.addCache(deviceCacheConfig);

		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

}
