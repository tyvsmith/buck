/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)")
public class SequencedBuildSlaveEvent implements org.apache.thrift.TBase<SequencedBuildSlaveEvent, SequencedBuildSlaveEvent._Fields>, java.io.Serializable, Cloneable, Comparable<SequencedBuildSlaveEvent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SequencedBuildSlaveEvent");

  private static final org.apache.thrift.protocol.TField EVENT_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField("eventNumber", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("event", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SequencedBuildSlaveEventStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SequencedBuildSlaveEventTupleSchemeFactory();

  public int eventNumber; // optional
  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer event; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EVENT_NUMBER((short)1, "eventNumber"),
    EVENT((short)2, "event");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EVENT_NUMBER
          return EVENT_NUMBER;
        case 2: // EVENT
          return EVENT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __EVENTNUMBER_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.EVENT_NUMBER,_Fields.EVENT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT_NUMBER, new org.apache.thrift.meta_data.FieldMetaData("eventNumber", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.EVENT, new org.apache.thrift.meta_data.FieldMetaData("event", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SequencedBuildSlaveEvent.class, metaDataMap);
  }

  public SequencedBuildSlaveEvent() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SequencedBuildSlaveEvent(SequencedBuildSlaveEvent other) {
    __isset_bitfield = other.__isset_bitfield;
    this.eventNumber = other.eventNumber;
    if (other.isSetEvent()) {
      this.event = org.apache.thrift.TBaseHelper.copyBinary(other.event);
    }
  }

  public SequencedBuildSlaveEvent deepCopy() {
    return new SequencedBuildSlaveEvent(this);
  }

  @Override
  public void clear() {
    setEventNumberIsSet(false);
    this.eventNumber = 0;
    this.event = null;
  }

  public int getEventNumber() {
    return this.eventNumber;
  }

  public SequencedBuildSlaveEvent setEventNumber(int eventNumber) {
    this.eventNumber = eventNumber;
    setEventNumberIsSet(true);
    return this;
  }

  public void unsetEventNumber() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __EVENTNUMBER_ISSET_ID);
  }

  /** Returns true if field eventNumber is set (has been assigned a value) and false otherwise */
  public boolean isSetEventNumber() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __EVENTNUMBER_ISSET_ID);
  }

  public void setEventNumberIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __EVENTNUMBER_ISSET_ID, value);
  }

  public byte[] getEvent() {
    setEvent(org.apache.thrift.TBaseHelper.rightSize(event));
    return event == null ? null : event.array();
  }

  public java.nio.ByteBuffer bufferForEvent() {
    return org.apache.thrift.TBaseHelper.copyBinary(event);
  }

  public SequencedBuildSlaveEvent setEvent(byte[] event) {
    this.event = event == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(event.clone());
    return this;
  }

  public SequencedBuildSlaveEvent setEvent(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer event) {
    this.event = org.apache.thrift.TBaseHelper.copyBinary(event);
    return this;
  }

  public void unsetEvent() {
    this.event = null;
  }

  /** Returns true if field event is set (has been assigned a value) and false otherwise */
  public boolean isSetEvent() {
    return this.event != null;
  }

  public void setEventIsSet(boolean value) {
    if (!value) {
      this.event = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case EVENT_NUMBER:
      if (value == null) {
        unsetEventNumber();
      } else {
        setEventNumber((java.lang.Integer)value);
      }
      break;

    case EVENT:
      if (value == null) {
        unsetEvent();
      } else {
        if (value instanceof byte[]) {
          setEvent((byte[])value);
        } else {
          setEvent((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENT_NUMBER:
      return getEventNumber();

    case EVENT:
      return getEvent();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case EVENT_NUMBER:
      return isSetEventNumber();
    case EVENT:
      return isSetEvent();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof SequencedBuildSlaveEvent)
      return this.equals((SequencedBuildSlaveEvent)that);
    return false;
  }

  public boolean equals(SequencedBuildSlaveEvent that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_eventNumber = true && this.isSetEventNumber();
    boolean that_present_eventNumber = true && that.isSetEventNumber();
    if (this_present_eventNumber || that_present_eventNumber) {
      if (!(this_present_eventNumber && that_present_eventNumber))
        return false;
      if (this.eventNumber != that.eventNumber)
        return false;
    }

    boolean this_present_event = true && this.isSetEvent();
    boolean that_present_event = true && that.isSetEvent();
    if (this_present_event || that_present_event) {
      if (!(this_present_event && that_present_event))
        return false;
      if (!this.event.equals(that.event))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEventNumber()) ? 131071 : 524287);
    if (isSetEventNumber())
      hashCode = hashCode * 8191 + eventNumber;

    hashCode = hashCode * 8191 + ((isSetEvent()) ? 131071 : 524287);
    if (isSetEvent())
      hashCode = hashCode * 8191 + event.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(SequencedBuildSlaveEvent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetEventNumber()).compareTo(other.isSetEventNumber());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventNumber()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventNumber, other.eventNumber);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEvent()).compareTo(other.isSetEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.event, other.event);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("SequencedBuildSlaveEvent(");
    boolean first = true;

    if (isSetEventNumber()) {
      sb.append("eventNumber:");
      sb.append(this.eventNumber);
      first = false;
    }
    if (isSetEvent()) {
      if (!first) sb.append(", ");
      sb.append("event:");
      if (this.event == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.event, sb);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SequencedBuildSlaveEventStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SequencedBuildSlaveEventStandardScheme getScheme() {
      return new SequencedBuildSlaveEventStandardScheme();
    }
  }

  private static class SequencedBuildSlaveEventStandardScheme extends org.apache.thrift.scheme.StandardScheme<SequencedBuildSlaveEvent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SequencedBuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENT_NUMBER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.eventNumber = iprot.readI32();
              struct.setEventNumberIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.event = iprot.readBinary();
              struct.setEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SequencedBuildSlaveEvent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetEventNumber()) {
        oprot.writeFieldBegin(EVENT_NUMBER_FIELD_DESC);
        oprot.writeI32(struct.eventNumber);
        oprot.writeFieldEnd();
      }
      if (struct.event != null) {
        if (struct.isSetEvent()) {
          oprot.writeFieldBegin(EVENT_FIELD_DESC);
          oprot.writeBinary(struct.event);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SequencedBuildSlaveEventTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SequencedBuildSlaveEventTupleScheme getScheme() {
      return new SequencedBuildSlaveEventTupleScheme();
    }
  }

  private static class SequencedBuildSlaveEventTupleScheme extends org.apache.thrift.scheme.TupleScheme<SequencedBuildSlaveEvent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SequencedBuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEventNumber()) {
        optionals.set(0);
      }
      if (struct.isSetEvent()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetEventNumber()) {
        oprot.writeI32(struct.eventNumber);
      }
      if (struct.isSetEvent()) {
        oprot.writeBinary(struct.event);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SequencedBuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.eventNumber = iprot.readI32();
        struct.setEventNumberIsSet(true);
      }
      if (incoming.get(1)) {
        struct.event = iprot.readBinary();
        struct.setEventIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

