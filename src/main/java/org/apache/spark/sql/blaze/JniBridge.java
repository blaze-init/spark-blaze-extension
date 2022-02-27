package org.apache.spark.sql.blaze;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.spark.SparkEnv;
import org.apache.spark.deploy.SparkHadoopUtil;
import org.apache.spark.shuffle.ShuffleManager;

public class JniBridge {
    static final public ConcurrentHashMap<String, Object> resourcesMap = new ConcurrentHashMap<>();
    static {
        System.loadLibrary("blaze_rs");
    }

    // JVM -> Native
    public static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    // JVM -> Native
    public static void setContextClassLoader(ClassLoader cl) {
        Thread.currentThread().setContextClassLoader(cl);
    }

    // JVM -> Native
    public static FileSystem getHDFSFileSystem(String uriString) {
        try {
            URI uri = new URI(uriString);
            return FileSystem.get(uri, SparkHadoopUtil.get().newConfiguration(SparkEnv.get().conf()));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
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
        int bytesRead = 0;

        while (bb.remaining() > 0) {
            int bytesReadPartial;
            try {
                bytesReadPartial = in.read(bb);
            } catch (UnsupportedOperationException e) {
                ReadableByteChannel channel = Channels.newChannel(in);
                bytesReadPartial = channel.read(bb);
            }

            if (bytesReadPartial < 0) {
                return bytesRead;
            }
            bytesRead += bytesReadPartial;
        }
        return bytesRead;
    }
}