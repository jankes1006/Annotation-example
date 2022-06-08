package com.janek;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class AnnotationProcessor {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Dog dog = new Dog(null,"Patyk");

        if(dog.getClass().isAnnotationPresent(FavoriteAnimal.class)){
            System.out.println("Dog is my favorite animal.");
        }

        for (Field field : dog.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(DefaultName.class)) {
                field.setAccessible(true);
                DefaultName defaultName = field.getAnnotation(DefaultName.class);
                String currentName = (String) field.get(dog);
                if(Objects.isNull(currentName))
                    field.set(dog,defaultName.name());
            }
        }

        for(Method method: dog.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(ImportantFunction.class)){
                ImportantFunction importantFunction = method.getAnnotation(ImportantFunction.class);
                for(int i=0; i<importantFunction.times(); i++){
                    method.invoke(dog);
                }
            }
        }
        System.out.println(dog);
    }

}
