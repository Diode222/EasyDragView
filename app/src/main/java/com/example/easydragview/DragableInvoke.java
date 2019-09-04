package com.example.easydragview;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodReplacement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DragableInvoke {

    private DragableInvoke() { };

    public static void invoke(Context context) {
        Class contextClazz = context.getClass();
        Field[] fields = contextClazz.getDeclaredFields();
        for (Field field: fields) {
            Class fieldClazz = field.getType();
            if (!View.class.isAssignableFrom(fieldClazz))  // Not view, continue
                continue;

            Annotation annotation = field.getAnnotation(Dragable.class);
            if (annotation == null)  // Has no Dragable annotation, continue
                continue;

            final int dragBackMode = ((Dragable) annotation).dragBackMode();
            final int dragOutsideMode = ((Dragable) annotation).dragOutsideMode();
            // TODO Using the two settings to invoke onTouchEvent method
            DexposedBridge.findAndHookMethod(fieldClazz, "onTouchEvent", MotionEvent.class, new DragableHook());
        }
    }
}

class DragableHook extends XC_MethodReplacement {

    // TODO Implement specific drag logic
    @Override
    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
        return null;
    }
}