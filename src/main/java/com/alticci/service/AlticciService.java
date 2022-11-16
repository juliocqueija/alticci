package com.alticci.service;

import com.alticci.utils.AlticciCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlticciService {

    private final AlticciCache alticciCache;

    public long calculate(long num) {

        if (alticciCache.containsKey(num)) {
            return alticciCache.get(num);
        }

        if (num == 0L) {
            return 0L;
        }

        if (num == 1L || num == 2L) {
            return 1L;
        }

        long result = calculate(num - 3) + calculate(num - 2);
        alticciCache.put(num, result);

        return result;
    }

}
