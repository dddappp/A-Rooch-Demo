// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.bcs;

import java.util.Objects;

public class Year {

    public Short number;

    public String calendar;

    public static Year deserialize(com.novi.serde.Deserializer deserializer) throws com.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        Year value = new Year();
        value.number = deserializer.deserialize_u16();
        value.calendar = deserializer.deserialize_str();
        deserializer.decrease_container_depth();
        return value;
    }

    public static Year bcsDeserialize(byte[] input) throws com.novi.serde.DeserializationError {
        if (input == null) {
            throw new com.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.novi.serde.Deserializer deserializer = new com.novi.bcs.BcsDeserializer(input);
        Year value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
            throw new com.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public void serialize(com.novi.serde.Serializer serializer) throws com.novi.serde.SerializationError {
        serializer.increase_container_depth();
        serializer.serialize_u16(number);
        serializer.serialize_str(calendar);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws com.novi.serde.SerializationError {
        com.novi.serde.Serializer serializer = new com.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year other = (Year) o;
        return Objects.equals(number, other.number) && Objects.equals(calendar, other.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, calendar);
    }

    @Override
    public String toString() {
        return "Year{" +
                "number=" + number +
                ", calendar=" + '\'' + calendar + '\'' +
                '}';
    }
    
}
