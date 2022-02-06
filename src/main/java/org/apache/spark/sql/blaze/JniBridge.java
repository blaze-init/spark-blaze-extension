package org.apache.spark.sql.blaze;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.spark.SparkEnv;
import org.apache.spark.deploy.SparkHadoopUtil;
import org.apache.spark.sql.execution.metric.SQLMetric;

public class JniBridge {
    static final public ConcurrentHashMap<String, Object> resourcesMap = new ConcurrentHashMap<>();
    static final Configuration conf;
    static final FileSystem fs;
    static {
        System.loadLibrary("blaze_rs");
        try {
            conf = SparkHadoopUtil.get().newConfiguration(SparkEnv.get().conf());
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // JVM -> Native
    public static FileSystem getHDFSFileSystem() {
        return fs;
    }

    // JVM -> Native
    public static Object getResource(String key) {
        return resourcesMap.get(key);
    }

    // Native -> JVM
    public static native void callNative(
            ByteBuffer taskDefinition,
            MetricNode metrics,
            Consumer<ByteBuffer> resultHandler
    );
}
