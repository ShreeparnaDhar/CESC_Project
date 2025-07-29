package com.cesc.mijobsum.Mapper;

import com.cesc.mijobsum.Model.miJobcutoffview;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class miJobCutOffViewMapper  implements RowMapper<miJobcutoffview> {

        @Override
        public miJobcutoffview mapRow(ResultSet rs, int rowNum) throws SQLException {
            miJobcutoffview view = new miJobcutoffview();

            view.setRgnCd                           (rs.getString("rgn_cd"));
            view.setJobCount                        (rs.getObject("job_count", Long.class));
            view.setTotalOs                         (rs.getBigDecimal("total_os"));
            view.setDoneJobCount                    (rs.getObject("done_count", Long.class));
            view.setDoneJobPercentage               (rs.getObject("done_job_pctg", Double.class));
            view.setDoneOs                          (rs.getBigDecimal("done_os"));
            view.setDoneOSPercentage                (rs.getObject("done_os_pctg", Double.class));
            view.setNotDoneJobCount                 (rs.getObject("not_done_count", Long.class));
            view.setNotDoneJobPercentage            (rs.getObject("not_done_job_pctg", Double.class));
            view.setNotDoneOs                       (rs.getBigDecimal("not_done_os"));
            view.setNotDoneOsPercentage             (rs.getObject("not_done_os_pctg", Double.class));

            return view;
        }
    }

