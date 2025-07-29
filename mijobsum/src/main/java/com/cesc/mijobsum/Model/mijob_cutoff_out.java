package com.cesc.mijobsum.Model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class mijob_cutoff_out {
    private String coff_id;
    private String job_id;
    private String cons_id;
    private String cons_num;
    private String form_type;
    private String rgn_cd;
    private int sub_cons_mtr_id;
    private int seq_num ;
    private String calr_seq;
    private String meter_num;
    private String rate;
    private Date crtDt;
    private String crtBy;
    private Date miJobDt;
    private String miEmpCode1;
    private String miImeiNo1;
    private String miLotNo;
    private String miEmpCode2;
    private String miImeiNo2;
    private String miPeriod;
    private String miRepeatMkr;
    private String miFeedbackCode;
    private String miFeedbackDesc;
    private int miFeedbackMtrRdng;
    private Date miFeedbackDt;
    private String miRemarks;
    private Date ltPrcdDt;
    private Date updDt;
    private String updBy;
    private String newMtrNum;
    private String transferMode;
    private String dayEveningMarker;
    private String chapterNo;
    private Date smsSentDt;
    private String smsSentMobNo;
    private int smsSeq;
    private String smsText;
    private String billPdfUrl;
    private String smsNotSentWhy;
    private String smsReconBillAppRefNo;
}
