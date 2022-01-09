package org.apache.spark.sql.blaze;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.spark.SparkEnv;
import org.apache.spark.deploy.SparkHadoopUtil;

public class JniBridge {
    static Configuration conf;
    static FileSystem fs;
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

    // Native -> JVM
    public static native void callNative(ByteBuffer taskDefinition, Consumer<ByteBuffer> ipcRecordBatchDataHandler);
}
