package com.example.easydragview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)  // TODO Maybe can remove this annotation
public @interface Dragable {

    /*
       Can or not back to center of the parent view when drag up,
       MAINTAIN_POS: no
       BACK_CENTER: yes
    */
    final static public int MAINTAIN_POS = 0;
    final static public int BACK_CENTER = 1;

    /*
       Can or not move outside of the parent view(partitial)
       NOT_OUTSIDE_PARENT_VIEW: no
       OUTSIDE_PARENT_VIEW: yes
    */
    final static public int NOT_OUTSIDE_PARENT_VIEW = 0;
    final static public int OUTSIDE_PARENT_VIEW = 1;

    int dragBackMode() default MAINTAIN_POS;

    int dragOutsideMode() default NOT_OUTSIDE_PARENT_VIEW;
}
