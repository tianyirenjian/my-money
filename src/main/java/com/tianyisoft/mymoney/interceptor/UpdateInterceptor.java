package com.tianyisoft.mymoney.interceptor;

import com.tianyisoft.mymoney.entity.NoDatetime;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * @author tianyi
 */
@Component
@Intercepts(@Signature(
        type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}
))
public class UpdateInterceptor implements Interceptor {
    private static final String CREATED_AT = "createdAt";
    private static final String UPDATED_AT = "updatedAt";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object object = invocation.getArgs()[1];
        NoDatetime nd = object.getClass().getAnnotation(NoDatetime.class);
        if (nd != null) {
            return invocation.proceed();
        }

        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        SqlCommandType sct = ms.getSqlCommandType();
        Field[] fields = object.getClass().getDeclaredFields();
        if (sct == SqlCommandType.INSERT) {
            for (Field field : fields) {
                if (field.getName().equals(CREATED_AT) || field.getName().equals(UPDATED_AT)) {
                    field.setAccessible(true);
                    field.set(object, LocalDateTime.now());
                    field.setAccessible(false);
                }
            }
        } else if (sct == SqlCommandType.UPDATE) {
            for (Field field : fields) {
                if (field.getName().equals(UPDATED_AT)) {
                    field.setAccessible(true);
                    field.set(object, LocalDateTime.now());
                    field.setAccessible(false);
                }
            }
        }
        return invocation.proceed();
    }
}
