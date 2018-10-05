package A402.utils;

import A402.model.BookingStatus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class RequestToInstanceMapper {

    public static <T> T createInstance(Class<T> targetClass, Map<String, String[]> request) {
        try {
            T instance = targetClass.newInstance();
            for (Method m : targetClass.getMethods()) {
                if (!m.getName().startsWith("set") || m.getParameterCount() != 1) continue;
                String fieldName = m.getName().substring(3);
                fieldName = fieldName.substring(0,1).toLowerCase() + fieldName.substring(1);

                Optional<?> fieldValue = ofNullable(request.get(fieldName))
                        .map(arr -> arr[0])
                        .map(getTypeMapper(m));
                if (fieldValue.isPresent()) {
                    m.invoke(instance, fieldValue.get());
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

    }

    static private BookingStatus mapBookingStatusFromView(String value){
        for(BookingStatus instance : BookingStatus.values()){
           if(instance.getViewRepresentation().equals(value)) {
               return instance;
           }
        }
        return null;
    }

    private static Function<? super String, ?> getTypeMapper(Method m) {
        Class<?>[] parameterTypes = m.getParameterTypes();
        Class<?> setterType = parameterTypes[0];
        if (setterType == String.class) {
            return Function.identity();
        } else if (setterType == int.class) {
            return Integer::parseInt;
        } else if (setterType == double.class) {
            return Double::parseDouble;
        } else if (setterType == BookingStatus.class) {
            return RequestToInstanceMapper::mapBookingStatusFromView;
        } else {
            throw new IllegalArgumentException(String.format("Incompatible type [%s]", setterType.getCanonicalName()));
        }
    }
}
