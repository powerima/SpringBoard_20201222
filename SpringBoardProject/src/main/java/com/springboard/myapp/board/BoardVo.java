package com.springboard.myapp.board;

public class BoardVo {
	private int seq;
	private String writer;
	private String content;
	private String subjet;
	private String passwd;
	private String regdate;
	private String ip;
	private int cnt;
	private int ref;
	private int re_step;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubjet() {
		return subjet;
	}
	public void setSubjet(String subjet) {
		this.subjet = subjet;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", writer=" + writer + ", content=" + content + ", subjet=" + subjet
				+ ", passwd=" + passwd + ", regdate=" + regdate + ", ip=" + ip + ", cnt=" + cnt + ", ref=" + ref
				+ ", re_step=" + re_step + "]";
	}
	
}
