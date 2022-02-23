package org.apache.spark.sql.blaze;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.apache.commons.lang3.ClassUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ByteBufferReadable;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.util.ClassUtil;
import org.apache.spark.SparkEnv;
import org.apache.spark.deploy.SparkHadoopUtil;
import org.apache.spark.shuffle.ShuffleManager;

public class JniBridge {
    static final public ConcurrentHashMap<String, Object> resourcesMap = new ConcurrentHashMap<>();
    static final Configuration conf;
    static final FileSystem fs;
    static {
        System.loadLibrary("blaze_rs");
        try {
            conf = SparkHadoopUtil.get().newConfiguration(SparkEnv.get().conf());
            conf.setBoolean("fs.hdfs.impl.disable.cache", true);
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
    public static ShuffleManager getShuffleManager() {
        return SparkEnv.get().shuffleManager();
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

    // JVM -> Native
    // shim method to FSDataInputStream.read()
    public static int readFSDataInputStream(FSDataInputStream in, ByteBuffer bb) throws IOException {
        try {
            return in.read(bb);

        } catch (UnsupportedOperationException e) {
            try {
                Field innerInField = null;
                innerInField = in.getClass().getDeclaredField("in");
                innerInField.setAccessible(true);
                InputStream innerIn = (InputStream) innerInField.get(in);

                if (innerIn instanceof ByteBufferReadable) {
                    return ((ByteBufferReadable) innerIn).read(bb);
                }
                if (innerIn instanceof ReadableByteChannel) {
                    return ((ReadableByteChannel) innerIn).read(bb);
                }
                throw new UnsupportedOperationException("no shims to FSDataInputStream.read()");

            } catch (NoSuchFieldException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
