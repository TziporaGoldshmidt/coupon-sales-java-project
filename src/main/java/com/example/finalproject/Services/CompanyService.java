package com.example.finalproject.Services;

import com.example.finalproject.Model.Category;
import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Model.Cupon;
import com.example.finalproject.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends ClientService{
    private long compId=1;

    public void addCupon(Cupon cupon) throws Exception {
        Company company=companyRepository.findById(compId).get();
        if(!companyRepository.getLstCuponsByTitle(compId,cupon.getTitle()).isEmpty())
            throw new Exception("כבר קיים לחברה זו קופון בעל כותרת זהה!");
        cupon.setCompany(company);
        cuponRepository.save(cupon);

    }
    public Cupon updateCupon(long id,Cupon cupon) throws Exception {
        Cupon cup=cuponRepository.findById(id).get();
        if(!cup.getCompany().equals(cup.getCompany()))
            throw new Exception("לא ניתן לשנות את החברה של הקופון!");
        cupon.setId(id);
        cuponRepository.save(cupon);
        return cupon;
    }
    public boolean deleteCupon(long id){
        if(!cuponRepository.existsByIdAndCompany_Id(id,compId))
            return false;
        cuponRepository.deleteById(id);
        return true;
    }

    public List<Cupon> getCompanyCupons(){
        return companyRepository.getLstCupons(compId);
    }
    public List<Cupon> getCompanyCupons(Category category){
        return companyRepository.getLstCupons(compId,category);
    }
    public List<Cupon> getCompanyCupons(double maxPrice){
        return companyRepository.getLstCupons(compId,maxPrice);
    }

    public Company getCompanyDetails(){
        return companyRepository.findById(compId).get();
    }



    @Override
    public boolean login(Credentionals credentionals) {
        return companyRepository.existsByCredentionals(credentionals);
    }
}
