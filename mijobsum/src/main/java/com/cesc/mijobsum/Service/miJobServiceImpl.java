package com.cesc.mijobsum.Service;

import com.cesc.mijobsum.Model.miJobcutoffview;
import com.cesc.mijobsum.Model.mijob_cutoff_out;

import java.math.BigInteger;
import java.util.List;

public interface miJobServiceImpl  {
    public List<miJobcutoffview>  GetAllOsValues();
    //public List<mijob_cutoff_out> GetAllJobs();
    public List<miJobcutoffview>  GetAllSums(String StartDate,String EndDate,String JobType);
}
