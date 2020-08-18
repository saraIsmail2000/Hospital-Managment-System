package sample.Model;

import java.util.Date;

public class PatientEntrance {
    private int PatId , EntryId , BillId , wardId,RoomId,RecId;
    private Date AdmitDate, LeavingDate;

    public int getPatId() {
        return PatId;
    }

    public void setPatId(int patId) {
        PatId = patId;
    }

    public int getEntryId() {
        return EntryId;
    }

    public void setEntryId(int entryId) {
        EntryId = entryId;
    }

    public int getBillId() {
        return BillId;
    }

    public void setBillId(int billId) {
        BillId = billId;
    }

    public int getWardId() {
        return wardId;
    }

    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    public int getRoomId() {
        return RoomId;
    }

    public void setRoomId(int roomId) {
        RoomId = roomId;
    }

    public int getRecId() {
        return RecId;
    }

    public void setRecId(int recId) {
        RecId = recId;
    }

    public Date getAdmitDate() {
        return AdmitDate;
    }

    public void setAdmitDate(Date admitDate) {
        AdmitDate = admitDate;
    }

    public Date getLeavingDate() {
        return LeavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        LeavingDate = leavingDate;
    }
}
