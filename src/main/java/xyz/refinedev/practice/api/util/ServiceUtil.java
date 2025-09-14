package xyz.refinedev.practice.api.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * <p>
 * This class is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * Redistribution of this class without permission is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version CarbonRecode
 * @since 2/15/2025
 */
@UtilityClass
public class ServiceUtil {

    public <T> Optional<T> findFirst(Class<T> clazz) {
        return findFirst(ServiceLoader.load(clazz, Bukkit.class.getClassLoader()).iterator());
    }

    static <T> Optional<T> findFirst(Iterator<T> iterator) {
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        } else {
            return Optional.empty();
        }
    }

}
