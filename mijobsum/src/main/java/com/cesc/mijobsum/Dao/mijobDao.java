package com.cesc.mijobsum.Dao;

import com.cesc.mijobsum.AllQuery.QueryClass;
import com.cesc.mijobsum.Mapper.miJobCutOffViewMapper;
import com.cesc.mijobsum.Model.miJobcutoffview;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.cesc.mijobsum.Model.mijob_cutoff_out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Repository
public  class mijobDao implements MijobDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<miJobcutoffview> GetAllOS() {


        //*********************************************************//
        //       Get Over All Os Value                             //
        //*********************************************************//
        String qry2 = QueryClass.DONE_OS_COUNT;
        List<miJobcutoffview> miJobcutoffviewList = jdbcTemplate.query(qry2, new miJobCutOffViewMapper());
        //return jdbcTemplate.query(qry2, BeanPropertyRowMapper.newInstance(miJobcutoffview.class));
        return miJobcutoffviewList;
    }

//    @Override
//    public List<mijob_cutoff_out> GetAllJobs() {
//        String qry = " select coff_id, job_id, cons_id, cons_num, form_type, rgn_cd from mijob_cutoff_out where coff_id = 55037 ";
//        return jdbcTemplate.query(qry, BeanPropertyRowMapper.newInstance(mijob_cutoff_out.class));
//    }

    @Override
    public boolean RetriveJobsAccordingToRegions(String StartDate, String EndDate ,String JobType) {
            // convert String to date //

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startdate = LocalDate.parse(StartDate.trim(), formatter);
        LocalDate enddate   = LocalDate.parse(EndDate.trim(), formatter);

        boolean flag =false;

            // exception handle for insertion of table //
        try {
            //***************************************************************************//
            //Delete the  GTMP MI JOB CUTOFF HDR table with in requested date range      //
            //***************************************************************************//
                try {
                    int functionResult = jdbcTemplate.update(QueryClass.DELETE_QTMP_MIJOB_CUTTOFF_HDR);
                    System.out.println("Deleted rows: " + functionResult);
                } catch (DataAccessException e) {
                    System.err.println("Error deleting data from gtmp_mijob_cutoff_hdr: " + e.getMessage());
                    e.printStackTrace();
                }
            //***************************************************************************//
            //Insert data into GTMP MI JOB CUTOFF HDR table with in requested date range //
            //***************************************************************************//
                String sql = QueryClass.INSERT_INTO_GTMP_MI_JOB_CUTOFF_HDR;

                MapSqlParameterSource parameters = new MapSqlParameterSource();
                parameters.addValue("startDate", StartDate);
                parameters.addValue("endDate", EndDate);
                parameters.addValue("jobType",JobType);

                int functionresult = namedParameterJdbcTemplate.update(sql, parameters);
                System.out.println(functionresult);
                    if(functionresult > 0){
                        System.out.println("row effected" + functionresult);
                        flag = true;
                        return flag;
                    }
                    else {
                        return flag;
                    }
        }
        catch (DataAccessException dae) {
            System.err.println("Database access error: " + dae.getMessage());
            return flag;
        }

    }
}
