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
package net.itrixlabs.cache.config;

public class CacheKey implements Key {

    private Object key;
    private Long creationTime;

    @Override
    public Object getKey() {
	return key;
    }

    public void setKey(Object key) {
	this.key = key;
    }

    @Override
    public Long getCreationTime() {
	return creationTime;
    }

    public void setCreationTime(Long creationTime) {
	this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof CacheKey)
	    return this.key.equals(((CacheKey) obj).key);
	else
	    return false;
    }

    @Override
    public int hashCode() {
	return this.key.hashCode();
    }
}