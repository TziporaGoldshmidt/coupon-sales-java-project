package com.example.finalproject.Repository;

import com.example.finalproject.Model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository extends JpaRepository<Cupon,Long> {
    public boolean existsByIdAndCompany_Id(long id,long compId);
}
