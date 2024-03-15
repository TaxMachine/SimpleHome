package dev.taxmachine.simplehome.utils;

import org.apache.commons.lang3.SystemUtils;

public class PathUtils {
    public static String join(String... strings) {
        String os = SystemUtils.OS_NAME;
        if (os.contains("Windows")) return String.join("\\", strings);
        else return String.join("/", strings);
    }
}
