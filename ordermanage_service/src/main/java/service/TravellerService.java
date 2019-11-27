package service;

import dao.MemberDao;
import dao.TravellerDao;
import domain.Member;
import domain.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellerService {
    @Autowired
    private TravellerDao travellerDao;
    public Traveller findById(String id){
        return travellerDao.findByIid(id);
    }
}
