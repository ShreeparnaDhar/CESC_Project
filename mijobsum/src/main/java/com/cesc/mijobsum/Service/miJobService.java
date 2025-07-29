package com.cesc.mijobsum.Service;

import com.cesc.mijobsum.AllQuery.QueryClass;
import com.cesc.mijobsum.Dao.MijobDaoImpl;
import com.cesc.mijobsum.Model.miJobcutoffview;
import com.cesc.mijobsum.Model.mijob_cutoff_out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cesc.mijobsum.AllQuery.QueryClass;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
public class miJobService implements miJobServiceImpl  {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MijobDaoImpl  mijobDaoImpl;

    @Override
    public List <miJobcutoffview> GetAllOsValues() {
        boolean     dbModifiaction = false;
        BigInteger  TotalValue     = BigInteger.ZERO;
        //SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
        List<miJobcutoffview> resultList = new ArrayList<>();
        resultList = mijobDaoImpl.GetAllOS();
        return resultList;
    }

//    @Override
//    public List<mijob_cutoff_out> GetAllJobs() {
//        return mijobDaoImpl.GetAllJobs();
//    }

    @Override
    public List<miJobcutoffview> GetAllSums(String StartDate, String EndDate,String JobType ) {
        List<miJobcutoffview> resultList = new ArrayList<>();
        boolean InsertOp = mijobDaoImpl.RetriveJobsAccordingToRegions(StartDate, EndDate, JobType);
        if(InsertOp){
            resultList = mijobDaoImpl.GetAllOS();
        }
        else{
            System.out.println("data insertion  not done in gtmp_mijob_cutoff_hdr TABLE ");
        }
        return resultList;
    }

}


