package org.apache.spark.sql.blaze;

import java.nio.ByteBuffer;

import org.ballistacompute.protobuf.PhysicalPlanNode;

public class BlazeBridge {
    public static native void callNative(ByteBuffer taskDefinition, String executorId, String dir, String filename);
}
