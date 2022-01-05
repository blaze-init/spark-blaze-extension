package org.apache.spark.sql.blaze;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileSystem getFileSystem() {
        return fs;
    }
}
