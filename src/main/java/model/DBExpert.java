package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<String> manNai(ArrayList<String> jumin) {
		String select = "SELECT TRUNC(MONTHS_BETWEEN(TRUNC(SYSDATE), TO_DATE(?,'YYYYMMDD')) / 12) "
				+ " FROM tbl_vote_202005";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			//pstmt.setString(1, (jumin));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String man = rs.getString(1);
				list.add(man);
			}
		}catch(Exception e) {
			
		}finally {
			
		}
		return list;
	}
	public ArrayList<String> substrJumin(){
		String select ="select '19'||substr(v_jumin,1,4) from tbl_vote_202005";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt= con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sj = rs.getString(1);
				Integer y = Integer.parseInt(sj.substring(0,4));
				Integer yy = 2022 - y;
				list.add(String.format("만%d세", yy));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	public ArrayList<VoteMember> countMno(){//카운트 m_no
		String select = "select m_no,decode(m_no,'1','김후보','2','이후보','3','박후보','4','조후보','5','최후보'),"
				+ " count(m_no) from tbl_vote_202005"
				+ " group by m_no order by count(m_no) desc";
		ArrayList<VoteMember> list = new ArrayList<VoteMember>();
		VoteMember vm = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vm = new VoteMember();
				vm.setM_no(rs.getString(1));
				vm.setM_name(rs.getString(2));
				vm.setCount_Mcode(rs.getString(3));
				list.add(vm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<VoteMember> voteViewList(){//만 나이 뺀 셀렉트 쿼리
		String select = "select v_name, '19' || substr(v_jumin,1,2) || '년', substr(v_jumin,3,2)||'월', substr(v_jumin,5,2)||'일생',"
				+ " decode(substr(v_jumin,7,1), '1','남','2','여'), m_no, substr(v_time,1,2)||':'||substr(v_time,3,4), decode(v_confirm, 'Y', '확인', 'N', '미확인')"
				+ " from tbl_vote_202005";
		ArrayList<VoteMember> list = new ArrayList<VoteMember>();
		VoteMember vm = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vm = new VoteMember();
				vm.setV_name(rs.getString(1));
				vm.setYear(rs.getString(2));
				vm.setMonth(rs.getString(3));
				vm.setDay(rs.getString(4));
				
				String y = rs.getString(2);
				Integer yy = Integer.parseInt(y.substring(0,4));
				Integer yyy = 2022- yy;
				String m = rs.getString(3);
				String mm = m.substring(0,2);
				String d = rs.getString(4);
				String dd = d.substring(0,2);
				vm.setV_jumin(String.format("만%d세", yyy));
				
				vm.setGender(rs.getString(5));
				vm.setM_no(rs.getString(6));
				vm.setV_time(rs.getString(7));
				vm.setV_confirm(rs.getString(8));
				list.add(vm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return list;
	}
	public boolean putVoteInfo(VoteMember vm) {
		String insert = "insert into tbl_vote_202005 values("
				+ " ?,?,?,?,?,?)";
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, vm.getV_jumin());
			pstmt.setString(2, vm.getV_name());
			pstmt.setString(3, vm.getM_no());
			pstmt.setString(4, vm.getV_time());
			pstmt.setString(5, vm.getV_area());
			pstmt.setString(6, vm.getV_confirm());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<String> searchMno(){//후보 번호 찾기 콤모 박스
		String select = "select distinct(m_no) from tbl_vote_202005 order by m_no asc";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mcodeList = rs.getString(1);
				list.add(mcodeList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<VoteMember> searchMemberList(){ //멤버 리스트
		String select = "select m.m_no, m.m_name, decode(m.p_code, 'P1', 'A정당', 'P2', 'B정당', 'P3', 'C정당', 'P4', 'D정당', 'P5', 'E정당'), m.p_school, m.m_jumin, m.m_city, p.p_tel1||' - '||p.p_tel2 ||' - '|| p.p_tel3"
				+ " from tbl_member_202005 m, tbl_party_202005 p"
				+ " where m.p_code = p.p_code";
		ArrayList<VoteMember> list = new ArrayList<VoteMember>();
		VoteMember vm = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vm = new VoteMember();
				vm.setM_no(rs.getString(1));
				vm.setM_name(rs.getString(2));
				vm.setP_code(rs.getString(3));
				vm.setP_school(rs.getString(4));
				
				String jumin = rs.getString(5);
				String front = jumin.substring(0,6);
				String back = jumin.substring(6);
				String jumin_r = front + "-" + back;
				
				vm.setM_jumin(jumin_r);
				vm.setM_city(rs.getString(6));
				vm.setTell(rs.getString(7));
				list.add(vm);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
