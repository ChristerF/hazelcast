/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.nio.serialization;

import com.hazelcast.nio.ObjectDataOutput;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * @author mdogan 12/26/12
 */
public interface PortableWriter {

    int getVersion();

    void writeInt(String fieldName, int value) throws IOException;

    void writeLong(String fieldName, long value) throws IOException;

    void writeUTF(String fieldName, String value) throws IOException;

    void writeBoolean(String fieldName, final boolean value) throws IOException;

    void writeByte(String fieldName, final byte value) throws IOException;

    void writeChar(String fieldName, final int value) throws IOException;

    void writeDouble(String fieldName, final double value) throws IOException;

    void writeFloat(String fieldName, final float value) throws IOException;

    void writeShort(String fieldName, final short value) throws IOException;

    void writePortable(String fieldName, Portable portable) throws IOException;

    void writeNullPortable(String fieldName, int factoryId, int classId) throws IOException;

    void writeByteArray(String fieldName, byte[] bytes) throws IOException;

    void writeCharArray(String fieldName, char[] chars) throws IOException;

    void writeIntArray(String fieldName, int[] ints) throws IOException;

    void writeLongArray(String fieldName, long[] longs) throws IOException;

    void writeDoubleArray(String fieldName, double[] values) throws IOException;

    void writeFloatArray(String fieldName, float[] values) throws IOException;

    void writeShortArray(String fieldName, short[] values) throws IOException;

    void writePortableArray(String fieldName, Portable[] portables) throws IOException;

    ObjectDataOutput getRawDataOutput() throws IOException;

    /**
     * Writes an object as a field.
     *
     * @param fieldName the name of the field
     * @param object the object to be written
     * @throws IOException if serialization fails.
     */
    <T> void writeObject(String fieldName, T object) throws IOException;

    /**
     * Writes an object array as a field.
     *
     * @param fieldName the name of the field
     * @param objectArray the object array - if null an empty object array will be written
     * @throws IOException if serialization fails.
     */
    <T> void writeObjectArray(String fieldName, T[] objectArray) throws IOException;

    /**
     * Writes a {@link Map} as a field.
     *
     * @param fieldName the name of the field
     * @param map the {@link Map} - if null an empty map will be written
     * @param <K> the value type of the key for the {@link java.util.Map}
     * @param <V> the value type of the value for the {@link java.util.Map}
     * @throws IOException if serialization fails.
     */
    <K, V> void writeMap(String fieldName, Map<K, V> map) throws IOException;

    /**
     * Writes a {@link Collection} as a field.
     *
     * @param fieldName the name of the field
     * @param collection the {@link Collection} - if null, an empty collection will be written
     * @param <T> the value type of the {@link java.util.Collection}
     * @throws IOException if serialization fails.
     */
    <T> void writeCollection(String fieldName, Collection<T> collection) throws IOException;
}
