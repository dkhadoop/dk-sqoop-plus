// ORM class for table 'ws_11'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Mar 08 10:23:01 CST 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ws_11 extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public ws_11 with_id(Integer id) {
    this.id = id;
    return this;
  }
  private String sbid;
  public String get_sbid() {
    return sbid;
  }
  public void set_sbid(String sbid) {
    this.sbid = sbid;
  }
  public ws_11 with_sbid(String sbid) {
    this.sbid = sbid;
    return this;
  }
  private String sbdata;
  public String get_sbdata() {
    return sbdata;
  }
  public void set_sbdata(String sbdata) {
    this.sbdata = sbdata;
  }
  public ws_11 with_sbdata(String sbdata) {
    this.sbdata = sbdata;
    return this;
  }
  private String v1;
  public String get_v1() {
    return v1;
  }
  public void set_v1(String v1) {
    this.v1 = v1;
  }
  public ws_11 with_v1(String v1) {
    this.v1 = v1;
    return this;
  }
  private String v2;
  public String get_v2() {
    return v2;
  }
  public void set_v2(String v2) {
    this.v2 = v2;
  }
  public ws_11 with_v2(String v2) {
    this.v2 = v2;
    return this;
  }
  private String v3;
  public String get_v3() {
    return v3;
  }
  public void set_v3(String v3) {
    this.v3 = v3;
  }
  public ws_11 with_v3(String v3) {
    this.v3 = v3;
    return this;
  }
  private String v4;
  public String get_v4() {
    return v4;
  }
  public void set_v4(String v4) {
    this.v4 = v4;
  }
  public ws_11 with_v4(String v4) {
    this.v4 = v4;
    return this;
  }
  private String v5;
  public String get_v5() {
    return v5;
  }
  public void set_v5(String v5) {
    this.v5 = v5;
  }
  public ws_11 with_v5(String v5) {
    this.v5 = v5;
    return this;
  }
  private java.sql.Timestamp scdate;
  public java.sql.Timestamp get_scdate() {
    return scdate;
  }
  public void set_scdate(java.sql.Timestamp scdate) {
    this.scdate = scdate;
  }
  public ws_11 with_scdate(java.sql.Timestamp scdate) {
    this.scdate = scdate;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ws_11)) {
      return false;
    }
    ws_11 that = (ws_11) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.sbid == null ? that.sbid == null : this.sbid.equals(that.sbid));
    equal = equal && (this.sbdata == null ? that.sbdata == null : this.sbdata.equals(that.sbdata));
    equal = equal && (this.v1 == null ? that.v1 == null : this.v1.equals(that.v1));
    equal = equal && (this.v2 == null ? that.v2 == null : this.v2.equals(that.v2));
    equal = equal && (this.v3 == null ? that.v3 == null : this.v3.equals(that.v3));
    equal = equal && (this.v4 == null ? that.v4 == null : this.v4.equals(that.v4));
    equal = equal && (this.v5 == null ? that.v5 == null : this.v5.equals(that.v5));
    equal = equal && (this.scdate == null ? that.scdate == null : this.scdate.equals(that.scdate));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ws_11)) {
      return false;
    }
    ws_11 that = (ws_11) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.sbid == null ? that.sbid == null : this.sbid.equals(that.sbid));
    equal = equal && (this.sbdata == null ? that.sbdata == null : this.sbdata.equals(that.sbdata));
    equal = equal && (this.v1 == null ? that.v1 == null : this.v1.equals(that.v1));
    equal = equal && (this.v2 == null ? that.v2 == null : this.v2.equals(that.v2));
    equal = equal && (this.v3 == null ? that.v3 == null : this.v3.equals(that.v3));
    equal = equal && (this.v4 == null ? that.v4 == null : this.v4.equals(that.v4));
    equal = equal && (this.v5 == null ? that.v5 == null : this.v5.equals(that.v5));
    equal = equal && (this.scdate == null ? that.scdate == null : this.scdate.equals(that.scdate));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.sbid = JdbcWritableBridge.readString(2, __dbResults);
    this.sbdata = JdbcWritableBridge.readString(3, __dbResults);
    this.v1 = JdbcWritableBridge.readString(4, __dbResults);
    this.v2 = JdbcWritableBridge.readString(5, __dbResults);
    this.v3 = JdbcWritableBridge.readString(6, __dbResults);
    this.v4 = JdbcWritableBridge.readString(7, __dbResults);
    this.v5 = JdbcWritableBridge.readString(8, __dbResults);
    this.scdate = JdbcWritableBridge.readTimestamp(9, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.sbid = JdbcWritableBridge.readString(2, __dbResults);
    this.sbdata = JdbcWritableBridge.readString(3, __dbResults);
    this.v1 = JdbcWritableBridge.readString(4, __dbResults);
    this.v2 = JdbcWritableBridge.readString(5, __dbResults);
    this.v3 = JdbcWritableBridge.readString(6, __dbResults);
    this.v4 = JdbcWritableBridge.readString(7, __dbResults);
    this.v5 = JdbcWritableBridge.readString(8, __dbResults);
    this.scdate = JdbcWritableBridge.readTimestamp(9, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sbid, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sbdata, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v1, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v2, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v3, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v4, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v5, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(scdate, 9 + __off, 93, __dbStmt);
    return 9;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(sbid, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(sbdata, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v1, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v2, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v3, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v4, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(v5, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeTimestamp(scdate, 9 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.sbid = null;
    } else {
    this.sbid = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.sbdata = null;
    } else {
    this.sbdata = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v1 = null;
    } else {
    this.v1 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v2 = null;
    } else {
    this.v2 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v3 = null;
    } else {
    this.v3 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v4 = null;
    } else {
    this.v4 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.v5 = null;
    } else {
    this.v5 = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.scdate = null;
    } else {
    this.scdate = new Timestamp(__dataIn.readLong());
    this.scdate.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.sbid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sbid);
    }
    if (null == this.sbdata) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sbdata);
    }
    if (null == this.v1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v1);
    }
    if (null == this.v2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v2);
    }
    if (null == this.v3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v3);
    }
    if (null == this.v4) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v4);
    }
    if (null == this.v5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v5);
    }
    if (null == this.scdate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.scdate.getTime());
    __dataOut.writeInt(this.scdate.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.sbid) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sbid);
    }
    if (null == this.sbdata) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, sbdata);
    }
    if (null == this.v1) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v1);
    }
    if (null == this.v2) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v2);
    }
    if (null == this.v3) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v3);
    }
    if (null == this.v4) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v4);
    }
    if (null == this.v5) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, v5);
    }
    if (null == this.scdate) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.scdate.getTime());
    __dataOut.writeInt(this.scdate.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sbid==null?"null":sbid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sbdata==null?"null":sbdata, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v1==null?"null":v1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v2==null?"null":v2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v3==null?"null":v3, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v4==null?"null":v4, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v5==null?"null":v5, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(scdate==null?"null":"" + scdate, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sbid==null?"null":sbid, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(sbdata==null?"null":sbdata, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v1==null?"null":v1, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v2==null?"null":v2, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v3==null?"null":v3, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v4==null?"null":v4, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(v5==null?"null":v5, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(scdate==null?"null":"" + scdate, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sbid = null; } else {
      this.sbid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sbdata = null; } else {
      this.sbdata = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v1 = null; } else {
      this.v1 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v2 = null; } else {
      this.v2 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v3 = null; } else {
      this.v3 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v4 = null; } else {
      this.v4 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v5 = null; } else {
      this.v5 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.scdate = null; } else {
      this.scdate = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sbid = null; } else {
      this.sbid = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.sbdata = null; } else {
      this.sbdata = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v1 = null; } else {
      this.v1 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v2 = null; } else {
      this.v2 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v3 = null; } else {
      this.v3 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v4 = null; } else {
      this.v4 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.v5 = null; } else {
      this.v5 = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.scdate = null; } else {
      this.scdate = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    ws_11 o = (ws_11) super.clone();
    o.scdate = (o.scdate != null) ? (java.sql.Timestamp) o.scdate.clone() : null;
    return o;
  }

  public void clone0(ws_11 o) throws CloneNotSupportedException {
    o.scdate = (o.scdate != null) ? (java.sql.Timestamp) o.scdate.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("sbid", this.sbid);
    __sqoop$field_map.put("sbdata", this.sbdata);
    __sqoop$field_map.put("v1", this.v1);
    __sqoop$field_map.put("v2", this.v2);
    __sqoop$field_map.put("v3", this.v3);
    __sqoop$field_map.put("v4", this.v4);
    __sqoop$field_map.put("v5", this.v5);
    __sqoop$field_map.put("scdate", this.scdate);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("sbid", this.sbid);
    __sqoop$field_map.put("sbdata", this.sbdata);
    __sqoop$field_map.put("v1", this.v1);
    __sqoop$field_map.put("v2", this.v2);
    __sqoop$field_map.put("v3", this.v3);
    __sqoop$field_map.put("v4", this.v4);
    __sqoop$field_map.put("v5", this.v5);
    __sqoop$field_map.put("scdate", this.scdate);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
    }
    else    if ("sbid".equals(__fieldName)) {
      this.sbid = (String) __fieldVal;
    }
    else    if ("sbdata".equals(__fieldName)) {
      this.sbdata = (String) __fieldVal;
    }
    else    if ("v1".equals(__fieldName)) {
      this.v1 = (String) __fieldVal;
    }
    else    if ("v2".equals(__fieldName)) {
      this.v2 = (String) __fieldVal;
    }
    else    if ("v3".equals(__fieldName)) {
      this.v3 = (String) __fieldVal;
    }
    else    if ("v4".equals(__fieldName)) {
      this.v4 = (String) __fieldVal;
    }
    else    if ("v5".equals(__fieldName)) {
      this.v5 = (String) __fieldVal;
    }
    else    if ("scdate".equals(__fieldName)) {
      this.scdate = (java.sql.Timestamp) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("id".equals(__fieldName)) {
      this.id = (Integer) __fieldVal;
      return true;
    }
    else    if ("sbid".equals(__fieldName)) {
      this.sbid = (String) __fieldVal;
      return true;
    }
    else    if ("sbdata".equals(__fieldName)) {
      this.sbdata = (String) __fieldVal;
      return true;
    }
    else    if ("v1".equals(__fieldName)) {
      this.v1 = (String) __fieldVal;
      return true;
    }
    else    if ("v2".equals(__fieldName)) {
      this.v2 = (String) __fieldVal;
      return true;
    }
    else    if ("v3".equals(__fieldName)) {
      this.v3 = (String) __fieldVal;
      return true;
    }
    else    if ("v4".equals(__fieldName)) {
      this.v4 = (String) __fieldVal;
      return true;
    }
    else    if ("v5".equals(__fieldName)) {
      this.v5 = (String) __fieldVal;
      return true;
    }
    else    if ("scdate".equals(__fieldName)) {
      this.scdate = (java.sql.Timestamp) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
