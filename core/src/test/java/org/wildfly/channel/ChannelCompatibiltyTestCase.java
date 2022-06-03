/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2020, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.wildfly.channel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.URL;

import org.junit.jupiter.api.Test;

public class ChannelCompatibiltyTestCase {

    @Test
    public void testReadChannel_1_0_0() throws Exception {
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        URL file = tccl.getResource("channels/versions/channel_1.0.0.yaml");
        Channel channel = ChannelMapper.from(file);
        assertNull(channel.getFoo());
        assertEquals("Injected", channel.getBar());
    }

    @Test
    public void testReadChannel_1_0_1() throws Exception {
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        URL file = tccl.getResource("channels/versions/channel_1.0.1.yaml");
        Channel channel = ChannelMapper.from(file);
        assertEquals("Whatever", channel.getFoo());
        assertEquals("Injected", channel.getBar());
    }

    @Test
    public void testReadChannel_2_0_0() throws Exception {
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        URL file = tccl.getResource("channels/versions/channel_2.0.0.yaml");
        Channel channel = ChannelMapper.from(file);
        assertEquals("Whatever", channel.getFoo());
        assertEquals("Very important", channel.getBar());
    }
}
