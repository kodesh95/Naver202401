package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	//회원정보 - members 아이디,암호 이름 이메일 폰 가입일
		String memberid; // mybatis / jpa html name="memberid"  - dto 변수명 - db 테이블 컬럼명 memberid
		String pw;
		String membername;
		String phone;
		String email;
		String regdate;
		
		public MemberDTO() {
			System.out.println("MemberDTO 기본생성자 호출");
		} //<bean id=dto1  class="member.MemberdTO" />

		
		public MemberDTO(String memberid, String membername, String phone, String email) {
			super();
			this.memberid = memberid;
			this.membername = membername;
			this.phone = phone;
			this.email = email;
		}

		

		public MemberDTO(String memberid, String pw, String membername, String phone, 
				String email, String regdate) {
			super();
			this.memberid = memberid;
			this.pw = pw;
			this.membername = membername;
			this.phone = phone;
			this.email = email;
			this.regdate = regdate;
		}

		public String getMemberid() {
			return memberid;
		}
		public void setMemberid(String memberid) {
			this.memberid = memberid;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getMembername() {
			return membername;
		}
		public void setMembername(String membername) {
			this.membername = membername;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}  
		
		//toString() , equals() 오버라이딩 추가-선택적
	}
