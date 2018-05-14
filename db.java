// ORM class for table 'db'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Thu Mar 08 10:16:50 CST 2018
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

public class db extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String Host;
  public String get_Host() {
    return Host;
  }
  public void set_Host(String Host) {
    this.Host = Host;
  }
  public db with_Host(String Host) {
    this.Host = Host;
    return this;
  }
  private String Db;
  public String get_Db() {
    return Db;
  }
  public void set_Db(String Db) {
    this.Db = Db;
  }
  public db with_Db(String Db) {
    this.Db = Db;
    return this;
  }
  private String User;
  public String get_User() {
    return User;
  }
  public void set_User(String User) {
    this.User = User;
  }
  public db with_User(String User) {
    this.User = User;
    return this;
  }
  private String Select_priv;
  public String get_Select_priv() {
    return Select_priv;
  }
  public void set_Select_priv(String Select_priv) {
    this.Select_priv = Select_priv;
  }
  public db with_Select_priv(String Select_priv) {
    this.Select_priv = Select_priv;
    return this;
  }
  private String Insert_priv;
  public String get_Insert_priv() {
    return Insert_priv;
  }
  public void set_Insert_priv(String Insert_priv) {
    this.Insert_priv = Insert_priv;
  }
  public db with_Insert_priv(String Insert_priv) {
    this.Insert_priv = Insert_priv;
    return this;
  }
  private String Update_priv;
  public String get_Update_priv() {
    return Update_priv;
  }
  public void set_Update_priv(String Update_priv) {
    this.Update_priv = Update_priv;
  }
  public db with_Update_priv(String Update_priv) {
    this.Update_priv = Update_priv;
    return this;
  }
  private String Delete_priv;
  public String get_Delete_priv() {
    return Delete_priv;
  }
  public void set_Delete_priv(String Delete_priv) {
    this.Delete_priv = Delete_priv;
  }
  public db with_Delete_priv(String Delete_priv) {
    this.Delete_priv = Delete_priv;
    return this;
  }
  private String Create_priv;
  public String get_Create_priv() {
    return Create_priv;
  }
  public void set_Create_priv(String Create_priv) {
    this.Create_priv = Create_priv;
  }
  public db with_Create_priv(String Create_priv) {
    this.Create_priv = Create_priv;
    return this;
  }
  private String Drop_priv;
  public String get_Drop_priv() {
    return Drop_priv;
  }
  public void set_Drop_priv(String Drop_priv) {
    this.Drop_priv = Drop_priv;
  }
  public db with_Drop_priv(String Drop_priv) {
    this.Drop_priv = Drop_priv;
    return this;
  }
  private String Grant_priv;
  public String get_Grant_priv() {
    return Grant_priv;
  }
  public void set_Grant_priv(String Grant_priv) {
    this.Grant_priv = Grant_priv;
  }
  public db with_Grant_priv(String Grant_priv) {
    this.Grant_priv = Grant_priv;
    return this;
  }
  private String References_priv;
  public String get_References_priv() {
    return References_priv;
  }
  public void set_References_priv(String References_priv) {
    this.References_priv = References_priv;
  }
  public db with_References_priv(String References_priv) {
    this.References_priv = References_priv;
    return this;
  }
  private String Index_priv;
  public String get_Index_priv() {
    return Index_priv;
  }
  public void set_Index_priv(String Index_priv) {
    this.Index_priv = Index_priv;
  }
  public db with_Index_priv(String Index_priv) {
    this.Index_priv = Index_priv;
    return this;
  }
  private String Alter_priv;
  public String get_Alter_priv() {
    return Alter_priv;
  }
  public void set_Alter_priv(String Alter_priv) {
    this.Alter_priv = Alter_priv;
  }
  public db with_Alter_priv(String Alter_priv) {
    this.Alter_priv = Alter_priv;
    return this;
  }
  private String Create_tmp_table_priv;
  public String get_Create_tmp_table_priv() {
    return Create_tmp_table_priv;
  }
  public void set_Create_tmp_table_priv(String Create_tmp_table_priv) {
    this.Create_tmp_table_priv = Create_tmp_table_priv;
  }
  public db with_Create_tmp_table_priv(String Create_tmp_table_priv) {
    this.Create_tmp_table_priv = Create_tmp_table_priv;
    return this;
  }
  private String Lock_tables_priv;
  public String get_Lock_tables_priv() {
    return Lock_tables_priv;
  }
  public void set_Lock_tables_priv(String Lock_tables_priv) {
    this.Lock_tables_priv = Lock_tables_priv;
  }
  public db with_Lock_tables_priv(String Lock_tables_priv) {
    this.Lock_tables_priv = Lock_tables_priv;
    return this;
  }
  private String Create_view_priv;
  public String get_Create_view_priv() {
    return Create_view_priv;
  }
  public void set_Create_view_priv(String Create_view_priv) {
    this.Create_view_priv = Create_view_priv;
  }
  public db with_Create_view_priv(String Create_view_priv) {
    this.Create_view_priv = Create_view_priv;
    return this;
  }
  private String Show_view_priv;
  public String get_Show_view_priv() {
    return Show_view_priv;
  }
  public void set_Show_view_priv(String Show_view_priv) {
    this.Show_view_priv = Show_view_priv;
  }
  public db with_Show_view_priv(String Show_view_priv) {
    this.Show_view_priv = Show_view_priv;
    return this;
  }
  private String Create_routine_priv;
  public String get_Create_routine_priv() {
    return Create_routine_priv;
  }
  public void set_Create_routine_priv(String Create_routine_priv) {
    this.Create_routine_priv = Create_routine_priv;
  }
  public db with_Create_routine_priv(String Create_routine_priv) {
    this.Create_routine_priv = Create_routine_priv;
    return this;
  }
  private String Alter_routine_priv;
  public String get_Alter_routine_priv() {
    return Alter_routine_priv;
  }
  public void set_Alter_routine_priv(String Alter_routine_priv) {
    this.Alter_routine_priv = Alter_routine_priv;
  }
  public db with_Alter_routine_priv(String Alter_routine_priv) {
    this.Alter_routine_priv = Alter_routine_priv;
    return this;
  }
  private String Execute_priv;
  public String get_Execute_priv() {
    return Execute_priv;
  }
  public void set_Execute_priv(String Execute_priv) {
    this.Execute_priv = Execute_priv;
  }
  public db with_Execute_priv(String Execute_priv) {
    this.Execute_priv = Execute_priv;
    return this;
  }
  private String Event_priv;
  public String get_Event_priv() {
    return Event_priv;
  }
  public void set_Event_priv(String Event_priv) {
    this.Event_priv = Event_priv;
  }
  public db with_Event_priv(String Event_priv) {
    this.Event_priv = Event_priv;
    return this;
  }
  private String Trigger_priv;
  public String get_Trigger_priv() {
    return Trigger_priv;
  }
  public void set_Trigger_priv(String Trigger_priv) {
    this.Trigger_priv = Trigger_priv;
  }
  public db with_Trigger_priv(String Trigger_priv) {
    this.Trigger_priv = Trigger_priv;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof db)) {
      return false;
    }
    db that = (db) o;
    boolean equal = true;
    equal = equal && (this.Host == null ? that.Host == null : this.Host.equals(that.Host));
    equal = equal && (this.Db == null ? that.Db == null : this.Db.equals(that.Db));
    equal = equal && (this.User == null ? that.User == null : this.User.equals(that.User));
    equal = equal && (this.Select_priv == null ? that.Select_priv == null : this.Select_priv.equals(that.Select_priv));
    equal = equal && (this.Insert_priv == null ? that.Insert_priv == null : this.Insert_priv.equals(that.Insert_priv));
    equal = equal && (this.Update_priv == null ? that.Update_priv == null : this.Update_priv.equals(that.Update_priv));
    equal = equal && (this.Delete_priv == null ? that.Delete_priv == null : this.Delete_priv.equals(that.Delete_priv));
    equal = equal && (this.Create_priv == null ? that.Create_priv == null : this.Create_priv.equals(that.Create_priv));
    equal = equal && (this.Drop_priv == null ? that.Drop_priv == null : this.Drop_priv.equals(that.Drop_priv));
    equal = equal && (this.Grant_priv == null ? that.Grant_priv == null : this.Grant_priv.equals(that.Grant_priv));
    equal = equal && (this.References_priv == null ? that.References_priv == null : this.References_priv.equals(that.References_priv));
    equal = equal && (this.Index_priv == null ? that.Index_priv == null : this.Index_priv.equals(that.Index_priv));
    equal = equal && (this.Alter_priv == null ? that.Alter_priv == null : this.Alter_priv.equals(that.Alter_priv));
    equal = equal && (this.Create_tmp_table_priv == null ? that.Create_tmp_table_priv == null : this.Create_tmp_table_priv.equals(that.Create_tmp_table_priv));
    equal = equal && (this.Lock_tables_priv == null ? that.Lock_tables_priv == null : this.Lock_tables_priv.equals(that.Lock_tables_priv));
    equal = equal && (this.Create_view_priv == null ? that.Create_view_priv == null : this.Create_view_priv.equals(that.Create_view_priv));
    equal = equal && (this.Show_view_priv == null ? that.Show_view_priv == null : this.Show_view_priv.equals(that.Show_view_priv));
    equal = equal && (this.Create_routine_priv == null ? that.Create_routine_priv == null : this.Create_routine_priv.equals(that.Create_routine_priv));
    equal = equal && (this.Alter_routine_priv == null ? that.Alter_routine_priv == null : this.Alter_routine_priv.equals(that.Alter_routine_priv));
    equal = equal && (this.Execute_priv == null ? that.Execute_priv == null : this.Execute_priv.equals(that.Execute_priv));
    equal = equal && (this.Event_priv == null ? that.Event_priv == null : this.Event_priv.equals(that.Event_priv));
    equal = equal && (this.Trigger_priv == null ? that.Trigger_priv == null : this.Trigger_priv.equals(that.Trigger_priv));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof db)) {
      return false;
    }
    db that = (db) o;
    boolean equal = true;
    equal = equal && (this.Host == null ? that.Host == null : this.Host.equals(that.Host));
    equal = equal && (this.Db == null ? that.Db == null : this.Db.equals(that.Db));
    equal = equal && (this.User == null ? that.User == null : this.User.equals(that.User));
    equal = equal && (this.Select_priv == null ? that.Select_priv == null : this.Select_priv.equals(that.Select_priv));
    equal = equal && (this.Insert_priv == null ? that.Insert_priv == null : this.Insert_priv.equals(that.Insert_priv));
    equal = equal && (this.Update_priv == null ? that.Update_priv == null : this.Update_priv.equals(that.Update_priv));
    equal = equal && (this.Delete_priv == null ? that.Delete_priv == null : this.Delete_priv.equals(that.Delete_priv));
    equal = equal && (this.Create_priv == null ? that.Create_priv == null : this.Create_priv.equals(that.Create_priv));
    equal = equal && (this.Drop_priv == null ? that.Drop_priv == null : this.Drop_priv.equals(that.Drop_priv));
    equal = equal && (this.Grant_priv == null ? that.Grant_priv == null : this.Grant_priv.equals(that.Grant_priv));
    equal = equal && (this.References_priv == null ? that.References_priv == null : this.References_priv.equals(that.References_priv));
    equal = equal && (this.Index_priv == null ? that.Index_priv == null : this.Index_priv.equals(that.Index_priv));
    equal = equal && (this.Alter_priv == null ? that.Alter_priv == null : this.Alter_priv.equals(that.Alter_priv));
    equal = equal && (this.Create_tmp_table_priv == null ? that.Create_tmp_table_priv == null : this.Create_tmp_table_priv.equals(that.Create_tmp_table_priv));
    equal = equal && (this.Lock_tables_priv == null ? that.Lock_tables_priv == null : this.Lock_tables_priv.equals(that.Lock_tables_priv));
    equal = equal && (this.Create_view_priv == null ? that.Create_view_priv == null : this.Create_view_priv.equals(that.Create_view_priv));
    equal = equal && (this.Show_view_priv == null ? that.Show_view_priv == null : this.Show_view_priv.equals(that.Show_view_priv));
    equal = equal && (this.Create_routine_priv == null ? that.Create_routine_priv == null : this.Create_routine_priv.equals(that.Create_routine_priv));
    equal = equal && (this.Alter_routine_priv == null ? that.Alter_routine_priv == null : this.Alter_routine_priv.equals(that.Alter_routine_priv));
    equal = equal && (this.Execute_priv == null ? that.Execute_priv == null : this.Execute_priv.equals(that.Execute_priv));
    equal = equal && (this.Event_priv == null ? that.Event_priv == null : this.Event_priv.equals(that.Event_priv));
    equal = equal && (this.Trigger_priv == null ? that.Trigger_priv == null : this.Trigger_priv.equals(that.Trigger_priv));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.Host = JdbcWritableBridge.readString(1, __dbResults);
    this.Db = JdbcWritableBridge.readString(2, __dbResults);
    this.User = JdbcWritableBridge.readString(3, __dbResults);
    this.Select_priv = JdbcWritableBridge.readString(4, __dbResults);
    this.Insert_priv = JdbcWritableBridge.readString(5, __dbResults);
    this.Update_priv = JdbcWritableBridge.readString(6, __dbResults);
    this.Delete_priv = JdbcWritableBridge.readString(7, __dbResults);
    this.Create_priv = JdbcWritableBridge.readString(8, __dbResults);
    this.Drop_priv = JdbcWritableBridge.readString(9, __dbResults);
    this.Grant_priv = JdbcWritableBridge.readString(10, __dbResults);
    this.References_priv = JdbcWritableBridge.readString(11, __dbResults);
    this.Index_priv = JdbcWritableBridge.readString(12, __dbResults);
    this.Alter_priv = JdbcWritableBridge.readString(13, __dbResults);
    this.Create_tmp_table_priv = JdbcWritableBridge.readString(14, __dbResults);
    this.Lock_tables_priv = JdbcWritableBridge.readString(15, __dbResults);
    this.Create_view_priv = JdbcWritableBridge.readString(16, __dbResults);
    this.Show_view_priv = JdbcWritableBridge.readString(17, __dbResults);
    this.Create_routine_priv = JdbcWritableBridge.readString(18, __dbResults);
    this.Alter_routine_priv = JdbcWritableBridge.readString(19, __dbResults);
    this.Execute_priv = JdbcWritableBridge.readString(20, __dbResults);
    this.Event_priv = JdbcWritableBridge.readString(21, __dbResults);
    this.Trigger_priv = JdbcWritableBridge.readString(22, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.Host = JdbcWritableBridge.readString(1, __dbResults);
    this.Db = JdbcWritableBridge.readString(2, __dbResults);
    this.User = JdbcWritableBridge.readString(3, __dbResults);
    this.Select_priv = JdbcWritableBridge.readString(4, __dbResults);
    this.Insert_priv = JdbcWritableBridge.readString(5, __dbResults);
    this.Update_priv = JdbcWritableBridge.readString(6, __dbResults);
    this.Delete_priv = JdbcWritableBridge.readString(7, __dbResults);
    this.Create_priv = JdbcWritableBridge.readString(8, __dbResults);
    this.Drop_priv = JdbcWritableBridge.readString(9, __dbResults);
    this.Grant_priv = JdbcWritableBridge.readString(10, __dbResults);
    this.References_priv = JdbcWritableBridge.readString(11, __dbResults);
    this.Index_priv = JdbcWritableBridge.readString(12, __dbResults);
    this.Alter_priv = JdbcWritableBridge.readString(13, __dbResults);
    this.Create_tmp_table_priv = JdbcWritableBridge.readString(14, __dbResults);
    this.Lock_tables_priv = JdbcWritableBridge.readString(15, __dbResults);
    this.Create_view_priv = JdbcWritableBridge.readString(16, __dbResults);
    this.Show_view_priv = JdbcWritableBridge.readString(17, __dbResults);
    this.Create_routine_priv = JdbcWritableBridge.readString(18, __dbResults);
    this.Alter_routine_priv = JdbcWritableBridge.readString(19, __dbResults);
    this.Execute_priv = JdbcWritableBridge.readString(20, __dbResults);
    this.Event_priv = JdbcWritableBridge.readString(21, __dbResults);
    this.Trigger_priv = JdbcWritableBridge.readString(22, __dbResults);
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
    JdbcWritableBridge.writeString(Host, 1 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Db, 2 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(User, 3 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Select_priv, 4 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Insert_priv, 5 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Update_priv, 6 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Delete_priv, 7 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_priv, 8 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Drop_priv, 9 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Grant_priv, 10 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(References_priv, 11 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Index_priv, 12 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Alter_priv, 13 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_tmp_table_priv, 14 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Lock_tables_priv, 15 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_view_priv, 16 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Show_view_priv, 17 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_routine_priv, 18 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Alter_routine_priv, 19 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Execute_priv, 20 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Event_priv, 21 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Trigger_priv, 22 + __off, 1, __dbStmt);
    return 22;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(Host, 1 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Db, 2 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(User, 3 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Select_priv, 4 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Insert_priv, 5 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Update_priv, 6 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Delete_priv, 7 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_priv, 8 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Drop_priv, 9 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Grant_priv, 10 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(References_priv, 11 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Index_priv, 12 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Alter_priv, 13 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_tmp_table_priv, 14 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Lock_tables_priv, 15 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_view_priv, 16 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Show_view_priv, 17 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Create_routine_priv, 18 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Alter_routine_priv, 19 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Execute_priv, 20 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Event_priv, 21 + __off, 1, __dbStmt);
    JdbcWritableBridge.writeString(Trigger_priv, 22 + __off, 1, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.Host = null;
    } else {
    this.Host = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Db = null;
    } else {
    this.Db = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.User = null;
    } else {
    this.User = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Select_priv = null;
    } else {
    this.Select_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Insert_priv = null;
    } else {
    this.Insert_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Update_priv = null;
    } else {
    this.Update_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Delete_priv = null;
    } else {
    this.Delete_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Create_priv = null;
    } else {
    this.Create_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Drop_priv = null;
    } else {
    this.Drop_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Grant_priv = null;
    } else {
    this.Grant_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.References_priv = null;
    } else {
    this.References_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Index_priv = null;
    } else {
    this.Index_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Alter_priv = null;
    } else {
    this.Alter_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Create_tmp_table_priv = null;
    } else {
    this.Create_tmp_table_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Lock_tables_priv = null;
    } else {
    this.Lock_tables_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Create_view_priv = null;
    } else {
    this.Create_view_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Show_view_priv = null;
    } else {
    this.Show_view_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Create_routine_priv = null;
    } else {
    this.Create_routine_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Alter_routine_priv = null;
    } else {
    this.Alter_routine_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Execute_priv = null;
    } else {
    this.Execute_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Event_priv = null;
    } else {
    this.Event_priv = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Trigger_priv = null;
    } else {
    this.Trigger_priv = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.Host) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Host);
    }
    if (null == this.Db) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Db);
    }
    if (null == this.User) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, User);
    }
    if (null == this.Select_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Select_priv);
    }
    if (null == this.Insert_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Insert_priv);
    }
    if (null == this.Update_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Update_priv);
    }
    if (null == this.Delete_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Delete_priv);
    }
    if (null == this.Create_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_priv);
    }
    if (null == this.Drop_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Drop_priv);
    }
    if (null == this.Grant_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Grant_priv);
    }
    if (null == this.References_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, References_priv);
    }
    if (null == this.Index_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Index_priv);
    }
    if (null == this.Alter_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Alter_priv);
    }
    if (null == this.Create_tmp_table_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_tmp_table_priv);
    }
    if (null == this.Lock_tables_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Lock_tables_priv);
    }
    if (null == this.Create_view_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_view_priv);
    }
    if (null == this.Show_view_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Show_view_priv);
    }
    if (null == this.Create_routine_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_routine_priv);
    }
    if (null == this.Alter_routine_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Alter_routine_priv);
    }
    if (null == this.Execute_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Execute_priv);
    }
    if (null == this.Event_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Event_priv);
    }
    if (null == this.Trigger_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Trigger_priv);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.Host) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Host);
    }
    if (null == this.Db) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Db);
    }
    if (null == this.User) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, User);
    }
    if (null == this.Select_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Select_priv);
    }
    if (null == this.Insert_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Insert_priv);
    }
    if (null == this.Update_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Update_priv);
    }
    if (null == this.Delete_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Delete_priv);
    }
    if (null == this.Create_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_priv);
    }
    if (null == this.Drop_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Drop_priv);
    }
    if (null == this.Grant_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Grant_priv);
    }
    if (null == this.References_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, References_priv);
    }
    if (null == this.Index_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Index_priv);
    }
    if (null == this.Alter_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Alter_priv);
    }
    if (null == this.Create_tmp_table_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_tmp_table_priv);
    }
    if (null == this.Lock_tables_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Lock_tables_priv);
    }
    if (null == this.Create_view_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_view_priv);
    }
    if (null == this.Show_view_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Show_view_priv);
    }
    if (null == this.Create_routine_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Create_routine_priv);
    }
    if (null == this.Alter_routine_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Alter_routine_priv);
    }
    if (null == this.Execute_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Execute_priv);
    }
    if (null == this.Event_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Event_priv);
    }
    if (null == this.Trigger_priv) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Trigger_priv);
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
    __sb.append(FieldFormatter.escapeAndEnclose(Host==null?"null":Host, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Db==null?"null":Db, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(User==null?"null":User, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Select_priv==null?"null":Select_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Insert_priv==null?"null":Insert_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Update_priv==null?"null":Update_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Delete_priv==null?"null":Delete_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_priv==null?"null":Create_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Drop_priv==null?"null":Drop_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Grant_priv==null?"null":Grant_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(References_priv==null?"null":References_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Index_priv==null?"null":Index_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Alter_priv==null?"null":Alter_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_tmp_table_priv==null?"null":Create_tmp_table_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Lock_tables_priv==null?"null":Lock_tables_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_view_priv==null?"null":Create_view_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Show_view_priv==null?"null":Show_view_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_routine_priv==null?"null":Create_routine_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Alter_routine_priv==null?"null":Alter_routine_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Execute_priv==null?"null":Execute_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Event_priv==null?"null":Event_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Trigger_priv==null?"null":Trigger_priv, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(Host==null?"null":Host, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Db==null?"null":Db, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(User==null?"null":User, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Select_priv==null?"null":Select_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Insert_priv==null?"null":Insert_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Update_priv==null?"null":Update_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Delete_priv==null?"null":Delete_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_priv==null?"null":Create_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Drop_priv==null?"null":Drop_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Grant_priv==null?"null":Grant_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(References_priv==null?"null":References_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Index_priv==null?"null":Index_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Alter_priv==null?"null":Alter_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_tmp_table_priv==null?"null":Create_tmp_table_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Lock_tables_priv==null?"null":Lock_tables_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_view_priv==null?"null":Create_view_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Show_view_priv==null?"null":Show_view_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Create_routine_priv==null?"null":Create_routine_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Alter_routine_priv==null?"null":Alter_routine_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Execute_priv==null?"null":Execute_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Event_priv==null?"null":Event_priv, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Trigger_priv==null?"null":Trigger_priv, delimiters));
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
    if (__cur_str.equals("null")) { this.Host = null; } else {
      this.Host = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Db = null; } else {
      this.Db = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.User = null; } else {
      this.User = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Select_priv = null; } else {
      this.Select_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Insert_priv = null; } else {
      this.Insert_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Update_priv = null; } else {
      this.Update_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Delete_priv = null; } else {
      this.Delete_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_priv = null; } else {
      this.Create_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Drop_priv = null; } else {
      this.Drop_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Grant_priv = null; } else {
      this.Grant_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.References_priv = null; } else {
      this.References_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Index_priv = null; } else {
      this.Index_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Alter_priv = null; } else {
      this.Alter_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_tmp_table_priv = null; } else {
      this.Create_tmp_table_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Lock_tables_priv = null; } else {
      this.Lock_tables_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_view_priv = null; } else {
      this.Create_view_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Show_view_priv = null; } else {
      this.Show_view_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_routine_priv = null; } else {
      this.Create_routine_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Alter_routine_priv = null; } else {
      this.Alter_routine_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Execute_priv = null; } else {
      this.Execute_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Event_priv = null; } else {
      this.Event_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Trigger_priv = null; } else {
      this.Trigger_priv = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Host = null; } else {
      this.Host = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Db = null; } else {
      this.Db = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.User = null; } else {
      this.User = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Select_priv = null; } else {
      this.Select_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Insert_priv = null; } else {
      this.Insert_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Update_priv = null; } else {
      this.Update_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Delete_priv = null; } else {
      this.Delete_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_priv = null; } else {
      this.Create_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Drop_priv = null; } else {
      this.Drop_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Grant_priv = null; } else {
      this.Grant_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.References_priv = null; } else {
      this.References_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Index_priv = null; } else {
      this.Index_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Alter_priv = null; } else {
      this.Alter_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_tmp_table_priv = null; } else {
      this.Create_tmp_table_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Lock_tables_priv = null; } else {
      this.Lock_tables_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_view_priv = null; } else {
      this.Create_view_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Show_view_priv = null; } else {
      this.Show_view_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Create_routine_priv = null; } else {
      this.Create_routine_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Alter_routine_priv = null; } else {
      this.Alter_routine_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Execute_priv = null; } else {
      this.Execute_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Event_priv = null; } else {
      this.Event_priv = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Trigger_priv = null; } else {
      this.Trigger_priv = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    db o = (db) super.clone();
    return o;
  }

  public void clone0(db o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("Host", this.Host);
    __sqoop$field_map.put("Db", this.Db);
    __sqoop$field_map.put("User", this.User);
    __sqoop$field_map.put("Select_priv", this.Select_priv);
    __sqoop$field_map.put("Insert_priv", this.Insert_priv);
    __sqoop$field_map.put("Update_priv", this.Update_priv);
    __sqoop$field_map.put("Delete_priv", this.Delete_priv);
    __sqoop$field_map.put("Create_priv", this.Create_priv);
    __sqoop$field_map.put("Drop_priv", this.Drop_priv);
    __sqoop$field_map.put("Grant_priv", this.Grant_priv);
    __sqoop$field_map.put("References_priv", this.References_priv);
    __sqoop$field_map.put("Index_priv", this.Index_priv);
    __sqoop$field_map.put("Alter_priv", this.Alter_priv);
    __sqoop$field_map.put("Create_tmp_table_priv", this.Create_tmp_table_priv);
    __sqoop$field_map.put("Lock_tables_priv", this.Lock_tables_priv);
    __sqoop$field_map.put("Create_view_priv", this.Create_view_priv);
    __sqoop$field_map.put("Show_view_priv", this.Show_view_priv);
    __sqoop$field_map.put("Create_routine_priv", this.Create_routine_priv);
    __sqoop$field_map.put("Alter_routine_priv", this.Alter_routine_priv);
    __sqoop$field_map.put("Execute_priv", this.Execute_priv);
    __sqoop$field_map.put("Event_priv", this.Event_priv);
    __sqoop$field_map.put("Trigger_priv", this.Trigger_priv);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("Host", this.Host);
    __sqoop$field_map.put("Db", this.Db);
    __sqoop$field_map.put("User", this.User);
    __sqoop$field_map.put("Select_priv", this.Select_priv);
    __sqoop$field_map.put("Insert_priv", this.Insert_priv);
    __sqoop$field_map.put("Update_priv", this.Update_priv);
    __sqoop$field_map.put("Delete_priv", this.Delete_priv);
    __sqoop$field_map.put("Create_priv", this.Create_priv);
    __sqoop$field_map.put("Drop_priv", this.Drop_priv);
    __sqoop$field_map.put("Grant_priv", this.Grant_priv);
    __sqoop$field_map.put("References_priv", this.References_priv);
    __sqoop$field_map.put("Index_priv", this.Index_priv);
    __sqoop$field_map.put("Alter_priv", this.Alter_priv);
    __sqoop$field_map.put("Create_tmp_table_priv", this.Create_tmp_table_priv);
    __sqoop$field_map.put("Lock_tables_priv", this.Lock_tables_priv);
    __sqoop$field_map.put("Create_view_priv", this.Create_view_priv);
    __sqoop$field_map.put("Show_view_priv", this.Show_view_priv);
    __sqoop$field_map.put("Create_routine_priv", this.Create_routine_priv);
    __sqoop$field_map.put("Alter_routine_priv", this.Alter_routine_priv);
    __sqoop$field_map.put("Execute_priv", this.Execute_priv);
    __sqoop$field_map.put("Event_priv", this.Event_priv);
    __sqoop$field_map.put("Trigger_priv", this.Trigger_priv);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("Host".equals(__fieldName)) {
      this.Host = (String) __fieldVal;
    }
    else    if ("Db".equals(__fieldName)) {
      this.Db = (String) __fieldVal;
    }
    else    if ("User".equals(__fieldName)) {
      this.User = (String) __fieldVal;
    }
    else    if ("Select_priv".equals(__fieldName)) {
      this.Select_priv = (String) __fieldVal;
    }
    else    if ("Insert_priv".equals(__fieldName)) {
      this.Insert_priv = (String) __fieldVal;
    }
    else    if ("Update_priv".equals(__fieldName)) {
      this.Update_priv = (String) __fieldVal;
    }
    else    if ("Delete_priv".equals(__fieldName)) {
      this.Delete_priv = (String) __fieldVal;
    }
    else    if ("Create_priv".equals(__fieldName)) {
      this.Create_priv = (String) __fieldVal;
    }
    else    if ("Drop_priv".equals(__fieldName)) {
      this.Drop_priv = (String) __fieldVal;
    }
    else    if ("Grant_priv".equals(__fieldName)) {
      this.Grant_priv = (String) __fieldVal;
    }
    else    if ("References_priv".equals(__fieldName)) {
      this.References_priv = (String) __fieldVal;
    }
    else    if ("Index_priv".equals(__fieldName)) {
      this.Index_priv = (String) __fieldVal;
    }
    else    if ("Alter_priv".equals(__fieldName)) {
      this.Alter_priv = (String) __fieldVal;
    }
    else    if ("Create_tmp_table_priv".equals(__fieldName)) {
      this.Create_tmp_table_priv = (String) __fieldVal;
    }
    else    if ("Lock_tables_priv".equals(__fieldName)) {
      this.Lock_tables_priv = (String) __fieldVal;
    }
    else    if ("Create_view_priv".equals(__fieldName)) {
      this.Create_view_priv = (String) __fieldVal;
    }
    else    if ("Show_view_priv".equals(__fieldName)) {
      this.Show_view_priv = (String) __fieldVal;
    }
    else    if ("Create_routine_priv".equals(__fieldName)) {
      this.Create_routine_priv = (String) __fieldVal;
    }
    else    if ("Alter_routine_priv".equals(__fieldName)) {
      this.Alter_routine_priv = (String) __fieldVal;
    }
    else    if ("Execute_priv".equals(__fieldName)) {
      this.Execute_priv = (String) __fieldVal;
    }
    else    if ("Event_priv".equals(__fieldName)) {
      this.Event_priv = (String) __fieldVal;
    }
    else    if ("Trigger_priv".equals(__fieldName)) {
      this.Trigger_priv = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("Host".equals(__fieldName)) {
      this.Host = (String) __fieldVal;
      return true;
    }
    else    if ("Db".equals(__fieldName)) {
      this.Db = (String) __fieldVal;
      return true;
    }
    else    if ("User".equals(__fieldName)) {
      this.User = (String) __fieldVal;
      return true;
    }
    else    if ("Select_priv".equals(__fieldName)) {
      this.Select_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Insert_priv".equals(__fieldName)) {
      this.Insert_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Update_priv".equals(__fieldName)) {
      this.Update_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Delete_priv".equals(__fieldName)) {
      this.Delete_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Create_priv".equals(__fieldName)) {
      this.Create_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Drop_priv".equals(__fieldName)) {
      this.Drop_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Grant_priv".equals(__fieldName)) {
      this.Grant_priv = (String) __fieldVal;
      return true;
    }
    else    if ("References_priv".equals(__fieldName)) {
      this.References_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Index_priv".equals(__fieldName)) {
      this.Index_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Alter_priv".equals(__fieldName)) {
      this.Alter_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Create_tmp_table_priv".equals(__fieldName)) {
      this.Create_tmp_table_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Lock_tables_priv".equals(__fieldName)) {
      this.Lock_tables_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Create_view_priv".equals(__fieldName)) {
      this.Create_view_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Show_view_priv".equals(__fieldName)) {
      this.Show_view_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Create_routine_priv".equals(__fieldName)) {
      this.Create_routine_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Alter_routine_priv".equals(__fieldName)) {
      this.Alter_routine_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Execute_priv".equals(__fieldName)) {
      this.Execute_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Event_priv".equals(__fieldName)) {
      this.Event_priv = (String) __fieldVal;
      return true;
    }
    else    if ("Trigger_priv".equals(__fieldName)) {
      this.Trigger_priv = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
