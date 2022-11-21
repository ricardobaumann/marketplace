package com.nabagagem.marketplace.repos;

import com.nabagagem.marketplace.entity.Gig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GigRepo extends PagingAndSortingRepository<Gig, String> {
    List<Gig> findByTags(String tag);
}
