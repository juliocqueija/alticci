package com.alticci.utils;

import com.alticci.utils.impl.AlticciCacheImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Import(value = {AlticciCacheImpl.class})
public class AlticciCacheTests {

    @Autowired
    private AlticciCache alticciCache;

    @Test
    public void putAndGetTest() {
        Long key = 6L;
        Long value = 3L;

        alticciCache.put(key, value);

        Long cachedValue = alticciCache.get(key);

        assertThat(cachedValue).isNotNull();
        assertThat(cachedValue).isEqualTo(value);
        assertThat(cachedValue).isOdd();
    }

    @Test
    public void containsKeyAndValueTest() {
        Long key = 6L;
        Long value = 3L;

        alticciCache.put(key, value);

        Boolean keyExists = alticciCache.containsKey(key);
        Boolean valueExists = alticciCache.containsValue(value);

        assertThat(keyExists).isNotNull();
        assertThat(valueExists).isNotNull();

        assertThat(keyExists).isEqualTo(true);
        assertThat(valueExists).isEqualTo(true);

        assertThat(keyExists).isTrue();
        assertThat(valueExists).isTrue();
    }

}
