package com.facility.utils;

import cn.hutool.core.util.ArrayUtil;

public class ArraysUtils {

    public static boolean isArrayNullOrZero(Object[] array){
        return ArrayUtil.isEmpty(array);
    }
}
