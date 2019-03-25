package com.github.arrange.temporary;

import java.util.UUID;

public class StringUtils {
    /**
     * 随机生成ID
     * @return
     */
    public static String generateID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
