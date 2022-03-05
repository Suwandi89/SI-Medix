package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.repository.RoleDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDB roleDb;

    @Override
    public List<RoleModel> findAll(){ return roleDb.findAll();}
}
