package model;

public class VoteMember {
	private String m_no;//후보번호
	private String m_name;//후보 이름
	private String p_code; //소속 정당
	private String p_school;//최종 학력
	private String m_jumin;//주민번호
	private String m_city;//지역구
	private String tell;//전화번호
	
	private String v_jumin;//명세 주민번호
	private String year;//년도
	private String month;//월
	private String day;//일
	private String v_name;//명세 성명
	private String v_time;//투표 시간
	private String v_area;//투표 장소
	private String v_confirm;//유권자 확인
	private String gender;//성별
	private String count_Mcode;//후보 번호 건수
	
	public String getCount_Mcode() {
		return count_Mcode;
	}
	public void setCount_Mcode(String count_Mcode) {
		this.count_Mcode = count_Mcode;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getV_jumin() {
		return v_jumin;
	}
	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_area() {
		return v_area;
	}
	public void setV_area(String v_area) {
		this.v_area = v_area;
	}
	public String getV_confirm() {
		return v_confirm;
	}
	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getM_no() {
		return m_no;
	}
	public void setM_no(String m_no) {
		this.m_no = m_no;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getP_code() {
		return p_code;
	}
	public void setP_code(String p_code) {
		this.p_code = p_code;
	}
	public String getP_school() {
		return p_school;
	}
	public void setP_school(String p_school) {
		this.p_school = p_school;
	}
	public String getM_jumin() {
		return m_jumin;
	}
	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}
	public String getM_city() {
		return m_city;
	}
	public void setM_city(String m_city) {
		this.m_city = m_city;
	}
	
}
