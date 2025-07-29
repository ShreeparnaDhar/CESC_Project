package com.cesc.mijobsum.Controller;

import com.cesc.mijobsum.Model.miJobcutoffview;
import com.cesc.mijobsum.Model.mijob_cutoff_out;
import com.cesc.mijobsum.Service.miJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class miJobController {

    @Autowired
    private miJobServiceImpl mJServiceImpl;

    @GetMapping(value = "/totalOS")
    public List<miJobcutoffview> retrieveAllOs() {
        return mJServiceImpl.GetAllOsValues();
    }

//    @GetMapping(value = "/getAllJobs")
//    public List<mijob_cutoff_out> getAllJobs() {
//        return mJServiceImpl.GetAllJobs();
//    }

    @GetMapping(value = "/totalSum")
    public ResponseEntity<List<miJobcutoffview>> retriveAllSums(@RequestParam String StartDate, @RequestParam String EndDate, @RequestParam String JobType) {
        //HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.set("Access-Control-Allow-Origin", "*");
        //return ResponseEntity.ok().headers(responseHeaders).body(mJServiceImpl.GetAllSums(StartDate, EndDate, JobType));
        return ResponseEntity.ok(mJServiceImpl.GetAllSums(StartDate, EndDate, JobType));
    }
}
