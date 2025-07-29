package com.cesc.mijobsum.AllQuery;

public class QueryClass {

    public static final String DONE_OS_COUNT =
            "SELECT " +
            "c.rgn_cd, " +
            "a.job_count, " +
            "a.total_os, " +
            "a.done_count, " +
            "ROUND((a.done_count/a.job_count)*100,2) done_job_pctg, " +
            "a.done_os, " +
            "ROUND((a.done_os/a.total_os)*100,2) done_os_pctg, " +
            "a.not_done_count, " +
            "ROUND((a.not_done_count/a.job_count)*100,2) not_done_job_pctg, " +
            "a.not_done_os, " +
            "ROUND((a.not_done_os/a.total_os)*100,2) not_done_os_pctg " +
            "FROM ( " +
            "  SELECT " +
            "    a.rgn_cd, " +
            "    COUNT(a.cons_id) job_count, " +
            "    SUM(a.tot_os) total_os, " +
            "    SUM(CASE WHEN b.mi_feedback_desc LIKE 'JOB-DONE' THEN 1 ELSE 0 END) done_count, " +
            "    SUM(CASE WHEN b.mi_feedback_desc LIKE 'JOB-DONE' THEN a.tot_os ELSE 0 END) done_os, " +
            "    SUM(CASE WHEN b.mi_feedback_desc LIKE 'JOB-NOT-DONE' THEN 1 ELSE 0 END) not_done_count, " +
            "    SUM(CASE WHEN b.mi_feedback_desc LIKE 'JOB-NOT-DONE' THEN a.tot_os ELSE 0 END) not_done_os " +
            "  FROM ( " +
            "    SELECT b.cons_id, b.coff_id, b.rgn_cd, g.day_evening_marker, tot_os, b.mi_job_dt, SUBSTR(b.cons_num, 1, 2) dist_cd " +
            "    FROM hhiorg_mijob_cutoff_dtl b, gtmp_mijob_cutoff_hdr g " +
            "    WHERE b.coff_id = g.coff_id " +
            "      AND b.rgn_cd = g.rgn_cd " +
            "      AND b.day_evening_marker = g.day_evening_marker " +
            "    GROUP BY b.cons_id, b.coff_id, b.rgn_cd, g.day_evening_marker, tot_os, b.mi_job_dt, SUBSTR(b.cons_num, 1, 2) " +
            "  ) a, ( " +
            "    SELECT b.cons_id, b.coff_id, b.rgn_cd, g.day_evening_marker, " +
            "      CASE WHEN SUM(CASE WHEN b.mi_feedback_desc LIKE 'JOB-DONE%' THEN 1 ELSE 0 END) > 0 THEN 'JOB-DONE' " +
            "      ELSE 'JOB-NOT-DONE' END mi_feedback_desc " +
            "    FROM mijob_cutoff_out b, gtmp_mijob_cutoff_hdr g " +
            "    WHERE b.coff_id = g.coff_id " +
            "      AND b.rgn_cd = g.rgn_cd " +
            "      AND b.day_evening_marker = g.day_evening_marker " +
            "    GROUP BY b.cons_id, b.coff_id, b.rgn_cd, g.day_evening_marker " +
            "  ) b " +
            "  WHERE a.rgn_cd = b.rgn_cd(+) " +
            "    AND a.coff_id = b.coff_id(+) " +
            "    AND a.cons_id = b.cons_id(+) " +
            "    AND a.day_evening_marker = b.day_evening_marker(+) " +
            "  GROUP BY a.rgn_cd " +
            ") a, " +
            "(SELECT DISTINCT rgn_cd FROM cl_dist_rgn_ctrl) c " +
            "WHERE c.rgn_cd = a.rgn_cd(+) " +
            "ORDER BY DECODE(c.rgn_cd,'SRO',1,'SWRO',2,'CRO',3,'NRO',4,'NSRO',5,'HRO',6)";


    public static final String DELETE_QTMP_MIJOB_CUTTOFF_HDR      = "DELETE FROM gtmp_mijob_cutoff_hdr ";
    public static final String INSERT_INTO_GTMP_MI_JOB_CUTOFF_HDR = "INSERT INTO gtmp_mijob_cutoff_hdr " +
                                                                    "SELECT * FROM mijob_cutoff_hdr " +
                                                                    "WHERE job_dt BETWEEN (:startDate) AND (:endDate) AND day_evening_marker like ('%'|| :jobType)";



}
