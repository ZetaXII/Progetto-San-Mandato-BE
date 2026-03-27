package it.san_mandato.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.san_mandato.entity.PoiEntity;

@Repository
public interface PoiRepository extends JpaRepository<PoiEntity, Long>, JpaSpecificationExecutor<PoiEntity> {
	Optional<PoiEntity> findByUuid(UUID uuid);

	@Query("SELECT DISTINCT p FROM PoiEntity p " + "LEFT JOIN FETCH p.architects a "
			+ "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
			+ "   OR LOWER(p.generalDescription) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
			+ "   OR LOWER(p.areaGroup) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
			+ "   OR LOWER(p.constructionCentury) LIKE LOWER(CONCAT('%', :searchTerm, '%')) "
			+ "   OR LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
	Page<PoiEntity> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

}
