package lk.ijse.Bo.Custom.Impl;

import lk.ijse.Bo.BoFactory;
import lk.ijse.Bo.Custom.BranchBo;
import lk.ijse.Dao.Custom.BranchDao;
import lk.ijse.Dao.DaoFactory;
import lk.ijse.Dto.BranchDto;
import lk.ijse.Entity.Branch;

import java.util.ArrayList;

public class BranchBoImpl implements BranchBo {
    BranchDao branchDao = (BranchDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.BRANCH);
    @Override
    public boolean AddBranch(BranchDto branchDto) {
        return branchDao.save(new Branch(branchDto.getId(),branchDto.getName(),branchDto.getAddress(),branchDto.getContact(),branchDto.getStatus()));
    }

    @Override
    public ArrayList<BranchDto> getAll() {
        ArrayList<BranchDto>branchDtos = new ArrayList<>();
        ArrayList<Branch>branches = branchDao.getAll();

        for (Branch b : branches){
            branchDtos.add(new BranchDto(b.getId(),b.getName(),b.getAddress(),b.getContact(),b.getStatus()));
        }
        return branchDtos;
    }

    @Override
    public String generateNewBookID() {
        return branchDao.generateNewId();
    }

    @Override
    public boolean UpdateBranch(BranchDto branchDto) {
        return branchDao.update(new Branch(branchDto.getId(),branchDto.getName(),branchDto.getAddress(),branchDto.getContact(),branchDto.getStatus()));
    }

    @Override
    public boolean deleteBranch(String id) {
        return branchDao.Delete(id);
    }
}
