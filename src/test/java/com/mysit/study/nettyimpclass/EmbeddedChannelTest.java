package com.mysit.study.nettyimpclass;


import com.mysit.study.netty.FixedLengthFrameDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

public class EmbeddedChannelTest {

    @Test
    public void test() {
        ByteBuf buffer = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buffer.writeByte(i);
        }
        ByteBuf input = buffer.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        Assert.assertTrue(channel.writeInbound(input.retain()));

        Assert.assertTrue(channel.finish());

        ByteBuf read = channel.readInbound();
        Assert.assertEquals(buffer.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        Assert.assertEquals(buffer.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        Assert.assertEquals(buffer.readSlice(3), read);
        read.release();


        read = channel.readInbound();
        Assert.assertNull(read);
    }




}
