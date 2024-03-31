//package autocom.common;
//
////import static org.selenium.automationtest.common.TestLogger.*;
////import static org.selenium.automationtest.common.constant.CT_Common.*;
//import autocom.common.CommonPage;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import org.apache.commons.exec.util.StringUtils;
////import org.apache.commons.lang3.StringUtils;
//import org.testng.Assert;
//
//public class JDBCConnection extends CommonBase {
//	private String db;
//	private String sid;
//	private String userName;
//	private String passWord;
//
//	private Connection conn;
//
//	public ResultSet executeSql(String sql) {
//		try {
//			if (conn == null) {
//				connect();
//			}
//			Statement state = conn.createStatement();
//			info("Thuc thi cau lenh " + sql);
//			ResultSet rs = state.executeQuery(sql);
//			// state.executeQuery("commit");
//			return rs;
//		} catch (Exception e) {
//			info("Khong thuc thi duoc cau lenh: " + sql);
//			Assert.assertFalse(false);
//		}
//		return null;
//	}
//
//	/**
//	 * 
//	 * @param sql
//	 */
//	public void executeManySQL(String... sql) {
//		if (sql.length > 0) {
//			try {
//				if (conn == null) {
//					connect();
//				}
//				Statement state = conn.createStatement();
//				for (int i = 0; i < sql.length; i++) {
//					state.executeQuery(sql[i]);
//				}
//			} catch (Exception e) {
//				info("Khong thuc hien duoc cau lenh sql " + sql);
//			}
//
//		}
//	}
//
//	/**
//	 * Ket noi den CSDL
//	 */
//	public void connect(String... database) {
//		if (database.length < 4) {
//			db = DB;
//			sid = SID;
//			userName = USERNAME;
//			passWord = PASSWORD;
//		} else {
//			db = database[0];
//			sid = database[1];
//			userName = database[2];
//			passWord = database[3];
//		}
//		try {
//			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			String dbConnectString = "jdbc:oracle:thin:@//" + db + ":1521/" + sid;
//			conn = DriverManager.getConnection(dbConnectString, userName, passWord);
//		} catch (Exception e) {
//			info("Can not connect to DB: " + database);
//		}
//	}
//
//	/**
//	 * Dong connection
//	 */
//	public void close() {
//		try {
//			if (conn != null) {
//				conn.close();
//				info("Close connect to DB");
//			}
//		} catch (Exception e) {
//			info("Can not close connection to DB");
//		}
//	}
//
//	/**
//	 * Dem so luong ban ghi co ton tai theo dieu kien cau lenh truy van
//	 * 
//	 * @param sql
//	 * @return
//	 */
//	public String checkRecordExist(String sql) {
//		try {
//			info("Thuc thu cau lenh " + sql);
//			ResultSet rs = executeSql(sql);
//			while (rs.next()) {
//				return rs.getString("count(*)");
//			}
//		} catch (Exception e) {
//
//		}
//		return "";
//	}
//
//	/**
//	 * So sanh du lieu tu cau lenh SQL tra ve voi mang du lieu
//	 * 
//	 * @param sql
//	 * @param params
//	 * @param expects
//	 * @return
//	 */
//	public boolean compareResult(String sql, String[] params, String[][] expects) {
//		String[][] data = getData(sql, params);
//		if (data != null) {
//			if (expects.length > 0 && data.length > 0) {
//				for (int i = 0; i < expects.length; i++) {
//					if (expects[i] != null && data[i] != null) {
//						for (int j = 0; j < expects[i].length; j++) {
//							String s = StringUtils.trim(data[i][j]);
//							info("Data get from DB: " + s);
//							String d = StringUtils.trim(expects[i][j]);
//							info("Data expect: " + d);
//							if (d != null) {
//								if (s != null && d != "") {
//
//									if (!d.equalsIgnoreCase(s)) {
//										info("data not map " + s + " and " + d);
//										return false;
//									}
//								} else if (d.equals("")) {
//									if (s != null) {
//										return false;
//									}
//								}
//							}
//						}
//					}
//				}
//			} else {
//				info("size of expects: " + expects.length);
//				info("size of data: " + data.length);
//				return false;
//			}
//		} else {
//			info("Data get from DB is null");
//			return false;
//		}
//		return true;
//	}
//
//	/**
//	 * lay du lieu tra ve tu cau lenh truy van, luu vao List 2 chieu
//	 * 
//	 * @param sql
//	 * @param params
//	 * @return
//	 */
//	public String[][] getData(String sql, String... params) {
//		String[][] data = new String[100][100];
//		try {
////			info("Thuc thi cau lenh " + sql);
//			ResultSet rs = executeSql(sql);
//			int i = 0;
//			if (rs != null) {
//				while (rs.next()) {
//					String[] currData = new String[params.length];
//					for (int j = 0; j < params.length; j++) {
////						info("Get collumn name " + params[j]);
//						currData[j] = rs.getString(params[j]);
//					}
//					data[i] = currData;
//					i++;
//				}
//			}
//		} catch (Exception e) {
////			info("Exception: " + e);
//			e.printStackTrace();
//			return data;
//		}
//		return data;
//	}
//
//	/**
//	 * 
//	 * @param command
//	 * @param param
//	 */
//	public void executeProcedure(String procedule, String... param) {
//		CallableStatement cal = null;
//		String command = "begin " + procedule + "; end;";
//		try {
//			if (conn == null) {
//				connect();
//			}
//			cal = conn.prepareCall(command);
//			if (param.length > 0) {
//				for (int i = 0; i < param.length; i++) {
//					info("param:" + param[i]);
//					if (param[i] != null) {
//						String[] pa = param[i].split("/");
//						switch (pa[0]) {
//						case "Long":
//							cal.setLong(i + 1, Long.parseLong(pa[1]));
//							break;
//						case "String":
//							cal.setString(i + 1, pa[1]);
//							break;
//						case "Date":
////							cal.setDate(i+1, formatDate("dd/MM/yyyy HH:mm:ss", pa[1]));
//							break;
//						default:
//							break;
//						}
//					}
//				}
//			}
//			cal.execute();
//		} catch (Exception e) {
//			info("Can not execute procedure");
//			info("Exception: " + e.getMessage());
//		}
//	}
//	// Cac ham tao du lieu tren DB cua sale
//
//	public void createSubscriberMobile() {
//
//	}
//
//	public void createSubscriberFix() {
//
//	}
//
//	public void deleteMapActiveInfo(String actionCode, String payType, String telServiceId) {
//		String sql = "update bccs_product.map_active_info set status = 0 where action_code = '" + actionCode
//				+ "' and pay_type = '" + payType + "' and status != 0 and tel_service_id = " + telServiceId + "";
//		executeSql(sql);
//	}
//
//	public void addMapActiveInfo(String actionCode, String payType, String telServiceId) {
//		String sql = "INSERT INTO bccs_product.map_active_info (ID,TEL_SERVICE_ID,PRODUCT_CODE,REG_REASON_ID,PROM_CODE,CHANNEL_TYPE_ID,PROVINCE_CODE,DISTRICT_CODE,EFFECT_DATE,OFFER_ID,STATUS,PRECINCT_CODE,SHOP_CODE,STAFF_CODE,ACTION_CODE,PAY_TYPE,TECHNOLOGY,UPDATE_DATETIME,CREATE_USER) "
//				+ "VALUES(bccs_product.map_active_info_seq.nextval," + telServiceId
//				+ ",'-1',-1,'-1',-1,'-1','-1',trunc(sysdate),-1,1,'-1','-1','-1','" + actionCode + "','" + payType
//				+ "','-1',sysdate,'automation_admin')";
//		executeSql(sql);
//	}
//
//	public void createCustomer() {
//
//	}
//
//	public void createCustIdentity() {
//
//	}
//}