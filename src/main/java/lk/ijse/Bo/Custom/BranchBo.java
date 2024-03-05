package lk.ijse.Bo.Custom;

import lk.ijse.Bo.SuperBo;
import lk.ijse.Dto.BranchDto;

import java.util.ArrayList;

public interface BranchBo extends SuperBo {
    boolean AddBranch(BranchDto branchDto);

    ArrayList<BranchDto> getAll();

    String generateNewBookID();

    boolean UpdateBranch(BranchDto branchDto);

    boolean deleteBranch(String id);
}
