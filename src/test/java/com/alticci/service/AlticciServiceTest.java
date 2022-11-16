package com.alticci.service;

import com.alticci.utils.AlticciCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class AlticciServiceTest {

    @InjectMocks
    private AlticciService alticciService;

    @Mock
    private AlticciCache alticciCache;

    @Test
    public void calculate0NoCacheTest() {
        when(alticciCache.containsKey(anyLong()))
                .thenReturn(false);

        Long result = alticciService.calculate(0);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void calculate1NoCacheTest() {
        when(alticciCache.containsKey(anyLong()))
                .thenReturn(false);

        Long result = alticciService.calculate(1);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculate2NoCacheTest() {
        when(alticciCache.containsKey(anyLong()))
                .thenReturn(false);

        Long result = alticciService.calculate(2);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void calculate6NoCacheTest() {
        when(alticciCache.containsKey(anyLong()))
                .thenReturn(false);

        Long result = alticciService.calculate(6);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate6CachedTest() {
        when(alticciCache.containsKey(anyLong()))
                .thenReturn(true);
        when(alticciCache.get(anyLong()))
                .thenReturn(3L);

        Long result = alticciService.calculate(6);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(3);
    }

}
