package org.apache.spark.sql.blaze;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class BlazeBridge extends BlazeNativeBridge {
    public static ClassLoader getClassLoader() {
        return BlazeBridge.class.getClassLoader();
    }

    public static native void callNative(ByteBuffer taskDefinition, Consumer<ByteBuffer> ipcRecordBatchDataHandler);
}