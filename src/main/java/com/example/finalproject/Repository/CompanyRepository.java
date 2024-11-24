package com.example.finalproject.Repository;

import com.example.finalproject.Model.Category;
import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Credentionals;
import com.example.finalproject.Model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public boolean existsByCredentionals(Credentionals credentionals);
    @Query("select comp.lstCupons from Company comp where comp.id=?1")
    public List<Cupon> getLstCupons(long compId);
    @Query("select cup from Cupon cup where cup.company.id=?1 and cup.category=?2")
    public List<Cupon> getLstCupons(long compId, Category category);
    @Query("select cup from Cupon cup where cup.company.id=?1 and cup.price<=?2")
    public List<Cupon> getLstCupons(long compId, double maxPrice);
    @Query("select cup from Cupon cup where cup.company.id=?1 and cup.title=?2")
    public List<Cupon> getLstCuponsByTitle(long compId,String title);

}
