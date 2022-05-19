package com.discordbot.utils;

import com.discordbot.listener.ListenerInterface;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InterfaceImpls {

    public static List<Class> getSubclasses(Class target){
        Reflections reflections = new Reflections(
                ClasspathHelper.forPackage(target.getPackageName()), Scanners.values());
        Set<Class> implementingTypes =
                reflections.getSubTypesOf(target);
        return implementingTypes.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        getSubclasses(ListenerInterface.class);
    }
}
