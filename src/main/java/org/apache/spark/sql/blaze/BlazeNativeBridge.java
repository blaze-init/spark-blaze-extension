package org.apache.spark.sql.blaze;

public abstract class BlazeNativeBridge {
    static {
        System.loadLibrary("blaze_rs");
    }
}
