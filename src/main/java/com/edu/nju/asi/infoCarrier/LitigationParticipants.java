package com.edu.nju.asi.infoCarrier;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Byron Dong on 2017/7/17.
 *
 * 诉讼参与人
 */
public class LitigationParticipants implements Serializable {

    /**
     * 当事人
     */
    private List<LitigationParticipant> litigants;

    public LitigationParticipants() {
    }

    public LitigationParticipants(List<LitigationParticipant> litigants) {
        this.litigants = litigants;
    }

    public List<LitigationParticipant> getLitigants() {
        return litigants;
    }

    public void setLitigants(List<LitigationParticipant> litigants) {
        this.litigants = litigants;
    }
}
