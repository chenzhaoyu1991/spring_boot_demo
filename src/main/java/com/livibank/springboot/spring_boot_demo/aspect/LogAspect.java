package com.livibank.springboot.spring_boot_demo.aspect;

import com.livibank.springboot.spring_boot_demo.InjectValue;
import com.livibank.springboot.spring_boot_demo.Type;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author chenzhaoyu
 * @date 2022/1/21  -  23:15
 **/
@Aspect
@Component
public class LogAspect {
    @Around("@annotation(com.livibank.springboot.spring_boot_demo.Permission)")
    public Object aound(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            Object[] args = joinPoint.getArgs();
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            if (args.length > 0) {
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                //获取方法参数的类型
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterAnnotations.length; i++) {//第一层代表参数
                    Annotation[] annotations = parameterAnnotations[i];
                    for (Annotation ann : annotations) {
                        if (ann.annotationType().equals(InjectValue.class)) {
                            //获取方法参数的类型
                            Class<?> parameterType = parameterTypes[i];
                            String typeName = parameterType.getName();
                            if (typeName.equals("java.lang.String")) {
                                InjectValue injectValue = (InjectValue) ann;
                                Type type = injectValue.propert();
                                if (type.equals(Type.custNo)) {
                                    args[i] = "007";
                                }
                            }
                        }
                    }
                }
            }

            result = joinPoint.proceed(args);
            return result;
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            return null;
        }
    }
}
