package com.cesc.mijobsum.Dao;

import com.cesc.mijobsum.Model.miJobcutoffview;
import com.cesc.mijobsum.Model.mijob_cutoff_out;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

public interface MijobDaoImpl {
    public List<miJobcutoffview> GetAllOS();
//    public List<mijob_cutoff_out> GetAllJobs();
    public boolean  RetriveJobsAccordingToRegions(String StartDate,String EndDate,String JobType);
}
