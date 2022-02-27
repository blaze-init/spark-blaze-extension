package com.kwai;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

public class NioSeekableByteChannel implements SeekableByteChannel {
    private ByteBuffer buffer;
    private long offset;

    public NioSeekableByteChannel(ByteBuffer buffer, long offset, long length) {
        this.buffer = buffer.duplicate();
        this.offset = offset;

        this.buffer.position((int) offset);
        this.buffer.limit((int) (offset + length));
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
        int readSize = Math.min(dst.capacity(), this.buffer.limit() - this.buffer.position());
        ByteBuffer part = this.buffer.duplicate();
        part.limit(part.position() + readSize);

        dst = dst.duplicate();
        dst.limit(readSize);
        dst.put(part);
        this.buffer.position(this.buffer.position() + readSize);
        return readSize;
    }

    @Override
    public SeekableByteChannel position(long newPosition) throws IOException {
        this.buffer.position((int) (this.offset + newPosition));
        return this;
    }

    @Override
    public long position() throws IOException {
        return (long) this.buffer.position() - this.offset;
    }

    @Override
    public long size() throws IOException {
        return (long) this.buffer.limit() - this.offset;
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