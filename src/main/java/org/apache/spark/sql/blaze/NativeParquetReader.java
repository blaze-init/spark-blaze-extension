package org.apache.spark.sql.blaze;

import lombok.Data;

public class NativeParquetReader {
    static {
        System.loadLibrary("blaze_temp_rs");
    }

    public native void create(String parquetReaderConfigJson);

    @Data
    static class ParquetReaderConfig {

    }
}
