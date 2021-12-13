package com.kwai;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

public class NioSeekableByteChannel implements SeekableByteChannel {
    private final long offset;
    private final long length;
    private ByteBuffer buffer;
    private int position = 0;

    public NioSeekableByteChannel(ByteBuffer buffer, long offset, long length) {
        this.buffer = buffer;
        this.offset = offset;
        this.length = length;
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
        int capacity = dst.capacity();
        ByteBuffer part = buffer.duplicate();
        part.position((int) (position + offset));
        part.limit(position + capacity);
        dst.put(part);
        return capacity;
    }

    @Override
    public long position() throws IOException {
        return this.position;
    }

    @Override
    public SeekableByteChannel position(long newPosition) throws IOException {
        this.position = (int) newPosition;
        return this;
    }

    @Override
    public long size() throws IOException {
        return this.length;
    }

    @Override
    public boolean isOpen() {
        return this.buffer != null;
    }

    @Override
    public void close() throws IOException {
        this.buffer = null;
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
        throw new UnsupportedOperationException("Read only");
    }

    @Override
    public SeekableByteChannel truncate(long size) throws IOException {
        throw new UnsupportedOperationException("Read only");
    }
}
