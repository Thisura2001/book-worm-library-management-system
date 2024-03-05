package lk.ijse.Dao.Custom.Impl;

import lk.ijse.Dao.Custom.BranchDao;
import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Branch;

import java.util.ArrayList;

public class BranchDaoImpl implements BranchDao {

    @Override
    public boolean save(Branch entity) {
        return false;
    }

    @Override
    public boolean update(Branch book) {
        return false;
    }

    @Override
    public ArrayList<Branch> getAll() {
        return null;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public boolean Delete(String id) {
        return false;
    }

    @Override
    public boolean validateAdmin(Branch admin) {
        return false;
    }
}
