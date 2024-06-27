package com.homerunball.inq.domain;

import java.util.Date;
import java.util.Objects;

public class InqDto {
    private int inq_id;
    private String pd_id;
    private int c_id;
    private String inq_title;
    private String inq_content;
    private String inq_phn;
    private String inq_attch_name;
    private char inq_is_sent;
    private char inq_is_show;
    private char inq_is_cmpl;
    private Date inq_dt;
    private String inq_stat_cd;
    private String inq_type_cd;
    private String c_name;



    public InqDto(){
    }

    public InqDto(int inq_id, String pd_id, int c_id, String inq_title, String inq_content, String inq_phn, String inq_attch_name, char inq_is_sent, char inq_is_show, char inq_is_cmpl, Date inq_dt, String inq_stat_cd, String inq_type_cd, String c_name) {
        this.inq_id = inq_id;
        this.pd_id = pd_id;
        this.c_id = c_id;
        this.inq_title = inq_title;
        this.inq_content = inq_content;
        this.inq_phn = inq_phn;
        this.inq_attch_name = inq_attch_name;
        this.inq_is_sent = inq_is_sent;
        this.inq_is_show = inq_is_show;
        this.inq_is_cmpl = inq_is_cmpl;
        this.inq_dt = inq_dt;
        this.inq_stat_cd = inq_stat_cd;
        this.inq_type_cd = inq_type_cd;
        this.c_name = c_name;
    }



    public int getInq_id() {
        return inq_id;
    }

    public void setInq_id(int inq_id) {
        this.inq_id = inq_id;
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getInq_title() {
        return inq_title;
    }

    public void setInq_title(String inq_title) {
        this.inq_title = inq_title;
    }

    public String getInq_content() {
        return inq_content;
    }

    public void setInq_content(String inq_content) {
        this.inq_content = inq_content;
    }

    public String getInq_phn() {
        return inq_phn;
    }

    public void setInq_phn(String inq_phn) {
        this.inq_phn = inq_phn;
    }

    public String getInq_attch_name() {
        return inq_attch_name;
    }

    public void setInq_attch_name(String inq_attch_name) {
        this.inq_attch_name = inq_attch_name;
    }

    public char getInq_is_sent() {
        return inq_is_sent;
    }

    public void setInq_is_sent(char inq_is_sent) {
        this.inq_is_sent = inq_is_sent;
    }

    public char getInq_is_show() {
        return inq_is_show;
    }

    public void setInq_is_show(char inq_is_show) {
        this.inq_is_show = inq_is_show;
    }

    public char getInq_is_cmpl() {
        return inq_is_cmpl;
    }

    public void setInq_is_cmpl(char inq_is_cmpl) {
        this.inq_is_cmpl = inq_is_cmpl;
    }

    public Date getInq_dt() {
        return inq_dt;
    }

    public void setInq_dt(Date inq_dt) {
        this.inq_dt = inq_dt;
    }

    public String getInq_stat_cd() {
        return inq_stat_cd;
    }

    public void setInq_stat_cd(String inq_stat_cd) {
        this.inq_stat_cd = inq_stat_cd;
    }

    public String getInq_typq_cd() {
        return inq_type_cd;
    }

    public void setInq_typq_cd(String inq_type_cd) {
        this.inq_type_cd = inq_type_cd;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }


    @Override
    public String toString() {
        return "InqDto{" +
                "inq_id=" + inq_id +
                ", pd_id='" + pd_id + '\'' +
                ", c_id=" + c_id +
                ", inq_title='" + inq_title + '\'' +
                ", inq_content='" + inq_content + '\'' +
                ", inq_phn='" + inq_phn + '\'' +
                ", inq_attch_name='" + inq_attch_name + '\'' +
                ", inq_is_sent=" + inq_is_sent +
                ", inq_is_show=" + inq_is_show +
                ", inq_is_cmpl=" + inq_is_cmpl +
                ", inq_dt=" + inq_dt +
                ", inq_stat_cd='" + inq_stat_cd + '\'' +
                ", inq_type_cd='" + inq_type_cd + '\'' +
                ", c_name='" + c_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InqDto inqDto = (InqDto) o;
        return inq_id == inqDto.inq_id && c_id == inqDto.c_id && inq_is_sent == inqDto.inq_is_sent && inq_is_show == inqDto.inq_is_show && inq_is_cmpl == inqDto.inq_is_cmpl && Objects.equals(pd_id, inqDto.pd_id) && Objects.equals(inq_title, inqDto.inq_title) && Objects.equals(inq_content, inqDto.inq_content) && Objects.equals(inq_phn, inqDto.inq_phn) && Objects.equals(inq_attch_name, inqDto.inq_attch_name) && Objects.equals(inq_dt, inqDto.inq_dt) && Objects.equals(inq_stat_cd, inqDto.inq_stat_cd) && Objects.equals(inq_type_cd, inqDto.inq_type_cd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inq_id, pd_id, c_id, inq_title, inq_content, inq_phn, inq_attch_name, inq_is_sent, inq_is_show, inq_is_cmpl, inq_dt, inq_stat_cd, inq_type_cd);
    }
}