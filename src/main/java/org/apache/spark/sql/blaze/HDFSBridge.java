package org.apache.spark.sql.blaze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.spark.SparkEnv;
import org.apache.spark.deploy.SparkHadoopUtil;

@SuppressWarnings("unused")
public class HDFSBridge {
    static {
        System.loadLibrary("blaze_temp_rs");
    }

    static Configuration conf;
    static FileSystem fs;
    static {
        try {
            conf = SparkHadoopUtil.get().newConfiguration(SparkEnv.get().conf());
            fs = FileSystem.get(conf);
            RemoteIterator<FileStatus> i = fs.listStatusIterator(new Path("hdfs://localhost:9000/warehouse/bigint9999"));
            while (i.hasNext()) {
                System.out.println("list status: " + i.next().getPath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileSystem getFileSystem() {
        return fs;
    }

    public static native String testNative() throws IOException;
    public static String test() {
        try {
            return testNative();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
