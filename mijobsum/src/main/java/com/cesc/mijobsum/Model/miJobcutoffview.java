package com.cesc.mijobsum.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class miJobcutoffview  {

    private String       rgnCd;
    private Long         jobCount;
    private BigDecimal   totalOs;
    private Long         doneJobCount;
    private Double       doneJobPercentage;//
    private BigDecimal   doneOs;
    private Double       doneOSPercentage;//
    private Long         notDoneJobCount;
    private Double       notDoneJobPercentage;//
    private BigDecimal   notDoneOs;
    private Double       notDoneOsPercentage;//
}
