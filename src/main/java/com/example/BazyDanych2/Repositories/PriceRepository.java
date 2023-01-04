package com.example.BazyDanych2.Repositories;

import com.example.BazyDanych2.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("priceRepository")
public interface PriceRepository extends JpaRepository<Price,Long> {
    public Optional<Price> findById(Long id);
    public Optional<Price> findByFaultId(Long id);

}
