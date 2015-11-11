/*
 * Copyright (c) 2014-2015. Author or original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.itrixlabs.cache.user;

import static org.springframework.security.core.SpringSecurityCoreVersion.SERIAL_VERSION_UID;

import net.itrixlabs.cache.ext.AbstractFileSystemCache;
import net.itrixlabs.cache.ext.CacheType;

/**
 * <p>
 * Efficient implementation of <code>ApplicationCache</code> for authentication sub-systems.
 * </p>
 * 
 * @author Abhinav Rai
 * @since November 11<sup>th</sup>, 2015
 *
 */
public class SerializableUserCache<K, V> extends AbstractFileSystemCache<K, V> {

    private static final long serialVersionUID = SERIAL_VERSION_UID;

    public SerializableUserCache(CacheType type) {
	super(type);
    }

    public SerializableUserCache(CacheType type, String cacheDir, String cacheFile) {
	super(type, cacheDir, cacheFile);
    }

    @Override
    public V getFromCache(K key) {
	return super.cache.get(key);
    }

    @Override
    public void putInCache(K key, V entry) {
	super.cache.putIfAbsent(key, entry);
    }

    @Override
    public void evictFromCache(K key) {
	super.cache.remove(key);
    }
}